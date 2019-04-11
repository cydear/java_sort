package com.test.code;

/**
 * 插入排序
 * <p>
 * 基本思想：每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字符序列的合适位置（从后向前找到合适位置后），
 * 直到全部插入排序完美为止。
 *
 * @author lary.huang
 * @version v 1.4.8 2019/4/9 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class InsertSort {
    /**
     * 插入排序：
     * <p>
     * 从第一个元素开始，该元素可以认为已经被排序
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置
     * 重复步骤3，直到找到已经排序的元素小于或者等于新元素的位置
     * 将新元素插入到该位置中
     * 重复步骤2
     *
     * @param arr 待排序数组
     */
    public static void insertSort(int[] arr) {
        int size = arr.length;
        int temp = 0;
        int j = 0;

        printArr(arr);

        for (int i = 0; i < size; i++) {
            temp = arr[i];
            //假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < arr[j - 1]; j--) {
                System.out.println("temp=" + temp + " arr[j]=" + arr[j] + " arr[j-1]=" + arr[j - 1]);
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {57, 68, 59, 52};
        insertSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
}
