package com.mutu.ntw.mm;

import java.text.DecimalFormat;

/**
 * 
 * @author Ye Kyaw Kyaw Htoo
 * This class has a static method to convert English Number to Myanmar Number.
 */
public class NumberToNumberConvertor {
	public static final String MM_ZERO = "\u1040";
	public static final String MM_ONE = "\u1041";
	public static final String MM_TWO = "\u1042";
	public static final String MM_THREE = "\u1043";
	public static final String MM_FOUR = "\u1044";
	public static final String MM_FIVE = "\u1045";
	public static final String MM_SIX = "\u1046";
	public static final String MM_SEVEN = "\u1047";
	public static final String MM_EIGHT = "\u1048";
	public static final String MM_NINE = "\u1049";
	public static final String MM_DOT = ".";
	public static final String MM_COMMA = ",";
	public static final String MM_SPACE = " ";
	
	public static final char EN_ZERO = '0';
	public static final char EN_ONE = '1';
	public static final char EN_TWO = '2';
	public static final char EN_THREE = '3';
	public static final char EN_FOUR = '4';
	public static final char EN_FIVE = '5';
	public static final char EN_SIX = '6';
	public static final char EN_SEVEN = '7';
	public static final char EN_EIGHT = '8';
	public static final char EN_NINE = '9';
	public static final char EN_DOT = '.';
	public static final char EN_COMMA = ',';
	public static final char EN_SPACE = ' ';
	
	public static String getMyanmarNumber (double v) {
		
		StringBuffer result = new StringBuffer();
		
		DecimalFormat df = new DecimalFormat("##,###.00");
		String value = df.format(v);
		
		for (char c: value.toCharArray()) {
			
			switch (c) {
			
				case EN_ZERO: {
					result.append(MM_ZERO);
					break;
				}
				case EN_ONE: {
					result.append(MM_ONE);
					break;
				}
				case EN_TWO: {
					result.append(MM_TWO);
					break;
				}
				case EN_THREE: {
					result.append(MM_THREE);
					break;
				}
				case EN_FOUR: {
					result.append(MM_FOUR);
					break;
				}
				case EN_FIVE: {
					result.append(MM_FIVE);
					break;
				}
				case EN_SIX: {
					result.append(MM_SIX);
					break;
				}
				case EN_SEVEN: {
					result.append(MM_SEVEN);
					break;
				}
				case EN_EIGHT: {
					result.append(MM_EIGHT);
					break;
				}
				case EN_NINE: {
					result.append(MM_NINE);
					break;
				}
				
				case EN_DOT: {
					result.append(MM_DOT);
					break;
				}
				
				case EN_COMMA: {
					result.append(MM_COMMA);
					break;
				}
				
				case EN_SPACE: {
					result.append(MM_SPACE);
					break;
				}
			
			}
		}
		
		return result.toString();
	}
	

/* 
  public static void main(String[] args) {
		String x = getMyanmarNumber(12455888.77);
		System.out.println("");
	}*/
}
