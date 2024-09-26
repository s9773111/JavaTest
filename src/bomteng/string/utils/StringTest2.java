package bomteng.string.utils;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringTest2 {
	public static void main(String[] args) {
		//把字串拆解(，) 正常要12個(如果依照分隔符號拆解)
		String a = "123a,4b, ,,dddd,,ee,ff,gg,, ,";
		System.out.println(a);
		System.out.println();
		
		// [123a, 4b,  , dddd, ee, ff, gg,  ] 長度 8 | 包含空白
        String[] b = StringUtils.split(a, ",");
        System.out.println("-----------split-----------");
        System.out.println(Arrays.toString(b));
        System.out.println("split 長度為:" + b.length);
        System.out.println();
        
        // [123a, 4b,  , dddd, ee, ff, gg,  , ] 長度 9
        String[] c = StringUtils.splitByWholeSeparator(a, ",");
        System.out.println("-----------splitByWholeSeparator-----------");
        System.out.println(Arrays.toString(c));
        System.out.println("splitByWholeSeparator 長度為:" + c.length);
        System.out.println();
        
        // [123a, 4b,  , , dddd, , ee, ff, gg, ,  , ] 長度 12
        String[] g = StringUtils.splitByWholeSeparatorPreserveAllTokens(a, ",");
        System.out.println("-----------splitByWholeSeparatorPreserveAllTokens-----------");
        System.out.println(Arrays.toString(g));
        System.out.println("splitByWholeSeparatorPreserveAllTokens 長度為:" + g.length);
        System.out.println();
        
        // [123a, 4b,  , , dddd, , ee, ff, gg, ,  , ] 長度 12
        String[] d = StringUtils.splitPreserveAllTokens(a, ",");
        System.out.println("-----------splitPreserveAllTokens-----------");
        System.out.println(Arrays.toString(d));
        System.out.println("splitPreserveAllTokens 長度為:" + d.length);
        System.out.println();  
        
        // [123, a, ,, 4, b, ,,  , ,,, dddd, ,,, ee, ,, ff, ,, gg, ,,,  , ,] 長度 18
        String[] e = StringUtils.splitByCharacterType(a);
        System.out.println("-----------splitByCharacterType-----------");
        System.out.println(Arrays.toString(e));
        System.out.println("splitByCharacterType 長度為:" + e.length);
        System.out.println(); 
        
        // [123, a, ,, 4, b, ,,  , ,,, dddd, ,,, ee, ,, ff, ,, gg, ,,,  , ,] 長度 18
        String[] f = StringUtils.splitByCharacterTypeCamelCase(a);
        System.out.println("-----------splitByCharacterTypeCamelCase-----------");
        System.out.println(Arrays.toString(f));
        System.out.println("splitByCharacterTypeCamelCase 長度為:" + f.length);
        System.out.println(); 

        // [123a,4b,, ,,dddd,,ee,ff,gg,,, ,] 長度 3
        String[] h = StringUtils.splitPreserveAllTokens(a);
        System.out.println("-----------splitPreserveAllTokens-----------");
        System.out.println(Arrays.toString(h));
        System.out.println("splitPreserveAllTokens 長度為:" + h.length);
        System.out.println(); 
        
        for(String a1 : h) {
        	System.out.println("h: " + a1);
        }
        System.out.println(); 
        
        for(String a2 : e) {
        	System.out.println("e splitByCharacterType: " + a2);
        }
        //把字串拆解( | )
        
        
	}
}
