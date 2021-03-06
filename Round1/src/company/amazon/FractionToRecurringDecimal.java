package company.amazon;

import java.util.HashMap;
import java.util.Map;
/**
 * 166. Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
 */
public class FractionToRecurringDecimal {

	public static void main(String[] args) {

	}

	public String fractionToDecimal(int numerator, int denominator) {
		StringBuilder sb = new StringBuilder();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // remainder, position
		
		if (denominator == 0) {
			return null;
		}
		
		if ((numerator < 0) ^ (denominator < 0)) {
			sb.append("-");
		}
		
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		
		int digit = numerator / denominator;
		int remainder = numerator % denominator;
		
		sb.append(digit);
		
		if (remainder == 0) {
			return sb.toString();
		}
		
		sb.append(".");
		
		while (remainder != 0) {
			map.put(remainder, sb.length()); //记录position， 为了方便之后加括号
			
			remainder *= 10;
			sb.append(remainder / denominator);
			remainder = remainder % denominator;
			
			if (map.containsKey(remainder)) {
				sb.insert(map.get(remainder), "(");
				sb.append(")");
				break;
			}
		}
		
		return sb.toString();
	}
}
