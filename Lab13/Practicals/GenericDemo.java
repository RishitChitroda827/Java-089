package Lab13;

class Box<T> {
    T value;

    void set(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }
}

class Pair<A, B> {
    A first;
    B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    void display() {
        System.out.println(first + " " + second);
    }
}

public class GenericDemo {

    static <T> T first(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Box value: " + b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Java");
        System.out.println("Box value: " + b2.get());

        Pair<String, Integer> p =
            new Pair<>("Rahul", 20);
        p.display();

        String[] names = {"Amit", "Rahul", "Neha"};
        System.out.println("First name: " + first(names));

        Integer[] numbers = {10, 20, 30};
        System.out.println("First number: " + first(numbers));
    }
}

