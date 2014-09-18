import java.util.Scanner;


public class Linear {
	public void solve(){
		Scanner scan = new Scanner(System.in);
		String s;
		while( !(s = scan.next()).equals("#") ){
			printOut( s );
		}
	}
	
	public void printOut( String s ){
		int output = 0;
		
		for( int i = 0; i < s.length(); i++ ){
			if( s.charAt(i) == '.' ){
				output = output + 100;
			}
			else if( s.charAt(i) == '|' ){
				int c1 = check( i, s, -1 );
				int c2 = check( i, s, 1 );
				int total = (c1 + c2 + 2) * 50;
				output = output + total;
			}
			else if( s.charAt(i) == '_' ){
				
			}
			else if( s.charAt(i) == '/' ){
				int c = check( i, s, -1 );
				output = output + ( c + 1) * 100;
			}
			else{
				int c = check( i, s, 1 );
				output = output + ( c + 1) * 100;
			}
		}
		System.out.println( output/s.length() );
	}
	
	public int goThough( char c ){
		if( c == '.' ){
			return 0;
		}
		else if( c == '_'){
			return 1;
		}
		else{
			return -1;
		}			
	}
	
	public int direct( char c ){
		if( c == '/' ){
			return -1;
		}
		else{
			return 1;
		}
	}
	
	public int check( int i, String s, int dir ){
		if( dir == -1 ){
			for( int j = i - 1; j >= 0; j-- ){
				int c = goThough(s.charAt(j));
				if( c == 0 ){
					return 0;
				}
				else if ( c == -1 ){
					return -1;
				}
			}
			return 0;
		}
		else{
			for( int j = i + 1; j < s.length(); j++ ){
				int c = goThough(s.charAt(j));
				if( c == 0 ){
					return 0;
				}
				else if ( c == -1 ){
					return -1;
				}
			}
			return 0;
		}
	}
	
	public static void main( String[] args ){
		Linear l = new Linear();
		l.solve();
	}
	
	
}
