package practice.cp5_1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class LSD {
    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = W - 1; d >= 0; d--) {
            int[] count = new int[R + 1];

            // 计算频率
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            // 将频率转换为索引
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // 将元素分类
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }

            // 回写
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        StdOut.println("start");
        int N = a.length;

        // 检查字符串都为定长
        int W = a[0].length();
        for (int i = 0; i < N; i++) {
            assert a[i].length() == W : "String must have fixed length";
        }

        sort(a, W);

        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
    }
}
