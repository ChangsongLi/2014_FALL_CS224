import java.util.Scanner;
import java.util.Vector;


public class BookShelf {
	Vector<Integer> width;
	Vector<Integer> id;
	int shelfWidth;
	int problem = 0;
	
	public void solve(){
		Scanner scan = new Scanner( System.in );
		String s;
		width = new Vector<Integer>(1);
		id = new Vector<Integer>(1);
		while( !(s = scan.nextLine()).equals("-1") ){
			type( s );
		}
	}
	

	public void type( String s ){
		Scanner scan = new Scanner( s );
		if( scan.hasNextInt() ){
			shelfWidth = scan.nextInt();
			return;
		}
		
		
		String type = scan.next();
		
		if( type.equals("A") ){
			int book = scan.nextInt();
			int w = scan.nextInt();
			
			if( !id.contains(book) ){
				int size = width.size();
				
				
				int total = 0;
				for( int i = 0; i < size; i++ ){
					total = total + width.elementAt(i);
				}
				
				if( total + w > shelfWidth ){
					id.add( book );
					width.add( w );
					total = total + w;
					
					while( total > shelfWidth ){
						id.remove( 0 );
						int wid = width.remove( 0 );
						total = total - wid;
					}
				}
				else{
					id.add( book );
					width.add( w );
				}
			}
			
		}
			
		else if( type.equals("R") ){
			int book = scan.nextInt();
			if( id.contains(book) ){
				int i = id.indexOf(book);
				id.remove(i);
				width.remove(i);
			}
		}
		
		else if( type.equals("E") ){
			problem++;
			System.out.print("PROBLEM " + problem + ":");
			
			for( int i = id.size() - 1; i >= 0; i-- ){
				System.out.print( " "+ id.elementAt(i) );
			}
			System.out.println();
			
			id.clear();
			width.clear();
		}
		
	}
	
	public static void main(String[] args) {
		BookShelf bs = new BookShelf();
		bs.solve();

	}

}
