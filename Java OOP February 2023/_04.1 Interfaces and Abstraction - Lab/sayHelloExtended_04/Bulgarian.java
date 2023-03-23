package sayHelloExtended_04;

public class Bulgarian extends BasePerson{
    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
