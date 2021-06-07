package edu.miu.mockitodemo.helper;

public class StringHelper {

	private final StringProviderInterface stringProviderInterface;

	public StringHelper(StringProviderInterface stringProviderInterface) {
		this.stringProviderInterface = stringProviderInterface;
	}

	public String truncateAInFirst2Positions() {
		var str=stringProviderInterface.getName();
		if (str.length() <= 2)
			return str.replaceAll("A", "");

		var first2Chars = str.substring(0, 2);
		var stringMinusFirst2Chars = str.substring(2);

		return first2Chars.replaceAll("A", "") + stringMinusFirst2Chars;
	}

	public boolean areFirstAndLastTwoCharactersTheSame() {
		String str=stringProviderInterface.getName();
		if (str.length() <= 1)
			return false;
		if (str.length() == 2)
			return true;

		var first2Chars = str.substring(0, 2);

		var last2Chars = str.substring(str.length() - 2);

		return first2Chars.equals(last2Chars);
	}

}
