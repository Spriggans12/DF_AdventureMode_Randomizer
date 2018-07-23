package fr.spriggans.df;

import java.util.List;
import java.util.Map;

import fr.spriggans.df.constants.Status;
import fr.spriggans.util.ArgumentsUtil;

/**
 * Options set via arguments.
 */
public class ProgramOptions {

	private final boolean colorful;
	
	private final Status status;
	
	public ProgramOptions(ProgramOptionsBuilder builder) {
		String sValue = getParamValue(builder.params, ArgumentsUtil.OPT_STATUS, ArgumentsUtil.OPT_S_VAL_P);
		this.status = Status.getStatusByString(sValue);
		this.colorful = builder.params.get(ArgumentsUtil.OPT_COLOR) != null;
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
