package com.mutu.ntw.eng;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractProcessor {
	protected final String SEPARATOR = " ";
    protected final int NO_VALUE = -1;

    protected List<Integer> getDigits(long value) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        if (value == 0) {
            digits.add(0);
        } else {
            while (value > 0) {
                digits.add(0, (int) value % 10);
                value /= 10;
            }
        }
        return digits;
    }

    public String getName(long value) {
        return getName(Long.toString(value));
    }

    public String getName(double value) {
    	String dString = new DecimalFormat("#").format(value);   
        return getName(dString);
    }
    
    public String getNameWithPyar(double value) {
    	String dString = new DecimalFormat("#.00").format(value);   
        return getNameWithPyar(dString);
    }

    abstract public String getName(String value);
    abstract public String getNameWithPyar(String value);
}
