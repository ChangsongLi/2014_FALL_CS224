import java.util.Scanner;


public class Solver {

	public void solve(){
		Scanner scan = new Scanner(System.in);
		String s;
		
		while( !( s = scan.nextLine() ).equals("#") ){
			int i = check(s);
			if( i == -1 ){
				System.out.println("suspicious");
			}
			else{
				System.out.println("OK");
			}
		}
	}
	
	public int check( String s ){
		Scanner scan = new Scanner( s );
		while( scan.hasNext() ){
			String str = scan.next();
			int i1 = checkTwoUpLe(str);
			if(i1 == -1){
				System.out.println(1);
				return -1;
			}
			int i2 = checkDiLe( str );
			if(i2 == -1){
				System.out.println(2);
				return -1;
			}
			
			int i3 = checkIsoLe( str );
			if( i3 == -1 ){
				System.out.println(3);
				return -1;
			}
			int i4 = checkTwoPunMark( str );
			if( i4 == -1 ){
				System.out.println(4);
				return -1;
			}
		
		}
		
		return 0;
	}
	
	public int checkTwoUpLe( String s ){
		for( int i = 0; i < s.length() - 1; i++ ){
			if( s.charAt(i) <= 'Z' && s.charAt(i) >= 'A' 
					&& s.charAt(i+1) <= 'Z' && s.charAt(i+1) >= 'A' ){
				return -1;
			}
		}
		
		return 0;
	}
	
	public int checkDiLe( String s ){
		for( int i = 0; i < s.length() - 1; i++ ){
			if( (s.charAt(i) <= '0' && s.charAt(i) >= '9' )
					&& ((s.charAt(i+1) <= 'Z' && s.charAt(i+1) >= 'A')
					|| (s.charAt(i+1) <= 'z' && s.charAt(i+1) >= 'a'))){
				return -1;
			}
			if( (s.charAt(i+1) <= '0' && s.charAt(i+1) >= '9' )
					&& ((s.charAt(i) <= 'Z' && s.charAt(i) >= 'A')
					|| (s.charAt(i) <= 'z' && s.charAt(i) >= 'a'))){
				return -1;
			}
		}
		
		return 0;
	}
	
	public int checkIsoLe( String s ){
		if( s.length() == 1 ){
			if( s.equals("A") || s.equals("a") || s.equals("I") ){
				return 0;
			}
			else{
				return -1;
			}
		}
		return 0;
	}
	
	public int checkTwoPunMark( String s ){
		for( int i = 0; i < s.length() - 1; i++ ){
			if( (!(s.charAt(i) <= '9' && s.charAt(i) >= '0') && 
				!(s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') &&
				!(s.charAt(i) <= 'z' && s.charAt(i) >= 'a'))
				&&((!(s.charAt(i+1) <= '9' && s.charAt(i+1) >= '0') && 
						!(s.charAt(i+1) <= 'Z' && s.charAt(i+1) >= 'A') &&
						!(s.charAt(i+1) <= 'z' && s.charAt(i+1) >= 'a')))){
				if(!(s.charAt(i) == '"') && !(s.charAt(i+1) == '"')){
					System.out.println(s.charAt(i)+" "+s.charAt(i+1) );
					return -1;
				}
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		Solver s = new Solver();
		s.solve();
	}

}
