import java.util.Scanner;


public class ImagePerimeters {
	char[][] arr;
	int edge = 0;
	private void solve(){
		Scanner scan = new Scanner(System.in);
		String s;
		while( !(s = scan.nextLine()).equals("0 0 0 0") ){
			Scanner scan2 = new Scanner(s);
			arr =  new char[scan2.nextInt()][];
			scan2.nextInt();
			int x = scan2.nextInt()-1;
			int y = scan2.nextInt()-1;
			edge = 0;
			
			for(int i = 0; i < arr.length; i++){
				arr[i] = scan.nextLine().toCharArray();
			}
			find(x,y);
			System.out.println(edge);
			scan2.close();
		}
		scan.close();
	}
	
	private void find(int x, int y){
		if( isEdge(x,y) == -1){
			getEdge(x,y);
			arr[x][y] = 'o';
			find(x+1,y);
			find(x+1,y-1);
			find(x+1,y+1);
			find(x-1,y);
			find(x-1,y-1);
			find(x-1,y+1);
			find(x,y+1);
			find(x,y-1);	
		}
		
	}
	
	private int getEdge(int x, int y){
		if( isEdge(x-1,y) == 0 )
			edge++;
		if( isEdge(x+1,y) == 0)
			edge++;
		if( isEdge(x,y+1) == 0)
			edge++;
		if( isEdge(x,y-1) == 0 )
			edge++;
		return edge;
	}
	
	private int isEdge(int x, int y){
		if( x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == '.')
			return 0;
		else if( arr[x][y] == 'o')
			return 1;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImagePerimeters ip = new ImagePerimeters();
		ip.solve();
	}

}
