package offer;

import java.util.Scanner;

/**
 * @author ：程智超
 * @date ：Created in 2021/5/14
 * @description：剑指offer第二题--替换空格
 */

public class Test2 {


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String s=scanner.nextLine();

        //关闭scanner流
        scanner.close();

        Test2 test2=new Test2();
        System.out.println(test2.replaceSpace(s));
        System.out.println(test2.replaceSpace1(s));
    }

    //直接利用String自带替换方法，
    //运行时间 17ms，占用内存 11372KB
    public String replaceSpace(String s){
        String s1=s.replaceAll(" ","%20");
        return s1;
    }

    //转换成字符数组，再通过StringBuilder构建动态字符串
    //运行时间 16ms,占用内存 11292KB
    public String replaceSpace1(String s){
        StringBuilder s1=new StringBuilder();
        char[] c=s.toCharArray();
        for(char temp:c){
            s1.append(temp!=' '?temp:"%20");
        }
        return s1.toString();
    }

}
