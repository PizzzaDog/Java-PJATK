import javax.swing.*;

public class Task_1 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame window = new MyFrame();
        });
    
    }
}

class MyFrame extends JFrame {
    public MyFrame() {
        setSize(1024, 768);
        setTitle("Hello, world!");
        setVisible(true);   
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    };       
}    


class A extends JFrame {
    A() {
        //...
    }
    public void paint(Graphics g) {
        // We are setting RGB color for drawing
        g.setColor(new Color(255, 1, 100));
        // At the point (512, 512) we are drawing an ellipse with dimension 40x40
        // Notice: (0,0) point is located in top left corner of a window
        g.drawOval(512, 512, 40, 40);
    }
}