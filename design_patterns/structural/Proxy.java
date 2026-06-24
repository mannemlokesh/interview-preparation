interface Image {
    void display();
}

class RealImage implements Image {
    
    private String image;
    
    public RealImage(String image) {
        this.image = image;
        
        loadImageFromDisk();
    }
    
    private void loadImageFromDisk() {
        System.out.println("Loading image :: " + image);
    }
    
    public void display() {
        System.out.println("Displaying image :: " + image);
    }
}

class ProxyImage implements Image {
    private String image;
    private RealImage real;
    
    public ProxyImage(String image) {
        this.image = image;
    }
    
    public void display() {
        if (real == null) {
            real = new RealImage(image);
        }
        
        real.display();
    }
}

public class Proxy {
    public static void main(String[] args) {
        
        Image i = new ProxyImage("image.png");
        i.display();
        
    }
}
