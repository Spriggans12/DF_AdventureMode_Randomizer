package fr.spriggans.df.constants;

import fr.spriggans.console.Console;

public enum SkillLevels {

	S_0("Dabbling ", Console.WHITE, 5),
	S_1("Novice ", Console.WHITE, 6),
	S_2("Adequate ", Console.WHITE_BRIGHT, 7),
	S_3("Competent ", Console.YELLOW, 8),
	S_4("Skilled ", Console.GREEN, 9),
	S_5("Proficient ", Console.GREEN_BRIGHT, 10),
	S_6("Talented ", Console.CYAN, 11),
	S_7("Adept ", Console.CYAN_BRIGHT, 12),
	S_8("Expert ", Console.CYAN_BRIGHT, 13),
	S_9("Professional ", Console.CYAN_BRIGHT, 14),
	S_10("Accomlished ", Console.CYAN_BRIGHT, 15),
	S_11("Great ", Console.CYAN_BRIGHT, 16),
	S_12("Master ", Console.CYAN_BRIGHT, 17),
	S_13("High Master ", Console.CYAN_BRIGHT, 18),
	S_14("Grand Master ", Console.CYAN_BRIGHT, 9999);

	private static SkillLevels[] vals = values();
	
	private final String name;

	private final String color;
	
	private final int costOfNextLevel;

	private SkillLevels(String name, String color, int costOfNextLevel) {
		this.name = name;
		this.color= color;
		this.costOfNextLevel = costOfNextLevel;
	}
	
	public SkillLevels next() {
		if(this.equals(S_14)) {
			return null;
		}
		return vals[this.ordinal() + 1];
	}

	@Override
	public String toString() {
		return this.name;
	}
	
	public String getColor() {
		return color;
	}

	public int getCostOfNextLevel() {
		return costOfNextLevel;
	}
}
