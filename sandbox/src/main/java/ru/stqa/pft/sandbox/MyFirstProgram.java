package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

        System.out.println("Hello, World!");

        System.out.println(2 + 2); // sout + enter
        System.out.println(2 * 2);
        System.out.println(2 / 2);
        System.out.println(2 - 2);

        //Дроби
        System.out.println(1 / 2);   // 0 - т.к. int - будет 0, округление целого
        System.out.println(1.0 / 2); // 0.5
        System.out.println(1 / 2.0); // 0.5
        System.out.println(2.0 / 2); // 1.0

        // сложение строк
        System.out.println("2" + "2"); // 22
        System.out.println("2" + 2);  // 22 - число преобразуется в строку, в итоге строка + строка
        System.out.println(2 + "2"); //22 - всё-равно число преобразуется в строку

        System.out.println(2 + 2 * 2); // 6
        System.out.println((2 + 2) * 2 ); // 8

        System.out.println("2 + 2 = " + 2 + 2); // 2 + 2 = 22
        System.out.println("2 + 2 = " + (2 + 2) ); // 2 + 2 = 4

        


    }

}