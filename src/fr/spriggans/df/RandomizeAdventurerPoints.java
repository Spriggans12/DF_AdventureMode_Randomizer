package fr.spriggans.df;

import fr.spriggans.df.constants.Status;

public class RandomizeAdventurerPoints {

	private static final Status STATUS = Status.PEASANT;

	public static void main(String[] args) {
		Adventurer adventurer = new Adventurer(STATUS);
		adventurer.randomize();
		adventurer.show();
	}

}
