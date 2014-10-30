import java.util.Scanner;


public class Hangover {
	public void solve(){
		Scanner scan = new Scanner(System.in);
		double s;
		while((s = scan.nextDouble()) != 0){
			int count = 0;
			double total = 0;
			while( total <= s ){
				total = total + 1/(double)(count+2);
				count++;
			}
			System.out.println(count + " card(s)");
		}
		scan.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hangover h = new Hangover();
		h.solve();
	}

}
