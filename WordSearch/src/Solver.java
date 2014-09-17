import java.util.Scanner;

public class Solver {
	
	class Coordinate{
		int x1,y1,x2,y2;
		Coordinate( int xS, int yS, int xE, int yE){
			x1 = xS;
			y1 = yS;
			x2 = xE;
			y2 = yE;
			
		}
	}
	
	private char[][] wordMatrix;
	private void solve(){
		//read input and put all word matrix to the 2D array
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		wordMatrix = new char[size][size];
		for( int i = 0; i < size; i++ ){
			String s = scan.next();
			for( int j = 0; j < s.length(); j++ ){
				wordMatrix[i][j] = s.charAt(j);
			}
		}
		
		String s;
		while( !(s = scan.next()).equals("0") ){
			int res = search(s);
			if( res == -1 ){
				System.out.println(s+": Not found");
			}
		}
	}

	private int search(String s){		
		for( int i = 0; i < wordMatrix.length; i++ ){
			for( int j = 0; j < wordMatrix[i].length; j++ ){
				if( wordMatrix[i][j] == s.charAt(0) ){
					Coordinate c = matchWord( s, i, j );
					if( c.x1 != -1 ){
						print( c, s );
						return 0;
					}
				}
			}
		}
		return -1;
	}
	
	private Coordinate matchWord( String s,int row, int col ){
		int lenS = s.length();
		Coordinate c = new Coordinate( -1, -1, -1, -1 );
		
		int top = row + 1 - lenS;
		int down = wordMatrix.length - row - lenS;
		int left = col + 1 - lenS;
		int right = wordMatrix.length - col -lenS;
		
		if( top >= 0 ){
			int i = checkTop( c, s, row, col );
			if( i == 0 )
				return c;
		}
		if( left >= 0 ){
			int i = checkLeft( c, s, row, col );
			if( i == 0 )
				return c;
		}
		if( right >= 0 ){
			int i = checkRight( c, s, row, col );
			if( i == 0 )
				return c;
		}
		if( down >= 0 ){
			int i = checkDown( c, s, row, col );
			if( i == 0 )
				return c;
		}
		if( top >= 0 && right >= 0){
			int i = checkTR( c, s, row, col );
			if( i == 0 )
				return c;
		}
		if( top >= 0 && left >= 0 ){
			int i = checkTL( c, s, row, col );
			if( i == 0 )
				return c;
		}
		if( down >= 0 && left >= 0 ){
			int i = checkDL( c, s, row, col );
			if( i == 0 )
				return c;
		}
		if( down >= 0 && right >= 0 ){
			int i = checkDR( c, s, row, col );
			if( i == 0 )
				return c;
		}
		
			return c;
	}
	
	//return 0 if find it. otherwise -1.
	private int checkTop( Coordinate c, String s,int row, int col){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row - i][col] != s.charAt(i) ){
				return -1;
			}
		}
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + 2 -s.length();
		c.y2 = col + 1;
		
		return 0;
	}
	
	private int checkDown( Coordinate c,String s,int row, int col ){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row + i][col] != s.charAt(i) ){
				return -1;
			}
		}
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + s.length();
		c.y2 = col + 1;
		return 0;
	}
	
	private int checkLeft( Coordinate c,String s,int row, int col ){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row][col - i] != s.charAt(i) ){
				return -1;
			}
		}
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + 1;
		c.y2 = col + 2 -s.length();
		return 0;
	}
	private int checkRight( Coordinate c,String s,int row, int col ){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row][col + i] != s.charAt(i) ){
				return -1;
			}
		}
		
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + 1;
		c.y2 = col + s.length();
		return 0;
	}
	
	private int checkTL( Coordinate c,String s,int row, int col ){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row - i][col - i] != s.charAt(i) ){
				return -1;
			}
		}
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + 2 -s.length();
		c.y2 = col + 2 -s.length();
		
		return 0;
	}
	private int checkTR( Coordinate c,String s,int row, int col ){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row - i][col + i] != s.charAt(i) ){
				return -1;
			}
		}
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + 2 -s.length();
		c.y2 = col + s.length();
		
		return 0;
	}
	private int checkDL( Coordinate c,String s,int row, int col ){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row + i][col - i] != s.charAt(i) ){
				return -1;
			}
		}
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + s.length();
		c.y2 = col + 2 -s.length();
		return 0;
	}
	private int checkDR( Coordinate c,String s,int row, int col ){
		for( int i = 1; i < s.length(); i++ ){
			if( wordMatrix[row + i][col + i] != s.charAt(i) ){
				return -1;
			}
		}
		c.x1 = row + 1;
		c.y1 = col + 1;
		c.x2 = row + s.length();
		c.y2 = col + s.length();
		return 0;
	}
	
	
	
	private void print( Coordinate c, String s){
		System.out.println( s+": ("+c.x1+ ","+ c.y1+ ") to (" +c.x2+ ","+c.y2+")" );
	}
	public static void main(String[] args) {
		Solver s = new Solver();
		s.solve();
	}

}
