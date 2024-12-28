package day07;

import java.util.Arrays;

public class Example4 { // class s

	public static void main(String[] args) { // main s
		// [1] 배열 사용, 학번 10개 저장하는 코드
		int[] studentIDs = new int[10];

		// [2] 배열 초기화 하기
		// 1. 개수가 생략함
		int[] studentIDs2 = new int[] { 101, 102, 103 };
		// 2. 오류발생 (주석처리)
		// int[] studentIDs3 = new int[3] { 101, 102, 103 };
		// 3. 개수가 생략하지 않음
		int[] studentIDs4 = { 101, 102, 103 };
		// 4. 배열 선언과 초기화를 따로 함
		int[] studentIDs5;
		studentIDs5 = new int[] { 101, 102, 103 };

		// [3] 배열 사용하기, 인덱스 사용하기
		int[] num = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		System.out.println(num);
		System.out.println(Arrays.toString(num));
		System.out.println(num[0]);
		System.out.println(num[3]);

		// 1분 복습
		int sum = 0;
		for (int index = 0; index <= num.length - 1; index++) {
			sum += num[index];
		}
		System.out.println(sum);

		// [4] 전체 배열 길이와 유효한 요소 값
		double[] data = new double[5]; // - 실수5개를 저장할수있는 배열선언
		data[0] = 10.0; // 첫번째 인덱스의 10.0 대입
		data[1] = 20.0; // 두번째 인덱스의 20.0 대입
		data[2] = 30.0; // 세번째 인덱스의 30.0 대입
		// 네번째 인덱스, 다섯번째 인덱스는 대입하지 않았다. [3], [5]는 기본값인 0.0 들어있다.
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	} // main end

} // class end
