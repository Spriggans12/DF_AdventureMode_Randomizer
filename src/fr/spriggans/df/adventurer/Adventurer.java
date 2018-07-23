package fr.spriggans.df.adventurer;

import fr.spriggans.df.ProgramOptions;
import fr.spriggans.df.console.Console;
import fr.spriggans.df.constants.Status;

public class Adventurer {

	/**
	 * Used for display.
	 */
	private Console console;
	
	private Status status;

	private PointsRepartition pointsRepartition;

	private Adventurer(AdventurerBuilder builder) {
		this.status = builder.options.getStatus();
		this.console = builder.console;
		this.pointsRepartition = new PointsRepartition(this.status, this.console);
	}

	public void randomize() {
		this.pointsRepartition.randomize();
	}

	public void show() {
		this.console.println("Your adventurer is a " + this.status + " !\n");
		this.pointsRepartition.show(false);
	}

	
	public static class AdventurerBuilder {
		
		private ProgramOptions options;
		
		private Console console;
		
		public AdventurerBuilder withOptions(ProgramOptions options) {
			this.options = options;
			return this;
		}
		
		public AdventurerBuilder withConsole(Console console) {
			this.console = console;
			return this;
		}
		
		public Adventurer build() {
			return new Adventurer(this);
		}

		
	}
}
