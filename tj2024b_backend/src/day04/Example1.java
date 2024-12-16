package day04;

import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 임포트

public class Example1 {

	public static void main(String[] args) {
		
		// P.102 switch
		/*
			- 형태
			switch( 조건/검사대상 ) {
				case 값1 :
					실행문;
					break;
			}
			
			- break : switch 종료 , 만일 break 없다면 아래 case 의 실행문이 실행된다.
		*/
		
		// [1]
		
		// Scanner 객체를 생성하여 사용자로부터 입력을 받을 준비를 합니다.
		Scanner sc = new Scanner(System.in);
		
		// 사용자에게 안내 메시지를 출력하여 "ranking" 값을 입력하도록 요청.
		System.out.println("ranking 을 입력하세요. [1,2,3] : ");
		
		// 사용자가 입력한 값을 정수형 변수 ranking 에 저장.
		int ranking =sc.nextInt();
		
		// medalColor 변수 선언 (각 등수에 따라 메달 색상을 저장할 변수)
		char medalColor;
		
		// switch 문을 사용하여 ranking 값에 따라 조건을 분기.
		switch (ranking) {
		case 1:						// ranking 값이 1일 경우
			medalColor = 'G';		// 'G'는 Gold(금메달)를 의미
			break;					// 조건에 맞는 코드 실행 후 switch 문을 빠져나.
		case 2:						// ranking 값이 2일 경우
			medalColor = 'S';		// 'S'는 Silver(은메달)를 의미
			break;					
		case 3:						// ranking 값이 3일 경우
			medalColor = 'B';		// 'B'는 Bronze(동메달)를 의미
			break;
		default:					// 위의 case 1, 2, 3에 해당하지 않는 모든 경우
			medalColor = 'A';		// 'A'는 "참가상" 같은 기본 값을 의미
		} // s end
		
		// medalColor 값을 출력하여 어떤 메달인지 사용자에게 알려.
		System.out.println("medalColor 는 : " + medalColor);
		sc.close(); // Scanner 객체를 닫아 자원을 해제.

	}

}