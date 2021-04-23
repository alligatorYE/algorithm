package linkedlist;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * @Description
 *  * 1) 单链表反转
 *  * 2) 链表中环的检测
 *  * 3) 两个有序的链表合并
 *  * 4) 删除链表倒数第n个结点
 *  * 5) 求链表的中间结点
 * @Version v1.0
 * @Author yange1
 * @Time 2021/3/2 19:26
 */
public class LinkedList {

    //单链表反转
    public static Node reverse(Node list){

        Node current = list,pre = null;

        while (current != null){
            Node next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }

    //检测环
    public static boolean checkCircle(Node list){
        if (list == null){
            return false;
        }
        return false;
    }

    //有序链表合并

    //删除倒数第n个节点

    //求中间节点

    //打印所有

    //创建节点

    //内部类
    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return this.data;
        }
    }


        public static void main(String[] args) {
            SecureRandom sr = null;
            try {
                // 获取高强度安全随机数生成器
                sr = SecureRandom.getInstanceStrong();
            } catch (NoSuchAlgorithmException e) {
                // 获取普通的安全随机数生成器
                sr = new SecureRandom();
            }
            byte[] buffer = new byte[16];
            // 用安全随机数填充buffer
            sr.nextBytes(buffer);
            System.out.println(Arrays.toString(buffer));
        }

}
