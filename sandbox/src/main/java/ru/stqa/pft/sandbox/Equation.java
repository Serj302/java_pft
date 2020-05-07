package ru.stqa.pft.sandbox;

public class Equation {

  private double a;
  private double b;
  private double c;

  private int n;

  public Equation (double a, double b, double c){
    this.a = a;
    this.b = b;
    this.c = c;

    // квадратное ур-ие
    double d = b*b - 4*a*c;

   /*
    if (d > 0) {
      n = 2;
    } else {
      if (d==0){
        n = 1;
      } else {
        n = 0;
      }
    }

    // такой вариант возможен, но... если условие d > 0 - соблюдается,
    // то остальные условия, все-равно будут проверяться
    if (d > 0) {
      n = 2;
    }

    if (d == 0) {
      n = 1;
    }

    if (d < 0) {
      n = 0;
    }
*/

    //при таком варианте, else не даст проверить остальные условия, когда d > 0 - соблюдается,
    // самый оптимальный
    if (d > 0) {
      n = 2;
    } else if (d == 0){
      n = 1;
    } else {
      n = 0;
    }

    //линейное ур-ие
/*
    if (a == 0)
      System.out.println("Вырожденное ур-ие");
*/

/*  if (a == 0)
    n = 1;  // но нужно проверить еще b
*/
/*
//решение лин ур-ия
    if (a == 0) {
      if (b == 0) {
        if (c == 0){
          n = -1;
        } else {
          n = 0;
        }
      } else {
        n = 1;
      }
//решение кв ур-ия
    } else {
      if (d > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }
    }
*/
  // оптимизация кода

    if (a != 0) {
      if (d > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }

    } else if (b != 0) {
      n = 1;

    } else if (c != 0){
      n = 0;

    } else {
      n = -1;
    }
  }

  public int rootNumber() {
      return n;
    }
}
