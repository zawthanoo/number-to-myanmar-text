package com.mutu.ntw.mm;

public class HundredConvertor extends AbstractMynNumConvertor {
	private TenConvertor tenConvertor = new TenConvertor();
    @Override
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        int number;
        if (value.length() > 3) {
            number = Integer.valueOf(value.substring(value.length() - 3), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        if(number < 1000) {
        	String postFix = value.substring(value.length() - 3, value.length() - 2);
        	if(Integer.valueOf(postFix) > 0) {
        		String numKey = MymNumConstant.MYN_NNUMBER_ + postFix;
	        	String num_1 = mymNumberConfig.getProperty(numKey) + mymNumberConfig.getProperty(MymNumConstant.MYN_ZERO_2_COUNT);
	        	buffer.append(num_1);
        	}
        	if(number % 100 != 0) {
            	String tenNum = value.substring(value.length() - 2, value.length());
            	String num_2 = tenConvertor.getName(tenNum);
            	buffer.append(num_2);
        	}
        }
        return buffer.toString();
    }
}
