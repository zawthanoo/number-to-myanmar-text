package com.mutu.ntw.mm;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public abstract class AbstractMynNumConvertor {
	protected static Properties mymNumberConfig;
	static {
	    try {
	    	mymNumberConfig = new Properties();
		    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		    InputStream in = classLoader.getResourceAsStream("mym-number-unicode.properties");
		    mymNumberConfig.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed to load mym-number.properties");
		}
	}	

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

    abstract public String getName(String value);
}
