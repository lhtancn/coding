package xiaozhao_2016;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lhtan on 5/2/2017.
 */

/**
 * 血型遗传对照表如下：
 父母血型	子女会出现的血型	子女不会出现的血型
 O与O	O	A,B,AB
 A与O	A,O	B,AB
 A与A	A,O	B,AB
 A与B	A,B,AB,O	——
 A与AB	A,B,AB	O
 B与O	B,O	A,AB
 B与B	B,O	A,AB
 B与AB	A,B,AB	O
 AB与O	A,B	O,AB
 AB与AB	A,B,AB	O
 请实现一个程序，输入父母血型，判断孩子可能的血型。
 给定两个字符串father和mother，代表父母的血型,请返回一个字符串数组，代表孩子的可能血型(按照字典序排列)。
 测试样例：
 ”A”,”A”
 返回：[”A”,“O”]
 */
public class ChkBloodType {
    public String[] chkBlood(String father, String mother) {
        // write code here
        String[] res = new String[]{"Error."};
        if(father.length() == 0 || mother.length() == 0) {
            return res;
        }
        Map<String, String[]> bloodMap = new HashMap<>();
        bloodMap.put("O_O", new String[]{"O"});
        bloodMap.put("A_O", new String[]{"A", "O"});
        bloodMap.put("A_A", new String[]{"A", "O"});
        bloodMap.put("A_B", new String[]{"A", "AB", "B", "O"});             //字典序中"AB"排在"B"前
        bloodMap.put("A_AB", new String[]{"A", "AB", "B"});
        bloodMap.put("B_O", new String[]{"B", "O"});
        bloodMap.put("B_B", new String[]{"B", "O"});
        bloodMap.put("AB_B", new String[]{"A", "AB", "B"});
        bloodMap.put("AB_O", new String[]{"A", "B"});
        bloodMap.put("AB_AB", new String[]{"A", "AB", "B"});

        String key = father.compareTo(mother) > 0 ? mother + "_" + father : father + "_" + mother;      //String的字典序对比要用compareTo，而不是'>'或者'<'。
        return bloodMap.get(key);
    }
}
