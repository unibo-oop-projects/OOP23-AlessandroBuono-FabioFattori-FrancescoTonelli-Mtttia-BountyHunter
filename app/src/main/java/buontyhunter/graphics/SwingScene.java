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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.BorderLayout;

public class SwingScene implements Scene {

	protected JFrame frame;
	protected ScenePanel panel;
	protected KeyboardInputController controller;
	protected GameState gameState;
	private boolean switchScene = false;
	private final boolean IsHub;
	private final List<JButton> buttons = new ArrayList<>();

	public SwingScene(GameState gameState, KeyboardInputController controller, boolean IsHub) {

		this.gameState = gameState;
		this.IsHub = IsHub;
		frame = new JFrame("Bounty Hunter - the official game");
		// make the frame appear in the middle of the screen
		// Calculates the position where the CenteredJFrame
		// should be paced on the screen.
		int x = (GameEngine.WINDOW_WIDTH - frame.getWidth()) / 2;
		int y = (GameEngine.WINDOW_HEIGHT - frame.getHeight()) / 2;
		frame.setLocation(x, y);
		// frame.setLocationRelativeTo(null);
		if (IsHub) {
			frame.setMinimumSize(new Dimension(GameEngine.HUB_WINDOW_WIDTH, GameEngine.HUB_WINDOW_HEIGHT));
			getQuestPannel().getQuests().forEach(q -> {
				JButton button = new JButton();
				button.addActionListener(e1 -> {
					q.start((PlayerEntity) gameState.getWorld().getPlayer());
					frame.repaint();
				});
				buttons.add(button);
			});

			panel = new ScenePanel(GameEngine.HUB_WINDOW_WIDTH, GameEngine.HUB_WINDOW_WIDTH, GameEngine.HUB_WIDTH,
					GameEngine.HUB_HEIGHT);
		} else {
			frame.setMinimumSize(new Dimension(GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT));

			panel = new ScenePanel(GameEngine.WINDOW_WIDTH, GameEngine.WINDOW_HEIGHT, GameEngine.WORLD_WIDTH,
					GameEngine.WORLD_HEIGHT);
		}
		frame.setSize(frame.getMinimumSize());
		frame.setResizable(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (!switchScene) {
					System.exit(0);
				}
			}
		});
		// frame.setUndecorated(true); // Remove title bar
		this.controller = controller;
		frame.setLayout(null);
		frame.add(panel, BorderLayout.CENTER);
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

	private QuestPannel getQuestPannel() {
		return (QuestPannel) gameState.getWorld().getInterractableAreas().stream()
				.filter(e -> e.getPanel() instanceof QuestPannel).findFirst().get().getPanel();
	}

	public class ScenePanel extends JPanel implements KeyListener {

		private int centerX;
		protected int centerY;
		protected double ratioX;
		protected double ratioY;
		protected Font scoreFont, gameOverFont;
		protected final SwingAssetProvider assetManager;

		public ScenePanel(int w, int h, double width, double height) {
			setSize(w, h);
			centerX = w / 2;
			centerY = h / 2;
			ratioX = w / width;
			ratioY = h / height;

			scoreFont = new Font("Verdana", Font.PLAIN, 36);
			gameOverFont = new Font("Verdana", Font.PLAIN, 88);
			setLayout(null);
			this.addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			requestFocusInWindow();
			this.assetManager = new SwingAssetProvider();
		}

		public void paintComponent(Graphics g) {
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

			} else {

				World scene = gameState.getWorld();

				/* drawing the game objects */

				var camera = new Camera(scene, IsHub);
				camera.update(scene.getPlayer(), scene.getTileManager());
				SwingGraphics gr = new SwingGraphics(g2, ratioX, ratioY, camera, assetManager);
				gameState.getWorld().getSceneEntities().forEach(e -> {
					if (!(e instanceof Teleporter)) {
						e.updateGraphics(gr, scene);
					}

					if ((camera.inScene(e.getPos()) && e instanceof Teleporter)) {
						e.updateGraphics(gr, scene);
					}
				});

				// render the buttons if it is the hub
				if (IsHub) {
					int height = (int) ((RectBoundingBox) getQuestPannel().getBBox()).getHeight();
					int unit = height / 6;
					int x = unit + unit / 6;
					int y = x + unit / 12;
					buttons.forEach(btn -> {
						frame.remove(btn);
						btn.setVisible(false);
					});
					getQuestPannel().getQuests().stream()
							.filter(q -> !((PlayerEntity) gameState.getWorld().getPlayer()).getQuests().contains(q))
							.forEach(q -> {
								var offsetX = (unit + (unit * 2) / 6) * getQuestPannel().getQuests().stream()
										.filter(quest -> !((PlayerEntity) gameState.getWorld().getPlayer()).getQuests()
												.contains(quest))
										.collect(Collectors.toList()).indexOf(q);
								var button = buttons.get(getQuestPannel().getQuests().indexOf(q));
								button.setVisible(getQuestPannel().isShow());
								gr.drawQuest((QuestEntity) q, x + offsetX, y, unit, button);
								this.add(button, BorderLayout.CENTER);
							});
					frame.pack();
				}
			}
		}

		protected int getXinPixel(Point2d p) {
			return (int) Math.round(p.x * ratioX);
		}

		protected int getYinPixel(Point2d p) {
			return (int) Math.round(p.y * ratioY);
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == 87) {
				controller.notifyMoveUp();
			} else if (e.getKeyCode() == 83) {
				controller.notifyMoveDown();
			} else if (e.getKeyCode() == 68) {
				controller.notifyMoveRight();
			} else if (e.getKeyCode() == 65) {
				controller.notifyMoveLeft();
			} else if (e.getKeyCode() == 77) {
				controller.notifyMPressed();
			} else if (e.getKeyCode() == 69) {
				controller.notifyEPressed();
			} else if (e.getKeyCode() == 74) {
				controller.notifyJPressed();
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == 87) {
				controller.notifyNoMoreMoveUp();
			} else if (e.getKeyCode() == 83) {
				controller.notifyNoMoreMoveDown();
			} else if (e.getKeyCode() == 68) {
				controller.notifyNoMoreMoveRight();
			} else if (e.getKeyCode() == 65) {
				controller.notifyNoMoreMoveLeft();
			} else if (e.getKeyCode() == 77) {
				controller.notifyNoMoreMPressed();
			} else if (e.getKeyCode() == 69) {
				controller.notifyNoMoreEPressed();
			} else if (e.getKeyCode() == 74) {
				controller.notifyNoMoreJPressed();
			}
		}

	}

	@Override
	public void dispose() {
		this.switchScene = true;
		this.frame.dispose();
	}
}
