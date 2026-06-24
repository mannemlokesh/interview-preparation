import java.util.List;
import java.util.ArrayList;

interface Employee {
    void showDetails();
}

class Developer implements Employee {
    
    private String name;
    
    public Developer(String name) {
        this.name = name;
    }
    
    public void showDetails() {
        System.out.println("Developer :: " + name);
    }
}

class Manager implements Employee {
    private String name;
    
    private List<Employee> team = new ArrayList<Employee>();
    
    public Manager(String name) {
        this.name = name;
    }
    
    public void add(Employee employee) {
        team.add(employee);
    }
    
    public void showDetails() {
        
        System.out.println("Manager :: " + name);
        for(Employee emp : team) {
            emp.showDetails();
        }
    }
}


public class Composite {
    public static void main(String[] args) {
        
        Developer d1 = new Developer("Lokesh");
        Developer d2 = new Developer("Karthik");
        
        Manager manager = new Manager("Ram");
        manager.add(d1);
        manager.add(d2);
        
        manager.showDetails();
    }
}
