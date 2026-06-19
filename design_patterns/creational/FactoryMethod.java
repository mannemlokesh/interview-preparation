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

interface LoggerFactory {
    Logger createLogger();
}

class ConsoleLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        return new ConsoleLogger();
    }
}

class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        return new FileLogger();
    }
}

public class FactoryMethod {
    public static void main(String[] args) {
        LoggerFactory factory = new ConsoleLoggerFactory();
        Logger logger = factory.createLogger();
        logger.logMessage("Hi...");
    }
}
