package service;

import model.Student;
import java.io.*;
import java.util.ArrayList;

public class StudentService {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }

        students.add(new Student(name));
    }

    public int getCount() {
        return students.size();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(students);
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            students = (ArrayList<Student>) in.readObject();
        }
    }
}
