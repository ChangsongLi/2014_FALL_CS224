import java.util.Scanner;


public class BinarySearchEff {
	long[] data = new long[20];
	long[] height = new long[20];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchEff bs = new BinarySearchEff();
		bs.solve();
	}

	private void solve() {
		Scanner scan = new Scanner(System.in);
		long num;
		fillArr();
		int c = 1;
		while(scan.hasNextLong()){
			num = scan.nextLong();
			int row = 0;
			while(num >= height[row]){
				row++;
			}
			long output = data[row-1] + (row + 1) * (num - height[row-1]);
			System.out.println("Case " + c + ": "+ output);
			c++;
		}
	}
	
	private void fillArr(){
		data[0] = 1;
		height[0] = 1;
		for(int i = 1; i < data.length; i++){
			height[i] = (long)Math.pow(2, i) + height[i-1];
			data[i] = data[i-1] + (i + 1) * (long)Math.pow(2, i) ;
		}
	}

}
