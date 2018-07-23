package fr.spriggans.df.constants;

import fr.spriggans.util.ArgumentsUtil;
import fr.spriggans.util.RandomUtil;

public enum Sex {
	
	FEMALE("Female"),
	MALE("Male");
	
	public static final Sex[] VALS = values();
	
	Sex(String name) {
		this.name = name;
	}
	
	private final String name;

	@Override
	public String toString() {
		return name;
	}
	
	public static Sex getByString(String s) {
		if(ArgumentsUtil.OPT_SEX_VAL_F.equals(s)) {
			return FEMALE;
		}
		if(ArgumentsUtil.OPT_SEX_VAL_M.equals(s)) {
			return MALE;
		}
		// If null, returns random value
		return VALS[RandomUtil.R.nextInt(VALS.length)];
	}
}
