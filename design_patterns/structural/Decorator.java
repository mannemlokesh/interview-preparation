interface Coffee {
    String getDescription();
    
    Double getCost();
}

class SimpleCoffee implements Coffee {
    
    public String getDescription() {
        return "Simple Coffee";
    }
    
    public Double getCost() {
        return 2d;
    }
}

abstract class CoffeeDecorator implements Coffee {
    
    protected Coffee coffee;
    
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
    
    public String getDescription() {
        return coffee.getDescription();
    }
    
    public Double getCost() {
        return coffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {
    
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }
    
    public String getDescription() {
        return coffee.getDescription() + ", Milk is added";
    }
    
    public Double getCost() {
        return coffee.getCost() + 2;
    }
}

class SugarDecorator extends CoffeeDecorator {
    
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }
    
    public String getDescription() {
        return coffee.getDescription() + ", Sugar is added";
    }
    
    public Double getCost() {
        return coffee.getCost() + 1;
    }
}

public class Decorator {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);
        
        System.out.println("Description :: " + coffee.getDescription() + "\nTotal Cost :: " + coffee.getCost());
    }
}
