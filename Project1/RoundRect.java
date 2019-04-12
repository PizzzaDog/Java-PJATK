import javax.swing.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;
class RoundRect extends Component{
    private JFrame f;
    private int x, y, w, h,arcW, arcH;
    private Color color;
    RoundRect(JFrame f, int x, int y, int w, int h, int arcW, int arcH, Color color) {
        //super(new BorderLayout());
        this.f = f;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.arcW = arcW;
        this.arcH = arcH;
        this.color = color;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d2 = (Graphics2D) g;
        //Ellipse2D.Double circle = new Ellipse2D.Double((f.getWidth() - dim) / 2, (f.getHeight()-dim)/2, dim, dim);
        //Ellipse2D.Double circle = new Ellipse2D.Double(x, y, 2*rad1, 2*rad2);
        d2.setColor(color);
        //d2.fill(circle);
        d2.fillRoundRect(x,y,w,h,arcW,arcH);
    }
    
    @Override 
    public String toString(){
        return color.getRed() + "," + color.getGreen() + ","+ color.getBlue() + ";" + "Roundrect" + ":" + x +"," 
        + y + "," + w + "," + h + "," + arcW + "," + arcH; 
    }
}