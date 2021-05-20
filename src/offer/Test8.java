package offer;


import java.util.Scanner;

/**
 * @author ：程智超
 * @date ：Created in 2021/5/20
 * @description：剑指offer第8题--跳台阶
 * 一只青蛙一次可以跳上1/2级台阶，求该青蛙跳上一个n级的台阶总共有多少中跳法。
 */

public class Test8 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n= scanner.nextInt();

        Test8 test8=new Test8();
        System.out.println(test8.jumpFloor(n));
    }

    /*
     * @Author czc
     * @Description 斐波那契数列实现,F(n)=F(n-1)+F(n-2)
     * @Date 2021/5/20
     * @Param
     * @return
     * 斐波那契数组的实际应用，采用尾递归实现。
     * 运行时间 10ms,占用内存 9540KB
     **/
    public int jumpFloor(int target){
        if(target<=2){
            return target;
        }
        return tailFibonacci(target,1,2);
    }

    /*
     * @Author czc
     * @Description
     * @Date 2021/5/20
     * @Param
     * @return
     **/
    public int tailFibonacci(int n,int step1,int step2){
        if(n==2){
            return step2;
        }
        return tailFibonacci(n-1,step2,step1+step2);
    }

}
