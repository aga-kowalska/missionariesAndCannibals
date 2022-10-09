package missionariesAndCannibals;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class MissionariesAndCannibals {
//	public static int mOnLeft = 3;
//	public static int cOnLeft = 3;
//	public static boolean bOnLeft = true;
	public static int[][] alphabet = { { 2, 0 }, { 0, 2 }, { 1, 0 }, { 0, 1 }, { 1, 1 } };

	public static State initialState = new State();

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);

		// check if it's even working with the user input
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

		Deque<State> stack = new ArrayDeque<State>();
		Deque<State> parentNodes = new ArrayDeque<State>();
		stack.push(initialState);
		while (!done(stack.peek())) {
			int counter = 0;
			State expandingState = stack.peek();
			parentNodes.push(expandingState);

			for (int[] input : alphabet) {

				State currentState = move(expandingState, input[0], input[1]);

				if (!deadState(currentState)) {
					boolean isCycle = false;
					for (State state : parentNodes) {
						if (state.getmOnLeft() == currentState.getmOnLeft()
								&& state.getcOnLeft() == currentState.getcOnLeft() 
								&& state.isbOnLeft() == currentState.isbOnLeft()) {
							isCycle = true;
						}
					}
					if (!isCycle) {
						stack.push(currentState);
						counter++;
					}
				} 
				if (done(stack.peek())) {
					break;
				}

			}
			if (counter == 0) {
				stack.pop();
				parentNodes.pop();
			}


		}
		for (State state : stack) {
			System.out.print("M:" + state.getmOnLeft() + " ");
			System.out.print("C:" + state.getcOnLeft() + " ");
			System.out.println();
		}

	}

	public static State move(State currentState, int m, int c) {
		int mOnLeft;
		int cOnLeft;
		if (currentState.isbOnLeft()) {
			mOnLeft = currentState.getmOnLeft() - m;
			cOnLeft = currentState.getcOnLeft() - c;
		} else {
			mOnLeft = currentState.getmOnLeft() + m;
			cOnLeft = currentState.getcOnLeft() + c;
		}
		return new State(mOnLeft, cOnLeft, !currentState.isbOnLeft());
	}

	public static boolean deadState(State state) {
		if (state.getmOnLeft() < 0 || state.getcOnLeft() < 0) {
			return true;
		} else if (state.getmOnLeft() > 3 || state.getcOnLeft() > 3) {
			return true;
		} else if (state.getmOnLeft() < 3 && state.getmOnLeft() > 0 && state.getmOnLeft() != state.getcOnLeft()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean done(State state) {
		if (state.getmOnLeft() == 0 && state.getcOnLeft() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
