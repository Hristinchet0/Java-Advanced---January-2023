package codingTracker;

import java.io.Serializable;

public class Example implements Serializable {

    private static final String nickName = "Pinguin";
    public String name;
    protected String webAddress;
    String email;
    private int zip;

    public Example() {
        this.setName("Java");
        this.setWebAddress("oracle.com");
        this.setEmail("mail@oracle.com");
        this.setZip(1407);
    }

    private Example(String name, String webAddress, String email) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    protected Example(String name, String webAddress, String email, int zip) {
        this.setName(name);
        this.setWebAddress(webAddress);
        this.setEmail(email);
        this.setZip(2300);
    }

    @Author(name = "Aleksandar")
    public final String getName() {
        return name;
    }

    @Author(name = "Pesho")
    private void setName(String name) {
        this.name = name;
    }

    @Author(name = "Gosho")
    protected String getWebAddress() {
        return webAddress;
    }

    private void setWebAddress(String webAddress) {
        this.webAddress = webAddress;
    }

    public String getEmail() {
        return email;
    }

    @Author(name = "Dragan")
    public void setEmail(String email) {
        this.email = email;
    }

    @Author(name = "Petkan")
    protected final int getZip() {
        return zip;
    }

    @Author(name = "Hristina")
    private void setZip(int zip) {
        this.zip = zip;
    }

    public String toString() {
        String result = "Name: " + getName() + "\n";
        result += "WebAddress: " + getWebAddress() + "\n";
        result += "email: " + getEmail() + "\n";
        result += "zip: " + getZip() + "\n";
        return result;
    }
}
