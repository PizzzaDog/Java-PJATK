public class Task_2{
    public static void main(String[] args) {
        Thread thread0 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.print(i + " ");
                }
                //System.out.println();
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0; i < 10; i++){
                    System.out.print(i + " ");
                }
                //System.out.println();
            }
        });

        thread0.start();
        thread1.start();
    }

}