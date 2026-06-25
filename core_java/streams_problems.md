For a **4+ years Java Backend Developer** interview, interviewers usually don't ask basic stream questions like `filter()` or `map()`. They typically focus on:

* Stream API + Collections
* Complex grouping and aggregation
* Custom collectors
* Performance considerations
* Real-world business problems
* Combining Streams with Optional and Comparator

Here are some commonly asked problems arranged from medium to advanced.

---

# Level 1: Basic Filtering & Mapping

### Problem 1

Given a list of employees, print names of employees whose salary is greater than 50,000.

```java
class Employee {
    int id;
    String name;
    double salary;
}
```

Expected:

```java
List<String> names
```

Concepts:

* filter
* map
* collect

---

### Problem 2

Find all even numbers from a list and square them.

Input:

```java
[1,2,3,4,5,6]
```

Output:

```java
[4,16,36]
```

Concepts:

* filter
* map

---

# Level 2: Sorting

### Problem 3

Sort employees by salary ascending.

### Problem 4

Sort employees by salary descending and then by name ascending.

Concepts:

```java
Comparator.comparing()
thenComparing()
reversed()
```

---

### Problem 5

Find top 3 highest-paid employees.

Concepts:

```java
sorted()
limit()
```

---

# Level 3: Duplicate Handling

### Problem 6

Find duplicate elements in a list.

Input:

```java
[1,2,3,2,4,5,1]
```

Output:

```java
[1,2]
```

Interviewers love this one.

Hint:

```java
Set<Integer> seen = new HashSet<>();
```

---

### Problem 7

Remove duplicates while preserving order.

Input:

```java
[3,1,2,1,3,4]
```

Output:

```java
[3,1,2,4]
```

Concept:

```java
distinct()
```

---

# Level 4: Grouping

### Problem 8

Group employees by department.

Output:

```java
Map<String, List<Employee>>
```

Concept:

```java
Collectors.groupingBy()
```

---

### Problem 9

Count employees in each department.

Output:

```java
Map<String, Long>
```

Concept:

```java
Collectors.counting()
```

---

### Problem 10

Find average salary by department.

Output:

```java
Map<String, Double>
```

Concept:

```java
Collectors.averagingDouble()
```

---

### Problem 11

Find highest-paid employee in each department.

Output:

```java
Map<String, Employee>
```

Concepts:

```java
groupingBy()
maxBy()
Optional
```

Very common interview question.

---

# Level 5: Real Interview Problems

### Problem 12

Given:

```java
List<String> words
```

Find frequency of each word.

Output:

```java
Map<String, Long>
```

Example:

```java
apple
banana
apple
orange
banana
apple
```

Result:

```java
apple -> 3
banana -> 2
orange -> 1
```

Concept:

```java
Collectors.groupingBy(
    Function.identity(),
    Collectors.counting()
)
```

---

### Problem 13

Find first non-repeated character.

Input:

```java
"stress"
```

Output:

```java
t
```

Very famous interview question.

Concepts:

```java
chars()
LinkedHashMap
groupingBy
```

---

### Problem 14

Find first repeated character.

Input:

```java
"programming"
```

Output:

```java
r
```

---

### Problem 15

Find second highest salary employee.

Concepts:

```java
sorted()
skip(1)
findFirst()
```

Interviewers frequently ask follow-up:

> What if multiple employees have same salary?

---

# Level 6: Nested Objects

### Problem 16

```java
class Department {
    String name;
    List<Employee> employees;
}
```

Get all employees from all departments.

Output:

```java
List<Employee>
```

Concept:

```java
flatMap()
```

---

### Problem 17

Find all unique skills possessed by employees.

```java
class Employee {
    String name;
    List<String> skills;
}
```

Output:

```java
Java
Spring
AWS
Kafka
```

Concept:

```java
flatMap()
distinct()
```

---

# Level 7: Advanced Grouping

### Problem 18

Group employees by department and then by designation.

Output:

```java
Map<String,
    Map<String, List<Employee>>
>
```

Concept:

```java
groupingBy(
    Employee::getDept,
    groupingBy(Employee::getDesignation)
)
```

---

### Problem 19

Find total salary expenditure department-wise.

Output:

```java
Map<String, Double>
```

Concept:

```java
summingDouble()
```

---

### Problem 20

Find employee names department-wise.

Output:

```java
Map<String, List<String>>
```

Concept:

```java
mapping()
```

---

# Level 8: Advanced Stream Questions

### Problem 21

Partition employees based on salary > 50000.

Output:

```java
Map<Boolean, List<Employee>>
```

Concept:

```java
partitioningBy()
```

---

### Problem 22

Find the longest string in a list.

Concept:

```java
max(Comparator.comparing(String::length))
```

---

### Problem 23

Find the employee with maximum salary.

Concept:

```java
max()
```

---

### Problem 24

Find the sum of salaries.

Concept:

```java
mapToDouble()
sum()
```

---

### Problem 25

Check if all employees belong to the same department.

Concept:

```java
allMatch()
```

---

# Level 9: Senior-Level Interview Problems

### Problem 26

Given:

```java
List<Transaction>
```

Find:

* Total transaction amount per customer.
* Highest spending customer.

This tests:

```java
groupingBy
summingDouble
max
entrySet stream
```

---

### Problem 27

Given orders:

```java
class Order {
    String customer;
    List<Item> items;
}
```

Find:

* Top 5 selling products.
* Revenue by product.
* Revenue by customer.

Requires:

```java
flatMap()
groupingBy()
counting()
summingDouble()
```

---

### Problem 28

Find employees whose salary is above department average salary.

This is frequently asked in senior backend interviews.

Steps:

1. Calculate avg salary per department.
2. Filter employees whose salary > department average.

Tests:

* groupingBy
* averagingDouble
* filter

---

### Problem 29

Implement SQL-like queries using Streams.

Examples:

```sql
SELECT department,
       MAX(salary)
FROM employee
GROUP BY department
```

Using Streams.

Many interviewers convert SQL questions into Stream API questions.

---

### Problem 30 (4+ Years Favorite)

Given:

```java
List<Employee>
```

Find:

```java
Department
    -> Highest Salary Employee
    -> Average Salary
    -> Employee Count
```

Output:

```java
Map<String, DepartmentStats>
```

Where:

```java
class DepartmentStats {
    Employee highestPaid;
    Double averageSalary;
    Long count;
}
```

This problem tests:

* groupingBy
* collectingAndThen
* custom collector
* Optional handling
* DTO creation

---

## Questions that are asked very frequently for 4+ years Java developers

1. Find duplicate elements.
2. Find first non-repeated character.
3. Find second highest salary.
4. Group employees by department.
5. Highest-paid employee per department.
6. Average salary per department.
7. Flatten nested lists using `flatMap`.
8. Word frequency count.
9. Top N highest salaries.
10. Employees above department average salary.
11. Custom grouping and aggregation.
12. Convert SQL `GROUP BY` problems into Streams.

If you're preparing for product companies or strong backend interviews, mastering these 30 problems will cover roughly 80–90% of the Stream API questions typically asked to Java developers with 4–8 years of experience.
