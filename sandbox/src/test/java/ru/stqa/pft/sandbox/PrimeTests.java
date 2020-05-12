package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimeTests {

  @Test
  public void testPrime(){
    // проверка true - если простое число. MAX_VALUE - 2147483647 - простое число, тест прошел
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE ));
  }

  @Test (enabled = false)
  public void testNonPrime(){
    // проверка false - если не простое число
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }

  @Test (enabled = false)
  public void testPrimeWhile(){
    // проверка true - если простое число. MAX_VALUE - 2147483647 - простое число, тест прошел
    Assert.assertTrue(Primes.isPrimeWhile(5));
  }

  @Test (enabled = false)
  public void testNonPrimeWhile(){
    // проверка false - если не простое число
    Assert.assertFalse(Primes.isPrimeWhile(Integer.MAX_VALUE - 2));
  }

  @Test (enabled = false)
  public void testPrimeLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test
  public void testPrimeFast(){
    Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE ));
  }

  @Test
  public void testPrimeFast2(){
    Assert.assertTrue(Primes.isPrimeFast2(Integer.MAX_VALUE ));
  }
}

