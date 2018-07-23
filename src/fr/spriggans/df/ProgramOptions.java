package fr.spriggans.df;

import java.util.List;
import java.util.Map;

import fr.spriggans.df.constants.Race;
import fr.spriggans.df.constants.Sex;
import fr.spriggans.df.constants.Status;
import fr.spriggans.util.ArgumentsUtil;
import fr.spriggans.util.RandomUtil;

/**
 * Options set via arguments.
 */
public class ProgramOptions {

	private final boolean colorful;
	
	private final Status status;
	
	private final Sex sex;
	
	private final Race race;
	
	public ProgramOptions(ProgramOptionsBuilder builder) {
		// We parse the seed first, in case it has been changed.
		String seed = getParamValue(builder.params, ArgumentsUtil.OPT_SEED, null);
		if(seed != null) {
			RandomUtil.overrideRandomWithSeed(Long.parseLong(seed));
		}
		
		String sValue = getParamValue(builder.params, ArgumentsUtil.OPT_STATUS, ArgumentsUtil.OPT_S_VAL_P);
		this.status = Status.getByString(sValue);
		
		this.colorful = builder.params.get(ArgumentsUtil.OPT_COLOR) != null;
		
		String sexValue = getParamValue(builder.params, ArgumentsUtil.OPT_SEX, null);
		this.sex = Sex.getByString(sexValue);
		
		String raceValue = getParamValue(builder.params, ArgumentsUtil.OPT_RACE, null);
		this.race = Race.getByString(raceValue);
	}
	
	private String getParamValue(Map<String, List<String>> params, String param, String defaultValue) {
		List<String> p = params.get(param);
		if(p == null || p.size() == 0) {
			return defaultValue;
		}
		return p.get(0);
	}

	public boolean isColorful() {
		return colorful;
	}

	public Status getStatus() {
		return status;
	}

	public Sex getSex() {
		return sex;
	}

	public Race getRace() {
		return race;
	}

	public static class ProgramOptionsBuilder {
		
		private Map<String, List<String>> params;

		public ProgramOptionsBuilder withParams(Map<String, List<String>> params) {
			this.params = params;
			return this;
		}

		public ProgramOptions build() {
			return new ProgramOptions(this);
		}
	}
}
