import java.util.Scanner;


public class Robot {
	
	
	public void solve(){
		Scanner scan = new Scanner(System.in);
		int row = scan.nextInt();
		while(row != 0){
			int col = scan.nextInt();
			int enterCol = scan.nextInt() - 1;
			int[][] matrix = new int[row][col];
			String s;
			for(int i = 0; i < matrix.length; i++){
				s = scan.next();
				for(int j = 0; j < matrix[0].length; j++){
					char c = s.charAt(j);
					if( c == 'N' )
						matrix[i][j] = -1;
					if( c == 'S' )
						matrix[i][j] = -2;
					if( c == 'E' )
						matrix[i][j] = -3;
					if( c == 'W' )
						matrix[i][j] = -4;
				}
			}
			
			int step = 1;
			boolean in = true;
			int r = 0;
			int c = enterCol;
			while( in && matrix[r][c] < 0 ){
				
				if(matrix[r][c] == -1){
					matrix[r][c] = step;
					r--;
				}
				else if(matrix[r][c] == -2){
					matrix[r][c] = step;
					r++;
				}
				else if(matrix[r][c] == -3){
					matrix[r][c] = step;
					c++;
				}
				else if(matrix[r][c] == -4){
					matrix[r][c] = step;
					c--;
				}
				
				in = r >= 0 && r < matrix.length && c >=0 && c < matrix[0].length;
				
				System.out.println( r+""+c+"  :"+step);
				step++;
			}
			if( in )
				System.out.println( (matrix[r][c] - 1) + " step(s) before a loop of " + (step - matrix[r][c]) +" step(s)");
			else
				System.out.println( step - 1 +" step(s) to exit");
			row = scan.nextInt();
		}
	}
	
	public static void main(String[] args){
		Robot r = new Robot();
		r.solve();
	}
}
