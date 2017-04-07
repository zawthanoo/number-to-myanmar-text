package com.mutu.ntw.mm;


public class TenConvertor extends AbstractMynNumConvertor {
    @Override
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        int number;
        if (value.length() > 2) {
            number = Integer.valueOf(value.substring(value.length() - 2), 10);
        } else {
            number = Integer.valueOf(value, 10);
        }
        if(number % 10 == 0) {
        	String numKey = MymNumConstant.MYN_NNUMBER_ + number / 10;
        	String tenNum = mymNumberConfig.getProperty(numKey) + mymNumberConfig.getProperty(MymNumConstant.MYN_ZERO_1_COUNT);
        	buffer.append(tenNum);
        } else {
        	if(number / 10 > 0) {
            	String a = mymNumberConfig.getProperty(MymNumConstant.MYN_NNUMBER_ + number / 10);
            	String b = mymNumberConfig.getProperty(MymNumConstant.MYN_NOT_DIV_10);
            	String c = mymNumberConfig.getProperty(MymNumConstant.MYN_NNUMBER_ + number % 10);
            	String tenNum = a + b + c;
            	buffer.append(tenNum);
        	}  else {
            	String num = mymNumberConfig.getProperty(MymNumConstant.MYN_NNUMBER_ + number % 10);
            	buffer.append(num);
        	}
        	
        }
        return buffer.toString();
    }
}
