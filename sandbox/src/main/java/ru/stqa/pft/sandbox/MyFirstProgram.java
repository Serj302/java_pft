package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {

      Point p1 = new Point(1, 1);
      Point p2 = new Point(5, 3);
      System.out.println("Расстояние между 2мя " + "точками = " + p1.distance(p2));
    }
}