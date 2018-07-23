package fr.spriggans.util;

import java.util.Random;

public class RandomUtil {
	
	public static Random R = new Random();
	
	public static void overrideRandomWithSeed(long seed) {
		R = new Random(seed);
	}
}
