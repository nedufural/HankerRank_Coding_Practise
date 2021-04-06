


public class GenericTypes implements CheckGenerics {

    public static void main(String[] args) {
        GenericTypes genericType = new GenericTypes();
        int result = (int) genericType.getAdditions(3);
        String result2 = (String) genericType.getAdditions("dog");
        System.out.println(result);
        System.out.println(result2);
    }


    @Override
    public Object getAdditions(Object sum) {
        return sum;
    }
}

interface CheckGenerics<T>{
    <T> T getAdditions(T sum);

}