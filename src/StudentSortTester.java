import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Creates Student objects that are grouped into studentList array
 * Contains overriding sort method and overriding toString method
 * Contains main method that allows user to interact with the class
 */
public class StudentSortTester {
    /**
     * Allows attribute rollno to increment each time parameterized constructor is used
     */
    private static int nextRollNo = 1;
    /**
     * The Roll Number of each Student object
     */
    private int rollno;
    /**
     * The full name of each Student object
     */
    private String studentName;
    /**
     * The address of each Student object
     */
    private String studentAddress;

    /**
     * Constructs new instance of the Student class
     * Increments attribute "nextRollNo"
     * @param studentName
     * @param studentAddress
     */
    public StudentSortTester (String studentName, String studentAddress){
        this.rollno = nextRollNo;
        nextRollNo++;
        this.studentName = studentName;
        this.studentAddress = studentAddress;}

    /**
     * @return Student's Roll Number
     */
    public int getRollno() {
        return rollno;
    }
    /**
     * @return Student's full name
     */
    public String getStudentName(){
        return studentName;
    }

    /**
     * @return Student's address
     */
    public String getStudentAddress(){
        return studentAddress;}

    /**
     * sorts array "studentList" according to a comparator of class StudentSortTester
     * @param studentList
     * @param comparator
     */
    public static void sort(StudentSortTester[] studentList, Comparator<StudentSortTester> comparator){
        int n = studentList.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(comparator.compare(studentList[j], studentList[j + 1]) > 0) {
                    StudentSortTester temp = studentList[j];
                    studentList[j] = studentList[j + 1];
                    studentList[j + 1] = temp;
                }}}}

    /**
     * @return a string that specifies a student's Roll Number, name, and address
     */
    public String toString() {
        return "\n\nStudent Roll Number: " + rollno +
                "\nStudent Name: " + studentName +
                "\nStudent Address: " + studentAddress +
                "\n";
    }

    /**
     * Allows users to interact with program by entering names and addresses for 10 StudentSortTester
     * objects and also choose from a menu of options to sort and view Student objects
     * @param args
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        StudentSortTester[] studentList = new StudentSortTester[10];
        for (int i = 0; i < studentList.length; i++) {
            try {
                System.out.println("Enter student Name: ");
                String sName = scnr.nextLine();
                System.out.println("Enter student address: ");
                String sAddress = scnr.nextLine();
                StudentSortTester student = new StudentSortTester(sName, sAddress);
                studentList[i] = student;
            }catch(InputMismatchException e ){
                System.out.println("Error: Enter valid string.");
                scnr.close();}}
        boolean continueLoop = true;
        while(continueLoop) {
            Scanner scan = new Scanner(System.in);
            try {
                System.out.println("Select option by number: \n" +
                        "1. Sort Students by Roll Number \n" +
                        "2. Sort Students by Name \n" +
                        "3. Print All Student Information \n" +
                        "4. Quit Program");
                int userChoice = scnr.nextInt();
                if ((userChoice < 1) || (userChoice > 4)) {
                    System.out.println("Please enter integer between 1 and 4");
                } else if (userChoice == 1) {
                    StudentSortTester.sort(studentList, new StudentComparatorRollno());
                    System.out.println("\n\nList has been sorted by Roll Number.\n\n");
                } else if (userChoice == 2) {
                    StudentSortTester.sort(studentList, new StudentComparatorName());
                    System.out.println("\n\nList has been sorted by name.\n\n");
                } else if (userChoice == 3) {
                    String studentsString = Arrays.toString(studentList);
                    System.out.println(studentsString);
                } else {
                    continueLoop = false;
                    System.out.println("Goodbye.");
                }
            }catch(InputMismatchException e ){
                System.out.println("Error: Please enter valid integer");
                scnr.nextLine();
            }}
        scnr.close();}}

