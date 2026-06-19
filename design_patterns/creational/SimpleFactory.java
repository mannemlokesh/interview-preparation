interface Logger {
    void logMessage(String message);
}

class ConsoleLogger implements Logger {
    
    public void logMessage(String message) {
        System.out.println("ConsoleLogger :: " + message);
    }
}

class FileLogger implements Logger {
    
    public void logMessage(String message) {
        System.out.println("FileLogger :: " + message);
    }
}

class LoggerFactory {
    
    public static Logger getLogger(String type) {
        return switch(type.toLowerCase()) {
          case "console" -> new ConsoleLogger();
          case "file" -> new FileLogger();
          default -> throw new IllegalArgumentException("Unkonwn type " + type);
        };
    } 
}

public class SimpleFactory {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger("console");
        logger.logMessage("Hi...");
        
    }
}
