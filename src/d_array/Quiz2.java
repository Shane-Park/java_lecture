package d_array;
import java.util.Arrays;

public class Quiz2 {

	public static void main(String[] args) {
		//그래프 그리기
		
		int[] arr = new int[20];
		int[] arr_count = new int[5];
		
		for(int i=0; i<arr.length; i++){
			arr[i] = (int)(Math.random() * 5) + 1;
			arr_count[arr[i]-1]++;
		}
		System.out.println(Arrays.toString(arr));
		/*
		 * 1~5의 숫자가 발생한 만큼 *을 이용해 그래프를 그려주세요.
		 * 1 : *** 3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : * 1
		 */
		for(int i=0; i<arr_count.length; i++){
			System.out.printf("%2d : ",i+1);
			for(int j=0; j<arr_count[i]; j++)
				System.out.print("*");
			System.out.printf(" %d\n",arr_count[i]);
		}
	}
}
