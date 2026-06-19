class User {
    private String name;
    private String email;
    private Integer age;
    
    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
    }
    
    
    public String toString() {
        return "{'name': " + name + ", 'email': " + email + " , 'age': " + age + "}";
    }
    
    static class Builder {
        private String name;
        private String email;
        private Integer age;
        
        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        
        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }
        
        public Builder setAge(Integer age) {
            this.age = age;
            return this;
        }
        
        public User build() {
            return new User(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        User user = new User.Builder()
                    .setName("lokesh")
                    .setEmail("mannemlokesh@gmail.com")
                    .setAge(24)
                    .build();
                    
        System.out.println(user);
        
    }
}
