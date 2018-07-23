package fr.spriggans.df.constants;

public enum Skills {

	SWORD("Sword"),
	MACE("Mace"),
	AXE("Axe"),
	HAMMER("Hammer"),
	PIKE("Pike"),
	BOW("Bow"),
	MARKS("Marks"),
	SPEAR("Spear"),
	LASHE("Lasher"),
	FIGHT("Fighter"),
	ARCHE("Archer"),
	OBSER("Observer"),
	SWIMM("Swimmer"),
	CLIMB("Climber"),
	AMBUS("Ambusher"),
	TRACK("Tracker"),
	SHIEL("Shield User"),
	ARMOR("Armor User"),
	DODGE("Dodger"),
	WREST("Wrestler"),
	STRIK("Striker"),
	KICK("Kicker"),
	BITER("Biter"),
	THROW("Thrower"),
	MISC("Misc. Object User"),
	KNAPP("Knapper"),
	BONES("Bone Carver"),
	BUTCH("Butcher"),
	CARPE("Carpenter"),
	READE("Reader"),
	WORDS("Wordsmith"),
	WRITT("Writer"),
	POET("Poet"),
	SPEAK("Speaker"),
	MUSIC("Musician"),
	SINGE("Singer"),
	STRIN("Stringed Instrumentalist"),
	WIND("Wind Instrumentalist"),
	PERCU("Percussionist"),
	DANCE("Dancer"),
	PERSU("Persuader"),
	FLATT("Flatterer"),
	JUDGE("Judge of Intent");
	
	public static final Skills[] VALS = values();

	private final String name;

	private Skills(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
