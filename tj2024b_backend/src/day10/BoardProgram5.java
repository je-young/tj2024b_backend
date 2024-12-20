package day10;

import java.util.Scanner;

public class BoardProgram5 { // class s
	
	public static void main(String[] args) { // main s
		
		Board[] boards = new Board[100];
		BoardService bs = new BoardService();
		
		while (true) { // while s
			
			System.out.print(">>> 1.등록 2.출력 : ");
			Scanner scan = new Scanner(System.in);
			int choose = scan.nextInt();
			if (choose == 1) {
				bs.boardAdd(scan, boards);
			} // if end
			else if (choose == 2) {
				bs.boardPrint(boards);
			} // elss if end
			
			
		} // while end
		
	} // main end

} // class end
