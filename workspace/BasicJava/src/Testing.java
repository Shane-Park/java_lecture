
public class Testing {
	public static void main(String[] args) {
		int n = 3;
		int m = 12;
		int[] answer = new int[2];
		answer[0] = 1;
        if(n>m){
            int temp = n;
            n = m;
            m = temp;
        }
        
        for(int i=2; i<=n; i++){
            if(n%i==0 && m%i==0)
                answer[0] = i;
        }
                
        answer[1] = n * m / answer[0];
       
        System.out.println(n+" "+m+" "+answer[0]+" "+answer[1]);
        
    }
	}
	



