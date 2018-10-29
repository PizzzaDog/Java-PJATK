import java.util.Scanner;
public
	class Test1{
		public static void main (String[]args){
			Scanner sc=new Scanner(System.in);

			int n=sc.nextInt();
			int curDig=0;
			int max=0;
			while(n>=10){
				curDig =n%10;
				max = max + curDig;
				n = (n-curDig)/10;
				}
				max = max + n;
				System.out.println(max);
				System.out.println(n);
				


			sc.close();
				}
			}