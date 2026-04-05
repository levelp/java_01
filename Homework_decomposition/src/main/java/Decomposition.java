/**
 * Разложение на слагаемые
 */
public class Decomposition {

    int N;
    int[] A;

    public Decomposition(int N) {
        this.N = N;
        A = new int[N];
    }

    /**
     * Сгенерировать и напечатать разложение
     */
    public void gen() {
        rec(0, N, N);
    }

    private void rec(int index, int max, int sum) {
        // Разложение получено
        if (sum == 0) {
            print(A, index);
            return;
        }
        for (int x = Math.min(max, sum); x >= 1; x--) {
            A[index] = x;
            rec(index + 1, x, sum - x);
        }
    }

    /**
     * @param A массив слагаемых
     */
    void print(int[] A, int size) {
        System.out.print(N + " = ");
        for (int i = 0; i < size - 1; i++) {
            System.out.print(A[i] + " + ");
        }
        System.out.println(A[size - 1]);
    }
}
