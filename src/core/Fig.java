package core;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import utility.IConstants;

/**
 *
 * @author nelson
 */
public class Fig extends Thread implements IConstants{
    private int yPosition;
    private int movement;
    private int speed;
    private Color color;
    private Icon image;
    private boolean endExecution;
    private TrackPanel trackPanel;
    private boolean barrierActivated;
    
    public Fig(int speed, int movement, Color color, Icon image, TrackPanel trackPanel) {
        this.yPosition = STARTING_TRACK_FIGURE_POSITION;
        this.movement = movement;
        this.speed = speed;
        this.color = color;
        this.image = image;
        this.endExecution = false;
        this.trackPanel = trackPanel;
        this.barrierActivated = false;
    }

    @Override
    public void run() {
        while (START_EXECUTION) {
            if (EXECUTE) { 
                if (!barrierActivated) {
                    yPosition += movement;
                    trackPanel.repaint();                    
                }
                try {
                    Thread.sleep(speed);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Fig.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (endExecution) {
                break;
            }
        }
    }
    
    public void endExecutionThread () {
        endExecution = true;
    }
    
    public Fig(int speed) {
        this.yPosition = STARTING_TRACK_FIGURE_POSITION;
        this.movement = speed;
    }        

    public int getyPosition() {
        return yPosition;
    }

    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }     

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }    

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }        

    void setBarrierActivated(boolean barrier) {
        this.barrierActivated = barrier;        
    }
}