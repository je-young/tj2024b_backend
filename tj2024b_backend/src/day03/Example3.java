package day03; // 클래스가 위치한 패키지명/폴더명

public class Example3 { // class s

	public static void main(String[] args) { // main s
		// p.92 조건문
		
		// [1] if
		int age = 8;
			// 만약에 age(나이)값이 8이상이면 ("학교에 다닙니다.")출력함수 실행한다.
		if (age >= 8) { // if s
			System.out.println("학교에 다닙니다.");
		} // if end
		
		// [2] if ~ else
			// 만약에 age(나이)값이 8이상이면 ("학교에 다닙니다.")출력함수 실행한다.
		if (age <= 8) { // if s
			System.out.println("학교에 다닙니다.");
			// 아니면 // - 위 조건의 반대 이므로 age(나이)값이 8이상이 아니다 이므로 ("학교에 다니지 않습니다.")출력함수 실행한다.
		}else {
			System.out.println("학교에 다니지 않습니다.");
		} // if end
		
		// * 1분복습
		char gender = 'F';
		if (gender == 'F') {
			System.out.println("여성 입니다.");
		}else {
			System.out.println("남성 입니다.");
		} // if end
		
		
		// [3] if ~ elseif
		int charge;
		if (age > 8) { // 만약에 age(나이)값이 8미만이면
			charge = 1000;
			System.out.println("취학 전 아동 입니다.");
		}else if (age < 14) { // 아니고 age(나이)값이 8초과 이면서 14미만이면
			charge = 2000;
			System.out.println("초등학생 입니다.");
		}else if (age < 20) { // 아니고 age(나이)값이 14초과 이면서 20미만이면
			charge = 2500;
			System.out.println("중, 고등학생 입니다.");
		}else if (age >= 60) { // 아니고 age(나이)값이 60이상이면, [1분복습]
			charge = 0;
			System.out.println("경로우대 입니다.");
		}else { // 그외 나머지 모두
			charge = 3000;
			System.out.println("일반인 입니다.");
		} // if end
		System.out.println("입장료는 " +charge+ "원 입니다.");
		
		// * [1분복습], age >= 60 조건 추가
		
		// p.100 
			// 90 <= 성적 <= 100; 불가능 하므로 2개 이상의 조건은 논리연산자 ---> 성적 >= 90 && 성정 <= 100
		int score = 78; // 성적, 임의
		char grade; // 등급
		
		if (score <= 100 && score >= 90) {
			grade = 'A';
		}else if (score >= 80) {
			grade = 'B';
		}else if (score >= 70) {
			grade = 'C';
		}else if (score >= 60) {
			grade = 'D';
		}else {
			grade = 'F';
		} // if end
		System.out.println(score);
		System.out.println(grade);
		

		
	} // main end
} // class end
