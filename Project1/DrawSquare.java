import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyWindow window = new MyWindow();
            window.movingThread().start();
        });
    }

    final int TITLE_BAR_HEIGHT = 20;
    int x, y, radius;
    int dx, dy;

    public MyWindow(){
        this.x = 20;
        this.y = 50;
        this.radius = 40;
        this.dx = 1;
        this.dy = 1;

        setSize(500, 300);
        setTitle("Hello, world!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {

        g.clearRect(0,0,getWidth(),getHeight());
        g.setColor(Color.BLUE);
        //Task 3
        //g.drawOval((getWidth()-radius)/2, (getHeight()-radius+TITLE_BAR_HEIGHT)/2, radius, radius);
        //-------
        //Task 6
        g.drawOval(x, y, radius, radius);
    }

    public Thread movingThread(){
        return new Thread(() -> {
            while (true) {
                x += dx;
                if(x <= 0 || x >= getWidth()-radius)
                    dx *= -1;
                y += dy;
                if(y <= TITLE_BAR_HEIGHT || y >= getHeight()-radius)
                    dy *= -1;

                repaint();
                try {
                    Thread.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
