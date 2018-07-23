package fr.spriggans.df.constants;

import fr.spriggans.util.ArgumentsUtil;
import fr.spriggans.util.RandomUtil;

public enum Race {
	
	DWARF("Dwarf"),
	ELF("Elf"),
	GOBLIN("Goblin"),
	HUMAN("Human");
	
	public static final Race[] VALS = values();
	
	Race(String name) {
		this.name = name;
	}
	
	private final String name;

	@Override
	public String toString() {
		return name;
	}
	
	public static Race getByString(String s) {
		if(ArgumentsUtil.OPT_RACE_VAL_D.equals(s)) {
			return DWARF;
		}
		if(ArgumentsUtil.OPT_RACE_VAL_E.equals(s)) {
			return ELF;
		}
		if(ArgumentsUtil.OPT_RACE_VAL_G.equals(s)) {
			return GOBLIN;
		}
		if(ArgumentsUtil.OPT_RACE_VAL_H.equals(s)) {
			return HUMAN;
		}
		// If null, returns random value
		return VALS[RandomUtil.R.nextInt(VALS.length)];
	}
}
