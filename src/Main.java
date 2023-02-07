import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Doan", "CodeGym"));
        students.add(new Student(2, "Huy", "CodeGym"));
        students.add(new Student(3, "Luc", "CodeGym"));

        writeFile(students, "demo.dat");

        List<Student> studentList;
        studentList = readFile("demo.dat");
        System.out.println(studentList);
    }
    public static void writeFile(List<Student> students, String fileName) {
        File file = new File(fileName);
        try {
            OutputStream outputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Student> readFile(String fileName) {
        File file = new File(fileName);
        try {
            InputStream inputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            List<Student> students = (List<Student>) objectInputStream.readObject();
            return students;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}