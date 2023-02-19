package Student;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {

        if (students.size() == 0) {

            students.add(student);

            return String.format
                    ("Added student %s %s", student.getFirstName(), student.getLastName());

        }

        if (capacity > students.size()) {
            for (Student s : students) {
                if (!s.getFirstName().equals(student.getFirstName())
                        && !s.getLastName().equals(student.getLastName())) {
                    students.add(student);

                    return String.format
                            ("Added student %s %s", s.getFirstName(), s.getLastName());
                } else {
                    return "Student is already in the university.";

                }
            }
        }
        return "No seats in the university";
    }

    public String dismissStudent(Student student) {

        for (Student s : students) {
            if (s.getFirstName().equals(student.getFirstName())
                    && s.getLastName().equals(student.getLastName())) {
                students.remove(student);

                return String.format
                        ("Removed student  %s %s", s.getFirstName(), s.getLastName());
            }
        }
        return String.format("Student not found.");
    }

    public Student getStudent(String firstName, String lastName) {

        Student searchedStudent = null;

        for (Student s : students) {
            if (s.getFirstName().equals(firstName)
                    && s.getLastName().equals(lastName)) {
                searchedStudent = s;
            }
        }

        return searchedStudent;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        for (Student s : students) {
            sb.append(s.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
