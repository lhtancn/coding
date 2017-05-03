package xiaozhao_2016;

import java.util.Scanner;

/**
 * Created by lhtan on 5/3/2017.
 * <p>
 * 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。重复这一过程直到最后剩下一个数。请求出最后剩下的数字。
 * <p>
 * 输入描述:
 * 每组数据一行一个数字，为题目中的n(n小于等于1000)。
 * <p>
 * <p>
 * 输出描述:
 * 一行输出最后剩下的数字。
 * <p>
 * 输入例子:
 * 500
 * <p>
 * 输出例子:
 * 255
 */

/**
 * 对于一个由0..n的所有数按升序组成的序列，我们要进行一些筛选，每次我们取当前所有数字中从小到大的第奇数位个的数，并将其丢弃。重复这一过程直到最后剩下一个数。请求出最后剩下的数字。

 输入描述:
 每组数据一行一个数字，为题目中的n(n小于等于1000)。


 输出描述:
 一行输出最后剩下的数字。

 输入例子:
 500

 输出例子:
 255
 */

/**
 * 练习链表的使用，对链表的定义要掌握
 */
public class Discard {
    public void getLast() {
        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                Node pHead = new Node(-1);
                Node cur = null;
                int n = in.nextInt();
                for (int i = 0; i <= n; ++i) {
                    Node node = new Node(i);
                    if (i == 0) {
                        pHead.next = node;
                        cur = node;
                    }
                    cur.next = node;
                    cur = node;
                }

                while (n > 0) {
                    pHead.next = pHead.next.next;
                    --n;
                    cur = pHead.next;
                    while (cur != null && cur.next != null) {
                        cur.next = cur.next.next;
                        --n;
                        cur = cur.next;
                    }
                }
                System.out.println(pHead.next.val);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}
