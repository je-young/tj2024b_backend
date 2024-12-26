package day02;

import java.util.Scanner;

public class Example5 { // class 시작

	public static void main(String[] args) { // main 시작
		
		// JS day10 연산자 문제 10개 (1_연산자.js) 를 자바로 풀이하기
		
		// 입력 : prompt() 대신에 Scanner scan = new Scanner(System.in); scan.nextXXX();
		// 출력 : System.out.println();
		
		// Scanner 객체 생성
		Scanner scan = new Scanner(System.in);
		
		
	    // [지문1] 국어 , 영어 , 수학 점수를 각 입력받아서 각 변수에 저장하고 총점 과 평균을 계산하여 console탭에 출력하시오.
        // 국어, 영어, 수학 점수 입력받기
        System.out.print("[지문1] 국어 점수를 입력하세요: ");
        int 국어 = scan.nextInt();
        
        System.out.print("[지문1] 영어 점수를 입력하세요: ");
        int 영어 = scan.nextInt();
        
        System.out.print("[지문1] 수학 점수를 입력하세요: ");
        int 수학 = scan.nextInt();
        
        // 총점 계산
        int 총점 = 국어 + 영어 + 수학;
        
        // 평균 계산
        double 평균 = 총점 / 3.0;
        
        // 결과 출력
        System.out.println("[지문1] 총점: " + 총점);
        System.out.println("[지문1] 평균: " + 평균);
		
        
	    // [지문2] 반지름를 입력받아서 원넓이[반지름*반지름*3.14] 계산하여 console탭에 출력하시오.
        // 반지름 입력받기
        System.out.print("[지문2] 반지름을 입력하세요: ");
        double 반지름 = scan.nextDouble();
        
        // 원 넓이 계산
        double 원넓이 = 반지름 * 반지름 * 3.14;
        
        // 결과 출력
        System.out.println("[지문2] 원의 넓이: " + 원넓이);
        
	
	    // [지문3] 두 실수를 입력받아서 앞 실수의 값이 뒤실수의 값의 비율% 계산하여 console탭에 출력하시오.
        // 두 실수 입력받기
        System.out.print("[지문3] 첫 번째 실수를 입력하세요: ");
        double 실수1 = scan.nextDouble();
        
        System.out.print("[지문3] 두 번째 실수를 입력하세요: ");
        double 실수2 = scan.nextDouble();
        
        // 비율 계산
        double 실수비율 = (실수1 / 실수2) * 100;
        
        // 결과 출력
        System.out.println("[지문3] 첫 번째 실수는 두 번째 실수의 " + 실수비율 + "% 입니다.");
        
	
	    // [지문4] 정수를 입력받아 입력받은 값이 홀수이면 true / 짝수이면 false 로 console탭에 출력하시오.
        // 정수 입력받기
        System.out.print("[지문4] 정수를 입력하세요: ");
        int number = scan.nextInt();
        
        // 홀수이면 true, 짝수이면 false 계산
        boolean tf = (number % 2 != 0);
        
        // 결과 출력
        System.out.println("[지문4] 입력받은 값이 홀수인가요? " + tf);
        
	
	    // [지문5] 정수를 입력받아 입력받은 값이 7의 배수이면 true / 아니면 false 로 console탭에 출력하시오.
        // 정수 입력받기
        System.out.print("[지문5] 정수를 입력하세요: ");
        int number2 = scan.nextInt();
        
        // 7배수 이면 true / 아니면 false
        boolean tf2 = (number2 % 7 == 0);
        
        // 결과 출력
        System.out.println("[지문5] 입력받은 값이 7배수 인가요? " + tf2);
        

	    // [지문6] 정수를 입력받아 입력받은 값이 홀수 이면서 7배수 이면 true / 아니면 false 로 console탭에 출력하시오.
        // 정수 입력받기 
        System.out.print("[지문6] 정수를 입력하세요: ");
        int number3 = scan.nextInt();
        
        // 홀수이면서 7배수 이면 true / 아니면 false
        boolean tf3 = (number3 % 2 != 0) && (number3 % 7 == 0);
        
        // 결과 출력
        System.out.println("[지문6] 입력받은 값이 홀수 이면서 7배수 인가요? " + tf3);
    
	
	    // [지문7] 십만원 단위의 금액을 입력받아 입력받은 금액의 지폐수를 console 출력하시오.
	       // -> 입력 예] 356789 입력시 , 출력 예] 십만원:3장 만원:5장 천원6장 
        // 금 입력받기 
        System.out.print("[지문7] 금액을 입력하세요: ");
        int number4 = scan.nextInt();
        
        // 지폐 수 계산
        int 십만원권 = number4 / 100000; // 10만 원 지폐 수
        number4 %= 100000; // 남은 금액
        
        int 일만원권 = number4 / 10000; // 1만 원 지폐 수
        number4 %= 10000; // 남은 금액
        
        int 일천원권 = number4 / 1000; // 1천 원 지폐 수
        
        // 결과 출력
        System.out.println("[지문7] 십만원: " + 십만원권 + "장");
        System.out.println("[지문7] 만원: " + 일만원권 + "장");
        System.out.println("[지문7] 천원: " + 일천원권 + "장");
        
	
	    // [지문8] 1차점수 와 2차점수 각각 입력받아서 
	       // -> 총점이 150점이상이면 '합격' 아니면 '불합격' 으로 console탭에 출력하시오.
        // 1차 점수 입력받기
        System.out.print("[지문8] 1차 점수를 입력하세요: ");
        int 점수1 = scan.nextInt();
        
        // 2차 점수 입력받기
        System.out.print("[지문8] 2차 점수를 입력하세요: ");
        int 점수2 = scan.nextInt();
        
        // 총점 계산
        int 점수합계 = 점수1 + 점수2;
    
        // 합격 여부 판단
        String 합격여부 = (점수합계 >= 150) ? "합격" : "불합격";
        
        // 결과 출력
        System.out.println("[지문8] 결과: " + 합격여부);
        
        /*
        if (점수합계 >= 150) {
        System.out.println("[지문8] 결과: 합격");
        } else {
        System.out.println("[지문8] 결과: 불합격");
        }
		*/
        scan.close();
    } // main end
} // class end
