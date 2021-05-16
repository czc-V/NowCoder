package offer;

import java.util.Stack;

/**
 * @author ：程智超
 * @date ：Created in 2021/5/16
 * @description：剑指offer第5题--用两个栈实现队列
 * 栈：后进先出
 * 队列：先进先出
 */

public class Test5 {


    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();


    public static void main(String[] args) {
        Test5 test5=new Test5();
        test5.push(1);
        test5.push(2);
        test5.push(3);
        System.out.println(test5.pop());

    }

    //压栈
    public void push(int node) {
        //用stack1当做队列
        stack1.push(node);


    }

    //出栈
    public int pop() {

        //stack2当做转换栈
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());

        }
        int result=stack2.pop();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }

}
