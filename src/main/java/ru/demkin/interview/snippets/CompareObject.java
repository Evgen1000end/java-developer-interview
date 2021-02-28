package ru.demkin.interview.snippets;

public class CompareObject {
  public static void main(String[] args) {

    // Отличие == от equals
    final Object obj1 = new Object();
    final Object obj2 = new Object();
    System.out.println(obj1.equals(obj2));
    System.out.println(obj1 == obj2);

    final String str1 = new String("string");
    final String str2 = new String("string");

    System.out.println(str1.equals(str2));
    System.out.println(str1 == str2);

    // // Обсуждаем пул стрингов и intent(), а также касаемся Constant pool
    // Сколько констант будет содержаться в констант пуле? Какая информация содержится в Constant-пуле?
    // Как вывести констант пул? Знает ли кандидат про javap?
    final String str3 = "string";
    final String str4 = "string";
    final String str5 = "str" + "ing";   // Вот можно обсудить структуру class файла, пул констант. Содержится ли в пуле константы str и ing?

    System.out.println(str3.equals(str4));
    System.out.println(str3 == str4);
    System.out.println(str3 == str5);

    final Integer i1 = new Integer(1);
    final Integer i2 = new Integer(1);

    System.out.println(i1.equals(i2));
    System.out.println(i1 == i2);

    final Integer i3 = 128;
    final Integer i4 = 128;  // Что тут происходит? Авто боксинг
    // Надо добиться от кандидата, что это компилится в Integer.valueof()

    // Попросить кандидата реализовать метод Integer.valueof()
    // Не боится ли кандидат работать с массивами?


    System.out.println(i3.equals(i4));
    System.out.println(i3 == i4);


  }
}
