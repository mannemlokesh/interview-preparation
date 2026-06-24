import java.util.List;
import java.util.ArrayList;

interface Employee {
    void showDetails(String indent);
}

class Developer implements Employee {
    
    private String name;
    
    public Developer(String name) {
        this.name = name;
    }
    
    public void showDetails(String indent) {
        System.out.println(indent + "Developer :: " + name);
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
    
    public void showDetails(String indent) {
        
        System.out.println(indent + "Manager :: " + name);
        for(Employee emp : team) {
            emp.showDetails(indent + "  ");
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
        Manager manager2 = new Manager("Vignesh");
        manager2.add(manager);
        manager2.showDetails("");
    }
}
