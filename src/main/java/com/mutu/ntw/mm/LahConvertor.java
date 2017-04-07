package com.mutu.ntw.mm;

public class LahConvertor extends AbstractMynNumConvertor {
	private TenThousandConvertor tenThousandConvertor = new TenThousandConvertor();
    public String getName(String value) {
        StringBuilder buffer = new StringBuilder();
        int number;
        if(value.length() > 6) {
        	DefaultConvertor defaultConvertor = new DefaultConvertor();
        	int lahNumber = Integer.valueOf(value.substring(0, value.length() - 5));
        	if(lahNumber % 10 != 0 || lahNumber == 10) {
        		if(lahNumber == 10) {
        			buffer.append(mymNumberConfig.getProperty(MymNumConstant.MYN_ZERO_1_COUNT));
        			buffer.append(mymNumberConfig.getProperty(MymNumConstant.LAH_POSTFIX));
        		} else {
        			buffer.append(defaultConvertor.getName(lahNumber));
        			buffer.append(mymNumberConfig.getProperty(MymNumConstant.LAH_POSTFIX));
        		}
        	} else {
        		buffer.append(mymNumberConfig.getProperty(MymNumConstant.LAH_PREFIX) + " ");
        		buffer.append(defaultConvertor.getName(lahNumber));
        		int notlahNumber = Integer.valueOf(value.substring(value.length() - 5, value.length()));
        		if( notlahNumber > 0){
        			buffer.append(" " + mymNumberConfig.getProperty(MymNumConstant.MYN_UNION_AND) + " ");
        		}
        	}
        	buffer.append(defaultConvertor.getName(value.substring(value.length() - 5, value.length())));
        } else {
            if (value.length() > 4) {
                number = Integer.valueOf(value.substring(value.length() - 4), 10);
            } else {
                number = Integer.valueOf(value, 10);
            }
            if(number < 100000) {
            	String postFix = value.substring(value.length() - 6, value.length() - 5);
            	if(Integer.valueOf(postFix) > 0) {
            		String numKey = MymNumConstant.MYN_NNUMBER_ + postFix;
                	String num_1 = mymNumberConfig.getProperty(numKey) + mymNumberConfig.getProperty(MymNumConstant.LAH_POSTFIX);
                	buffer.append(num_1);
            	}
            	if(number % 10000 != 0) {
                	String tenNum = value.substring(value.length() - 5, value.length());
                	String num_2 = tenThousandConvertor.getName(tenNum);
                	buffer.append(num_2);
            	}
            }
        }
        return buffer.toString();

    }
}
