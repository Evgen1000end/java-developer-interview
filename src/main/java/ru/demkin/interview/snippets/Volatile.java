package ru.demkin.interview.snippets;

public class Volatile {

  /**
   * Кандидату предлагается эта задача при обсуждении многопоточности и ключевого слова volatile
   *
   * Кандидат должен рассказать в каких случаях и почему данный код будет работать некорректно
   *
   * Связанные вопросы: кэширование, ordering, happens-before, кэшлайны, cache-miss, cache-pollution, когерентность кешей
   */
  public static class A {
    private volatile int value;

    public void increment() {
      value ++;
    }

    public int getValue() {
      return value;
    }
  }


  // Пример - в результате
  public static void main(String[] args) throws InterruptedException {
    final A a = new A();
    final Thread t1 = new Thread(new Job(a));
    final Thread t2 = new Thread(new Job(a));
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    System.out.println(a.getValue());
  }

  static class Job implements Runnable {
    private final A a;

    public Job(A a) {
      this.a = a;
    }

    @Override
    public void run() {
      for (int i = 0; i < 10000; i++) {
        a.increment();
      }
    }
  }
}
