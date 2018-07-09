package com.nihongo.support.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author DoanhNV
 * Jul 7, 2018 10:33:54 AM
 */
public class NihongoUtil {
	
	public static List<Integer> randomNumberList(int min, int max, int total) {
		List<Integer> numbers = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < total; i++) {
			int number = random.nextInt(max);
			while(numbers.contains(number) || number > max || number < min) {
				number = random.nextInt(max);
			}
			numbers.add(number);
		}
		return numbers;
	}
}
