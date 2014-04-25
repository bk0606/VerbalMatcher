package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Class that provides the ability to create large and complex
 * regular expressions in a simple way
 * For example:
 * <code>
 * main.VerbalMatcher VmGreeting = new main.VerbalMatcher()
 *            .then("Hello")
 *            .or("Hi")
 *            .then(", ")
 *            .then("Petter")
 *            .maybe("!");
 * System.out.println(VmGreeting.toString());
 * </code>
 * Prints pattern: "((Hello)|(Hi))(, )(Petter)(!)?"
 * @author Albert Bikeev
 */
public class VerbalMatcher {
	private String pattern = "";

	public VerbalMatcher then(String pattern) {
		this.pattern += "(" + pattern + ")";
		try {
			Pattern.compile(this.pattern);
		} catch(PatternSyntaxException e) {
			System.out.println("Uncorrect pattern in \"then\" operation: " + e.getPattern());
		}
		return this;
	}

	public VerbalMatcher or(String pattern) {
		this.pattern = "(" + this.pattern + "|(" + pattern + "))";
		try {
			Pattern.compile(this.pattern);
		} catch(PatternSyntaxException e) {
			System.out.println("Uncorrect pattern in \"or\" operation: " + e.getPattern());
		}
		return this;
	}

	public VerbalMatcher maybe(String pattern) {
		this.pattern += "(" + pattern + ")?";
		try {
			Pattern.compile(this.pattern);
		} catch(PatternSyntaxException e) {
			System.out.println("Uncorrect pattern in \"maybe\" operation: " + e.getPattern());
		}
		return this;
	}

	public VerbalMatcher without(String pattern) {
		this.pattern += "(" + "(" + pattern + "){0}" + ")";
		try {
			Pattern.compile(this.pattern);
		} catch(PatternSyntaxException e) {
			System.out.println("Uncorrect pattern in \"without\" operation: " + e.getPattern());
		}
		return this;
	}

	public String toString() {
		return this.pattern;
	}

	public Pattern compilePattern() {
		return Pattern.compile(this.pattern);
	}

	public boolean test(String line) {
		Pattern p = Pattern.compile(this.pattern);
		Matcher m = p.matcher(line);
		System.out.println(line);
		return m.matches();
	}
}
