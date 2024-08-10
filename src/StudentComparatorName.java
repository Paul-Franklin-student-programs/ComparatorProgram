import java.util.Comparator;

/**
 * Empowers the Student class to effectively sort the studentList array
 * on the basis of student name
 */
public class StudentComparatorName implements Comparator<StudentSortTester> {
    @Override
    public int compare(StudentSortTester s1, StudentSortTester s2) {
        return CharSequence.compare(s1.getStudentName(), s2.getStudentName());
    }
}