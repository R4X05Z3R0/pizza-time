public class Customer {
    String name;
    String phoneNumber;

    public Customer( String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", getName(), getPhoneNumber());
    }
}
