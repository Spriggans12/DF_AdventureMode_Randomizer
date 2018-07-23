package fr.spriggans.df;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import fr.spriggans.console.Console;
import fr.spriggans.df.constants.AttributeLevels;
import fr.spriggans.df.constants.Attributes;
import fr.spriggans.df.constants.SkillLevels;
import fr.spriggans.df.constants.Skills;
import fr.spriggans.df.constants.Status;

public class Configuration {

	/**
	 * Amount of + pressed for said attribute.
	 */
	Map<Attributes, AttributeLevels> attributesRepartition;

	private int remainingAttributePoints;

	/**
	 * Amount of + pressed for said skill.
	 */
	Map<Skills, SkillLevels> skillsRepartition;

	private int remainingSkillPoints;

	public Configuration(Status status) {
		this.attributesRepartition = initAttrs();
		this.skillsRepartition = initSkills();
		this.remainingAttributePoints = status.getAttributePoints();
		this.remainingSkillPoints = status.getSkillPoints();
	}

	private Map<Attributes, AttributeLevels> initAttrs() {
		Map<Attributes, AttributeLevels> res = new HashMap<>();
		for (Attributes attr : Attributes.values()) {
			res.put(attr, AttributeLevels.A_0);
		}
		return res;
	}

	private Map<Skills, SkillLevels> initSkills() {
		Map<Skills, SkillLevels> res = new HashMap<>();
		for (Skills skill : Skills.values()) {
			res.put(skill, SkillLevels.S_0);
		}
		return res;
	}

	public void randomize() {
		Random r = new Random();
		randomizeAttributes(r);
		randomizeSkills(r);
	}

	private void randomizeAttributes(Random r) {
		// List of upgrades we can afford.
		List<Attributes> affordableList = Arrays.asList(Attributes.VALS);

		// Loop until no more upgrades possible
		while (!affordableList.isEmpty()) {
			int random = r.nextInt(affordableList.size());
			Attributes attrToIncrement = affordableList.get(random);
			AttributeLevels currentLevel = this.attributesRepartition.get(attrToIncrement);
			int upgradeCost = currentLevel.getCostOfNextLevel();

			// Buy upgrade
			this.remainingAttributePoints -= upgradeCost;
			this.attributesRepartition.put(attrToIncrement, currentLevel.next());

			affordableList = getAffordableAttributes();
		}
	}

	private List<Attributes> getAffordableAttributes() {
		List<Attributes> res = new ArrayList<>();
		for (Entry<Attributes, AttributeLevels> entry : this.attributesRepartition.entrySet()) {
			if (entry.getValue().getCostOfNextLevel() <= this.remainingAttributePoints) {
				res.add(entry.getKey());
			}
		}
		return res;
	}

	private void randomizeSkills(Random r) {
		// List of upgrades we can afford.
		List<Skills> affordableList = Arrays.asList(Skills.VALS);

		// Loop until no more upgrades possible
		while (!affordableList.isEmpty()) {
			int random = r.nextInt(affordableList.size());
			Skills skillToIncrement = affordableList.get(random);
			SkillLevels currentLevel = this.skillsRepartition.get(skillToIncrement);
			int upgradeCost = currentLevel.getCostOfNextLevel();

			// Buy upgrade
			this.remainingSkillPoints -= upgradeCost;
			this.skillsRepartition.put(skillToIncrement, currentLevel.next());

			affordableList = getAffordableSkills();
		}
	}

	private List<Skills> getAffordableSkills() {
		List<Skills> res = new ArrayList<>();
		for (Entry<Skills, SkillLevels> entry : this.skillsRepartition.entrySet()) {
			if (entry.getValue().getCostOfNextLevel() <= this.remainingSkillPoints) {
				res.add(entry.getKey());
			}
		}
		return res;
	}

	public void show(boolean showAll) {
		Console.println("Attributes :");
		attributesRepartition.forEach((skill, level) -> {
			if (showAll || !level.equals(AttributeLevels.A_0))
				Console.printlnColor(level + "" + skill, level.getColor());
		});

		Console.println("\nSkills :");
		skillsRepartition.forEach((attr, level) -> {
			if (showAll || !level.equals(SkillLevels.S_0)) {
				Console.printlnColor(level + "" + attr, level.getColor());
			}
		});

		Console.println("\nRemaining points :");
		Console.println(this.remainingAttributePoints + " for attributes.");
		Console.println(this.remainingSkillPoints + " for skills.");

	}
}
