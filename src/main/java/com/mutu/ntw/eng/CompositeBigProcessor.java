package com.mutu.ntw.eng;

public class CompositeBigProcessor extends AbstractProcessor {
	static public Scale SCALE = Scale.SHORT;
	private HundredProcessor hundredProcessor = new HundredProcessor();
	private AbstractProcessor lowProcessor;
	private int exponent;

	public CompositeBigProcessor(int exponent) {
		if (exponent <= 3) {
			lowProcessor = hundredProcessor;
		} else {
			lowProcessor = new CompositeBigProcessor(exponent - 3);
		}
		this.exponent = exponent;
	}

	public String getToken() {
		return SCALE.getName(getPartDivider());
	}

	protected AbstractProcessor getHighProcessor() {
		return hundredProcessor;
	}

	protected AbstractProcessor getLowProcessor() {
		return lowProcessor;
	}

	public int getPartDivider() {
		return exponent;
	}

	@Override
	public String getName(String value) {
		StringBuilder buffer = new StringBuilder();

		String high, low;
		if (value.length() < getPartDivider()) {
			high = "";
			low = value;
		} else {
			int index = value.length() - getPartDivider();
			high = value.substring(0, index);
			low = value.substring(index);
		}

		String highName = getHighProcessor().getName(high);
		String lowName = getLowProcessor().getName(low);

		if (!highName.isEmpty()) {
			buffer.append(highName);
			buffer.append(SEPARATOR);
			buffer.append(getToken());

			if (!lowName.isEmpty()) {
				buffer.append(SEPARATOR);
			}
		}

		if (!lowName.isEmpty()) {
			buffer.append(lowName);
		}

		return buffer.toString();
	}

	@Override
	public String getNameWithPyar(String value) {
		return getName(value);
	}
	
}
