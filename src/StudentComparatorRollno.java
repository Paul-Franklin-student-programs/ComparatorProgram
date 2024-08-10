import java.util.Comparator;

/**
 * Empowers the Student class to effectively sort the studentList array
 * on the basis of Roll Number
 */
public class StudentComparatorRollno implements Comparator<StudentSortTester> {
    @Override
    public int compare(StudentSortTester s1, StudentSortTester s2) {
        return Integer.compare(s1.getRollno(), s2.getRollno());
    }
}
