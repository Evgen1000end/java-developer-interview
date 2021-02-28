package ru.demkin.interview.snippets;

class VolatileSnippet {

  public static class A {
    private volatile int value;

    public void increment() {
      value ++;
    }

    public int getValue() {
      return value;
    }
  }

}