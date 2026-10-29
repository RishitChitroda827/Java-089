import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Run {}

class MyTests {
    @Run
    public void testAddition() {
        System.out.println("Addition test passed");
    }

    @Run
    public void testSubtraction() {
        System.out.println("Subtraction test passed");
    }

    public void normalMethod() {
        System.out.println("This method will not run");
    }
}

public class MiniTestRunner {
    public static void main(String[] args) throws Exception {
        MyTests obj = new MyTests();
        int count = 0;

        for (Method m : obj.getClass().getDeclaredMethods()) {
            if (m.isAnnotationPresent(Run.class)
                    && m.getParameterCount() == 0) {
                m.invoke(obj);
                count++;
            }
        }

        System.out.println("Tests executed: " + count);
    }
}
