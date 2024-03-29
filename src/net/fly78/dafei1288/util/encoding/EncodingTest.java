package net.fly78.dafei1288.util.encoding;

/** *//**
 * <p>Title: LoonFramework</p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2008</p>
 * <p>Company: LoonFramework</p>
 * <p>License: http://www.apache.org/licenses/LICENSE-2.0</p>
 * @author chenpeng
 * @email：ceponline@yahoo.com.cn
 * @version 0.1
 */
public class EncodingTest{
    public static void main(String argc[]){
        ParseEncoding parse;

        parse = new ParseEncoding();
        System.out.println("北路先端="+parse.getEncoding("http://www.jaist.ac.jp/"));
         System.out.println("中国大陆：");
         System.out.println("测试字符串，编码格式="+parse.getEncoding("百度".getBytes()));
         System.out.println("测试站点，编码格式="+parse.getEncoding("http://www.baidu.com"));
         System.out.println();
         System.out.println("中国台湾：");
         System.out.println("测试字符串，编码格式="+parse.getEncoding("い地チ瓣".getBytes()));
         System.out.println("测试站点，编码格式="+parse.getEncoding("http://tw.yahoo.com/"));
         System.out.println("测试站点(繁体字，UTF编码)，编码格式="+parse.getEncoding("http://www.javaworld.com.tw/jute"));
         System.out.println();
         System.out.println("日本：");
         System.out.println("测试字符串，编码格式="+parse.getEncoding("その機能".getBytes()));
         System.out.println("测试站点，编码格式="+parse.getEncoding("http://www.4gamer.net"));
         System.out.println();
         System.out.println("自称蚩尤后代那群……：");
         System.out.println("测试站点，编码格式="+parse.getEncoding("http://www.easyjava.co.kr/"));

    }
}
