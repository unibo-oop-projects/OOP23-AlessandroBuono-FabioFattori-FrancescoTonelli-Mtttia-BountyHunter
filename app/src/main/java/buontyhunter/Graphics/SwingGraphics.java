package buontyhunter.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import buontyhunter.common.Point2d;
import buontyhunter.core.GameEngine;
import buontyhunter.model.CircleBoundingBox;
import buontyhunter.model.GameObject;
import buontyhunter.model.RectBoundingBox;
import buontyhunter.model.TileManager;

public class SwingGraphics implements Graphics {

	private Graphics2D g2;
	private static final Stroke strokeBall = new BasicStroke(4f);
	private static final Stroke strokePick = new BasicStroke(8f);

	private int centerX;
	private int centerY;
	private double ratioX;
	private double ratioY;

	public SwingGraphics(Graphics2D g2, int centerX, int centerY, double ratioX, double ratioY) {
		this.g2 = g2;
		this.centerX = centerX;
		this.centerY = centerY;
		this.ratioX = ratioX;
		this.ratioY = ratioY;
	}

	private int getXinPixel(Point2d p) {
		return (int) Math.round(centerX + p.x * ratioX);
	}

	private int getYinPixel(Point2d p) {
		return (int) Math.round(centerY - p.y * ratioY);
	}

	private int getDeltaXinPixel(double dx) {
		return (int) Math.round(dx * ratioX);
	}

	private int getDeltaYinPixel(double dy) {
		return (int) Math.round(dy * ratioY);
	}

	@Override
	public void drawPlayer(GameObject obj) {
		var x = getXinPixel(obj.getPos());
		var y = getYinPixel(obj.getPos());
		var height = getDeltaYinPixel(((RectBoundingBox) obj.getBBox()).getHeight());
		var width = getDeltaXinPixel(((RectBoundingBox) obj.getBBox()).getWidth());

		g2.setColor(Color.RED);
		g2.fillRect(x, y, width, height);
	}

	@Override
	public void drawMap(TileManager tileManager) {
		double screenStartX = (GameEngine.WORLD_WIDTH / 2);
		double screenStartY = (GameEngine.WORLD_HEIGHT / 2);
		var pos = new Point2d(tileManager.getPos().x + screenStartX,
				tileManager.getPos().y - screenStartY);
		var tiles = tileManager.getTiles();
		var firstX = (int) Math.floor(pos.x);
		var firstY = (int) Math.floor(pos.y);
		var offsetX = pos.x - firstX;
		var offsetY = pos.y - firstY;

		try {
			for (int y = firstY; y <= GameEngine.WORLD_HEIGHT; y++) {
				for (int x = firstX; x <= GameEngine.WORLD_WIDTH; x++) {
					Point2d tilePos = new Point2d(x - offsetX - screenStartX, y - offsetY - screenStartY);
					g2.drawImage(tiles.get(x).get(y).getImage(), getXinPixel(tilePos),
							getYinPixel(tilePos), null);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("we're fucked up");
		}
	}
}
