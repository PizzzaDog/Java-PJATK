import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.awt.*;
class Rect extends Component{
    private JFrame f;
    private int x, y, w, h;
    private Color color;
    Rect(JFrame f, int x, int y, int w, int h, Color color) {
        this.f = f;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.color = color;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d2 = (Graphics2D) g;
        d2.setColor(color);
        d2.fillRect(x, y, w, h);
    }
    
    @Override 
    public String toString() {
        return color.getRed() + "," + color.getGreen() + ","+ color.getBlue() + ";" + "rect" + ":" + x +"," + y + "," + w + "," + h; 
    }
}