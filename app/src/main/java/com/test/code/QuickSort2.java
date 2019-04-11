package com.test.code;

/**
 * 快速排序是通常被认为在同数量级(O(nlog2n))的排序方法中平均性能最好，但若初始序列按关键有序或基本有序时，快速排序反而蜕化为冒泡排序。为改进之，通常
 * 以"三者取中"来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。快速排序是一个稳定的排序方法。
 *
 * @author lary.huang
 * @version v 1.4.8 2019/4/9 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class QuickSort2 {
    /**
     * 查找出中轴（默认是最低位low）的在arr数组排序后所在位置
     *
     * @param arr  带查找数组
     * @param low  开始位置
     * @param high 结束位置
     * @return 中轴所在位置
     */
    public static int getMiddle(int[] arr, int low, int high) {
        //数组的第一个作为中轴
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] > temp) {
                high--;
            }
            //比中轴小的记录移到低端
            arr[low] = arr[high];
            while (low < high && arr[low] < temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    /**
     * 递归形式的分治算法
     *
     * @param arr  带排序数组
     * @param low  开始位置
     * @param high 结束位置
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            //将arr数组进行一分为二
            int middle = getMiddle(arr, low, high);
            //对低字段进行递归排序
            quickSort(arr, low, middle - 1);
            //对高字段表进行递归排序
            quickSort(arr, middle + 1, high);
        }
    }

    public static void quick(int[] arr) {
        if (arr.length > 0) {
            quickSort(arr, 0, arr.length - 1);
        }
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        quick(arr);
        printArr(arr);
    }
}
