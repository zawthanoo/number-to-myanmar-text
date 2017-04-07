package com.mutu.ntw.mm;

public class DefaultConvertor extends AbstractMynNumConvertor {
	private UnitConvertor unitConvertor = new UnitConvertor();
	private TenConvertor tenConvertor = new TenConvertor();
	private HundredConvertor hundredConvertor = new HundredConvertor();
	private ThousandConvertor thousandConvertor = new ThousandConvertor();
	private TenThousandConvertor tenThousandConvertor = new TenThousandConvertor();
	private LahConvertor lahConvertor = new LahConvertor();
    @Override
    public String getName(String value) {
        String result = null;
        if (value.length() > 5) {
        	result = lahConvertor.getName(value);
        } else if (value.length() > 4) {
        	result = tenThousandConvertor.getName(value);
        } else if (value.length() > 3) {
        	result = thousandConvertor.getName(value);
        } else if (value.length() > 2) {
        	result = hundredConvertor.getName(value);
        } else if (value.length() > 1) {
        	result = tenConvertor.getName(value);
        } else {
        	result = unitConvertor.getName(value);
        }
        return result;
    }
}
