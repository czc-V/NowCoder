package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author ：程智超
 * @date ：Created in 2021/5/14
 * @description：剑指offer第三题--从尾到头打印链表
 */

public class Test3 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        //读取整行输入，以,分割
        String str= scanner.nextLine();
        String[] s=str.trim().split(",");

        /*创建非静态内部类实例，通过外部类访问内部类
        Test3.ListNode listNode1=test3.new ListNode(val$1);
         */
        Test3 test3=new Test3();
        Test3.ListNode[] ln=new ListNode[s.length];
        for(int i=0;i<s.length;i++){
            ln[i]=test3.new ListNode(Integer.parseInt(s[i]));
        }

        //将数组连成链表
        for(int i=0;i<ln.length-1;i++){
            ln[i].next=ln[i+1];
        }

        List list= test3.printListFromTailToHead(ln[0]);
        System.out.println(list.toString());

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode==null){
            return null;
        }

        //将链表里的数据放入栈中
        Stack<Integer> stack=new Stack<>();
        while (listNode.next!=null){
            System.out.println(listNode.val);
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        //最后一个链表节点入栈
        stack.push(listNode.val);

        ArrayList<Integer> arrayList=new ArrayList<>();
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //倒序，利用递归的思想
    public ArrayList<Integer> digui(ListNode listNode){
        ArrayList<Integer> arrayList=new ArrayList<>();
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }


    //ListNode内部类,自定义链表
    public class ListNode{
        int val;
        ListNode next=null;

        ListNode(int val){
            this.val=val;
        }
    }

}
