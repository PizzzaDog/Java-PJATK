import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.awt.*;
class Elipse extends Component{
    private JFrame f;
    int x, y, rad1, rad2;
    Color color;

    Elipse(JFrame f, int x, int y, int rad1, int rad2, Color color) {
        this.f = f;
        this.x = x;
        this.y = y;
        this.rad1 = rad1;
        this.rad2 = rad2;
        this.color = color;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 2*rad1, 2*rad2);
        d2.setColor(color);
        d2.fillOval(x, y, 2*rad1, 2*rad2);
    }

    @Override 
    public String toString() {
        return color.getRed() + "," + color.getGreen() + ","+ color.getBlue() + ";" + "elipse" + ":" + x +"," + y + "," + rad1 + "," +rad2; 
    }
}