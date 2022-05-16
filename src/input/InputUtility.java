package input;

import javafx.scene.input.KeyCode;

public class InputUtility {
	private static KeyCode firstPlayerKey;
	private static KeyCode secondPlayerKey;

	public static KeyCode getFirstPlayerKeyPressed() {
		return firstPlayerKey;
	}

	public static KeyCode getSecondPlayerKeyPressed() {
		return secondPlayerKey;
	}

	public static void setKeyPressed(KeyCode keyCode, boolean pressed) {
		if (pressed) {
			System.out.println(keyCode);
			if ((keyCode == KeyCode.W) || (keyCode == KeyCode.A) || (keyCode == KeyCode.S) || (keyCode == KeyCode.D)) {
				firstPlayerKey = keyCode;
			}
			if ((keyCode == KeyCode.I) || (keyCode == KeyCode.L) || (keyCode == KeyCode.K) || (keyCode == KeyCode.J)) {
				secondPlayerKey = keyCode;
			}
		}
		System.out.println(keyCode);
	}
}
