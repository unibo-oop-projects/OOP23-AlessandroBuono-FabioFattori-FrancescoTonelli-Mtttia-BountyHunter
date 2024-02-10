package buontyhunter.graphics;

import java.util.function.Predicate;
import java.util.function.Function;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JButton;
import buontyhunter.core.GameEngine;
import buontyhunter.common.ImageType;
import buontyhunter.common.Point2d;
import buontyhunter.model.*;

import java.awt.BorderLayout;
import javax.swing.JLabel;

public class SwingGraphics implements Graphics {

	private Graphics2D g2;

	private double ratioX;
	private double ratioY;
	private SceneCamera camera;
	private SwingAssetProvider assetManager;
	
	private Font titleFont = new Font("Arial", Font.BOLD, 20);
	private Font paragraphFont = new Font("Arial", Font.PLAIN, 15);

	public SwingGraphics(Graphics2D g2, double ratioX, double ratioY, SceneCamera camera,
			SwingAssetProvider assetManager) {
		this.g2 = g2;
		this.ratioX = ratioX;
		this.ratioY = ratioY;
		this.camera = camera;
		this.assetManager = assetManager;
	}

	private int getXinPixel(Point2d p) {
		return (int) Math.round(p.x * ratioX);
	}

	private int getYinPixel(Point2d p) {
		return (int) Math.round(p.y * ratioY);
	}

	private int getDeltaXinPixel(double dx) {
		return (int) Math.round(dx * ratioX);
	}

	private int getDeltaYinPixel(double dy) {
		return (int) Math.round(dy * ratioY);
	}

	private Point2d getTilePosInPixel(Point2d p) {
		return new Point2d(getXinPixel(p), getYinPixel(p));
	}

	@Override
	public void drawPlayer(GameObject obj, World w) {
		var x = getXinPixel(camera.getPlayerPoint());
		var y = getYinPixel(camera.getPlayerPoint());
		var height = getDeltaYinPixel(((RectBoundingBox) obj.getBBox()).getHeight());
		var width = getDeltaXinPixel(((RectBoundingBox) obj.getBBox()).getWidth());

		g2.setColor(Color.RED);
		g2.fillRect(x, y, width, height);
	}

	@Override
	public void drawMap(TileManager tileManager, World w) {
		var tiles = tileManager.getTiles();

		var firstX = camera.getTileFirstX();
		var firstY = camera.getTileFirstY();
		var offsetX = camera.getTileOffsetX();
		var offsetY = camera.getTileOffsetY();
		var lastX = camera.getTileLastX();
		var lastY = camera.getTileLastY();

		int i = 0, j = 0;
		for (int y = firstY; y < lastY; y++) {
			i = 0;
			for (int x = firstX; x < lastX; x++) {
				Point2d tilePos = new Point2d(i - offsetX, j - offsetY);
				try {
					var image = tiles.get(y).get(x).getImage();
					g2.drawImage(assetManager.getImage(image), getXinPixel(tilePos),
							getYinPixel(tilePos), null);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println("Error");
				}

				i++;
			}
			j++;
		}
	}

	private int validateCoordinateMiniMap(int computedProps, Predicate<Integer> acceptor,
			Function<Integer, Integer> getCorrectValue) {
		return (acceptor.test(computedProps)) ? computedProps : getCorrectValue.apply(computedProps);
	}

	private int getMaxY(List<List<Tile>> tiles) {
		return tiles.stream().mapToInt((list) -> list.size()).max().getAsInt();
	}

	public void drawMiniMap(HidableObject miniMap, World w) {
		if (!miniMap.isShow())
			return;
		var tileManager = w.getTileManager();
		var tiles = tileManager.getTiles();

		int mapShowOffSetX = 18;
		int mapShowOffSetY = 15;

		var firstX = 0;
		var firstY = 0;
		final var lastX = tiles.size();
		final var lastY = getMaxY(tiles);

		Point2d tilePos = new Point2d(1, 1);

		var propsX = validateCoordinateMiniMap(GameEngine.WINDOW_WIDTH / (lastX),
				(computedValue) -> !(getXinPixel(tilePos) + (lastY - 1) * computedValue >= GameEngine.WINDOW_WIDTH),
				(computedProps) -> {

					while (getXinPixel(tilePos) + (lastY - 1) * computedProps >= GameEngine.WINDOW_WIDTH) {
						computedProps--;
					}
					computedProps--;
					return (computedProps <= 0) ? 1 : computedProps;
				});
		var propsY = validateCoordinateMiniMap(GameEngine.WINDOW_HEIGHT / (lastY),
				(computedValue) -> !(getYinPixel(tilePos) + (lastX - 1) * computedValue >= GameEngine.WINDOW_HEIGHT),
				(computedProps) -> {
					while (getYinPixel(tilePos) + (lastX - 1) * computedProps >= GameEngine.WINDOW_HEIGHT) {
						computedProps--;
					}
					computedProps--;
					return (computedProps <= 0) ? 1 : computedProps;
				});

		g2.drawImage(assetManager.getImage(ImageType.MAPBG), firstX + mapShowOffSetY, firstY + mapShowOffSetX,
				getXinPixel(tilePos) + mapShowOffSetY * 2 + lastX * propsX,
				getYinPixel(tilePos) + mapShowOffSetX * 2 + lastY * propsY, null);
		for (int x = firstX; x < lastX; x++) {
			for (int y = firstY; y < lastY; y++) {

				try {
					g2.setColor(getTileColor(tiles.get(x).get(y).getType()));
					g2.fillRect(getXinPixel(tilePos) + mapShowOffSetY + y * propsX,
							getYinPixel(tilePos) + mapShowOffSetX + x * propsY, propsX, propsY);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println("we're fucked up");
				}

			}
		}

		var p = w.getPlayer();

		g2.setColor(Color.RED);
		g2.fillRect(getXinPixel(tilePos) + mapShowOffSetY + (int) Math.floor(p.getPos().x) * propsX,
				getYinPixel(tilePos) + mapShowOffSetX + (int) Math.floor(p.getPos().y) * propsY, propsX, propsY);

		var navigatorLine = w.getNavigatorLine();
		var pathStream = navigatorLine.getPath().stream();

		g2.setColor(Color.ORANGE);
		pathStream.forEach((Point2d np) -> g2.fillOval(getXinPixel(tilePos) + mapShowOffSetY + (int) np.x - 2,
				getYinPixel(tilePos) + mapShowOffSetX + (int) np.y - 2, 5, 5));
	}

	private Color getTileColor(TileType type) {
		switch (type) {
			case earth:
				return new Color(160, 82, 45); // brown
			case grass:
				return Color.GREEN;
			case sand:
				return Color.YELLOW;
			case tree:
				return new Color(1, 50, 32);
			case wall:
				return Color.DARK_GRAY;
			case water:
				return Color.cyan;
			default:
				return Color.RED;

		}
	}

	@Override
	public void drawNavigatorLine(NavigatorLine navigatorLine, World w) {
		var pathStream = navigatorLine.getPath().stream();

		g2.setColor(Color.YELLOW);
		pathStream.filter((Point2d p) -> camera.inScene(p))
				.forEach((Point2d p) -> g2.fillRect(getXinPixel(camera.getObjectPointInScene(p).get()),
						getYinPixel(camera.getObjectPointInScene(p).get()), getDeltaXinPixel(0.5),
						getDeltaYinPixel(0.5)));
	}

	@Override
	public void drawHealthBar(HealthBar healthBar, World w) {

		g2.setColor(Color.BLACK);
		g2.fillRect((int) healthBar.getPos().x, (int) healthBar.getPos().y,
				((FighterEntity) w.getPlayer()).getMaxHealth() * HealthBar.zoom + HealthBar.margin, 30);
		g2.setColor(Color.RED);
		g2.fillRect((int) healthBar.getPos().x + HealthBar.margin / 2,
				(int) healthBar.getPos().y + HealthBar.margin / 2,
				((FighterEntity) w.getPlayer()).getHealth() * HealthBar.zoom, 20);
	}

	@Override
	public void drawTeleporter(Teleporter tp, World w) {

		// TODO => replace this code with an image loader for the Teleporter
		var tpPosInPixel = getTilePosInPixel(camera.getObjectPointInScene(tp.getPos()).get());
		var height = getDeltaYinPixel(((RectBoundingBox) tp.getBBox()).getHeight());
		var width = getDeltaXinPixel(((RectBoundingBox) tp.getBBox()).getWidth());

		g2.setColor(Color.WHITE);
		g2.fillRect((int) tpPosInPixel.x, (int) tpPosInPixel.y, width, height);
	}

	@Override
	public void drawQuestPannel(QuestPannel questPannel, World w) {
		if (!questPannel.isShow())
			return;
		var panelPosInPixel = questPannel.getPos();
		var height = (int) ((RectBoundingBox) questPannel.getBBox()).getHeight();

		
		g2.setColor(new Color(0, 0, 0, 0.6f));
		g2.fillRect((int) panelPosInPixel.x, (int) panelPosInPixel.y, height, height);
		
		// questa unità di misura mi permette di disegnare le varie parti della bacheca
		int unit = height / 6;
		g2.setColor(new Color(239,208,144,255));
		g2.fillRoundRect(unit, unit, 4 * unit, 4 * unit, 36, 36);
		g2.setColor(Color.BLACK);
		g2.setFont(paragraphFont);
		g2.drawString("Missioni Disponibili",unit+11, unit + 13);
		
	}

	public void drawQuest(QuestEntity quest, int x, int y, int unit, JButton btn) {
		btn.setBackground(Color.red);
		btn.setOpaque(true);
		btn.setBorderPainted(false);
		btn.setBounds(x, y, unit, unit);
		btn.setLayout(new BorderLayout());
		JLabel nameLabel = new JLabel(quest.getName());
		JLabel descriptionLabel = new JLabel(quest.getDescription());
		JLabel rewardLabel = new JLabel(quest.getDoblonsReward() + " dobloni");
		nameLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 11));
		descriptionLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 10));
		rewardLabel.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 11));
		btn.add(nameLabel, BorderLayout.NORTH);
		btn.add(descriptionLabel, BorderLayout.CENTER);
		btn.add(rewardLabel, BorderLayout.SOUTH);
	}

	public void drawStringUnderPlayer(String s) {
		var playerPosition = camera.getPlayerPoint();
		playerPosition.setY(playerPosition.y + 1.5);
		playerPosition.setX(playerPosition.x - 2);
		var x = getXinPixel(playerPosition);
		var y = getYinPixel(playerPosition);
		g2.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20));
		g2.setColor(Color.BLACK);
		g2.drawString(s, x, y);
	}

	@Override
	public void drawQuestJournal(World w) {
		int width;
		int height;
		if(camera.isHub()){
			width = GameEngine.HUB_WINDOW_WIDTH;
			height = GameEngine.HUB_WINDOW_HEIGHT;
		}else{
			width = GameEngine.WINDOW_WIDTH;
			height = GameEngine.WINDOW_HEIGHT;
		}
		g2.setColor(new Color(0, 0, 0, 0.6f));
		g2.fillRect(0,0,width,height);
		g2.setColor(Color.WHITE);
		g2.drawRoundRect(width/12, height/12, 5*width/6, 5*height/6, 36, 36);

		var quests = ((PlayerEntity)w.getPlayer()).getQuests();

		int singleQuestHeight = 150;

		g2.setFont(titleFont);
		g2.drawString("Registro Missioni", width/2 - 75, height/24);

		quests.forEach((Quest q) -> {
			int indexOfQuest = quests.indexOf(q);
			g2.setFont(titleFont);
			g2.drawString(q.getName(), width/12 + 10 , height/12 + 20 + singleQuestHeight* indexOfQuest);
			g2.setFont(paragraphFont);
			g2.drawString(q.getDescription(), width/12 + 10 , height/12 + 50 + singleQuestHeight* indexOfQuest);
			g2.setFont(titleFont);
			g2.drawString(q.getDoblonsReward() + " dobloni", width/12 + 10 , height/12 + 80 +singleQuestHeight* indexOfQuest);
		});
	}

	private void outWeapon (int x, int y, int width, int height){
		g2.setColor(Color.blue);
		g2.fillRect(x, y, width, height);
	}

	@Override
	public void drawWeapon(FighterEntity fe) {
		if(((FighterEntity)fe).getWeapon().getSprite()==null){
			int vectX =((int)fe.getDamagingArea().getVel().x);
			int vectY =((int)fe.getDamagingArea().getVel().y);
			int height =50;
			int width =20;
			int offsetPP=width/2;
			int offsetPL=18;

			int x= getXinPixel(camera.getPlayerPoint())+18;
			int y= getYinPixel(camera.getPlayerPoint())+18;

			if(vectY==-1){
				outWeapon(x-offsetPP, y-(height+offsetPL), width, height);
			}
			if(vectY==1){
				outWeapon(x-offsetPP, y+offsetPL, width, height);
			}
			if(vectX==-1){
				outWeapon(x-(height+offsetPL), y-offsetPP, height, width);
			}
			if(vectX==1){
				outWeapon(x+offsetPL, y-offsetPP, height, width);
			}
		}
		else{
			/* da fare con sprite
			int vectX =((int)fe.getDamagingArea().getVel().x);
			int vectY =((int)fe.getDamagingArea().getVel().y);
			int height = fe.getWeapon().getSprite().;
			int width =20;
			int offsetPP=width/2;
			int offsetPL=18;

			int x= getXinPixel(camera.getPlayerPoint())+18;
			int y= getYinPixel(camera.getPlayerPoint())+18;

			if(vectY==-1){
				outWeapon(x-offsetPP, y-(height+offsetPL), width, height);
			}
			if(vectY==1){
				outWeapon(x-offsetPP, y+offsetPL, width, height);
			}
			if(vectX==-1){
				outWeapon(x-(height+offsetPL), y-offsetPP, height, width);
			}
			if(vectX==1){
				outWeapon(x+offsetPL, y-offsetPP, height, width);
			}
			*/

		}
		
		
		
	}

	

}
