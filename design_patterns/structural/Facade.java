
class Engine {
    public void startEngine() {
        System.out.println("Engine Started");
    }
}

class FuelPump {
    public void supplyFuel() {
        System.out.println("Fule Supply Started");
    }
}

class Battery {
    public void supplyPower() {
        System.out.println("Supplying Power Started");
    }
}

class CarFacade {
    private Battery battery;
    private FuelPump fuel;
    private Engine engine;
    
    public CarFacade() {
        battery = new Battery();
        fuel = new FuelPump();
        engine = new Engine();
    }
    
    public void startCar() {
        battery.supplyPower();
        fuel.supplyFuel();
        engine.startEngine();
    }
}


public class Facade {
    public static void main(String[] args) {
        
        CarFacade facade = new CarFacade();
        facade.startCar();
    }
}
