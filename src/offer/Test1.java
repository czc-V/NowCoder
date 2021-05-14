package offer;

import java.util.Scanner;

/**
 * @author ：程智超
 * @date ：Created in 2021/5/13
 * @description：剑指offer第一题--二维数组中的查找
 */

public class Test1 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();

        //初始化输入数组
        int a[][]={
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        Test1 test1=new Test1();
        System.out.println(test1.find(n,a));
        System.out.println(test1.findByBinary(n,a));
        System.out.println(test1.findResult(n,a));



    }

    //第一种解法：暴力检索,时间复杂度为n*2
    public boolean find(int target,int[][] array){
        boolean result=false;
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array[i].length;j++){
                if(target<array[i][j]){
                    break;
                }else if(target==array[i][j]){
                    result=true;
                    break;
                }
            }
            if(result){
                break;
            }
        }
        return result;
    }

    //第二种解法：二分查找,时间复杂度为nlogn
    public boolean findByBinary(int target,int[][] array){
        boolean result=false;

        for(int i=0;i<array.length;i++){
            int low=0;
            int high=array[i].length-1;
            int mid=(high+low)/2;
            while(high>=low){
                if(target==array[i][mid]){
                    result=true;
                    break;
                }else if(target<array[i][mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
                mid=(high+low)/2;
            }
            if(result){
                break;
            }
        }
        return result;
    }


    //第三种解法：从数组的左下角开始检索，大于则向右，小于则向上
    public boolean findResult(int target,int[][] array){
        boolean result=false;

        //定义二维数组游标
        int x=0;
        int y=array.length-1;

        //注意这里y和x的判断不能交换
        while (y>=0&&x<array[y].length){
            if(target==array[y][x]){
                result=true;
                break;
            }else if(target>array[y][x]){
                x++;
            }else{
                y--;
            }
        }
        return result;
    }



}
