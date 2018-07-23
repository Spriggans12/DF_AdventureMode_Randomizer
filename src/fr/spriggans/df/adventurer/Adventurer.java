package fr.spriggans.df.adventurer;

import fr.spriggans.df.ProgramOptions;
import fr.spriggans.df.console.Console;
import fr.spriggans.df.constants.Race;
import fr.spriggans.df.constants.Sex;
import fr.spriggans.df.constants.Status;

public class Adventurer {

	private Status status;

	private Sex sex;

	private Race race;

	private PointsRepartition pointsRepartition;

	private Adventurer(AdventurerBuilder builder) {
		this.status = builder.options.getStatus();
		this.sex = builder.options.getSex();
		this.race = builder.options.getRace();
		this.pointsRepartition = new PointsRepartition(this.status);
	}

	public void randomize() {
		this.pointsRepartition.randomize();
	}

	public void show() {
		Console.println("Your adventurer is a " + this.sex + " " + this.race + " " + this.status + " !\n");
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
