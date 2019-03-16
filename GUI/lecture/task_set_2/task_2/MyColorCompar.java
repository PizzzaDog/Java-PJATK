import java.util.Comparator;
import java.awt.Color;
public class MyColorCompar  implements Comparator<MyColor>{
    public enum ColComponent { RED{
        @Override
        public int compare(MyColor a, MyColor b){
            if(a.red == b.red){
                return 0;
            }else if(a.red > b.red) {
                return +1;
            }else return -1;

        }
    }, GREEN{
        @Override
        public int compare(MyColor a, MyColor b){
            if(a.green == b.green){
                return 0;
            }else if(a.green > b.green) {
                return +1;
            }else return -1;

        }

    }, BLUE{
        @Override
        public int compare(MyColor a, MyColor b){
            if(a.blue == b.blue){
                return 0;
            }else if(a.blue > b.blue) {
                return +1;
            }else return -1;
        }
    }};
    public ColComponent comp;

    public MyColorCompar(ColComponent c){
        comp = c;
    }
}