package bomteng.string.utils;

import java.util.Arrays;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

public class StringTest1 {
	public static void main(String[] args) {
		// 判斷字串是否為空 
		// true
		boolean isBlank = StringUtils.isBlank("");
		System.out.println("isBlank:" + isBlank);

		// 將字串轉換為大寫 
		// HELLO
		String upperCase = StringUtils.upperCase("hello");
		System.out.println("upperCase:" + upperCase);


		// 將字串中的某個字串替換為另一個字串
		// goodbye world
		String replaced = StringUtils.replace("hello world", "hello", "goodbye");
		System.out.println("replaced:" + replaced);

		
		// 截取字串的子字串
		// world
		String substring = StringUtils.substring("hello world", 5);
		System.out.println("substring:" + substring);

		
		// 將字串陣列合併為一個字串
		// hello world
		String joined = StringUtils.join(new String[]{"hello", "world"}, " ");
		System.out.println("joined:" + joined);

		// 去除字串首尾的空白字元
		// hello 
		String trimmed = StringUtils.trim("  hello  ");
		System.out.println("trimmed:" + trimmed);

		// 將字串拆分為字串陣列
		// hello, world
		String[] split = StringUtils.split("hello world", " ");
		for (String str : split) {
		    System.out.println("split1 :" +str);
		}
		
		System.out.println("split2 array:" + Arrays.toString(split));

	}
}
