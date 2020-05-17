package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {

/* объявляется переменная типа массив (arr) строк - [].
*  String[] - тип элементов, котор могут храниться в этом arr
*  new String[4] - размер arr, может хранить 4 элемента

   String[] langs = new String[4];

* заполнить arr значениями
    langs [0] = "Java";
    langs [1] = "C#";
    langs [2] = "Python";
    langs [3] = "PHP";  // у php -  индекс - 3


* оптимизация по заполнению arr
    String[] langs = {"Java","C#","Python","PHP"};

* устравиваем итерацию по элементам arr

    for (int i = 0; i < langs.length; i++){
      System.out.println("Я хочу выучить " + langs[i]);
    }

 */

/* ``````````````````````````````````````````````````````````````
    // Total

    String[] langs = {"Java","C#","Python","PHP"};

    for (int i = 0; i < langs.length; i++){
      System.out.println("Я хочу выучить " + langs[i]);
    }
* ``````````````````````````````````````````````````````````````/

/* особый цикл для коллекций

    for (String l : langs){                           // l - это уже не индекс, а ссылка на элемент arr
      System.out.println("Я хочу выучить " + l);      // l - переменная, котор последовательно указывает на все элементы этой коллекции
    }

*//*------- для работы с коллекциями - сущ-ют спец классы, которые находятся в пакете java.util ---------


* напр, для использования списка, самый популярный класс - ArrayList

    List<String> languages = new ArrayList<String>(); // List/список - импорт из java.util.List

* List<String> languages - интерфейс
*                           new ArrayList<String>() - класс, котор реализует этот интерфейс

* далее необходимо этот List - заполнить какими-то значениями
* в отличии от arr, где можно задать размер и больше он меняться не может - размер List при создании, = 0 и его можно менять
* в List - можно: добавлять элементы, удалять элементы и при этом его размер будет изменяться

    languages.add("Java");   // теперь размер List  = 1
    languages.add("С#");
    languages.add("Python");
    languages.add("PHP");    // теперь размер List  = 4

* итерации для списка/List
    for (String l : languages){                           // l - это уже не индекс, а ссылка на элемент arr
      System.out.println("Я хочу выучить " + l);      // l - переменная, котор последовательно указывает на все элементы этой коллекции
    }
*/

/* ``````````````````````````````````````````````````````````````
    // Total:

    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = new ArrayList<String>();
    languages.add("Java");
    languages.add("С#");
    languages.add("Python");
    languages.add("PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
````````````````````````````````````````````````````````````````*/

/* оптимизация списка/List

*  так как сделали с arr - нельзя
    List<String> languages = new ArrayList<String>("Java", "C#", "Python", "PHP");
* так нельзя
    List<String> languages = new ArrayList<String>({"Java", "C#", "Python", "PHP"});
* и так нельзя

* как можно?
* в стандартной бибилотеке java - есть спец класс, который содержит методы, для преобразования arr в List(массивов в списки)
* спец класс Arrays (из java.util) с методом asList для преобразования arr в List.
* в метод asList - можно передать какое-то кол-во строк, в качестве параметра и результатом будет список, состоящий из этих строк
*       List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

// итерация для List

    for (int i = 0; i < languages.size(); i++) {                     // для List-метод size, для arr - lenght
      System.out.println("Я хочу выучить " + languages.get(i));   // обращаться к методу ч/з get, в качестве параметра - индекс i
    }
// [] - средство работы с arr
// () - средство работы с List,т.к. List  - обычный объект, и обращение к нему - вызывая какой-то метод

*//* ```````````````````````````````````````````````````````````

    // Total:

    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (int i = 0; i < languages.size(); i++) {
      System.out.println("Я хочу выучить " + languages.get(i));
    }
``````````````````````````````````````````````````````````````*/

// оптимизация итерации для List

/* ````````````````````````````````````````````````````````````

    // Total:

    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
``````````````````````````````````````````````````````````````*/

/* Список объектов произвольного типа

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");
* если убрать <>
    List languages = Arrays.asList("Java", "C#", "Python", "PHP");

* можно поместить элементы - разных типов, но..
* в итерации, уже указать не тип, а объект

    for (Object l : languages) {
      System.out.println("Я хочу выучить " + l);
    }

// это менее удобно!
// лучше работать с элементами конкретных типов

 *//* ````````````````````````````````````````````````````````````

    // Total:

    String[] langs = {"Java", "C#", "Python", "PHP"};

    List languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (Object l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
``````````````````````````````````````````````````````````````*/

    String[] langs = {"Java", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "Python", "PHP");

    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }



  }
}





























