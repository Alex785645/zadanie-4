import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
    public String groupName;
    public List<Student> students;

    public StudentGroup(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() >= 15) {
            throw new IllegalStateException("Maximum number of students in group reached");
        }
        if (students.contains(student)) {
            throw new IllegalStateException("Student is already in the group");
        }
        students.add(student);
    }
}
