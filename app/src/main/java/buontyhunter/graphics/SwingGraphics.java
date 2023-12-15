package buontyhunter.graphics;

import java.util.function.Predicate;
import java.util.function.Function;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;

import buontyhunter.core.GameEngine;
import buontyhunter.common.ImageType;
import buontyhunter.common.Point2d;
import buontyhunter.model.FighterEntity;
import buontyhunter.model.GameObject;
import buontyhunter.model.HealthBar;
import buontyhunter.model.HidableObject;
import buontyhunter.model.NavigatorLine;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.TileManager;
import buontyhunter.model.TileType;
import buontyhunter.model.World;
import buontyhunter.model.Tile;
import java.awt.*;

public class SwingGraphics implements Graphics {

	private Graphics2D g2;

	private double ratioX;
	private double ratioY;
	private SceneCamera camera;
	private SwingAssetProvider assetManager;

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

		g2.drawImage(assetManager.getImage(ImageType.MAPBG), firstX, firstY, null);
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
		g2.fillRect(getXinPixel(tilePos) + mapShowOffSetX + (int) Math.floor(p.getPos().x) * propsX,
				getYinPixel(tilePos) + mapShowOffSetY + (int) Math.floor(p.getPos().y) * propsY, propsX, propsY);

		var navigatorLine = w.getNavigatorLine();
		var pathStream = navigatorLine.getPath().stream();

		g2.setColor(Color.ORANGE);
		pathStream.forEach((Point2d np) -> g2.fillOval(getXinPixel(tilePos) + (int) np.x - 2,
				getYinPixel(tilePos) + (int) np.y - 2, 5, 5));
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
	public void drawTitleScreen(HidableObject titleScreen, World w) {
		Font sbTitleFont = new Font("Verdana", Font.ITALIC, 33);
			Font titleFont = new Font("Verdana", Font.PLAIN, 84);

		String title = "BountyHunter";
		String subTitle = "press any key to start ...";

		

		g2.drawImage(assetManager.getImage(ImageType.GAME_ICON), 0, 0, null);

		g2.setColor(Color.BLACK);
		g2.setFont(titleFont);
		g2.drawString(title, 0, 90);
		g2.setFont(sbTitleFont);
		g2.drawString(subTitle, 0, 150);
	}
}
