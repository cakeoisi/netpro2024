public class Renshu {
    
    // 与えられた整数 x の値を2倍にして返す。
    public int doubleValue(int x) {
        return x * 2;
    }
    
    // 1から n までの整数の合計値を返す。
    public int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
    
    // p から q までの整数の合計値を返す。
    public int sumFromPtoQ(int p, int q) {
        int sum = 0;
        for (int i = p; i <= q; i++) {
            sum += i;
        }
        return sum;
    }
    
    // 配列 a[] の指定された index から以降の要素の合計値を返す。不正な index の場合は -1 を返す。
    public int sumFromArrayIndex(int[] a, int index) {
        if (index < 0 || index >= a.length) {
            return -1;
        }
        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
    
    // 配列 a の中で最大の値を返す。
    public int selectMaxValue(int[] a) {
        int max = Integer.MIN_VALUE;
        for (int value : a) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
    
    // 配列 a の中で最大の値が入っている要素の位置（index）を返す。最大値が複数の場合は最小のindexを返す。
    public int selectMaxIndex(int[] a) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    
    // 配列 p の i 番目と j 番目の要素を入れ替える。
    public void swapArrayElements(int[] p, int i, int j) {
        int temp = p[i];
        p[i] = p[j];
        p[j] = temp;
    }
    
    // 同じ長さの二つの配列 a と b の内容を入れ替える。
    public boolean swapTwoArrays(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            a[i] = b[i];
            b[i] = temp;
        }
        return true;
    }
}
