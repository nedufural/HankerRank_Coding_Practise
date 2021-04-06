public class InterfaceExtendsInterface implements B1{
    @Override
    public void printInterfaceName() {
        System.out.println("A1");
    }

    @Override
    public void printInterfaceStatus() {
        System.out.println("B1");
    }

    public static void main(String[] args) {
        InterfaceExtendsInterface interfaceExtendsInterface = new InterfaceExtendsInterface();
        interfaceExtendsInterface.printInterfaceName();
        interfaceExtendsInterface.printInterfaceStatus();
    }
}

interface A1 {
    void printInterfaceName();
}
interface B1 extends A1{
    void printInterfaceStatus();
}
