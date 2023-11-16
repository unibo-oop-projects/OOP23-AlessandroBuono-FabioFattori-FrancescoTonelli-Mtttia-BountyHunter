package buontyhunter.graphics;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Stroke;

import com.google.common.util.concurrent.ExecutionError;

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
	public void drawPlayer(GameObject obj) {
		double halfWidth = (GameEngine.WORLD_WIDTH / 2);
		double halfHeight = (GameEngine.WORLD_HEIGHT / 2);
		var pos = obj.getPos();
		var x = pos.x > halfWidth ? getDeltaXinPixel(halfWidth) : getXinPixel(obj.getPos());
		var y = pos.y > halfHeight ? getDeltaYinPixel(halfHeight) : getYinPixel(obj.getPos());
		var height = getDeltaYinPixel(((RectBoundingBox) obj.getBBox()).getHeight());
		var width = getDeltaXinPixel(((RectBoundingBox) obj.getBBox()).getWidth());

		g2.setColor(Color.RED);
		g2.fillRect(x, y, width, height);
	}

	@Override
	public void drawMap(TileManager tileManager) {
		double halfWidth = (GameEngine.WORLD_WIDTH / 2);
		double halfHeight = (GameEngine.WORLD_HEIGHT / 2);

		var pos = tileManager.getPlayer().getPos();

		var tiles = tileManager.getTiles();
		var firstX = pos.x > halfWidth ? (int) Math.floor(pos.x - halfWidth) : 0;
		var firstY = pos.y > halfHeight ? (int) Math.floor(pos.y - halfHeight) : 0;
		var offsetX = pos.x > halfWidth ? (pos.x - halfWidth) - Math.floor(pos.x - halfWidth) : 0;
		var offsetY = pos.y > halfHeight ? (pos.y - halfHeight) - Math.floor(pos.y - halfHeight) : 0;
		var lastX = offsetX > 0 ? firstX + GameEngine.WORLD_WIDTH + 1 : firstX + GameEngine.WORLD_WIDTH;
		var lastY = offsetY > 0 ? firstY + GameEngine.WORLD_HEIGHT + 1 : firstY + GameEngine.WORLD_HEIGHT;

		int i = 0, j = 0;
		for (int y = firstY; y < lastY; y++) {
			i = 0;
			for (int x = firstX; x < lastX; x++) {
				Point2d tilePos = new Point2d(i - offsetX, j - offsetY);
				try {
					var image = tiles.get(y).get(x).getImage().getScaledInstance(getDeltaXinPixel(1),
							getDeltaYinPixel(1), Image.SCALE_DEFAULT);
					g2.drawImage(image, getXinPixel(tilePos),
							getYinPixel(tilePos), null);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					System.out.println("we're fucked up");
				}

				i++;
			}
			j++;
		}

	}
}
