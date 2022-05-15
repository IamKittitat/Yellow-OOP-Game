package input;

import javafx.scene.input.KeyCode;

public class InputUtility {
	private static KeyCode firstPlayerKey;
	private static KeyCode secondPlayerKey;

	public static boolean getFirstPlayerKeyPressed(KeyCode keycode) {
		return firstPlayerKey == keycode;
	}

	public static boolean getSecondPlayerKeyPressed(KeyCode keycode) {
		return secondPlayerKey == keycode;
	}

	public static void setKeyPressed(KeyCode keyCode, boolean pressed) {
		if (pressed) {
			if ((keyCode == KeyCode.W) || (keyCode == KeyCode.A) || (keyCode == KeyCode.S) || (keyCode == KeyCode.D)) {
				firstPlayerKey = keyCode;
			}
			if ((keyCode == KeyCode.UP) || (keyCode == KeyCode.RIGHT) || (keyCode == KeyCode.DOWN) || (keyCode == KeyCode.LEFT)) {
				secondPlayerKey = keyCode;
			}
		}
	}
}
