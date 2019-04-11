package com.test.code;

/**
 * 希尔排序
 *
 * @author lary.huang
 * @version v 1.4.8 2019/4/9 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class ShellSort {

    public static void shellSort(int[] arr) {
        int j = 0;
        int temp = 0;
        //每次将步长缩短为原来的一半
        for (int incement = arr.length / 2; incement > 0; incement /= 2) {
            for (int i = incement; i < arr.length; i++) {
                temp = arr[i];
                for (j = i; j >= incement; j -= incement) {
                    if (temp > arr[j - incement]) {
                        arr[j] = arr[j - incement];
                    } else {
                        break;
                    }
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 8, 9, 1, 3, 4};
        shellSort(arr);
        printArr(arr);
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }
}
