package br.com.deadlocksimulator;

public class Print {

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

	// Bold
	public static final String BLACK_BOLD = "\033[1;30m"; // BLACK
	public static final String RED_BOLD = "\033[1;31m"; // RED
	public static final String GREEN_BOLD = "\033[1;32m"; // GREEN
	public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
	public static final String BLUE_BOLD = "\033[1;34m"; // BLUE
	public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
	public static final String CYAN_BOLD = "\033[1;36m"; // CYAN
	public static final String WHITE_BOLD = "\033[1;37m"; // WHITE

	public static void colored(String text, String color) {
		System.out.println(getColorANSI(color) + text + RESET);
	}

	public static String getColorANSI(String color) {
		switch (color) {
		case "BLACK":
			return BLACK;
		case "RED":
			return RED;
		case "GREEN":
			return GREEN;
		case "YELLOW":
			return YELLOW;
		case "BLUE":
			return BLUE;
		case "PURPLE":
			return PURPLE;
		case "CYAN":
			return CYAN;
		case "WHITE":
			return WHITE;
		case "BLACK_BOLD":
			return BLACK_BOLD;
		case "RED_BOLD":
			return RED_BOLD;
		case "GREEN_BOLD":
			return GREEN_BOLD;
		case "YELLOW_BOLD":
			return YELLOW_BOLD;
		case "BLUE_BOLD":
			return BLUE_BOLD;
		case "PURPLE_BOLD":
			return PURPLE_BOLD;
		case "CYAN_BOLD":
			return CYAN_BOLD;
		case "WHITE_BOLD":
			return WHITE_BOLD;
		}
		return null;
	}
}
