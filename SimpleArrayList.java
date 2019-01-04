public class SimpleArrayList{
    private final static int INITIAL_CAPASITY = 5; 
    private int size = 0;
    private int cap = INITIAL_CAPASITY;
    private int [] arr = new int[cap];
    
    public static void main(String[] args) {
       SimpleArrayList a =
            new SimpleArrayList()
                .append(new int[]{1,3}).insert(1,2)
                .append(6).insert(3,new int[]{4,5});
        SimpleArrayList b = new SimpleArrayList(a);
        for (int i = 0; i < a.size(); ++i)
            a.set(i,a.get(i)+6);
        b.append(a).append(13).trim();
        System.out.println("a -> " + a);
        System.out.println("b -> " + b);
    }

    public SimpleArrayList(){
        size = 0;
        cap = INITIAL_CAPASITY;
    }

    public SimpleArrayList(int a){
        arr[0] = a;
        size = 1;
    }

    public SimpleArrayList(int [] crr){
        arr = crr;
        size = arr.length;
        //cap =
    }

    public SimpleArrayList(SimpleArrayList a){
        arr = a.arr;
    }

    public int size(){
        return size;
    }

    public void clear(){
        size = 0;
        cap = INITIAL_CAPASITY;
        arr = new int [cap];
    }

    public void trim(){
        cap = size;
    }

    public SimpleArrayList insert (int ind, int [] other){
        if (ind > size || ind < 0){
            throw new IndexOutOfBoundsException();
        }
        
        if(cap < (arr.length + other.length)){
           arr = new int[(arr.length + other.length)*2];     
        } 

        for(int i = ind; i <= other.length + ind; i++){
            arr[i+other.length] = arr[i];
            arr[i] = other[i-ind];
        }             
        return this;
        /*
        ind = 4 ; other = [4,5,7]
        [0,1,2,3,4,5,6,7,8,9,10,]
        [2,4,6,7,4,7,8,4,6,7,8, , , ]
        [2,4,6,7, , , ,4,7,8,4,6,7,8]        
        i = 4;
        shift =other.length+ ind;
        i+1 = 5;
        5+3 
        [4,5,7]

        int[] arr = new  int[5];
        int [] arr = {3};
        */
    }

    public SimpleArrayList insert(int ind, int e){
        insert(ind, new int[]{e});
        return this;
    }

    public SimpleArrayList append(int e){
        arr[arr.]    
    }
}