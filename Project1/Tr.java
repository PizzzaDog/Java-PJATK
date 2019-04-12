import javax.swing.*;
import java.awt.geom.Point2D;
import java.awt.*;
class Tr extends Component{
    private JFrame f;
    int[] x, y;
    int n =3;
    Color color;
    Tr(JFrame f, int[]x , int y[], Color color) {
        this.f = f;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D d2 = (Graphics2D) g;
        d2.setColor(color);
        d2.fillPolygon(x, y, n);
    }

    @Override 
    public String toString(){
        return color.getRed() + "," + color.getGreen() + ","+ color.getBlue() + ";" + "tr" + ":" + x[0] +"," + x[1] + "," +
        x[2] + "," + y[0] + "," + y[1] + ","+ y[2];
    }
}