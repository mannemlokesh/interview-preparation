interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsCheckbox implements Checkbox {
    
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

class MacCheckbox implements Checkbox {
    
    public void render() {
        System.out.println("Rendering Mac Checkbox");
    }
}

class MacButton implements Button {
    
    public void render() {
        System.out.println("Rendering Mac Button");
    }
}

class WindowsButton implements Button {
    
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

interface UiFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsUiFactory implements UiFactory {
    
    public Button createButton() {
        return new WindowsButton();
    }
    
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacUiFactory implements UiFactory {
    
    public Button createButton() {
        return new MacButton();
    }
    
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        UiFactory factory = new MacUiFactory();
        Button button = factory.createButton();
        button.render();
        Checkbox checkbox = factory.createCheckbox();
        checkbox.render();
    }
}
