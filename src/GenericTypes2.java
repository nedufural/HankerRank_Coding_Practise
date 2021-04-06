

public class GenericTypes2<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }

        public static void main(String[] args) {
            GenericTypes2<Integer> integerBox = new GenericTypes2<>();
            GenericTypes2<String> stringBox = new GenericTypes2<>();

            integerBox.add(10);
            stringBox.add("Hello World");

            System.out.printf("Integer Value :%d\n\n", integerBox.get());
            System.out.printf("String Value :%s\n", stringBox.get());
        }
    }

