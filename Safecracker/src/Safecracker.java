import java.util.Arrays;
import java.util.Scanner;

public class Safecracker {

	private void solve() {
		Scanner scan = new Scanner(System.in);
		String s;
		while (!(s = scan.nextLine()).equals("0 END")) {
			// get the data
			Scanner scanStr = new Scanner(s);
			int target = scanStr.nextInt();
			char[] lets = scanStr.next().toCharArray();
			Arrays.sort(lets);
			scanStr.close();
			
			String result = getSolution(lets,target);
			System.out.println(result);
		}
		scan.close();
	}

	private String getSolution(char[] lets, int target) {
		for (int i = lets.length - 1; i >= 0; i--)
			for (int j = lets.length - 1; j >= 0; j--)
				for (int k = lets.length - 1; k >= 0; k--)
					for (int l = lets.length - 1; l >= 0; l--)
						for (int m = lets.length - 1; m >= 0; m--) {
							boolean areDif = areDifferent(i,j,k,l,m);
							if(areDif){
								double sum = (lets[i] - 'A' + 1) -
										Math.pow((lets[j] - 'A' + 1), 2) +
										Math.pow((lets[k] - 'A' + 1), 3) -
										Math.pow((lets[l] - 'A' + 1), 4) +
										Math.pow((lets[m] - 'A' + 1), 5);
								if( sum == target )
									return "" + lets[i] + lets[j] + lets[k]
											+ lets[l] + lets[m];
							}
						}
		return "no solution";
	}

	private boolean areDifferent( int i, int j, int k, int l, int m ){
		if( i != j && k != j && k != i && l != k 
				&& l != j && l != i && m != i && 
				m != j && m != k && m != l){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Safecracker s = new Safecracker();
		s.solve();
	}

}
