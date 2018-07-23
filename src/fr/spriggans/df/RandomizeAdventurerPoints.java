package fr.spriggans.df;

import java.util.List;
import java.util.Map;

import fr.spriggans.df.ProgramOptions.ProgramOptionsBuilder;
import fr.spriggans.df.adventurer.Adventurer;
import fr.spriggans.df.adventurer.Adventurer.AdventurerBuilder;
import fr.spriggans.df.console.Console;
import fr.spriggans.util.ArgumentsUtil;

public class RandomizeAdventurerPoints {

	public static void main(String[] args) {
		final Map<String, List<String>> params =  ArgumentsUtil.parseArgumentsToMap(args);
		if(params == null) {
			return;
		}

		ProgramOptions options = new ProgramOptionsBuilder().withParams(params).build();
		if(options.isColorful()) {
			Console.makeColorful();
		}
		Adventurer adventurer = new AdventurerBuilder().withOptions(options).build();
		adventurer.randomize();
		adventurer.show();
	}

}
