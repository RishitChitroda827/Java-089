
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

class Student {
    @Column(name = "name")
    String name;

    @Column(name = "age")
    int age;

    @Column(name = "city")
    String city;

    public void display() {
        System.out.println(name + " " + age + " " + city);
    }
}

public class ColumnExample {
    public static void main(String[] args) throws Exception {
        String[] header = {"name", "age", "city"};
        String[] data = {"Rahul", "20", "Ahmedabad"};

        Student s = new Student();

        for (Field f : Student.class.getDeclaredFields()) {
            if (!f.isAnnotationPresent(Column.class)) {
                continue;
            }

            String columnName =
                f.getAnnotation(Column.class).name();

            boolean found = false;

            for (int i = 0; i < header.length; i++) {
                if (header[i].equals(columnName)) {
                    f.setAccessible(true);

                    if (f.getType() == int.class) {
                        f.setInt(s, Integer.parseInt(data[i]));
                    } else {
                        f.set(s, data[i]);
                    }

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println(
                    "Missing column: " + columnName);
            }
        }

        s.display();
    }
}
