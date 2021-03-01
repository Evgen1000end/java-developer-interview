# java-developer-interview

#### **Перед интервью:**

Главная цель на интервью - оценить навыки соискателя в разрезе проектных задач и ответить на вопрос, 
подходят ли нам его опыт и знания.

Перед интервью я должен ответить себе на вопросы:

1) Какого специалиста я ищу и какими навыками он должен владеть?
2) Какие из компетенций обязательные, а каким я смогу его обучить?


#### **Вводная часть - 5-10 минут:**

Представляемся сами и предлагаем кандидату рассказать о себе: опыт, квалификация, сильные области, последние проекты и причина поиска работы.

_Мотивация_: Получить первичную информацию о навыках кандидата и технологиях которые он использовал, а также дать понять, что интервью проводится на равных - это беседа
двух умных людей, а не экзамен или допрос.

#### **Техническая часть - основной блок**

_Интервью предлагаю проводить в режиме совместного написания кода в редакторе: https://code.yandex-team.ru/_

_Также предполагается пропускать определенные вопросы в зависимости от хода интервью_

**Часть 1** - Сравнение объектов, String pool, IntPool, intent, constant pool, auto boxing/unboxing:
Кандидату предлагается задачка из Сниппета 
```
https://github.com/Evgen1000end/java-developer-interview/blob/main/src/main/java/ru/demkin/interview/snippets/CompareObject.java
```

Ответ: 


По результатам обсуждения предлагаю реализовать метод Integer.valueOf самостоятельно

**Часть 2** - Коллекции
1) Какие классы и интерфейсы вы знаете/использовали? 

Ответ: 

 Интерфейсы: List, Queue, Set, Deque, SortedSet
 Классы: ArrayList, LinkedList, HashSet и т.д.
 + Map и HashMap

2) ArrayList vs Массив? Какие преимущества? 

3) Реализация метода ArrayList.add() - знает ли кандидат про Arrays.copyOf и как часто он вызывается?
4) Задача на ArrayList:

```
public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      list.add(i);
    }
  }
```

Посчитать сколько раз будет вызвана функция Arrays.copyOf. Как надо изменить код чтобы уменьшить кол-во вызовов?

5 - Задача  - Предлагается задачка написать Iterator по массиву.

Если кандидат не помнит интерфейс итератора, то описать контракт методов next() и hasNext() - и после 
этого посмотреть на результат.
Пример реализации тут: 
```
https://github.com/Evgen1000end/java-developer-interview/blob/main/src/main/java/ru/demkin/interview/snippets/ArrayIterator.java
```

6) ArrayList vs LinkedList - в каком случае целесообразно использовать LinkedList? Привести пример из жизни.

Ответ:

ArrayList следует использовать, когда в приоритете доступ по индексу, так как эти операции выполняются за константное время. Добавление в конец списка в среднем тоже выполняется за константное время. Кроме того в ArrayList нет дополнительных расходов на хранение связки между элементами. Минусы в скорости вставки/удаления элементов находящихся не в конце списка, так как при этой операции все элементы правее добавляемого/удаляемого сдвигаются.

LinkedList удобен когда важнее быстродействие операций вставки/удаления, которые в LinkedList выполняются за константное время. Операции доступа по индексу производятся перебором с начала или конца (смотря что ближе) до нужного элемента. Дополнительные затраты на хранение связки между элементами.

7) Как работает HahsMap? 
Время поиска в худшем случае?
Как на основе hashcode определяется индекс корзины? 

Задача: 
```
HashMap<String, ..> - время поиска в худшем случае?

class StringWrapper {
  private String value;
  
  int hashcode() {
    return value.hashcode();
  }
  // equals и другие методы опущены
 }

HashMap<StringWrapper , ..> - время поиска в худшем случае?
```
  
 

**Часть 3** - Многопоточное программирование 
1) Начинаем общение с простого примера: 
```
public class A {
    private volatile int value;

    public void increment() {
      value ++;
    }

    public int getValue() {
      return value;
    }
  }
```
Два потока одновременно вызывают метод increment() - корректно ли будет работать данный код?

Если кандидат предлагает добавить ключевое слово syncronized к increment, то спрашиваем что это, как работает? 
Что такое монитор и т.д. Захват монитора, CAS-операции. Также общаемся на тему гарантий volatile, кэшлайны, happens-before и т.д. 
В кэш мисс, кэш поллюшен, когерентность кешей не углубляемся.

https://habr.com/ru/post/143237/
https://habr.com/ru/post/209128/

https://habr.com/ru/post/354748/

https://habr.com/ru/post/133981/




2) Synchronized vs Lock, виды локов (Reentral, ReadWriteLock).

Пример неправильного лока: - что тут может пойти не так (doSomething может выкинуть исключение)?  
```
public void function(){
    synchronized (this) {
      doSomething();
    }
  }

public void function(){
    lock.lock();
    doSomething();
    lock.unlock();
}
```

https://www.baeldung.com/java-concurrent-locks
https://crunchify.com/what-is-lock-unlock-reentrantlock-trylock-and-how-its-different-from-synchronized-block-in-java/


3) Способы создания и запуска потоков: 
Thread, ExecutorService. 
Какие виды ExecutoService кандидат знает? (Single, Cached, Fixed)

https://www.baeldung.com/java-executors-cached-fixed-threadpool

4) Deadlock/ Livelock - что это и в чем разница? 

4) Задача wait/notify - Producer/Consumer задача ( сложно, предпочитаю не задавать), 
   Spurious wakeup
 http://opensourceforgeeks.blogspot.com/2014/08/spurious-wakeups-in-java-and-how-to.html
 https://metanit.com/java/tutorial/8.5.php
  http://www.javenue.info/post/91
 https://javarush.ru/groups/posts/1611-otvetih-na-voprosih-k-sobesedovaniju-level27

Ответ:    
Иногда при взаимодействии потоков встает вопрос о извещении одних потоков о действиях других. 
Например, действия одного потока зависят от результата действий другого потока, и 
надо как-то известить один поток, что второй поток произвел некую работу. 
И для подобных ситуаций у класса Object определено ряд методов:

   


5) Future.get vs ExecutorService.awaitTermination

https://stackoverflow.com/questions/43854942/javas-executorservice-awaittermination-vs-future-gettimeout




**Часть 4** - GC:

Сильно не углубляемся: интересен кругозор кандидата: 

1) Знает ли поколения? 
2) Знает ли про GC roots?
3) Знает ли какой GC сейчас используется в Java?

http://java-online.ru/garbage-collection.xhtml
https://ziginsider.github.io/Garbage_Collector_Java/


**Часть 5** - Задача и подводка к вопросам про Unit-тесты:
Кандидату предлагается задача: 
```
Дана строка, состоящая из цифр, алгебраических операторов и скобок. 
Например:  3 - ((12 + 3) * (7 / 12)) 

Надо проверить баланс скобок.
Строка считается сбалансированной в следующих случаях:
  1) Если она пустая;
  2) Если все открывающие скобки находятся слева от соответствующих закрывающих;
  3) Если отсутствуют пересечения диапазонов символов между двумя парами скобок.
```
Решение очень простое - создать счетчик, инкрементить его на "(", декрементить на ")" и проверять что счетчик >= 0

По результатам решения предлагается написать тесты (тестовые сценарии - входные и выходные данные) к этой задаче.
Далее спрашиваем про:
 
 Тестовые фреймворки, которые он использовал: JUNIT? Mockito? PowerMock? TestContainters?
  Плюсы и минусы использования моков?


**Часть 6** - Вопросы по Spring:
1) Какие компоненты Spring использовали? 
1) Как устроен Spring Core? (фабрика бинов, принцип инверсии зависимостей)
2) Жизненный цикл бина
3) Типы связываний
4) Spring vs Spring Boot (Что такое starter? Механизм поиска автоконфигураций)
5) Задачка на @Transactional - но попроще. На уровне одного класса.
```
@Service
public class ServiceA {
 
  @Transactional
  private void doSomething() {
    /* logic here */
  }
 
  public void doSomethingElse() {
    this.doSomething();
    
  }
}
```

https://habr.com/ru/post/532000/#infra

6) Внутреннее устройство Spring MVC ( servlet, dispatcher и т.д.) - нужно ли это спрашивать? 

**Часть 7** - Вопросы по Базам данных (если у кандидата в резюме указан опыт)
1) Какие интерфейсы JDBC вы знаете/помните?
2) Что такое index? В чем отличие индекса от ключа
3) Типы транзакций и виды блокировок ( оптимистичная/пессимистичная)
4) Задача на SQL:

```
CREATE TABLE employee (
  id            INTEGER      NOT NULL, -- идентификатор сотрудника
  manager_id    INTEGER,               -- идентификатор начальника
  name          VARCHAR(128) NOT NULL, -- имя сотрудника
  salary        DECIMAL      NOT NULL, -- оклад сотрудника
  PRIMARY KEY (id),
  FOREIGN KEY (manager_id) REFERENCES employee(id)
);

Список сотрудников с окладом, большим чем у непосредственного руководителя:

SELECT t1.name, t1.salary, t2.name, t2.salary FROM employee t1
  INNER JOIN employee t2 ON t1.manager_id = t2.id
  WHERE t1.salary > t2.salary;
```

5 - Написать итератор по ResultSet 

**Часть 8** - Вопросы по JMS (если у кандидата в резюме указан опыт)

1) Какой Брокер использовали?
2) Зачем использовать брокер? Плюсы и минусы асинхронного взаимодействия 
3) Что такое гарантированная доставка? 
4) Exactly-once, at-least-once, at-most-once


**Часть 9** - Вопросы на кругозор
1) SOLID - понимание принципов
2) Какие опции JVM знает? 
3) Какие утилиты использовал? Thread Dump (что содержится в Thread Dump?), Heap Dump?  (что содержится в Heap Dump?),
 javap и т.д.
4) Как вы понимаете REST?
5) Generics  на примере задачи
```
public class Foo {}
public class Bar extends Foo {}
public class Baz extends Bar {}
 
public static void main(String[] args) {
  List<Bar> listA = new ArrayList<>();
  listA.add(new Foo());
  listA.add(new Bar());
  listA.add(new Baz());
 
  List<?> listB = listA;
  listB.add(new Foo());
  listB.add(new Object());
 
  List<? extends Foo> listC = new ArrayList<>();
  listC.add(new Foo());
  listC.add(new Bar());
  listC.add(new Baz());
 
  List<? super Foo> listD = new ArrayList<>();
  listD.add(new Foo());
  listD.add(new Bar());
  listD.add(new Baz());
}
```

#### **Домашнее задание** 

Условия задания
Напишите SpringBoot приложение, которое предоставляет REST-контроллер для управления информацией о пользователях. Контроллер должен публиковать следующие операции:

создание нового пользователя;
получения списка пользователей;
получение информации об указанном пользователе;
блокировка пользователя.
Объект, описывающий запись с информацией о пользователе, должен содержать как минимум два поля: полное имя и название учетной записи. Остальные поля - на усмотрение разработчика.

Для хранения данных приложения необходимо использовать таблицу реляционной базы данных. 

Вместе с результатом выполнения задания необходимо прислать инструкцию по сборке, настройке и запуску приложения.

**Что проверяется по результатам ДЗ?** 

При оценке результата, смотрим на следующее:

* оформление и чистоту исходного кода, декомпозицию и разделение на слои;
* Наличие сценария сборки;
* Наличие качество тестов и актуальность выбранных технологий;
* Ясность и простота инструкции;
* Отсутствие ошибок при сборке и запуске приложения.
