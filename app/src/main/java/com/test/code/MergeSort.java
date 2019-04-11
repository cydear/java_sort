package com.test.code;

/**
 * 归并排序
 *
 * @author lary.huang
 * @version v 1.4.8 2019/4/9 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class MergeSort {
    /**
     * 归并排序
     * 时间复杂度：O(nlogn)
     * 稳定排序方式
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int[] sort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            //左边
            sort(arr, low, mid);
            //右边
            sort(arr, mid + 1, high);
            //合并
            merge(arr, low, mid, high);
        }
        return arr;
    }

    /**
     * 数组中low到high位置的数进行排序
     *
     * @param arr  带排序数组
     * @param low  待排序开始位置
     * @param mid  待排序中间位置
     * @param high 待排序结束位置
     */
    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        //左指针
        int i = low;
        //右指针
        int j = mid + 1;
        int k = 0;

        //把较小的数先移到新数组
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        //把左边剩余的数组移入数组
        while (i <= mid) {
            temp[k++] = arr[j++];
        }

        //把右边剩余的数组移入数组
        while (j <= high) {
            temp[k++] = arr[j++];
        }

        //把新数组中的数覆盖arr数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + low] = temp[k2];
        }
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int[] arr = {100, 36, 138, 367, 21, 8, 2, 19, 30, 40, 7, 9, 1};
        sort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
