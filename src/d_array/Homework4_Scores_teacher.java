package d_array;


public class Homework4_Scores_teacher {

	public static void main(String[] args) {

		/*

		 * 우리반 모두의 국어, 영어, 수학, 사회, 과학, Oracle, Java 점수를

		 * 0 ~ 100까지 랜덤으로 생성해주시고, 아래와 같이 출력해주세요.

		 * 

		 * 			국어		영어		수학		사회		과학		Oracle	Java	합계		평균		석차

		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

		 * 홍길동		90		90		90		90		90		90		90		630		90.00	1

		 * 과목합계	450		450		450		450		450		450		450

		 * 과목평균	90.00	90.00	90.00	90.00	90.00	90.00	90.00

		 */

		

		String[] names = {"정지수", "이현기", "윤지혜", "정이삭", "박세현"

				  		, "오세일", "장병길", "배수진", "김지훈", "임태준"

				  		, "최희수", "전형섭", "김혜정", "송수미", "진예은"

				  		, "양지수", "김도윤", "김보현", "원정훈", "문선준"

				  		, "진유리", "김동익", "이진수", "박초원", "김보미"};

		String[] subjects = {"국어", "영어", "수학", "사회", "과학", "Oracle", "Java"};

		int[][] score = new int[names.length][subjects.length];

		

		for(int i = 0; i < score.length; i++){

			for(int j = 0; j < score[i].length; j++){

				score[i][j] = (int)(Math.random() * 101);

			}

		}

		

		int[] nameSum = new int[score.length];

		double[] nameAvg = new double[score.length];

		for(int i = 0; i < score.length; i++){

			for(int j = 0; j < score[i].length; j++){

				nameSum[i] += score[i][j];

			}

			nameAvg[i] = Math.round((double) nameSum[i] / subjects.length * 100) / 100.0;

		}

		

		int[] subSum = new int[subjects.length];

		double[] subAvg = new double[subjects.length];

		for(int i = 0; i < subjects.length; i++){

			for(int j = 0; j < score.length; j++){

				subSum[i] += score[j][i];

			}

			subAvg[i] = Math.round((double)subSum[i] / score.length * 100) / 100.0;

		}

		

		int[] rank = new int[score.length];

		for(int i = 0; i < score.length; i++){

			rank[i] = 1;

			for(int j = 0; j < score.length; j++){

				if(nameSum[i] < nameSum[j]){

					rank[i]++;

				}

			}

		}

		

		//정렬

		for(int i = 0; i < nameSum.length - 1; i++){

			int max = i;

			for(int j = i + 1; j < nameSum.length; j++){

				if(nameSum[max] < nameSum[j]){

					max = j;

				}

			}

			int[] temp = score[i];

			score[i] = score[max];

			score[max] = temp;

			

			int temp2 = nameSum[i];

			nameSum[i] = nameSum[max];

			nameSum[max] = temp2;

			

			double temp3 = nameAvg[i];

			nameAvg[i] = nameAvg[max];

			nameAvg[max] = temp3;

			

			int temp4 = rank[i];

			rank[i] = rank[max];

			rank[max] = temp4;

			

			String temp5 = names[i];

			names[i] = names[max];

			names[max] = temp5;

		}

		

		//출력

		for(int i = 0; i < subjects.length; i++){

			System.out.print("\t" + subjects[i]);

		}

		System.out.println("\t합계\t평균\t석차");

		for(int i = 0; i < score.length; i++){

			System.out.print(names[i] + "\t");

			for(int j = 0; j < score[i].length; j++){

				System.out.print(score[i][j] + "\t");

			}

			System.out.println(nameSum[i] + "\t" + nameAvg[i] + "\t" + rank[i]);

		}

		

		System.out.print("과목합계\t");

		for(int i = 0; i < subSum.length; i++){

			System.out.print(subSum[i] + "\t");

		}

		System.out.println();

		

		System.out.print("과목평균\t");

		for(int i = 0; i < subAvg.length; i++){

			System.out.print(subAvg[i] + "\t");

		}

	}

}
