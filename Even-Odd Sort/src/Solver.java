import java.util.Scanner;
import java.util.Arrays;

public class Solver {

	public void solve(){
		
		Scanner s = new Scanner( System.in );
		int[] input = new int[1000];
		int[] output = new int[1000];
		
		int oddCount = 0;
		int evenCount = 0;
		int counter = 0;
		
		int read = s.nextInt();
		
		while( read != 0 ){
			
			if ( read % 2 == 0 ){
				evenCount++;
				input[counter] = read;
			}
			else{
				oddCount++;
				input[counter] = read;
			}
			
			counter++;
			read = s.nextInt();
		}
		
		
		int[] even = new int[evenCount];
		int[] odd = new int[oddCount];
		
		evenCount = 0;
		oddCount = 0;
		
		for( int i = 0; i < counter; i++ ){
			if ( input[i] % 2 == 0 ){
				
				even[evenCount] = input[i];
				evenCount++;
			}
			else{
				odd[oddCount] = input[i];
				oddCount++;
			}
		}
		
		Arrays.sort(even);
		Arrays.sort(odd);
		
		
		int index = 0;
		
		if( evenCount >= oddCount ){
			int i;
			for( i = 0; i < oddCount; i++ ){
				output[index] = even[i];
				index++;
				output[index] = odd[i];
				index++;
			}
			
			if( evenCount != oddCount ){
				for( int j = i ; j < evenCount; j++ ){
					output[index] = even[j];
					index++;
				}
			}
		}
		else{
			int i;
			for( i = 0; i < evenCount; i++ ){
				output[index] = even[i];
				index++;
				output[index] = odd[i];
				index++;
			}
			
			for( int j = i ; j < oddCount; j++ ){
				output[index] = odd[j];
				index++;
			}
		}
		
		for( int i = 0; i < counter; i++ ){
			System.out.println(output[i]);
		}
	}
	
	
	public static void main(String[] args) {
		
		Solver s = new Solver();
		s.solve();

	}

}
