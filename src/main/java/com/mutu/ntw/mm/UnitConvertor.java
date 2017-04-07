package com.mutu.ntw.mm;


public class UnitConvertor extends AbstractMynNumConvertor {
	protected final String SEPARATOR = " ";
    protected final int NO_VALUE = -1;

	public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        int number;
        if (value.length() > 1) {
            number = Integer.valueOf(value.substring(value.length() - 1), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
    	String mynNumber = MymNumConstant.MYN_NNUMBER_ + number;
        buffer.append(mymNumberConfig.getProperty(mynNumber));
        return buffer.toString();
    }
}
