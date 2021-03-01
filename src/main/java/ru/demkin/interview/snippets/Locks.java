package ru.demkin.interview.snippets;

import java.util.concurrent.locks.Lock;

public class Locks {
  Lock lock;

  public void function(){
    lock.lock();
    doSomething();
    lock.unlock();
  }

  public void function2(){
    synchronized (this) {
      doSomething();
    }
  }

  public void correctFunction() {

  }

  private void doSomething() {
    throw new IllegalStateException("Oops!");
  }

}
