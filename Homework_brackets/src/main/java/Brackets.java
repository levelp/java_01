import java.util.ArrayList;

/**
 * Правильные скобочные последовательности
 */
public class Brackets {
    private int N;
    private ArrayList<String> result;
    // Скобочная последовательность как массив символов
    private StringBuilder symbols;

    Brackets(int N) {
        this.N = N;
    }

    ArrayList<String> gen() {
        result = new ArrayList<>();
        symbols = new StringBuilder();
        // Какую скобочку можем поставить определяется балансом
        rec(0, 0);
        return result;
    }

    /**
     * @param open  открывающих скобок
     * @param close закрывающих скобок
     */
    private void rec(int open, int close) {
        if (open < N) {
            symbols.append('(');
            rec(open + 1, close);
            symbols.deleteCharAt(symbols.length() - 1);
        }
        if (close < open) {
            symbols.append(')');
            rec(open, close + 1);
            symbols.deleteCharAt(symbols.length() - 1);
        }
        if (open == N && close == N) {
            result.add(symbols.toString());
        }
    }
}
