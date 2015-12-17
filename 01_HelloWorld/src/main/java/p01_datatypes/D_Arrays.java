package p01_datatypes;

// Массивы: foreach, многомерные
// -----------------------------
public class D_Arrays {
    public static void main(String[] args) {
        //-->
        // Инициализация
        int[] intArray1 = new int[]{1, 2, 3, 10};

        // Сокращённая форма инициализации
        int[] intArray2 = {1, 2, 3, 10};
        // Массив
        int[] intArray3 = new int[100];
        //<--

        // Пробегаем по всем элементам массива
        //-->
        for (int i = 0; i < intArray2.length; i++) {
            System.out.println("intArray1[" + i + "] = " +
                    intArray1[i]);
        }
        // Если нам не важны индексы,
        // то мы можем использовать цикл "foreach"
        for (int i : intArray1) {
            System.out.print(i + " ");
        }
        System.out.println(); // Просто перевод строки
        //<--

        // Двухмерный массив
        //-->
        int[][] array2D = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int x = array2D[0][1]; // Элемент массива с индексом 0 1
        array2D[1][1] = 231; // Новое значение
        //<--
    }

}
