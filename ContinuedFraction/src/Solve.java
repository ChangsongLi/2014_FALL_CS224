import java.util.Scanner;


public class Solve {

	private void solver(){
		Scanner scan = new Scanner(System.in);
		int caseNum = 1;
		while(scan.hasNextInt()){
			int n1 = scan.nextInt();
			int n2 = scan.nextInt();
			int[] r1 = new int[n1];
			int[] r2 = new int[n2];
			
			for(int i = 0; i < n1; i++)
				r1[i] = scan.nextInt();
			for(int i = 0; i < n2; i++)
				r2[i] = scan.nextInt();
			
			int num1 = 1;
			int dem1 = r1[n1-1];
			
			for(int i = n1 - 2; i >= 0; i--){
				num1 = num1 + r1[i] * dem1;
				if(i != 0){
					int tmp = num1;
					num1 = dem1;
					dem1 = tmp;
				}
			}
			
			int num2 = 1;
			int dem2 = r2[n2-1];
			
			for(int i = n2 - 2; i >= 0; i--){
				num2 = num2 + r2[i] * dem2;
				if(i != 0){
					int tmp = num2;
					num2 = dem2;
					dem2 = tmp;
				}
			}
			
			
			System.out.println("Case "+caseNum+":");
			
			String result = "";
			int num;
			int dem;
			
			num = num1 * dem2 + num2 * dem1;
			dem = dem1 * dem2;
			
			while( dem != 0 ){
				int c = num / dem;
				result = result + c + " ";
				num = num - c * dem;
				int tmp = num;
				num = dem;
				dem = tmp;
			}
			System.out.println(result);
			
			result = "";
			num = num1 * dem2 - num2 * dem1;
			dem = dem1 * dem2;
			while( dem != 0 ){
				int c = num / dem;
				result = result + c + " ";
				num = num - c * dem;
				int tmp = num;
				num = dem;
				dem = tmp;
			}
			System.out.println(result);
			
			result = "";
			num = num1 * num2;
			dem = dem1 * dem2;
			while( dem != 0 ){
				int c = num / dem;
				result = result + c + " ";
				num = num - c * dem;
				int tmp = num;
				num = dem;
				dem = tmp;
			}
			System.out.println(result);
			
			result = "";
			num = num1 * dem2;
			dem = dem1 * num2;
			while( dem != 0 ){
				int c = num / dem;
				result = result + c + " ";
				num = num - c * dem;
				int tmp = num;
				num = dem;
				dem = tmp;
			}
			System.out.println(result);
			
			caseNum++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solve s = new Solve();
		s.solver();
	}

}
