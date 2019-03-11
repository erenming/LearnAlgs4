1. 排序算法分类：
    - 原地排序：除了函数调用所需的栈和固定数目的实例变量之外无需其他额外内存
    - 其他排序：需要额外内存
2. 选择排序：不断地选择剩余元素之中的最小者
    - 步骤：
        1. 找到数组中的最小的那个元素
        2. 将它与数组中的第一个元素交换位置
        3. 在剩下的元素中找到最小的元素，将它与数组中的第二个元素交换位置
        4. 如此往复，直到将整个数组排序
    - 特点
        1. 运行时间与输入无关：eg, 有序和无序数组排序时间一样
        2. 数据移动是最少的：交换次数与数组大小线性关系
    - 时间复杂度: O(n^2)
3. 插入排序：
    - 步骤：
        1. 将数组的第`i`个元素与第`i-1`个元素组成的有序数组中个的元素从右到左逐个比较
        2. 插入到合适的位置(这里我们逐个交换位置，直到元素大于有序数组中的元素)
        3. 然后对数组中的第`i+1`个元素执行步骤`1, 2`
        4. 如此往复，直到最后一个元素被插入到合适位置
    - 倒置：数组中的两个顺序颠倒的元素
    - 部分有序数组：数组中倒置的数量小于数组大小的某个倍数
    - 特点：
        1. 插入排序对于部分有序数组十分高效
        2. 适合小规模数组
    - 时间复杂度: O(n^2)
4. 希尔排序：针对插入排序优化，以`h`为间隔进行插入排序
    - h有序数组：使数组中任意间隔为`h`的元素都有序，由h个互相独立的有序数组编织在一起组成的一个数组
    - 步骤：
        1. 构造从`N/k + 1`递减至`1`的递减序列。
        2. 从`N/k + 1`开始，按照递减序列里的h值，逐次执行插入排序，直到h为1
    - 相对高效原因：
        1. 权衡了子数组的规模和有序性
        2. 排序之初，各个子数组都很短
        3. 排序之后子数组都是部分有序的
    - 特点：
        1. 适用于中等大小的数组
        2. 代码量较少，且空间O(1)
    - 时间复杂度：O(n^1.3)
5. 归并排序：将两个有序数组归并成一个更大的有序数组
    - 归并方法：

    ```java
    public static void merge(Comparable[] a, int lo, int mid, int hi)
    {  // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)  // Copy a[lo..hi] to aux[lo..hi]. aux是辅助数组
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)  // Merge back to a[lo..hi].
            if      (i > mid)              a[k] = aux[j++];  // 右半边取尽
            else if (j > hi )              a[k] = aux[i++];  // 左半边取尽
            else if (less(aux[j], aux[i])) a[k] = aux[j++];  // 右半边的当前元素小于左半边的当前元素
            else                           a[k] = aux[i++];  // 右半边的当前元素大于左半边的当前元素
    }
    ```

    - 自顶向下的归并排序：利用了分治思想， 化整为零
        1. 如果能将两个子数组排序，就能通过归并两个子数组来将整个数组排序

        ```java
        private static void sort(Comparable[] a, int lo, int hi)
        {  // Sort a[lo..hi].
            if (hi <= lo) return;
            int mid = lo + (hi - lo)/2;
            sort(a, lo, mid);       // Sort left half.
            sort(a, mid+1, hi);     // Sort right half.
            merge(a, lo, mid, hi);  // Merge results (code on page 271).
        }
        ```

    - 自底向上的归并排序：利用了分治思想，循序渐进
        1. 先归并哪些微型数组，然后再成对归并得到的子数组
        2. 比较适合用链表组织的数据

        ```java
        public static void sort(Comparable[] a)
        {  // Do lg N passes of pairwise merges.
            int N = a.length;
            aux = new Comparable[N];
            for (int sz = 1; sz < N; sz = sz+sz)         // sz: subarray size
                for (int lo = 0; lo < N-sz; lo += sz+sz) // lo: subarray index
                    merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
        }

        ```

    - 时间复杂度：O(nlogn)
    - 空间复杂度: O(n)
6. 快速排序：分治思想
    - 将一个数组分成两个数组，然后将两部分独立地排序。当两个子数组都有序时整个数组就自然有序了
    - 切分(partition)： 将一个数组切分为两部分，位置取决于数组的内容