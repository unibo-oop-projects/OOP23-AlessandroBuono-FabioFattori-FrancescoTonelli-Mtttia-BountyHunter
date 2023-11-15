package buontyhunter.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import buontyhunter.Core.GameState;


/**
 * ScreenHandler => this class will handle all the frame-type operation 
 */
public class ScreenHandler implements IScreenHandler{
    private static final String APPLICATION_TITLE = "Buonty Hunter v1.0";
    private static final int screenWidth = 600;
    private static final int screenHeight = 400;
    private JFrame frame;
    private GameState gameState;
    private ScenePanel panel;

    public ScreenHandler(GameState gameState){
        this(APPLICATION_TITLE, gameState);
    }

    public ScreenHandler(String title, GameState gameState){
		this.gameState = gameState;

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Dimension screenDimension = new Dimension(screenWidth, screenHeight);

        

        frame.setPreferredSize(screenDimension);
        frame.setSize(screenDimension);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        this.panel = new ScenePanel(screenWidth, screenHeight, screenWidth, screenHeight);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }

    @Override
    public void draw() {
        frame.repaint();
    }

	/* ScenePanel is an innested class that contain all the graphic rappresentation of the gameObjects */
    public class ScenePanel extends JPanel implements KeyListener {

    	
        private Font gameOverFont;
		private Stroke strokeBorder = new BasicStroke(2f);

    	public ScenePanel(int w, int h, double width, double height){
            
            
            gameOverFont = new Font("Verdana", Font.PLAIN, 88);
            
            this.addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            requestFocusInWindow(); 
            
        }
        
        public void paint(Graphics g){
    		Graphics2D g2 = (Graphics2D) g;
    		
    		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    		          RenderingHints.VALUE_ANTIALIAS_ON);
    		g2.setRenderingHint(RenderingHints.KEY_RENDERING,
    		          RenderingHints.VALUE_RENDER_QUALITY);
    		g2.clearRect(0,0,this.getWidth(),this.getHeight());
            
    		if (gameState.isGameOver()){

    			/* drawing the score */
				g2.setFont(gameOverFont);
				g2.setColor(Color.BLACK);
				g2.drawString("GAME OVER ", 30, 50);
				
       			
    		} else {
    			/* drawing the border */
    			g2.setStroke(strokeBorder);
    			g2.setColor(Color.BLACK);
    			g2.drawRect(0, 0, this.getWidth(), this.getHeight());
				
				/* drawing the game objects */
				
				gameState.getGameObjects().forEach( e -> {
					e.draw(g2);
				});
				
    		}
        }

    	
    	
    	@Override
		public void keyPressed(KeyEvent e) {
	     	/*
            if (e.getKeyCode() == 38){
	     		controller.notifyMoveUp();
	     	} else if (e.getKeyCode() == 40){
	     		controller.notifyMoveDown();
	     	} else if (e.getKeyCode() == 39){
	     		controller.notifyMoveRight();
	     	} else if (e.getKeyCode() == 37){
	     		controller.notifyMoveLeft();
	     	}
            */

			
		}

		@Override
		public void keyTyped(KeyEvent e) {}

		@Override
		public void keyReleased(KeyEvent e) {
	     	/*
            if (e.getKeyCode() == 38){
	     		controller.notifyNoMoreMoveUp();
	     	} else if (e.getKeyCode() == 40){
	     		controller.notifyNoMoreMoveDown();
	     	} else if (e.getKeyCode() == 39){
	     		controller.notifyNoMoreMoveRight();
	     	} else if (e.getKeyCode() == 37){
	     		controller.notifyNoMoreMoveLeft();
	     	}
            */
		}
        
    }

    
}