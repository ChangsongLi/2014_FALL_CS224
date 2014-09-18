import java.util.Scanner;


public class Solver {

	public void solve(){
		Scanner scan = new Scanner(System.in);
		String s;
		
		while( !(s = scan.nextLine()).equals("#") ){
			print(s);
		}
		
		scan.close();
	}
	
	public void print( String s ){
		int sum = 0;
		for( int i = 1; i <= s.length(); i++ ){
			if( s.charAt(i-1) != ' ' ){
				sum = sum + (int)( s.charAt(i-1) - 'A' + 1 ) * i;
			}
		}
		
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		Solver s = new Solver();
		s.solve();
	}

}
