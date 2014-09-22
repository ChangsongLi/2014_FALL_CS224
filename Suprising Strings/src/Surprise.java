import java.util.Scanner;


public class Surprise {

	public void solve(){
		Scanner scan = new Scanner(System.in);
		String s; 
		while( !(s = scan.next()).equals("*") ){
			int c = check(s);
			System.out.print(s);
			if( c == 0 ){
				System.out.println(" is surprising.");
			}
			else{
				System.out.println(" is NOT surprising.");
			}
		}
	}
	
	public int check( String s ){
		if( s.length() < 3 ){
			return 0;
		}
		
		int increment = 1;
		for( int i = 0; i < s.length() - 2; i++ ){
			String list = "";
			String part = "";
			for( int j = 0; j < s.length() - increment; j++ ){
				part = part + s.charAt(j) + s.charAt( j + increment );
				if( list.contains(part) ){
					return -1;
				}
				list = list + part + ",";
				part = "";
			}
			increment++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Surprise s = new Surprise();
		s.solve();
	}

}
