import java.util.Scanner;


public class LargeProduct {

	private void solve(){
		Scanner scan = new Scanner( System.in );
		String read;
		String s = "";
		while( !(read = scan.nextLine()).equals("END") ){
			s = s + read;
		}
		long max = 0;
		for(int i = 0; i < s.length()- 12; i++){
			long num = 1;
			for( int j = 0; j < 13; j++ ){
				num = num * (s.charAt(i+j) - '0');
			}
			if(num > max)
				max = num;
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		LargeProduct l = new LargeProduct();
		l.solve();
	}

}
