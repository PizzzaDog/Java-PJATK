import javax.swing.*;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.awt.*;
import java.io.FileWriter;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MyFrame f = new MyFrame();
            Elipse oval2 = new Elipse(f,512,618,20,20,new Color(255, 1, 100));
            ArrayList figures = new ArrayList();
            Rect r = new Rect(f,300,250,550,90, new Color(50,30, 180));

            int[]x = {200,100,40};
            int[]y = {500,476,390};
            Tr t = new Tr(f, x, y, new Color(230, 20, 109));
            JPanel j = new JPanel(new BorderLayout());

            f.add(j); 
            f.getContentPane().add(oval2);
            f.getContentPane().add(r);


            try {
                FileWriter writer = new FileWriter("output.txt"); 
                for(Object fig: figures) {
                    writer.write(fig.toString());
                }                
                writer.close();
            } catch(IOException e) {
                System.out.println(e);
            }   
        });
    }    
}
