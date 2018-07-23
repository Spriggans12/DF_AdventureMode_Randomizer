package fr.spriggans.df.constants;

import fr.spriggans.util.ArgumentsUtil;

public enum Status {

	PEASANT("Peasant", 72, 35),
	HERO("Hero", 92, 95), 
	DEMI_GOD("Demigod", 162, 161),
	CHEATER("Cheater", 500, 999);

	private final String name;

	private final int attributePoints;

	private final int skillPoints;

	Status(String name, int attributePoints, int skillPoints) {
		this.name = name;
		this.attributePoints = attributePoints;
		this.skillPoints = skillPoints;
	}

	@Override
	public String toString() {
		return name;
	}

	public int getAttributePoints() {
		return attributePoints;
	}

	public int getSkillPoints() {
		return skillPoints;
	}
	
	public static Status getStatusByString(String s) {
		if(ArgumentsUtil.OPT_S_VAL_P.equals(s)) {
			return PEASANT;
		} else if(ArgumentsUtil.OPT_S_VAL_H.equals(s)) {
			return HERO;
		} else if(ArgumentsUtil.OPT_S_VAL_G.equals(s)) {
			return DEMI_GOD;
		}
		return CHEATER;
	}
}
