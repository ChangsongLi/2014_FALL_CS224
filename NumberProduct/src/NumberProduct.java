import java.util.Scanner;

public class NumberProduct {
	
	class Direction{
		int top;
		int right;
		int tr;
		int br;
		
		Direction(){
			top = 0;
			right = 0;
			tr = 0;
			br = 0;
		}
	}
	
	private final int num = 4;
	private final int height = 20;
	private final int width = 20;
	Direction[][] dire;
	int[][] matrix;
	private long max = 0;
	

	
	public void solve(){
		matrix = new int[height][width];
		
		dire = new Direction[height][width];
		for( int i = 0; i < dire.length; i++){
			for(int j = 0; j < dire[0].length; j++){
				dire[i][j] = new Direction();
			}
		}
		Scanner scan = new Scanner(System.in);
		String s;
		int i = 0;
		while(!(s = scan.nextLine()).equals("END")){
			Scanner scan2 = new Scanner(s);
			for(int j = 0; j < width; j++){
				matrix[i][j] = scan2.nextInt();
			}
			i++;
		}
		initialDire();
		getMax();
		System.out.println(max);
		
	}
	
	public void initialDire(){
		for( int i = 0; i < height; i++ ){
			for( int j = 0; j < width;j++ ){
				if( (i - num + 1) >= 0 ){
					dire[i][j].top = 1;
				}
				if( (j + num) <= (width - 1) ){
					System.out.println(i+" "+ j);
					dire[i][j].right = 1;
					if( i + num <= height - 1 ){
						dire[i][j].br = 1;
					}
				}
				if( dire[i][j].top == 1 && dire[i][j].right == 1 ){
					dire[i][j].tr = 1;
				}
				
			}
		}
	}
	
	public void getMax(){
		for( int i = 0; i < height; i++ ){
			for( int j = 0; j < width;j++ ){
				if(dire[i][j].right == 1){
					product(i,j,2);
				}
				if(dire[i][j].tr == 1){
					product(i,j,3);
				}
				if(dire[i][j].br == 1){
					product(i,j,4);
				}

				if(dire[i][j].top == 1){
					product(i,j,1);
				}

			}
		}
	}
	
	// direction = 1 is top
	// direction = 2 is right
	// direction = 3 is tr
	// direction = 4 is br
	public void product(int h, int w, int direction){
		if(direction == 1){
			long number = 1;
			for( int i = 0; i < num; i ++ ){
				number = number * matrix[h - i][w];
			}
			if( number > max ){
				max = number;
				System.out.println(max);
			}
		}
		else if( direction == 2 ){
			long number = 1;
			for( int i = 0; i < num; i ++ ){
				number = number * matrix[h][w + i];
			}
			if( number > max ){
				max = number;
				System.out.println(max);
			}
		}
		else if( direction == 3 ){
			long number = 1;
			for( int i = 0; i < num; i ++ ){
				number = number * matrix[h - i][w + i];
			}
			if( number > max ){
				max = number;
				System.out.println(max);
			}
		}
		else if( direction == 4 ){
			long number = 1;
			for( int i = 0; i < num; i ++ ){
				number = number * matrix[h + i][w + i];
			}
			if( number > max ){
				max = number;
				System.out.println(max);
			}
		}
	}
	


	public static void main(String[] args) {
		NumberProduct np = new NumberProduct();
		np.solve();
	}

}
