package fr.spriggans.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArgumentsUtil {

	private static final String OPT_HELP = "help";

	public static final String OPT_STATUS = "s";

	public static final String OPT_S_VAL_P = "p";

	public static final String OPT_S_VAL_H = "h";

	public static final String OPT_S_VAL_G = "g";

	public static final String OPT_COLOR = "c";

	private static final List<String> KNOWN_PARAMETERS = Arrays.asList(OPT_HELP, OPT_STATUS, OPT_COLOR);

	/**
	 * Reads args and puts all that in a nice HashMap.<br/>
	 * If an error occurs, prints the help and an error message.
	 * Returns null if error in args.
	 */
	public static Map<String, List<String>> parseArgumentsToMap(String[] args) {
		Map<String, List<String>> params = parseArgs(args);
		boolean paramsOK = checkParamValues(params);
		if (!paramsOK) {
			System.err.println("");
			printHelp();
			return null;
		}
		return params;
	}

	private static Map<String, List<String>> parseArgs(String[] args) {
		final Map<String, List<String>> res = new HashMap<>();
		List<String> options = null;
		for (int i = 0; i < args.length; i++) {
			final String arg = args[i];
			if (arg.charAt(0) == '-') {
				if (arg.length() < 2) {
					System.err.println("Error at argument " + arg);
					return null;
				}
				options = new ArrayList<>();
				res.put(arg.substring(1), options);
			} else if (options != null) {
				options.add(arg);
			} else {
				System.err.println("Illegal parameter usage");
				return null;
			}
		}
		return res;
	}

	private static boolean checkParamValues(Map<String, List<String>> params) {
		if (params == null || params.get(OPT_HELP) != null) {
			return false;
		}
		if (!checkParamValue(params, OPT_STATUS, Arrays.asList(OPT_S_VAL_P, OPT_S_VAL_H, OPT_S_VAL_G), false)) {
			return false;
		}
		if (!checkParamValue(params, OPT_COLOR, null, false)) {
			return false;
		}

		if (!checkUnknownArguments(params)) {
			return false;
		}
		return true;
	}

	/**
	 * @param allowedValues
	 *            null if parameter is a flag
	 * @param required
	 *            if true, param must be supplied
	 */
	private static boolean checkParamValue(Map<String, List<String>> params, String paramToCheck,
			List<String> allowedValues, boolean required) {
		List<String> param = params.get(paramToCheck);
		if (param == null) {
			// Parameter is not set
			if (required) {
				System.err.println("Parameter '" + paramToCheck + "' is required.");
				return false;
			}
			return true;
		}
		if (param.size() > 0) {
			// If parameter is a flag, it must not have a value
			if(allowedValues == null) {
				System.err.println("Parameter '" + paramToCheck + "' does not accept values.");
				return false;
			}
			// Parameter is set with a value. Check that value
			if (!allowedValues.contains(param.get(0))) {
				System.err.println("Parameter '" + paramToCheck + "' has incorrect value.");
				System.err.print("Valid values for parameter '" + paramToCheck + "' are : ");
				System.err.print(allowedValues.stream().collect(Collectors.joining("', '", "'", "'")));
				System.err.println();
				return false;
			}
		} else if(allowedValues != null) {
			// Parameter is set without value and is not a flag...
			System.err.println("Parameter '" + paramToCheck + "' must have a value.");
			System.err.print("Valid values for parameter '" + paramToCheck + "' are : ");
			System.err.print(allowedValues.stream().collect(Collectors.joining("', '", "'", "'")));
			System.err.println();
			return false;
			
		}
		return true;
	}

	private static boolean checkUnknownArguments(Map<String, List<String>> params) {
		for (String suppliedParam : params.keySet()) {
			if (!KNOWN_PARAMETERS.contains(suppliedParam)) {
				System.err.println("Argument '" + suppliedParam + "' is not a valid argument.");
				return false;
			}
		}
		return true;
	}

	private static void printHelp() {
		System.err.println("Usage : java -jar Main.jar [options]");
		System.err.println("  Options:");
		System.err.println("  -help\t\t\tShows this screen");
		System.err.println("  -s <value>\t\tStatus of the adventurer. Permitted values are 'p' (Peasant), 'h' (Hero) and 'g' (Semigod). Defaults to Peasant.");
		System.err.println("  -c\t\t\tColorful. Turns on the use of colors (only supported by ANSI consoles). Disabled by default.");
	}
}
