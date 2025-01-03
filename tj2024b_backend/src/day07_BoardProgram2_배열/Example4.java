package day07_BoardProgram2_배열;

import java.util.Arrays;

public class Example4 { // class s

	public static void main(String[] args) { // main s
		// [1] 배열 사용, 학번 10개 저장하는 코드
		int[] studentIDs = new int[10];
		studentIDs[0] = 101;
		studentIDs[1] = 102;
		studentIDs[2] = 103;
		studentIDs[3] = 104;
		studentIDs[4] = 105;
		studentIDs[5] = 106;
		studentIDs[6] = 107;
		studentIDs[7] = 108;
		studentIDs[8] = 109;
		studentIDs[9] = 110;
		System.out.println(studentIDs[0]); // 101

		// [2] 배열 초기화 하기
		// 1. 개수가 생략함
		int[] studentIDs2 = new int[] { 101, 102, 103 };
		System.out.println(studentIDs2[1]); // 102

		// 2. 오류발생 (주석처리)
		// int[] studentIDs3 = new int[3] { 101, 102, 103 };

		// 3. 개수가 생략하지 않음
		int[] studentIDs4 = { 101, 102, 103 };
		System.out.println(studentIDs4[2]); // 103

		// 4. 배열 선언과 초기화를 따로 함
		int[] studentIDs5;
		studentIDs5 = new int[] { 101, 102, 103 };
		System.out.println(studentIDs5); // [I@15db9742

		// [3] 배열 사용하기, 인덱스 사용하기
		int[] num = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(num); // [I@6d06d69c
		System.out.println(Arrays.toString(num)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println(num[0]); // 1
		System.out.println(num[3]); // 4

		// 1분 복습
		int sum = 0;
		for (int index = 0; index <= num.length - 1; index++) { // 0~9
			sum += num[index]; // sum = sum + num[index];
		}
		System.out.println(sum); // 55

		// [4] 전체 배열 길이와 유효한 요소 값
		double[] data = new double[5]; // - 실수5개를 저장할수있는 배열선언
		data[0] = 10.0; // 첫번째 인덱스의 10.0 대입
		data[1] = 20.0; // 두번째 인덱스의 20.0 대입
		data[2] = 30.0; // 세번째 인덱스의 30.0 대입
		// 네번째 인덱스, 다섯번째 인덱스는 대입하지 않았다. [3], [5]는 기본값인 0.0 들어있다.
		for (int i = 0; i < data.length; i++) { // 0~4
			System.out.println(data[i]); // 10.0, 20.0, 30.0, 0.0, 0.0
		} // for end
	} // main end
} // class end
