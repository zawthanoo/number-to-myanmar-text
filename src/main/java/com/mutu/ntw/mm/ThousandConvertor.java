package com.mutu.ntw.mm;

public class ThousandConvertor extends AbstractMynNumConvertor {
	private HundredConvertor hundredConvertor = new HundredConvertor();
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        int number;
        if (value.length() > 3) {
            number = Integer.valueOf(value.substring(value.length() - 3), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        if(number < 10000) {
        	String postFix = value.substring(value.length() - 4, value.length() - 3);
        	if(Integer.valueOf(postFix) > 0) {
        		String numKey = MymNumConstant.MYN_NNUMBER_ + postFix;
	        	String num_1 = mymNumberConfig.getProperty(numKey) + mymNumberConfig.getProperty(MymNumConstant.MYN_ZERO_3_COUNT);
	        	buffer.append(num_1);
        	}
        	if(number % 1000 != 0) {
            	String tenNum = value.substring(value.length() - 3, value.length());
            	String num_2 = hundredConvertor.getName(tenNum);
            	buffer.append(num_2);
        	}
        }
        return buffer.toString();
    }

}
