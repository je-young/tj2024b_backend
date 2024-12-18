package day07;

import java.util.Scanner;

public class Example5 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // 입력을 받기 위한 Scanner 객체 생성

		int[] numbers = new int[5]; // 크기가 5인 정수 배열 선언
		int sum = 0; // 총점을 저장할 변수
		double average = 0.0; // 평균을 저장할 변수

		// [1] 정수 5개를 입력받아 배열에 저장
		System.out.println("정수 5개를 입력하세요!");
		for (int i = 0; i < numbers.length; i++) {
			System.out.print((i + 1) + "번째 정수: ");
			numbers[i] = scan.nextInt(); // 사용자가 입력한 정수를 배열에 저장
		}

		// [2] 총점 계산
		for (int i = 0; i < numbers.length; i++) {
			sum += numbers[i]; // 배열의 각 요소를 더해서 총점 계산
		}

		// [3] 평균 계산
		average = (double) sum / numbers.length; // 총점을 배열의 크기로 나누어 평균 계산

		// [4] 결과 출력
		System.out.println("총점: " + sum);
		System.out.printf("평균: %.2f\n", average); // 평균은 소수점 둘째 자리까지 출력

		scan.close(); // Scanner 객체 닫기

	}

}
