
public class Solver {
	
	public void solve( int num ){
		printE( num );
		printP( num );
		printI( num );
		printC( num );
	}
	
	public void printE( int num ){
		String l = "";
		String s = "";
		for( int i = 0; i < num * 5; i++ ){
			l = l + "E";
		}
		for( int i = 0; i < num; i++ ){
			s = s + "E";
		}
		
		for( int i = 0; i < 5; i++ ){
			if( i % 2 == 0 ){
				for(int j = 0; j < num; j++)
					System.out.println(l);
			}
			else{
				for(int j = 0; j < num; j++)
					System.out.println(s);
			}
		}
		for(int j = 0; j < num; j++)
			System.out.println();
	}
	
	public void printP( int num ){
		String l = "";
		String m = "";
		String s = "";
		
		for( int i = 0; i < num * 5; i++ ){
			l = l + "P";
		}
		for( int i = 0; i < num * 5; i++ ){
			if( i < num || i > 4 * num - 1 )
				m = m + "P";
			else
				m = m + " ";
		}
		for( int i = 0; i < num; i++ ){
			s = s + "P";
		}
		
		for( int i = 0; i < 3; i++ ){
			if( i % 2 == 0 ){
				for(int j = 0; j < num; j++)
					System.out.println(l);
			}
			else{
				for(int j = 0; j < num; j++)
					System.out.println(m);
			}
		}
		
		for( int i = 0; i < 2 * num; i++ ){
			System.out.println(s);
		}
		for(int j = 0; j < num; j++)
			System.out.println();
		
	}
	
	public void printI( int num ){
		String l = "";
		String s = "";
		for( int i = 0; i < num * 5; i++ ){
			l = l + "I";
		}
		for( int i = 0; i < 3 * num; i++ ){
			if( i < 2 * num ){
				s = s + " ";
			}
			else{
				s = s + "I";
			}
		}
		
		for( int i = 0; i < num; i++ ){
			System.out.println(l);
		}
		for( int i = 0; i < num * 3; i++ ){
			System.out.println(s);
		}
		for( int i = 0; i < num; i++ ){
			System.out.println(l);
		}
		
		for(int j = 0; j < num; j++)
			System.out.println();
	}
	
	public void printC( int num ){
		String l = "";
		String s = "";
		for( int i = 0; i < num * 5; i++ ){
			l = l + "C";
		}
		for( int i = 0; i < num; i++ ){
			s = s + "C";
		}
		
		for( int i = 0; i < num ; i++ ){
			System.out.println(l);
		}
		for( int i = 0; i < num * 3; i++ ){
			System.out.println(s);
		}
		for( int i = 0; i < num; i++ ){
			System.out.println(l);
		}
		
		
	}
	
	public static void main( String[] arg ){
		Solver s = new Solver();
		int i = Integer.parseInt(arg[0]);
		s.solve( i );
	}
}
