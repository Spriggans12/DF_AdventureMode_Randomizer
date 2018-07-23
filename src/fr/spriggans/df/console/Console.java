package fr.spriggans.df.console;

public class Console {

	// Reset
	public static final String RESET = "\033[0m"; // Text Reset

	// Regular Colors
	public static final String BLACK = "\033[0;30m"; // BLACK
	public static final String RED = "\033[0;31m"; // RED
	public static final String GREEN = "\033[0;32m"; // GREEN
	public static final String YELLOW = "\033[0;33m"; // YELLOW
	public static final String BLUE = "\033[0;34m"; // BLUE
	public static final String PURPLE = "\033[0;35m"; // PURPLE
	public static final String CYAN = "\033[0;36m"; // CYAN
	public static final String WHITE = "\033[0;37m"; // WHITE

	// High Intensity
	public static final String BLACK_BRIGHT = "\033[0;90m"; // BLACK
	public static final String RED_BRIGHT = "\033[0;91m"; // RED
	public static final String GREEN_BRIGHT = "\033[0;92m"; // GREEN
	public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
	public static final String BLUE_BRIGHT = "\033[0;94m"; // BLUE
	public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
	public static final String CYAN_BRIGHT = "\033[0;96m"; // CYAN
	public static final String WHITE_BRIGHT = "\033[0;97m"; // WHITE

	private final boolean colorful;

	private Console(ConsoleBuilder builder) {
		this.colorful = builder.colorful;
	}

	public void printRed(Object o) {
		printColor(o, RED_BRIGHT);
	}

	public void printlnRed(Object o) {
		printlnColor(o, RED_BRIGHT);
	}

	public void printLime(Object o) {
		printColor(o, GREEN_BRIGHT);
	}

	public void printlnLime(Object o) {
		printlnColor(o, GREEN_BRIGHT);
	}

	public void print(Object o) {
		printColor(o, WHITE);
	}

	public void println(Object o) {
		printlnColor(o, WHITE);
	}

	public void printColor(Object o, String color) {
		if (colorful) {
			System.out.print(color + o + RESET);
		} else {
			System.out.print(o);
		}
	}

	public void printlnColor(Object o, String color) {
		printColor(o + "\n", color);
	}

	public static class ConsoleBuilder {
		private boolean colorful;

		public ConsoleBuilder colorful(boolean colorful) {
			this.colorful = colorful;
			return this;
		}

		public Console build() {
			return new Console(this);
		}
	}
}
