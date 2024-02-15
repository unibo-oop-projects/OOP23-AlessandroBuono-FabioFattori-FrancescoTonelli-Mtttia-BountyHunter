package buontyhunter.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;

import buontyhunter.common.ImagePathProvider;
import buontyhunter.common.Point2d;
import buontyhunter.core.GameEngine;
import buontyhunter.core.GameFactory;
import buontyhunter.input.*;
import buontyhunter.model.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.*;
import java.util.stream.Collectors;
import java.awt.BorderLayout;

public class SwingScene implements Scene, ComponentListener {

	protected JFrame frame;
	protected ScenePanel panel;
	protected KeyboardInputController controller;
	protected GameState gameState;
	private boolean switchScene = false;
	private boolean IsHub;
	private final List<JButton> buttons = new ArrayList<>();
	protected final SwingAssetProvider assetManager;

	public SwingScene(GameState gameState, KeyboardInputController controller, boolean IsHub) {

		this.assetManager = new SwingAssetProvider();
		this.gameState = gameState;
		this.IsHub = IsHub;
		frame = new JFrame("Bounty Hunter - the official game");
		frame.setMinimumSize(
				new Dimension(GameEngine.RESIZATOR.getWINDOW_WIDTH(), GameEngine.RESIZATOR.getWINDOW_HEIGHT()));
		panel = new ScenePanel(GameEngine.RESIZATOR.getWINDOW_WIDTH(), GameEngine.RESIZATOR.getWINDOW_HEIGHT(),
				GameEngine.RESIZATOR.getWORLD_WIDTH(),
				GameEngine.RESIZATOR.getWORLD_HEIGHT());

		frame.setSize(panel.getSize());
		// make the frame appear in the middle of the screen
		// Calculates the position where the CenteredJFrame
		// should be paced on the screen.
		int x = (GameEngine.RESIZATOR.getWINDOW_WIDTH() - frame.getWidth()) / 2;
		int y = (GameEngine.RESIZATOR.getWINDOW_HEIGHT() - frame.getHeight()) / 2;
		frame.setLocation(x, y);
		// frame.setLocationRelativeTo(null);
		if (IsHub) {
			getQuestPannel().getQuests().forEach(q -> {
				JButton button = new JButton();
				button.addActionListener(e1 -> {
					q.start((PlayerEntity) gameState.getWorld().getPlayer());
					frame.repaint();
				});
				buttons.add(button);
			});
		}

		frame.setResizable(true);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (!switchScene) {
					System.exit(0);
				}
			}
		});
		frame.addComponentListener(this);
		// frame.setUndecorated(true); // Remove title bar
		this.controller = controller;
		frame.setLayout(null);
		frame.add(panel, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
	}

	public void setIsHub(boolean isHub) {
		this.IsHub = isHub;
		if (isHub) {
			getQuestPannel().getQuests().forEach(q -> {
				JButton button = new JButton();
				button.addActionListener(e1 -> {
					q.start((PlayerEntity) gameState.getWorld().getPlayer());
					frame.repaint();
				});
				buttons.add(button);
			});
		} else {
			buttons.clear();
		}
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
		try {
			return (QuestPannel) gameState.getWorld().getInterractableAreas().stream()
					.filter(e -> e.getPanel() instanceof QuestPannel).findFirst().get().getPanel();
		} catch (Exception e) {
			throw new RuntimeException("QuestPannel not found" + gameState.getWorld().getInterractableAreas().stream()
					.filter(pan -> pan.getPanel() instanceof QuestPannel).toString());
		}
	}

	public class ScenePanel extends JPanel implements KeyListener {

		private int centerX;
		protected int centerY;
		protected double ratioX;
		protected double ratioY;
		protected Font scoreFont, gameOverFont;

		public ScenePanel(int w, int h, double width, double height) {
			setSize(w, h);
			ratioX = GameEngine.RESIZATOR.getRATIO_WIDTH();
			ratioY = GameEngine.RESIZATOR.getRATIO_HEIGHT();

			scoreFont = new Font("Verdana", Font.PLAIN, 36);
			gameOverFont = new Font("Verdana", Font.PLAIN, 88);
			setLayout(null);
			this.addKeyListener(this);
			setFocusable(true);
			setFocusTraversalKeysEnabled(false);
			requestFocusInWindow();
		}

		public void setRatioX(double ratioX) {
			this.ratioX = ratioX;
		}

		public void setRatioY(double ratioY) {
			this.ratioY = ratioY;
		}

		public void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;

			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,
					RenderingHints.VALUE_RENDER_QUALITY);
			g2.clearRect(0, 0, this.getWidth(), this.getHeight());

			// title screen graphics
			if (gameState.isInTitleScreen()) {
				g2.setColor(Color.CYAN);
				g2.fillRect(0, 0, this.getWidth(), this.getHeight());
				g2.setColor(Color.BLACK);
				g2.drawString("Press any key to start", GameEngine.RESIZATOR.getWINDOW_WIDTH() / 2 -50,
						GameEngine.RESIZATOR.getWINDOW_HEIGHT() -200);
				SwingGraphics gr = new SwingGraphics(g2, ratioX, ratioY, null, assetManager);
				gameState.getWorld().getLoadingBar().updateGraphics(gr, gameState.getWorld());
				return;
			}

			if (gameState.isGameOver()) {

				/* drawing the score */
				g2.setFont(gameOverFont);
				g2.setColor(Color.BLACK);

				g2.setFont(scoreFont);
				g2.setColor(Color.GREEN);

			} else {

				World scene = gameState.getWorld();

				/* drawing the game objects */

				var camera = new Camera(scene);
				camera.update(scene.getPlayer(), scene.getTileManager());
				SwingGraphics gr = new SwingGraphics(g2, ratioX, ratioY, camera, assetManager);
				gameState.getWorld().getSceneEntities().forEach(e -> {
					if (!(e instanceof Teleporter)) {
						e.updateGraphics(gr, scene);
					}

					if (e instanceof PlayerEntity) {

						((PlayerEntity) e).getDamagingArea().updateGraphics(gr, scene);
					}

					if ((camera.inScene(e.getPos()) && e instanceof Teleporter)) {
						e.updateGraphics(gr, scene);
					}
				});

				// render the buttons if it is the hub
				if (IsHub && getQuestPannel().isShow()) {
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

			controller.notifyAnyKeyIsPressedSinceStart();

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
				case 38:
					controller.notifyAttackUp();
					break;
				case 40:
					controller.notifyAttackDown();
					break;
				case 37:
					controller.notifyAttackLeft();
					break;
				case 39:
					controller.notifyAttackRight();
					break;
				case 77:
					controller.notifyMPressed();
					break;
				case 74:
					controller.notifyJPressed();
					break;
				case 69:
					controller.notifyEPressed();
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

			controller.notifyNoMoreAnyKeyIsPressedSinceStart();

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
				case 38:
					controller.notifyNoMoreAttackUp();
					break;
				case 40:
					controller.notifyNoMoreAttackDown();
					break;
				case 37:
					controller.notifyNoMoreAttackLeft();
					break;
				case 39:
					controller.notifyNoMoreAttackRight();
					break;
				case 77:
					controller.notifyNoMoreMPressed();
					break;
				case 74:
					controller.notifyNoMoreJPressed();
					break;
				case 69:
					controller.notifyNoMoreEPressed();
					break;

				default:
					break;

			}
		}

	}

	@Override
	public void dispose() {
		this.switchScene = true;
		this.frame.dispose();
	}

	@Override
	public void componentResized(ComponentEvent e) {

		var dim = frame.getSize();
		GameEngine.RESIZATOR.needToResize(dim);
		ImagePathProvider.resizeAssets();
		this.assetManager.loadAllAssets();

		this.panel.setSize(dim);
		this.panel.setRatioX((int) GameEngine.RESIZATOR.getRATIO_WIDTH());
		this.panel.setRatioY((int) GameEngine.RESIZATOR.getRATIO_HEIGHT());

	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// do nothing
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// do nothing
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// do nothing
	}
}
