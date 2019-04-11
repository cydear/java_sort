package com.test.code;

/**
 * 快速排序
 *
 * @author lary.huang
 * @version v 1.4.8 2019/4/9 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /**
     * 快速排序
     *
     * @param arr  目标排序数组
     * @param low  最低位索引
     * @param high 最高位索引
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low > high) {
            return;
        }
        //i,j表示左右的两个指针
        int i, j;
        //temp是基准位
        int temp, t;
        i = low;
        j = high;
        //以左边low位为基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左边递减
            while (temp <= arr[j] && i < j) {
                j--;
            }

            //再看左边，依次向右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }

            //如果条件满足则交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用半数组
        quickSort(arr, low, j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
    }
}
