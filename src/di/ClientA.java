package di;

public class ClientA {
    private ServiceB serviceB;

    ClientA(ServiceB serviceB){
        this.serviceB = serviceB;
    }

    public void getInfo(){
        String info = serviceB.doSomething();
        System.out.println(info);
    }
}
