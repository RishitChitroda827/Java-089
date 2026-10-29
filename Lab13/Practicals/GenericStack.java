package Lab13;

class Stack<T> {
    T[] arr;
    int top = -1;

    @SuppressWarnings("unchecked")
    Stack(int size) {
        arr = (T[]) new Object[size];
    }

    void push(T value) {
        if (top == arr.length - 1) {
            System.out.println("Stack is full");
        } else {
            arr[++top] = value;
        }
    }

    T pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return arr[top--];
        }
    }
}

public class GenericStack {
    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>(5);
        s1.push(10);
        s1.push(20);

        System.out.println(s1.pop());

        Stack<String> s2 = new Stack<>(5);
        s2.push("Java");
        s2.push("Python");

        System.out.println(s2.pop());
        System.out.println(s2.pop());
        System.out.println(s2.pop());
    }
}

