package xiaozhao_2016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by lhtan on 5/1/2017.
 */

/**
 * 输入一个字符串，求出该字符串包含的字符集合

 输入描述:
 每组数据输入一个字符串，字符串最大长度为100，且只包含字母，不可能为空串，区分大小写。


 输出描述:
 每组数据一行，按字符串原有的字符顺序，输出字符集合，即重复出现并靠后的字母不输出。

 输入例子:
 abcqweracb

 输出例子:
 abcqwer
 */

public class CharSet {
    public void getString(){
        try(Scanner in = new Scanner(System.in)){
            while(in.hasNext()) {
                String str = in.nextLine();
                Set<String> set = new HashSet<>();
                StringBuilder sb = new StringBuilder();         //StringBuilder()不需要人工导入包，和String一样

                for(int i = 0; i < str.length(); ++i) {
                    String cur = String.valueOf(str.charAt(i));
                    if(set.contains(cur)) {
                        continue;
                    }
                    set.add(cur);
                    sb.append(cur);
                }
                System.out.println(sb.toString());
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}