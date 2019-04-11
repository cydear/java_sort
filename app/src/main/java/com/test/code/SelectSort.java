package com.test.code;

/**
 * 选择排序
 * <p>
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换
 * 如此循环到倒数第二个数和最后一个数比较为止。
 * <p>
 * 初始值：57 68 59 52
 * <p>
 * 1. 最小值为52，与第一个交换  52 68 59 57
 * 2. 最小值为57，与第二个交换  52 57 59 68
 * 3. 59即为最小值，无需交换，完成 52 57 59 68
 *
 * @author lary.huang
 * @version v 1.4.8 2019/4/9 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class SelectSort {
    public static void selectSort(int[] arr) {
        int size = arr.length;
        int temp = 0;

        for (int i = 0; i < size; i++) {
            //待确定的位置
            int k = i;
            //选出应该在第i个位置的数据
            for (int j = size - 1; j > i; j--) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            //交换两个数
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {57, 68, 59, 52};
        selectSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
}
