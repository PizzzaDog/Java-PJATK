public class Task_1 {
    public static void main(String[] args){
       /* long a = System.currentTimeMillis();
        for(int i = 0; i <= 1000000; i++){
            System.out.println(i);
        }
        long b = System.currentTimeMillis();
       
        System.out.println(b - a);*/
        Thread thread0 = new Thread(new Runnable() {
            public void run() {
                long a = System.currentTimeMillis();
                for(int i = 1; i <= 1000000; i+=2){
                    System.out.println(i);
                }
                long b = System.currentTimeMillis();
                System.out.println("thread 1 " + (b - a));
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                long c = System.currentTimeMillis();
                for(int i = 0; i <= 1000000; i+=2){
                    System.out.println(i);
                }
                long d = System.currentTimeMillis();
                System.out.println("thread 2:" + (d - c));
                 
            }
        });

       thread0.start();
        thread1.start();
        
        
    }
}