## Problem 1
### Given a list of employees, print names of employees whose salary is greater than 50,000.
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000),
            new Employee(2, "Bob", 45000),
            new Employee(3, "Charlie", 70000),
            new Employee(4, "David", 50000)
        );

        List<String> names = employees.stream()
                .filter(emp -> emp.salary > 50000)
                .map(emp -> emp.name)
                .collect(Collectors.toList());

        System.out.println(names);
    }
}
```

## Problem 2
### Find all even numbers from a list and square them.
```java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)   // keep even numbers
                .map(n -> n * n)           // square each number
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
```

## Problem 3
### Sort employees by salary ascending.
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000),
            new Employee(2, "Bob", 45000),
            new Employee(3, "Charlie", 70000),
            new Employee(4, "David", 50000)
        );

        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(emp -> emp.salary))
                .collect(Collectors.toList());

        sortedEmployees.forEach(System.out::println);
    }
}
```

## Problem 4
### Sort employees by salary descending and then by name ascending.
```java
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000),
            new Employee(2, "Bob", 70000),
            new Employee(3, "Charlie", 70000),
            new Employee(4, "David", 50000)
        );

        List<Employee> sortedEmployees = employees.stream()
                .sorted(
                    Comparator.comparing((Employee e) -> e.salary)
                              .reversed()
                              .thenComparing(e -> e.name)
                )
                .toList();

        sortedEmployees.forEach(System.out::println);
    }
}
```

## Problem 5
### Find top 3 highest-paid employees.
```java
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000),
            new Employee(2, "Bob", 70000),
            new Employee(3, "Charlie", 70000),
            new Employee(4, "David", 50000)
        );

        List<Employee> sortedEmployees = employees.stream()
                .sorted(
                    Comparator.comparing((Employee e) -> e.salary)
                              .reversed()
                )
                .limit(3)
                .toList();

        sortedEmployees.forEach(System.out::println);
    }
}
```

## Problem 6
### Find duplicate elements in a list.
```java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 1);

        Set<Integer> seen = new HashSet<>();

        List<Integer> duplicates = numbers.stream()
                .filter(n -> !seen.add(n))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(duplicates);
    }
}
```

## Problem 7
### Remove duplicates while preserving order.
```java
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,1,2,1,3,4);

        Set<Integer> seen = new HashSet<>();

        List<Integer> duplicates = numbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(duplicates);
    }
}
```

## Problem 8
### Group employees by department.
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000, "IT"),
            new Employee(2, "Bob", 50000, "HR"),
            new Employee(3, "Charlie", 70000, "IT"),
            new Employee(4, "David", 45000, "Finance")
        );

        Map<String, List<Employee>> employeesByDept =
                employees.stream()
                         .collect(Collectors.groupingBy(emp -> emp.department));

        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + " -> " + empList.size() + " employees");
        });
    }
}
```

## Problem 9
### Count employees in each department.
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000, "IT"),
            new Employee(2, "Bob", 50000, "HR"),
            new Employee(3, "Charlie", 70000, "IT"),
            new Employee(4, "David", 45000, "Finance")
        );

        Map<String, Long> employeesByDept =
                employees.stream()
                         .collect(
                             Collectors.groupingBy(
                                emp -> emp.department,
                                Collectors.counting()
                             ));

        
        System.out.println(employeesByDept);

    }
}
```

## Problem 10
### Find average salary by department.
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000, "IT"),
            new Employee(2, "Bob", 50000, "HR"),
            new Employee(3, "Charlie", 70000, "IT"),
            new Employee(4, "David", 45000, "Finance")
        );

        Map<String, Double> employeesByDept =
                employees.stream()
                         .collect(
                             Collectors.groupingBy(
                                emp -> emp.department,
                                Collectors.averagingDouble(emp -> emp.salary)
                             ));
        
        System.out.println(employeesByDept);

    }
}
```

## Problem 11
### Find highest-paid employee in each department.
```java
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    double salary;
    String department;

    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return name + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 60000, "IT"),
            new Employee(2, "Bob", 50000, "HR"),
            new Employee(3, "Charlie", 75000, "IT"),
            new Employee(4, "David", 45000, "Finance"),
            new Employee(5, "Eve", 55000, "HR")
        );

        Map<String, Optional<Employee>> highestPaidByDept =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                emp -> emp.department,
                                Collectors.maxBy(
                                        Comparator.comparingDouble(emp -> emp.salary)
                                )
                        ));

        highestPaidByDept.forEach((dept, emp) ->
                System.out.println(dept + " -> " + emp.get()));
    }
}
```

## Problem 12
### Find frequency of each word.
```java
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.util.stream.*;

class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "apple", "banana", "apple",
                "orange", "banana", "apple"
        );
        
        
        Map<String, Long> map = words.stream()
        .collect(
            Collectors.groupingBy(
                word -> word,
                Collectors.counting()
            )
        );
        
        
        System.out.println(map);
    }
}
```

## Problem 13
### Find first non-repeated character.
```java
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Main {
    public static void main(String[] args) {
        String input = "stress";
        
        
        Character c = input.chars()
        .mapToObj(obj -> (char) obj)
        .collect(
            Collectors.groupingBy(
                // obj-> obj, 
                Function.identity(), 
                LinkedHashMap::new, 
                Collectors.counting()
            )
        )
        .entrySet()
        .stream()
        .filter(obj -> obj.getValue() == 1)
        // .map(Map.Entry::getKey)
        .map(obj -> obj.getKey())
        .findFirst()
        .orElse(null);
        
        
        System.out.println(c);
    }
}
```

## Problem 14
### Find first repeated character.
```java

```

## Problem 15
### Find second highest salary employee.
```java

```

## Problem 16
### Get all employees from all departments.
```java

```

## Problem 17
### Find all unique skills possessed by employees.
```java

```

## Problem 18
### Group employees by department and then by designation.
```java

```

## Problem 19
### Find total salary expenditure department-wise.
```java

```

## Problem 20
### Find employee names department-wise.
```java

```

## Problem 21
### Partition employees based on salary > 50000.
```java

```

## Problem 22
### Find the longest string in a list.
```java

```

## Problem 23
### Find the employee with maximum salary.
```java

```

## Problem 24
### Find the sum of salaries.
```java

```

## Problem 25
### Check if all employees belong to the same department.
```java

```

## Problem 26
### Find: - Total transaction amount per customer. - Highest spending customer.
```java

```

## Problem 27
### Find: - Top 5 selling products. - Revenue by product. - Revenue by customer.
```java

```

## Problem 28
### Find employees whose salary is above department average salary.

This is frequently asked in senior backend interviews.

Steps:

Calculate avg salary per department.
Filter employees whose salary > department average.
Tests:

groupingBy
averagingDouble
filter
```java

```

## Problem 29
### Implement SQL-like queries using Streams.

Examples:

SELECT department,
       MAX(salary)
FROM employee
GROUP BY department
Using Streams.
```java

```

## Problem 30
### Given:

List<Employee>
Find:

Department
    -> Highest Salary Employee
    -> Average Salary
    -> Employee Count
Output:

Map<String, DepartmentStats>
Where:

class DepartmentStats {
    Employee highestPaid;
    Double averageSalary;
    Long count;
}
This problem tests:

groupingBy
collectingAndThen
custom collector
Optional handling
DTO creation
```java

```
