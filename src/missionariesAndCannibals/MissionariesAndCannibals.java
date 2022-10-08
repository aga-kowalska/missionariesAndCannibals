package missionariesAndCannibals;

import java.util.Scanner;

public class MissionariesAndCannibals {
	public static int mOnLeft = 3;
	public static int cOnLeft = 3;
	public static boolean bOnLeft = true;
	public static int[][] alphabet = { { 2, 0 }, { 0, 2 }, { 1, 0 }, { 0, 1 }, { 1, 1 } };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//check if it's even working with the user input
//		while (!done() && !deadState()) {
//			System.out.print("M:");
//			int m = sc.nextInt();
//			System.out.print("C:");
//			int c = sc.nextInt();
//			move(m, c);
//		}
//		if (done()) {
//			System.out.println("Congrats");
//		} else if (deadState()) {
//			System.out.println("Fail");
//		}

	}

	public static void move(int m, int c) {
		if (bOnLeft) {
			mOnLeft -= m;
			cOnLeft -= c;
		} else {
			mOnLeft += m;
			cOnLeft += c;
		}
		bOnLeft = !bOnLeft;
	}

	public static boolean deadState() {
		if (mOnLeft < 0 || cOnLeft < 0) {
			return true;
		} else if (mOnLeft > 3 || cOnLeft > 3) {
			return true;
		} else if (mOnLeft < 3 && mOnLeft > 0 && mOnLeft != cOnLeft) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean done() {
		if (mOnLeft == 0 && cOnLeft == 0) {
			return true;
		} else {
			return false;
		}
	}
}
