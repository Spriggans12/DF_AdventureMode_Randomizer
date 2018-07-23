package fr.spriggans.df;

import fr.spriggans.console.Console;
import fr.spriggans.df.constants.Status;

public class Adventurer {

	private Status status;

	private Configuration configuration;

	public Adventurer(Status status) {
		this.status = status;
		this.configuration = new Configuration(this.status);
	}

	public void randomize() {
		this.configuration.randomize();
	}

	public void show() {
		Console.println("Your adventurer is a " + this.status + " !\n");
		this.configuration.show(false);
	}

}
