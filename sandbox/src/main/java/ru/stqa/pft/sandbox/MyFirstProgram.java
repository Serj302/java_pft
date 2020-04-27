package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

      // Вызов метода по расчету расстояния м/у 2мя точками
      Point p1 = new Point(1,3);
      Point p2 = new Point(5, 3);
      //System.out.println("Расстояние между 2мя точками: \n " + "p1: " + p1.x + p1.y + " \n p2: " + p2.x + p2.y + "\n Будет равно: " + p1.distance(p2));
      System.out.println("Расстояние между 2мя точками: \n" + "p1: " + p1.x + ", " + p1.y + "\np2: " + p2.x + ", " + p2.y + "\nБудет равно: " + p1.distance(p2) );
      // Вызов метода по вычислению площади квадрата (Square)
      Square s = new Square(5);
      System.out.println("\nПлощадь квадрата со стороной " + s.l + " = " + s.area() );

      // Вызов метода по вычислению площади прямоугольника (Rectangle)
      Rectangle r = new Rectangle(4, 6);
      System.out.println("\nПлощадь прямоугольника со сторонами " + r.a + " and " + r.b + " = " + r.area() );

    }


}