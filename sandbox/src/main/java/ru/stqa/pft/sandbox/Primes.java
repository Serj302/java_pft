package ru.stqa.pft.sandbox;
// Задача: если число простое - true, else - false

public class Primes {

  public static boolean isPrime(int n){
    // int i = 2 - инициализация, счетчик начинается с 2,
    // i < n - когда счетчик должен остановиться,
    // i = i + 1 - что происходит с переменной счетчика на каждой итерации цикла
    for (int i = 2; i < n; i ++){
      if (n % i == 0) {                 // если n делится на i без остатка - число простое, выход из цикла
          return false;
      }
    }                                   // если n не делится на i без остатка - число не простое, цикл продолжается дальше,
    return true;                        // проверям делиться ли n на 2, потом на 3, на 4 и т.д. пока не поделиться без остатка
  }                                     // в этом случае - вернуть true

  // переписать for с помощью while

  public static boolean isPrimeWhile(int n){
    int i = 2;
    while (i < n) {       // до тех пор, пока i < n
      if (n % i == 0) {
        return false;
      }
      i ++;
    }
    return true;
  }

   // 1я модификация функции isPrime -тип long - тест отрабатывает в 4 раза медленее, из-за такого типа данных

  public static boolean isPrime(long n){
    for (long i = 2; i < n; i ++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  // 2я модификация - сокращение итераций
  // делить не на все числа, которые < n, а на половину чисел

  public static boolean isPrimeFast(int n){
    for (int i = 2; i < n / 2; i ++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  // 3я модификация - сокращение итераций
  // достаточно преверять до Math.sqrt(n), до корня из n

  public static boolean isPrimeFast2(int n){
    int m = (int) Math.sqrt(n);         // т.к. корень может быть не целым - надо преобразовать его к целому с помощью (int)
    for (int i = 2; i < m; i ++){
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }











}
