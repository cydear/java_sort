package com.test.code;

/**
 * 冒泡排序
 *
 * @author lary.huang
 * @version v 1.4.8 2019/4/9 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class BubbleSort {

    /**
     * 原理：比较两个乡邻的元素，将值大的元素交换至右端
     * <p>
     * 思路：依次比较乡邻的两个数，将小数放在前面，大数放在后面。即在第一趟：比较第1个和第2个数，将小数放
     * 前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数
     * 放前，大数放后。重复第一趟，直至全部排序完成。
     * <p>
     * 第二趟
     * 第三趟
     * ..........依次类推
     */

    public static void main(String[] args) {
        int[] arrs = {100, 85, 12, 189, 23, 7};
        int temp = 0;
        int size = arrs.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arrs[j] > arrs[j + 1]) {
                    temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i <= arrs.length - 1; i++) {
            if (i == 0) {
                System.out.print("[ " + arrs[i]);
                continue;
            }
            System.out.print("," + arrs[i]);
            if (i == arrs.length - 1) {
                System.out.print(" ]");
            }
        }
    }
}
