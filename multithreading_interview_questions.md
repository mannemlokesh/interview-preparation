If you're preparing for an interview on multithreading, interviewers usually cover concepts, synchronization, concurrency problems, language-specific APIs, and real-world design scenarios.

## Fundamental Questions

1. What is a thread?
2. What is the difference between a process and a thread?
3. What are the advantages of multithreading?
4. What is concurrency vs parallelism?
5. What is context switching?
6. What is a thread lifecycle (new, runnable, running, blocked, terminated)?
7. What are user threads and daemon threads?
8. What is thread starvation?
9. What is thread priority, and can it guarantee execution order?

## Synchronization Questions

1. Why is synchronization needed?
2. What is a race condition?
3. What is a critical section?
4. What is mutual exclusion?
5. What is a mutex?
6. What is a semaphore?
7. Difference between mutex and semaphore?
8. What is a monitor?
9. What is a lock?
10. What is reentrant locking?

**Example: Race Condition**

```java
count++;

```

This looks simple, but internally it involves:

1. Read count
2. Increment
3. Write count

Multiple threads executing this simultaneously can produce incorrect results.

## Deadlock Questions

1. What is deadlock?
2. What are the four conditions required for deadlock?

   * Mutual Exclusion
   * Hold and Wait
   * No Preemption
   * Circular Wait
3. How can you prevent deadlocks?
4. How can you detect deadlocks?
5. Difference between deadlock, livelock, and starvation?

**Deadlock Example**

```java
Thread 1:
synchronized(lockA){
    synchronized(lockB){
    }
}

Thread 2:
synchronized(lockB){
    synchronized(lockA){
    }
}
```

## Java-Specific Multithreading Questions

### Thread Creation

1. How do you create a thread?

   * Extending Thread
   * Implementing Runnable
   * Implementing Callable

2. Difference between:

   * Thread
   * Runnable
   * Callable

3. Why is Callable preferred over Runnable sometimes?

### Thread Methods

1. Difference between `start()` and `run()`?
2. What does `join()` do?
3. What is `sleep()`?
4. What is `yield()`?
5. What is `interrupt()`?
6. What happens when a thread is interrupted?

### Synchronization

1. Difference between synchronized method and synchronized block?
2. What is intrinsic locking?
3. What is volatile?
4. Difference between volatile and synchronized?
5. What is atomicity?
6. What are Atomic classes?

Example:

```java
AtomicInteger counter = new AtomicInteger(0);
counter.incrementAndGet();
```

## Executor Framework Questions

1. Why use thread pools?

2. What is the Executor Framework?

3. Difference between:

   * FixedThreadPool
   * CachedThreadPool
   * SingleThreadExecutor
   * ScheduledThreadPool

4. What is Future?

5. What is CompletableFuture?

6. How do you handle exceptions in asynchronous tasks?

Example:

```java
ExecutorService executor =
        Executors.newFixedThreadPool(5);

executor.submit(() -> {
    System.out.println("Task");
});
```

## Concurrent Collections

1. Why is HashMap not thread-safe?

2. Difference between:

   * HashMap
   * Hashtable
   * ConcurrentHashMap

3. How does ConcurrentHashMap achieve thread safety?

4. What is CopyOnWriteArrayList?

5. When would you use BlockingQueue?

## Advanced Questions

1. What is the Java Memory Model (JMM)?
2. What is visibility?
3. What is happens-before relationship?
4. What is instruction reordering?
5. What is CAS (Compare-And-Swap)?
6. What is lock-free programming?
7. What is false sharing?
8. What is Fork/Join Framework?
9. What is work stealing?

## Scenario-Based Questions

### Q1: How would you make a counter thread-safe?

Possible answers:

* synchronized
* AtomicInteger
* LongAdder (high contention)

### Q2: A web application receives 10,000 requests simultaneously. How would you design concurrency?

Expected discussion:

* Thread pools
* Queue management
* Async processing
* Rate limiting
* Resource management

### Q3: Multiple threads are updating shared data. Performance is poor due to synchronization. What would you do?

Possible solutions:

* Reduce lock scope
* Use read-write locks
* Use concurrent collections
* Use Atomic classes
* Partition data

## Frequently Asked "Tricky" Questions

### What is the output?

```java
Thread t = new Thread(() -> {
    System.out.println("Thread");
});

t.run();
System.out.println("Main");
```

**Answer:** No new thread is created because `run()` is called directly.

Output:

```
Thread
Main
```

### Can a volatile variable make an operation atomic?

**Answer:** No.

```java
volatile int count;
count++;
```

Still not atomic.

### Why is String immutable useful in multithreading?

Because immutable objects are inherently thread-safe.

## Senior-Level Questions

1. Explain Java Memory Model in detail.
2. How does ConcurrentHashMap work internally?
3. Explain CAS and ABA problem.
4. How does ReentrantLock differ from synchronized?
5. Explain CompletableFuture chaining.
6. How would you troubleshoot a production deadlock?
7. How would you design a high-throughput concurrent cache?
8. How would you improve performance in a highly concurrent system?
9. Explain lock contention and techniques to reduce it.
10. How do modern JVMs optimize synchronization?

These questions cover most interview rounds from 2–10+ years of Java experience. If you're targeting Java developer roles specifically, I can also provide **50 interview questions with detailed answers and coding examples**.
