import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentServiceTest {

    @Test
    public void testAddStudent() {
        StudentService service = new StudentService();

        service.addStudent("Rahul");

        assertEquals(1, service.getCount());
    }

    @Test
    public void testAddTwoStudents() {
        StudentService service = new StudentService();

        service.addStudent("Rahul");
        service.addStudent("Amit");

        assertEquals(2, service.getCount());
    }

    @Test
    public void testInvalidName() {
        StudentService service = new StudentService();

        assertThrows(IllegalArgumentException.class,
                () -> service.addStudent(""));
    }

    public static void main(String[] args) {
        StudentServiceTest test = new StudentServiceTest();
        test.testAddStudent();
        System.out.println("testAddStudent: PASSED");
        test.testAddTwoStudents();
        System.out.println("testAddTwoStudents: PASSED");
        test.testInvalidName();
        System.out.println("testInvalidName: PASSED");
        System.out.println("All Practical 1 tests passed successfully.");
    }
}
