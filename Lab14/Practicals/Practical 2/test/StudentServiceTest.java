package test;

import service.StudentService;
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

    @Test
    public void testSaveAndReloadData() throws Exception {
        StudentService service1 = new StudentService();
        service1.addStudent("Rahul");
        service1.addStudent("Amit");

        String filename = "students_test.dat";
        service1.saveToFile(filename);

        StudentService service2 = new StudentService();
        service2.loadFromFile(filename);

        assertEquals(service1.getCount(), service2.getCount());
        assertEquals(service1.getStudents(), service2.getStudents());

        new java.io.File(filename).delete();
    }

    public static void main(String[] args) throws Exception {
        StudentServiceTest test = new StudentServiceTest();
        test.testAddStudent();
        System.out.println("testAddStudent: PASSED");
        test.testAddTwoStudents();
        System.out.println("testAddTwoStudents: PASSED");
        test.testInvalidName();
        System.out.println("testInvalidName: PASSED");
        test.testSaveAndReloadData();
        System.out.println("testSaveAndReloadData: PASSED");
        System.out.println("All Practical 2 tests passed successfully.");
    }
}
