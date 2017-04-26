package xiaozhao_2016;
import java.util.*;

/**
 * Created by lhtan on 4/26/2017.
 */
public class Coder {
    String cmp = "coder";
    public String[] findCoder(String[] A, int n) {
        // write code here
        if(A == null || A.length == 0 || A.length != n) {
            return null;
        }
        List<StrInfo> list = new ArrayList<>();
        for(int i = 0; i < A.length; ++i) {
            String str = A[i].toLowerCase();
            int count = findCount(str);
            if(count == 0) {
                continue;
            }
            StrInfo si = new StrInfo(str, count, i);
            list.add(si);
        }

        /*Collections.sort(list, new Comparator<StrInfo>() {           //可用lamda表达式替换，且Collections.sort -> list.sort
            @Override
            public int compare(StrInfo s1, StrInfo s2) {
                if(s2.getCount() == s1.getCount()) {
                    return s1.getIndex() - s2.getIndex();
                }
                return s2.getCount() - s1.getCount();
            }
        });*/

        list.sort((s1, s2) -> {
                if(s2.getCount() == s1.getCount()) {
                    return s1.getIndex() - s2.getIndex();
                }
                return s2.getCount() - s1.getCount();
        });

        List<String> resList = new ArrayList<>();

        for(StrInfo item : list) {
            resList.add(item.getContent());
        }
        String[] resArr = new String[resList.size()];
        return resList.toArray(resArr);
    }

    private int findCount(String str) {
        int count = 0;
        int start = 0;

        while(start < str.length()) {
            int initIndex = str.indexOf(cmp, start);
        //    initIndex == -1 ? break : ++count;            //不能这么写，break不能放入三目运算中
            if(initIndex == -1) {
                break;
            }
            ++count;
            start = initIndex + cmp.length();
        }
        return count;
    }
}


/**
 * 辅助类，存储关于str的多信息，且各个变量提供get方法，以利于后期的比较。
 */
class StrInfo {                     //本方法和类可以去掉public修饰，维持包级私有
    private String content;
    private int count;
    private int index;

    StrInfo(String content, int count, int index) {
        this.content = content;
        this.count = count;
        this.index = index;
    }

    String getContent() {
        return content;
    }

    int getCount() {
        return count;
    }

    int getIndex() {
        return index;
    }
}