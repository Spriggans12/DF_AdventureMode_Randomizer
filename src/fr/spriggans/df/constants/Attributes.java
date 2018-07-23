package fr.spriggans.df.constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Attributes {

	STREN("Strength"),
	AGILI("Agility"),
	TOUGH("Toughness"),
	ENDUR("Endurance"),
	RECUP("Recuperation"),
	DIS_R("Diseace Resistance"),
	ANA_A("Analytical Ability"),
	FOCUS("Focus"),
	WIILP("Willpower"),
	CREAT("Creativity"),
	INTUI("Intuition"),
	PATIE("Patience"),
	MEMOR("Memory"),
	LINGU("Linguistic Ability"),
	SPA_S("Spacial Sence"),
	MUSIC("Musicality"),
	KINES("Kinesthetic Sence"),
	EMPAT("Empathy"),
	SOC_A("Social Awareness");

	public static final Attributes[] VALS = values();
	
	private final String name;

	private Attributes(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
