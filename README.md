## Myanmar numbesr to word convertor.

The uitility is use to convert *Myanmar* number to word. 

Utility library developed in Java to convert digit number to *Myanmar* number in words.

### Test-case

	package com.mutu.ntw.mm;

	import java.util.Formatter;

	public class TestCase {
		public static String escapeUnicode(String input) {
			StringBuilder b = new StringBuilder(input.length());
			Formatter f = new Formatter(b);
			for (char c : input.toCharArray()) {
				if (c < 128) {
					b.append(c);
				} else {
					f.format("\\u%04x", (int) c);
				}
			}
			return b.toString();
		}

		public static void main(String[] args) {
			Double value = 12345678d;
			AbstractMynNumConvertor convertor = new DefaultConvertor();
			String mmWord = convertor.getName(value);
			
			/*
			 To check the output
			 Go -> https://www.percederberg.net/tools/text_converter.html
			 Convert the out ascii code of mmWord.
			 */
			 String assciiOutput = escapeUnicode(mmWord);
			 System.out.println(assciiOutput);
		}
	}

Use *TestCase* class to run the utility.
For example, if the input value is **12345678d**, then the output will be **တစ်ရာနှစ်ဆယ့်သုံးသိန်းလေးသောင်းငါးထောင်ခြောက်ရာခုနှစ်ဆယ့်ရှစ်** (unicode)

### Note

Now, it is using **unicode**, if you would like to use **zawgyi**, change `mym-number-unicode.properties` to `mym-number-zawgyi.properties` in `AbstractMynNumConvertor` class.
