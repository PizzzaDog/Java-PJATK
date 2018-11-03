public class OneLiners {
    public static boolean hasTwoRoots(double a, double b, double c) {
        boolean n = false;
        double d = ((b * b) - (4 * a * c));
        if (d > 0 && a!=0) {
            n = true;
        }
        return n;
    }

    public static boolean monot(double a, double b, double c) {
        boolean k = false ;
        if ((a>b && b>c) || (a<b && b<c)){
            k = true;
        }
        return k;
    }

    public static double maxEl(double a, double b, double c) {
        double s = a>=b ? a : b;
        s = s>=c ? s : c;
        return s;
    }

    public static int numPos(double a, double b, double c) {
        double arr [] = {a,b,c};
        int i;
        int n=0;
        for (i=0; i<arr.length; i++){
            if (arr[i]>0){
                n++;
            }
        }
        return n;
   }

    public static void main(String[] args) {
        double a = 2, b = 3, c = 1;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): hasTwoRoots? " + hasTwoRoots(a, b, c));
        a = 0;
        b = 2;
        c = 1;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): hasTwoRoots? " + hasTwoRoots(a, b, c));

        a = 2;
        b = 1;
        c = -1;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): monot? " + monot(a, b, c));
        a = 2;
        b = 1;
        c = 2;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): monot? " + monot(a, b, c));

        a = 2;
        b = 1;
        c = 2;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): maxEl = " + maxEl(a, b, c));
        a = 2;
        b = 2;
        c = 4;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): maxEl = " + maxEl(a, b, c));

        a = -2;
        b = 1;
        c = -3;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): numPos = " + numPos(a, b, c));
        a = -2;
        b = 1;
        c = 3;
        System.out.println("(a, b, c,)=(" + a + ", " + b + ", " + c + "): numPos = " + numPos(a, b, c));

    }
}