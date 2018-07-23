package fr.spriggans.df.constants;

import fr.spriggans.console.Console;

public enum AttributeLevels {

	A_0("Very Low ", Console.RED_BRIGHT, 1),
	A_1("Low ", Console.RED_BRIGHT, 1),
	A_2("Below Average ", Console.RED_BRIGHT, 1),
	A_3("Average ", Console.WHITE, 5),
	A_4("Above Average ", Console.GREEN_BRIGHT, 10),
	A_5("High ", Console.GREEN_BRIGHT, 20),
	A_6("Superior ", Console.GREEN_BRIGHT, 9999);

	private static AttributeLevels[] vals = values();
	
	private final String name;
	
	private final String color;
	
	private final int costOfNextLevel;

	private AttributeLevels(String name, String color, int costOfNextLevel) {
		this.name = name;
		this.color = color;
		this.costOfNextLevel = costOfNextLevel;
	}

	public AttributeLevels next() {
		if(this.equals(A_6)) {
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
