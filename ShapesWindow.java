import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

enum ShapeType {
    ELLIPSE(0), RECTANGLE(1), TRIANGLE(2);

    private final int value;
    private ShapeType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

abstract class Shape {
    private static final int MAX_COLOR = 255;

    ShapeType type; 
    int length;
    int height;
    int x;
    int y;
    Color c;
    
    Shape(int windowWidth, int windowHeight) {
        Random r = new Random();
        c = new Color(r.nextInt(MAX_COLOR), r.nextInt(MAX_COLOR), r.nextInt(MAX_COLOR));
        x = r.nextInt(windowWidth);
        y = r.nextInt(windowHeight);
        length = r.nextInt(windowWidth - x);
        height = r.nextInt(windowHeight - y);
    }

    abstract ShapeType getType();
    abstract void draw(Graphics graphics, double scalex, double scaley);

    @Override
    public String toString() {
        return getType()+":"+c.getRed() + "," + c.getGreen() + ","+ c.getBlue() + ";";
    }
}

class Ellipse extends Shape {
    public Ellipse(int windowWidth, int windowHeight){
        super(windowWidth, windowHeight);
    }

    @Override 
    public ShapeType getType(){
        return ShapeType.ELLIPSE;
    }

    @Override 
    public void draw(Graphics graphics, double scalex, double scaley) {
        graphics.drawOval(
            (int)(x * scalex), 
            (int)(y * scaley), 
            (int)(length * scalex), 
            (int)(height * scaley)
        );
    }

    @Override 
    public String toString() {
        return super.toString() + x +"," + y + "," + length + "," +height; 
    }
}

class Rectangle extends Shape {
    public Rectangle(int windowWidth, int windowHeight){
        super(windowWidth, windowHeight);
    }

    @Override 
    public ShapeType getType(){
        return ShapeType.RECTANGLE;
    }

    @Override 
    public void draw(Graphics graphics, double scalex, double scaley){
        graphics.drawRect(
            (int)(x * scalex), 
            (int)(y * scaley), 
            (int)(length * scalex), 
            (int)(height * scaley)
        );
    }

    @Override 
    public String toString() {
        return super.toString() + x +"," + y + "," + length + "," + height; 
    }
}

class Triangle extends Shape {
    int[] arrx = new int[3];
    int[] arry= new int[3];

    Triangle(int windowWidth, int windowHeight) {
        super(windowWidth, windowHeight);
        Random r = new Random();
        arrx[0] = x;
        arrx[1] = x+length;
        arrx[2] = r.nextInt(length)+x;
        arry[0] = y;
        arry[1] = y+height;
        arry[2] = r.nextInt(height)+y;
    }

    @Override 
    public ShapeType getType(){
        return ShapeType.TRIANGLE;
    }

    @Override 
    public void draw(Graphics graphics, double scalex, double scaley){
        int[] xtmp = new int[3];
        int[] ytmp = new int[3];

        for (int m = 0; m < 3; m++){
            xtmp[m] = (int)(arrx[m]*scalex);
            ytmp[m] = (int)(arry[m]*scaley);
        }
        graphics.drawPolygon(xtmp, ytmp, arry.length);
    }

    @Override 
    public String toString() {
        return super.toString()+ arrx[0] +"," + arrx[1] + "," +
            arrx[2] + "," + arry[0] + "," + arry[1] + ","+ arry[2];
    }
}


public class ShapesWindow extends JFrame {
    private static final int REPAINT_INTERVAL_MSEC = 3000;
    private static final int WINDOW_HEIGHT = 768;
    private static final int WINDOW_WIDTH = 1024;

    
    static FileWriter writer;// new FileWriter("output.txt"); 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ShapesWindow window = new ShapesWindow();
            window.addingThread().start();
            
        }); 
    }

    ArrayList<Shape> shapes = new ArrayList<>();
    
    public ShapesWindow() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("BIG Figures");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        try {
            writer = new FileWriter("output.txt");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void closeFile() {
        System.out.println("Closing file");
        try {
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Closed file");
    }

    public void writeToFile(Shape p) {
        try {
            writer.write(p.toString());
            writer.flush();
        } catch (IOException e) {
            System.out.println(e);
        } 
    }
    
    public void paint(Graphics g) {

        double scalex = (double)getWidth()/WINDOW_WIDTH;
        double scaley = (double)getHeight()/WINDOW_HEIGHT;

        g.clearRect(0, 0, getWidth(), getHeight());
        
        for (Shape shape : shapes) {
            g.setColor(shape.c);
            shape.draw(g, scalex, scaley);
        }
    }

    public void addShape() {
        Random rand = new Random();
        int r = rand.nextInt(ShapeType.values().length);
        ShapeType shapeType = ShapeType.values()[r];
        Shape shape;

        switch (shapeType) {
            case ELLIPSE:
                shape = new Ellipse(WINDOW_WIDTH, WINDOW_HEIGHT);
                break;
            case RECTANGLE:
                shape = new Rectangle(WINDOW_WIDTH, WINDOW_HEIGHT);
                break;
            case TRIANGLE:
                shape = new Triangle(WINDOW_WIDTH, WINDOW_HEIGHT);
                break;
            default:
                return;
        }
        shapes.add(shape);
        writeToFile(shape);
    }
  
    public Thread addingThread() {
        return new Thread(() -> {
            try {
                while (true) {
                    addShape();
                    repaint();
                    try {
                        Thread.sleep(REPAINT_INTERVAL_MSEC);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                closeFile();
            } 
        });
    }
}