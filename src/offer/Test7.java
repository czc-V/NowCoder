package offer;

import java.util.Scanner;

/**
 * @author ：程智超
 * @date ：Created in 2021/5/17
 * @description：剑指offer第7题--斐波那契数列
 */

public class Test7 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        Test7 test7=new Test7();
        System.out.println(test7.Fibonacci(n));
        System.out.println(test7.getResult(n));
    }

    /*
    斐波那契数列F(n)=F(n-1)+F(n-2),F(0)=0,F(n)=1
    采用递归方案实现
    运行时间 851ms,占用内存 9776KB
     */
    public int Fibonacci(int n) {
        if(n<2){
            return n;
        }else{
            return tailFibonacci(n,0,1);
        }
    }

    /*
    采用尾递归方案优化递归，不会发生栈溢出
    运行时间：11ms,占用内存：9760KB
     */
    public int tailFibonacci(int n,int step1,int step2){
        if(n==0){
            return 0;
        }
        if(n==1){
            return step2;
        }
        return tailFibonacci(n-1,step2,step1+step2);
    }

    /*
    采用循环避免递归
    运行时间 9ms,占用内存 9608KB
     */
    public int getResult(int n){
        if(n<2){
            return n;
        }
        int firstStep=0;
        int secondStep=1;
        int result=0;
        for (int i=2;i<=n;i++){
            result=firstStep+secondStep;
            firstStep=secondStep;
            secondStep=result;
        }
        return result;
    }

}
