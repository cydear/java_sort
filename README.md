# java_sort
Java 排序算法

#冒泡排序

冒泡排序是一种简单的排序算法，它重复地走访过要排序的数列，一次比较两个元素，如果他们顺序错误就把他们交换过来。走访工作是重复地进行指导没有再需要交换，也就是该数列已经排序完成。

     原理：比较两个乡邻的元素，将值大的元素交换至右端

     思路：依次比较乡邻的两个数，将小数放在前面，大数放在后面。即在第一趟：比较第1个和第2个数，将小数放
     前，大数放后。然后比较第2个数和第3个数，将小数放前，大数放后，如此继续，直至比较最后两个数，将小数
     放前，大数放后。重复第一趟，直至全部排序完成。

     第二趟
     第三趟
     ..........依次类推
     
     for (int i = 0; i < size - 1; i++) {
                 for (int j = 0; j < size - 1 - i; j++) {
                     if (arrs[j] > arrs[j + 1]) {
                         temp = arrs[j];
                         arrs[j] = arrs[j + 1];
                         arrs[j + 1] = temp;
                     }
                 }
     }
     
     
#快速排序

假设我们现在对“6 1 2 7 9 3 4 5 10 8”这个10个数进行排序。首先在这个序列中随便找一个数作为基准数（不要被这个名词吓到了，
就是一个用来参照的数，待会你就知道它用来做啥的了）。为了方便，就让第一个数6作为基准数吧。接下来，需要将这个序列中所有比基准数大的数放在6的右边，
比基准数小的数放在6的左边

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
    
#选择排序

 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；然后在剩下的数当中再找最小的与第二个位置的数交换
 如此循环到倒数第二个数和最后一个数比较为止。

 初始值：57 68 59 52

 1. 最小值为52，与第一个交换  52 68 59 57
 2. 最小值为57，与第二个交换  52 57 59 68
 3. 59即为最小值，无需交换，完成 52 57 59 68
 
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
      
#插入排序

每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。

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
    
#希尔排序

基本思想：

先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。

操作方法：

选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
按增量序列个数k，对序列进行k 趟排序；
每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

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
    
#归并排序

归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列。

