package xiaozhao_2016;
import java.util.*;
/**
 * Created by lhtan on 5/2/2017.
 */

/**
 * 现在有一个字符串列表，和一个关键词列表，请设计一个高效算法，检测出含关键字列表中关键字(一个或多个)的字符串。
 给定字符串数组A及它的大小n以及关键词数组key及它的大小m，请返回一个排好序的含关键词的字符串序号的列表。保证所有字符串长度小于等于100，关键词个数小于等于100，字符串个数小于等于200。保证所有字符串全部由小写英文字符组成。若不存在含关键字的字符串，请返回一个只含-1的数组。
 测试样例：
 ["nowcoder","hello","now"],3,["coder",now],2
 返回：[0,2]
 */

public class KeywordDetect {
    public int[] containKeyword(String[] A, int n, String[] keys, int m) {
        // write code here
        int[] res = new int[]{-1};
        if(A == null || keys == null || A.length == 0 || keys.length == 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        CreateTrie ct = new CreateTrie();

        for(int i = 0; i < m; ++i) {
            ct.addWord(keys[i]);
        }

        for(int i = 0; i < n; ++i) {
            if(ct.filter(A[i])) {
                list.add(i);
            }
        }
        res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}

class CreateTrie {
    private class TrieNode {
        private boolean end = false;
        private Map<Character, TrieNode> subNodes = new HashMap<>();
        void addSubNode(Character key, TrieNode node) {
            subNodes.put(key, node);
        }
        TrieNode getSubNode(Character key) {
            return subNodes.get(key);
        }
        boolean isKeywordEnd() {
            return end;
        }
        void setKeywordEnd(boolean end) {
            this.end = end;
        }
    }

    private TrieNode rootNode = new TrieNode();

    public boolean filter(String text) {
        TrieNode tempNode = rootNode;
        int begin = 0;            //回滚不可少
        int position = 0;

        while(position < text.length()) {
            char c = text.charAt(position);
            tempNode = tempNode.getSubNode(c);
            if(tempNode == null) {
                position = begin + 1;
                begin = position;               //匹配几个后发现不匹配，回滚到最开始匹配的下一个
                tempNode = rootNode;
            }else if(tempNode.isKeywordEnd()) {
                return true;
            }else {
                ++position;
            }
        }
        return false;
    }

    public void addWord(String str) {
        TrieNode tempNode = rootNode;
        for(int i = 0; i < str.length(); ++i) {
            Character c = str.charAt(i);
            TrieNode node = tempNode.getSubNode(c);

            if(node == null) {
                node = new TrieNode();
                tempNode.addSubNode(c, node);
            }

            tempNode = node;

            if(i == str.length() - 1) {
                tempNode.setKeywordEnd(true);
            }
        }
    }
}
