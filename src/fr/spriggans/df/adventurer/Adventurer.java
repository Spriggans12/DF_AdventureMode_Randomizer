package fr.spriggans.df.adventurer;

import fr.spriggans.df.ProgramOptions;
import fr.spriggans.df.console.Console;
import fr.spriggans.df.constants.Status;

public class Adventurer {

	private Status status;

	private PointsRepartition pointsRepartition;

	private Adventurer(AdventurerBuilder builder) {
		this.status = builder.options.getStatus();
		this.pointsRepartition = new PointsRepartition(this.status);
	}

	public void randomize() {
		this.pointsRepartition.randomize();
	}

	public void show() {
		Console.println("Your adventurer is a " + this.status + " !\n");
		this.pointsRepartition.show(false);
	}

	
	public static class AdventurerBuilder {
		
		private ProgramOptions options;
				
		public AdventurerBuilder withOptions(ProgramOptions options) {
			this.options = options;
			return this;
		}
		
		public Adventurer build() {
			return new Adventurer(this);
		}

		
	}
}
