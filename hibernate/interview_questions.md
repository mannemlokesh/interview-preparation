For a Java developer with **4+ years of experience**, Hibernate interview questions typically focus on ORM concepts, performance tuning, mappings, caching, transactions, and real-world troubleshooting rather than just basic CRUD operations.

## Hibernate Basics

### 1. What is Hibernate?

Hibernate is an ORM (Object Relational Mapping) framework that maps Java objects to database tables and reduces boilerplate JDBC code.

### 2. What are the advantages of Hibernate over JDBC?

* Less boilerplate code
* Automatic object-table mapping
* Database independence
* Caching support
* Lazy loading
* HQL and Criteria APIs
* Transaction management

### 3. What are the core interfaces of Hibernate?

* SessionFactory
* Session
* Transaction
* Query
* CriteriaBuilder/CriteriaQuery (JPA)

### 4. Difference between SessionFactory and Session?

| SessionFactory               | Session                         |
| ---------------------------- | ------------------------------- |
| Heavy-weight                 | Lightweight                     |
| Thread-safe                  | Not thread-safe                 |
| Created once per application | Created per request/transaction |
| Holds cache and metadata     | Performs CRUD operations        |

---

## Entity States

### 5. Explain Hibernate object states.

1. Transient
2. Persistent
3. Detached
4. Removed

Example:

```java
Employee emp = new Employee(); // Transient

session.save(emp); // Persistent

session.close(); // Detached

session.delete(emp); // Removed
```

### 6. What is a detached object?

An object that was once associated with a session but is no longer managed by Hibernate.

### 7. Difference between update() and merge()?

| update()                                              | merge()                        |
| ----------------------------------------------------- | ------------------------------ |
| Reattaches detached object                            | Copies state to managed object |
| Throws exception if same ID already exists in session | No exception                   |
| Faster                                                | Safer                          |

---

## Primary Keys & Identifier Generation

### 8. What identifier generation strategies are available?

```java
@GeneratedValue(strategy = GenerationType.IDENTITY)
@GeneratedValue(strategy = GenerationType.SEQUENCE)
@GeneratedValue(strategy = GenerationType.AUTO)
@GeneratedValue(strategy = GenerationType.TABLE)
```

### 9. Difference between IDENTITY and SEQUENCE?

| IDENTITY                        | SEQUENCE           |
| ------------------------------- | ------------------ |
| Auto increment column           | Database sequence  |
| Insert immediately              | Can batch inserts  |
| Less efficient for bulk inserts | Better performance |

---

## Hibernate Mappings

### 10. Explain One-to-One mapping.

```java
@OneToOne
@JoinColumn(name="address_id")
private Address address;
```

### 11. Explain One-to-Many mapping.

```java
@OneToMany(mappedBy="department")
private List<Employee> employees;
```

### 12. Difference between OneToMany and ManyToOne?

ManyToOne is usually the owning side and stores the foreign key.

### 13. Explain Many-to-Many mapping.

```java
@ManyToMany
@JoinTable(
 name="student_course",
 joinColumns=@JoinColumn(name="student_id"),
 inverseJoinColumns=@JoinColumn(name="course_id")
)
```

### 14. What is mappedBy?

Indicates the inverse side of a relationship and avoids duplicate join table creation.

### 15. What is the owning side in Hibernate?

The side responsible for updating the relationship in the database.

---

## Fetching Strategies

### 16. Difference between Lazy Loading and Eager Loading?

| Lazy                  | Eager                         |
| --------------------- | ----------------------------- |
| Data loaded on demand | Data loaded immediately       |
| Better performance    | May cause unnecessary queries |

```java
@OneToMany(fetch = FetchType.LAZY)
```

### 17. What is LazyInitializationException?

Occurs when lazy-loaded data is accessed after the session is closed.

### 18. How do you solve LazyInitializationException?

* Fetch Join
* Open Session in View
* DTO projection
* Explicit initialization

```java
Hibernate.initialize(employee.getProjects());
```

### 19. What is Fetch Join?

```java
SELECT e
FROM Employee e
JOIN FETCH e.projects
```

Used to avoid N+1 query problems.

---

## Caching

### 20. What is First-Level Cache?

* Session-level cache
* Enabled by default

```java
Employee e1 = session.get(Employee.class,1);
Employee e2 = session.get(Employee.class,1);
```

Only one SQL query executes.

### 21. What is Second-Level Cache?

* SessionFactory-level cache
* Shared across sessions
* Requires configuration

Popular providers:

* Ehcache
* Hazelcast
* Infinispan

### 22. What is Query Cache?

Caches query results rather than entities.

### 23. Difference between First-Level and Second-Level Cache?

| First-Level        | Second-Level           |
| ------------------ | ---------------------- |
| Session scoped     | SessionFactory scoped  |
| Default enabled    | Requires configuration |
| Cannot be disabled | Optional               |

---

## Querying

### 24. Difference between HQL and SQL?

| HQL                  | SQL               |
| -------------------- | ----------------- |
| Uses entity names    | Uses table names  |
| Database independent | Database specific |

Example:

```java
from Employee
```

instead of

```sql
select * from employee
```

### 25. What is Criteria API?

Type-safe way of creating dynamic queries.

### 26. What are Named Queries?

```java
@NamedQuery(
 name="Employee.findAll",
 query="from Employee"
)
```

### 27. Difference between get() and load()?

| get()                     | load()                         |
| ------------------------- | ------------------------------ |
| Immediately hits DB       | Returns proxy                  |
| Returns null if not found | Throws exception when accessed |
| Eager                     | Lazy                           |

---

## Performance Questions

### 28. What is the N+1 Select Problem?

Example:

* 1 query for departments
* N queries for employees

Result:

```sql
1 + N queries
```

### 29. How do you solve N+1 problems?

* Fetch Join
* Entity Graph
* Batch Fetching
* DTO Projections

### 30. What is batch fetching?

```properties
hibernate.default_batch_fetch_size=20
```

Reduces database round trips.

### 31. What is JDBC batching?

```properties
hibernate.jdbc.batch_size=50
```

Improves bulk insert/update performance.

### 32. How do you optimize Hibernate performance?

* Use lazy loading
* Enable second-level cache
* Use batch processing
* Avoid N+1 queries
* Use projections instead of entities when possible
* Monitor SQL execution

---

## Transactions

### 33. What is Hibernate Transaction?

```java
Transaction tx = session.beginTransaction();
tx.commit();
```

### 34. Difference between commit() and flush()?

| flush()                      | commit()            |
| ---------------------------- | ------------------- |
| Synchronizes session with DB | Permanently commits |
| Transaction remains active   | Ends transaction    |

### 35. What is automatic flushing?

Hibernate automatically flushes before:

* Commit
* Certain queries

---

## Concurrency

### 36. What is optimistic locking?

```java
@Version
private Long version;
```

Prevents lost updates without locking rows.

### 37. What is pessimistic locking?

```java
LockModeType.PESSIMISTIC_WRITE
```

Locks database rows immediately.

### 38. When would you use optimistic locking?

When reads are much more frequent than writes.

---

## Spring Boot + Hibernate Questions

### 39. Difference between Hibernate and JPA?

| Hibernate           | JPA               |
| ------------------- | ----------------- |
| Implementation      | Specification     |
| Provides ORM engine | Defines standards |

### 40. What is Hibernate's role in Spring Data JPA?

Hibernate acts as the default JPA provider that executes ORM operations.

### 41. Difference between save() and saveAndFlush() in Spring Data JPA?

```java
save(entity);
```

Persists but may delay SQL execution.

```java
saveAndFlush(entity);
```

Immediately flushes changes.

### 42. What happens when @Transactional is used?

* Opens transaction
* Commits on success
* Rolls back on exception

---

## Scenario-Based Questions (Very Common)

### 43. Production application is slow. How would you identify whether Hibernate is the problem?

* Enable SQL logs
* Check N+1 queries
* Analyze execution plans
* Monitor connection pool
* Review fetch strategies
* Use profiling tools

### 44. You see hundreds of SQL queries for a single API call. What could be wrong?

* N+1 issue
* Eager fetching
* Incorrect entity relationships
* Lazy loading inside loops

### 45. Why does Hibernate generate unexpected update statements?

Possible reasons:

* Dirty checking
* Bidirectional mapping issues
* Collection modifications
* Cascade operations

### 46. How would you handle bulk updates of 1 million records?

```java
for(...) {
    session.save(entity);

    if(count % 50 == 0){
        session.flush();
        session.clear();
    }
}
```

Also enable JDBC batching.

### 47. Explain dirty checking.

Hibernate automatically detects entity changes and updates only modified fields during flush.

### 48. What are cascade types?

```java
CascadeType.PERSIST
CascadeType.MERGE
CascadeType.REMOVE
CascadeType.REFRESH
CascadeType.DETACH
CascadeType.ALL
```

### 49. Difference between orphanRemoval and CascadeType.REMOVE?

* `CascadeType.REMOVE` removes child when parent is deleted.
* `orphanRemoval=true` removes child when removed from collection.

### 50. What Hibernate issues have you solved in a real project?

Common answers:

* N+1 query optimization
* Batch processing
* LazyInitializationException
* Cache tuning
* Slow HQL queries
* Transaction deadlocks
* Connection pool issues

## Questions Frequently Asked in 4–6 Year Interviews

1. Explain entity lifecycle states.
2. Difference between merge and update.
3. How does first-level cache work?
4. What is second-level cache?
5. Explain N+1 query problem and solutions.
6. Difference between get() and load().
7. Difference between flush() and commit().
8. What is dirty checking?
9. How do you optimize Hibernate performance?
10. Explain optimistic locking using @Version.
11. What causes LazyInitializationException?
12. How do you design mappings for large-scale applications?
13. Explain cascade types with examples.
14. How would you troubleshoot slow APIs caused by Hibernate?
15. Difference between Hibernate and JPA.

These are the kinds of Hibernate questions most commonly asked for Java developers with 4–7 years of experience in companies such as banking, fintech, product companies, and large enterprise organizations.
