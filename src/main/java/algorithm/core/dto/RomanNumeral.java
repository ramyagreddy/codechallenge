package algorithm.core.dto;

public class RomanNumeral {

	private int number;
	private String romanNumeral;

	public RomanNumeral() {
		super();
	}

	public RomanNumeral(final String romanNumeral) {
		super();

		setRomanNumeral(romanNumeral);
	}

	public RomanNumeral(final int number, final String romanNumeral) {
		super();

		setNumber(number);
		setRomanNumeral(romanNumeral);
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getRomanNumeral() {
		return romanNumeral;
	}

	public void setRomanNumeral(String romanNumeral) {
		this.romanNumeral = romanNumeral;
	}
}
