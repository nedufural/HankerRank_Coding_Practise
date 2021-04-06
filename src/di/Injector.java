package di;

public class Injector {
    public static void main(String[] args) {
        ServiceB  serviceB = new IServiceC();
        ClientA clientA = new ClientA(serviceB);
        clientA.getInfo();
    }
}
