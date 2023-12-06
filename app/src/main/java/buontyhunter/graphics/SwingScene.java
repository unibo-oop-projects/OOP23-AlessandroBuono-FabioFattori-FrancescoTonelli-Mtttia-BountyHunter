package buontyhunter.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import buontyhunter.common.Point2d;
import buontyhunter.core.GameEngine;
import buontyhunter.input.*;
import buontyhunter.model.*;

public class SwingScene implements Scene {

	private JFrame frame;
	private ScenePanel panel;
	private KeyboardInputController controller;
	private GameState gameState;

	public SwingScene(GameState gameState, KeyboardInputController controller, int w, int h, double width,
			double height) {
		frame = new JFrame("Bounty Hunter - the official game");
		// make the frame appear in the middle of the screen
		// Calculates the position where the CenteredJFrame
		// should be paced on the screen.
		int x = (GameEngine.WINDOW_WIDTH - frame.getWidth()) / 2;
		int y = (GameEngine.WINDOW_HEIGHT - frame.getHeight()) / 2;
		frame.setLocation(x, y);
		// frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(w, h));
		frame.setSize(frame.getMinimumSize());
		frame.setResizable(false);
		// frame.setUndecorated(true); // Remove title bar
		this.gameState = gameState;
		this.controller = controller;
		panel = new ScenePanel(w, h, width, height);
		frame.getContentPane().add(panel);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				System.exit(-1);
			}

			public void windowClosed(WindowEvent ev) {
				System.exit(-1);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}

	public void render() {
		try {
			frame.repaint();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void renderGameOver() {
		try {
			SwingUtilities.invokeAndWait(() -> {
				frame.repaint();
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public class ScenePanel extends JPanel implements KeyListener {

		private int centerX;
		private int centerY;
		private double ratioX;
		private double ratioY;
		private Font scoreFont, gameOverFont;

		public ScenePanel(int w, int h, double width, double height) {
			setSize(w, h);
			centerX = w / 2;
			centerY = h / 2;
			ratioX = w / width;
			ratioY = h / height;

			scoreFont = new Font("Verdana", Font.PLAIN, 36);
			gameOverFont = new Font("Verdana", Font.PLAIN, 88);

			this.addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			requestFocusInWindow();
		}

		public void paint(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			g2.clearRect(0, 0, this.getWidth(), this.getHeight());

			if (gameState.isGameOver()) {

				/* drawing the score */
				g2.setFont(gameOverFont);
				g2.setColor(Color.BLACK);
				g2.drawString("GAME OVER ", 30, centerY - 50);
				g2.setFont(scoreFont);
				g2.setColor(Color.GREEN);
				g2.drawString("Final score " + gameState.getScore(), 180, centerY + 50);

			} else {

				World scene = gameState.getWorld();

				/* drawing the game objects */

				var camera = new Camera(scene);
				camera.update(scene.getPlayer(), scene.getTileManager());
				SwingGraphics gr = new SwingGraphics(g2, ratioX, ratioY, camera);
				gameState.getWorld().getSceneEntities().forEach(e -> {
					e.updateGraphics(gr, scene);
				});
			}
		}

		private int getXinPixel(Point2d p) {
			return (int) Math.round(p.x * ratioX);
		}

		private int getYinPixel(Point2d p) {
			return (int) Math.round(p.y * ratioY);
		}

		@Override
		public void keyPressed(KeyEvent e) {

			/*if (e.getKeyCode() == 87) {
				controller.notifyMoveUp();
			} else if (e.getKeyCode() == 83) {
				controller.notifyMoveDown();
			} else if (e.getKeyCode() == 68) {
				controller.notifyMoveRight();
			} else if (e.getKeyCode() == 65) {
				controller.notifyMoveLeft();
			} else if (e.getKeyCode() == 77) {
				controller.notifyMPressed();
			}*/

			switch (e.getKeyCode()) {
				case 87:
					controller.notifyMoveUp();
					break;
				case 83:
					controller.notifyMoveDown();
					break;
				case 68:
					controller.notifyMoveRight();
					break;
				case 65:
					controller.notifyMoveLeft();
					break;
				case 77:
					controller.notifyMPressed();
					break;
				default:
					break;
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			/*if (e.getKeyCode() == 87) {
				controller.notifyNoMoreMoveUp();
			} else if (e.getKeyCode() == 83) {
				controller.notifyNoMoreMoveDown();
			} else if (e.getKeyCode() == 68) {
				controller.notifyNoMoreMoveRight();
			} else if (e.getKeyCode() == 65) {
				controller.notifyNoMoreMoveLeft();
			} else if (e.getKeyCode() == 77) {
				controller.notifyNoMoreMPressed();
			}*/

			switch (e.getKeyCode()) {
				case 87:
					controller.notifyNoMoreMoveUp();
					break;
				case 83:
					controller.notifyNoMoreMoveDown();
					break;
				case 68:
					controller.notifyNoMoreMoveRight();
					break;
				case 65:
					controller.notifyNoMoreMoveLeft();
					break;
				case 77:
					controller.notifyNoMoreMPressed();
					break;
				default:
					break;

			}
		}

	}
}
