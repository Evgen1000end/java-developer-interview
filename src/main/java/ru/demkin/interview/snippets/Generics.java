package ru.demkin.interview.snippets;

import java.util.ArrayList;
import java.util.List;

public class Generics {

  public static class Foo {}
  public static class Bar extends Foo {}
  public static class Baz extends Bar {}

  public static void main(String[] args) {
    List<Bar> listA = new ArrayList<>();
  //  listA.add(new Foo());
    listA.add(new Bar());
    listA.add(new Baz());

    List<?> listB = listA;
   // listB.add(new Foo());
  //  listB.add(new Object());

    List<? extends Foo> listC = new ArrayList<>();
   // listC.add(new Foo());
   // listC.add(new Bar());
  //  listC.add(new Baz());

    List<? super Foo> listD = new ArrayList<>();
    listD.add(new Foo());
    listD.add(new Bar());
    listD.add(new Baz());
  }

}
