
public class test {
    public static void main(String[] args) {
        info(encode(130999,101,7777,99,7000,6));
    }

    public static long encode(int caller, int caller_zone,
                              int callee, int callee_zone,
                              int duration, int tariff) {
        long enc;
        enc = check(caller,17);
        enc+= (caller >>>=(17-check(caller,17)));
        caller_zone<<=(7-check(caller_zone,7));
        enc<<=7;
        enc+= (caller_zone >>>=(7-check(caller_zone,7)));
        enc<<=17;
        callee<<=(17-check(callee,17));
        enc+=(callee >>>=(17-check(callee,17)));
        enc<<=7;
        callee_zone<<=(7-check(callee_zone,7));
        enc+=(callee_zone >>>=(7-check(callee_zone,7)));
        enc<<=13;
        duration<<=(13-check(duration,13));
        enc+=(duration >>>=(13-check(duration,13)));
        enc<<=3;
        tariff<<=(3-check(tariff,3));
        enc+=(tariff >>>=(3-check(tariff,3)));
        return enc;
    }
    public static int check(int n, int bitL){
        int count = 0;
        int mask = 1;
        for( int i=1; i<=bitL; i++){
            if( (n & (mask << i)) != 0)
                count=i;
        }
        return count+=1;
    }
    public static void info(long res) {
        {long caller = res >>> 47;
        System.oput.println(caller);
        }
        {res <<=17;
        long caller_zone = res >> 57;  
        System.oput.println(caller_zone);
        }
        {res <<=24;
        long callee = res >> 47; 
        System.oput.println(callee);
        }
        {res <<=34;
        long callee_zone = res >> 57;
        System.oput.println(callee_zone);
        }
        {res <<=51;
        long duration = res >> 51;  
        System.oput.println(duration);
        }
        {res <<=54;
        long tariff = res >> 61;  
        System.oput.println(tariff);
        }
    }
}