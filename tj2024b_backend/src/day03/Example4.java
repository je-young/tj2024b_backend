package day03; // 클래스가 위치한 패키지명/폴더명

import java.util.Scanner; //Scanner 임포트

public class Example4 { // class s

	public static void main(String[] args) { // main s

		Scanner scan = new Scanner(System.in);

		// [ 구현 문제 , FOR문 없이 풀이 ]
		// 문제1 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 '합격' 아니면 '불합격' 출력 하시오.
		System.out.print("[문제1] 점수를 입력하세요: ");

		// Scanner 로 입력받기 : scan.nextInt()
		int score = scan.nextInt();

		// 삼항연산자
		System.out.println(score >= 90 ? "삼항연산자 : 합격" : "삼항연산자 : 불합격");

		// if , else
		if (score >= 90) {
			System.out.println("if : 합격");
		} else {
			System.out.println("if : 불합격");
		}

		// 문제2 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 'A등급', 80점 이상이면 'B등급', 70점 이상이면 'C등급', 그외
		// '재시험' 으로 출력 하시오.
		System.out.print("[문제2] 점수를 입력하세요: ");

		// Scanner 로 입력받기 : scan.nextInt()
		int score2 = scan.nextInt();

		// 삼항연산자
		String grade = ((score2 >= 90) ? "A등급" : (score2 >= 80) ? "B등급" : (score2 >= 70) ? "C등급" : "재시험");
		// score2 가= 90이상이면? grade 는 A등급 : score2 가= 80이하이면? grade 는B 등급 : score2 가=
		// 70이하이면? grade 는C 등급 : score2 가= 70이하이면? grade 재시험
		System.out.println("삼항연산자 등급: " + grade);

		// if else
		if (score2 >= 90) { // 만약에 score2가 90 이상이면
			System.out.println("if : " + grade);
		} else if (score2 >= 80) { // 만약에 score2가 80 이상이면
			System.out.println("if else if : " + grade);
		} else if (score2 >= 70) { // 만약에 score2가 70 이상이면
			System.out.println("if else if : " + grade);
		} else { // 그외면
			System.out.println("else : " + grade);
		}

		// 문제3 : 각 3개의 정수형으로 수를 입력받아 가장 큰 수를 출력 하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
		System.out.print("[문제3] 각 3개의 정수를 입력하세요: ");

		// Scanner 로 입력받기 : scan.nextInt()
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();

		int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println("[문제3] 삼항연산자 : " + max);

		// if else
		int max2; // 가장 큰 값을 저장할 변수

		if (a > b) { // 만약에 a 가 b 보다 큰 경우
			if (a > c) { // 그리고 a 가 c 보다도 크면
				max2 = a; // a 가 b 보다 크고, 그리고 a 가 c 보다도 크면 a 가 가장 큼
			} else { // 위의 조건이 모두 아니면
				max2 = c; // a 가 b 보다 크고, a 가 c 보다 작으면 c 가 가장 큼
			}
		} else { // b 가 a 보다 큰 경우
			if (b > c) { // 그리고 b 가 c 보다 크면
				max2 = b; // b 가 a 보다 크고, b 가 c 보다 크면 b 가 가장 큼
			} else { // 위의 조건이 모두 아니면
				max2 = c; // b 가 a 보다 크고, b 가 c 보다 작으면 c 가 가장 큼
			}
		} // if end
		System.out.println("[문제3] if else : " + max2);

		// 문제4 : 각 3개의 정수형으로 수를 입력받아 오름차순 순서대로 출력하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
		System.out.print("[문제4] 세 정수를 입력하세요: ");

		// Scanner 로 입력받기 : scan.nextInt()
		int a2 = scan.nextInt();
		int b2 = scan.nextInt();
		int c2 = scan.nextInt();

		if (a2 > b2) { // 첫번째 비교
			int temp = a2; // a2 의 값을 temp 에 저장
			a2 = b2; // b2 의 값을 a2 로 이동
			b2 = temp; // temp 에 저장된 a2 의 값을 b2 로 이동
		}

		if (b2 > c2) { // 두번째 비교
			int temp = b2; // b2 의 값을 temp 에 저장
			b2 = c2; // c2 의 값을 b2 로 이동
			c2 = temp; // temp 에 저장된 b2 의 값을 c2 로 이동
		}

		if (a2 > b2) { // 세번째 비교
			int temp = a2; // a2 의 값을 temp 에 저장
			a2 = b2; // b2 의 값을 a2 로 이동
			b2 = temp; // temp 에 저장된 a2 의 값을 b2 로 이동
		}

		System.out.println("[문제4] 오름차순 정렬 : " + a2 + ", " + b2 + ", " + c2);

		// 문제5 : 가위바위보 게임 구현하기.
		// - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다.
		// - 승리자 판단과 무승부 경우의수를 출력하시오.
		// [입력 조건] 플레이어1 과 플레이어2 에게 각각 입력을 받습니다.
		// [출력 조건] 플레이어1 이기면 ' 플레이어1 승리 ', 플레이어2 이기면 ' 플레이어2 승리 ' 무승부 이면 '무승부' 출력 하시오.

		System.out.print("[문제5] 플레이어1의 입력 (가위: 0, 바위: 1, 보: 2): ");
		int player1 = scan.nextInt(); // Scanner 로 입력받기 : scan.nextInt()

		System.out.print("[문제5] 플레이어2의 입력 (가위: 0, 바위: 1, 보: 2): ");
		int player2 = scan.nextInt(); // Scanner 로 입력받기 : scan.nextInt()

		// 삼항연산자
		String result = (player1 == player2) ? "삼항연산자 : 무승부"
				: (player1 == 0 && player2 == 2 || player1 == 1 && player2 == 0 || player1 == 2 && player2 == 1)
						? "플레이어1 승리"
						: "플레이어2 승리";
		System.out.println(result);

		// if, else if, else
		if (player1 == player2) {
			System.out.println("if : 무승부");
		} else if ((player1 == 0 && player2 == 2) || // 가위가 보를 이김
				(player1 == 1 && player2 == 0) || // 바위가 가위를 이김
				(player1 == 2 && player2 == 1)) { // 보가 바위를 이김
			System.out.println("else if : " + result);
		} else {
			System.out.println("else : " + result);
		}
		
		scan.close();
		
		// 문제6 : 윤년/평년 판단하기
		// [ 입력조건 ] 하나의 연도를 입력 받습니다.
		// [ 윤년/평년 조건 ]
		// -연수가 4로 나누어 떨어지는 해는 윤년으로 한다.
		// -연수가 4, 100으로 나누어 떨어지는 해는 평년으로 한다.
		// -연수가 4, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다.
		// [ 출력조건] '입력한OOOO년 은' 윤년 입니다. 혹은 평년 입니다 로 출력하시오.

		// 문제7 : 주차 사용요금 계산하기
		// [ 선언 변수 조건 ] 입차시간이 9시30분 입니다.
		// - int 시 = 9; int 분 = 30; 이와 같이 변수를 먼저 선언해주세요.
		// [ 출차시간 입력 조건 ] 출차시간의 시 와 분을 각 입력받아 각 변수에 저장하시오.
		// [ 처리출력 조건 ] 1분당 1000원으로 계산하여 사용요금' 0000원' 을 출력하시오,
		// - 단 입차 시간 이전 으로 입력 할 경우에는 '출차시간 오류' 출력하시오.

		// 문제8 : 로그인 처리
		// [입력 조건] 아이디[문자열] 와 비밀번호[문자열] 를 입력받기
		// [처리출력 조건]
		// 1. 아이디가 'admin' 이고 비밀번호가 '1234' 모두 동일하면 '로그인성공'
		// 2. 아이디가 다르면 '아이디 정보가 일치하지 않습니다.'
		// 3. 아이디는 일치하고 비밀번호가 다르면 '비밀번호 정보가 일치하지 않습니다'
		// [ 참고 ]
		// 1. 문자열 비교시에는 == 같다 연산자 대신에 .equals() 함수를 이용해주세요.
		// 예]
		// String name = scan.next();
		// name =="admin" 대신에 name.equals( "admin" ) 사용.

		// 문제9 : 당첨번호 개수 찾기
		// [ 선언 변수 조건 ] int 공1 = 14 ; int 공2 = 21 ; int 공3 = 9; 이와 같이 변수를 먼저 선언해주세요.
		// [ 입력 조건 ] 세개의 정수를 입력받아 각 변수에 저장하시오.
		// [ 출력 조건 ] 입력받은 세 정수 중에서 공1~공3 까지 동일한 번호 가 몇개 인지 출력하시오.

	} // main end
} // class end
