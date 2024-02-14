package buontyhunter.graphics;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import buontyhunter.common.ImageType;
import buontyhunter.common.Logger.AppLogger;
import buontyhunter.common.Logger.LogType;
import buontyhunter.model.World;

public class TitleSwingScene {
    private final int loadingTime;
    private int currentLoaded;
    private final JFrame frame;
    private final TitlePannel pannelLoader;

    public TitleSwingScene(int width, int height) {
        this.currentLoaded = 0;

        this.loadingTime = 490;
        this.frame = new JFrame("BountyHunter");
        this.frame.setAlwaysOnTop(true);
        this.frame.setSize(new Dimension(width, height));
        this.frame.setPreferredSize(new Dimension(width, height));

        this.frame.setBackground(Color.CYAN);

        this.pannelLoader = new TitlePannel();
        this.frame.add(pannelLoader);
        this.frame.addKeyListener(pannelLoader);
        this.frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                System.exit(-1);
            }

            public void windowClosed(WindowEvent ev) {
                System.exit(-1);
            }
        });

        this.frame.setVisible(true);
    }

    public void startTitleLoop() {
        var drawCount = 0;
        long lastFPSPrint = 0;
        while (this.currentLoaded <= this.loadingTime) {
            long currentCycleStartTime = System.currentTimeMillis();

            render();
            drawCount++;
            waitForNextFrame(currentCycleStartTime);
            if (System.currentTimeMillis() - lastFPSPrint > 1000) {
                lastFPSPrint = System.currentTimeMillis();
                AppLogger.getLogger().log("FPS: " + drawCount, LogType.CORE);
                drawCount = 0;
            }
        }
        this.frame.setVisible(false);
    }

    /**
     * Wait until the next frame should be drawn
     * 
     * @param cycleStartTime time when the current cycle started
     */
    protected void waitForNextFrame(long cycleStartTime) {
        long dt = System.currentTimeMillis() - cycleStartTime;
        if (dt < 60) {
            try {
                Thread.sleep(60 - dt);
            } catch (Exception ex) {
            }
        }
    }

    private void render() {
        this.frame.repaint();
    }

    private int convertX(int toConvert) {
        return this.frame.getWidth() * toConvert / 510;
    }

    private class TitlePannel extends JPanel implements KeyListener {
        private boolean isLoading;

        private TitlePannel() {
            isLoading = false;
            this.addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {
            isLoading = true;
        }

        @Override
        public void keyPressed(KeyEvent e) {
            isLoading = true;
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // do nothing
        }

        public void paint(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;

            if (!isLoading) {
                g2.drawString("Press any key to start", frame.getWidth() / 2 - "Press any key to start".length() * 2,
                        frame.getHeight() - 100);
            } else {
                g2.drawString("loading...", frame.getWidth() / 2 - "Press any key to start".length() * 2,
                        frame.getHeight() - 200);
                drawProgressBar(g2);
            }
        }

        private void drawProgressBar(Graphics2D g2) {
            g2.setColor(Color.black);
            g2.fillRect(0, frame.getHeight() - 180, convertX(500), 80);
            g2.setColor(Color.white);
            g2.fillRect(10, frame.getHeight() - 170, convertX(currentLoaded), 60);
            currentLoaded += (int) (Math.random() * loadingTime / 10);
        }
    }

}
