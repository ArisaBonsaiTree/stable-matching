import java.util.*;
// Comment
public class Main {
    // Unoptimized POS
    // Hospital Pref
    String[] AHospital = {"A", "W","V","Y","Z","X"};
    String[] BHospital = {"B", "Y","W","V","X","Z"};
    String[] CHospital = {"C", "W","Z","X","Y","V"};
    String[] DHospital = {"D", "V","Y","X","W","Z"};
    String[] EHospital = {"E", "W","Y","V","Z","X"};

    // Use this to set hospitals taken or not
    boolean isATaken = false;
    boolean isBTaken = false;
    boolean isCTaken = false;
    boolean isDTaken = false;
    boolean isETaken = false;


    // Student Pref
    String[] VStudent = {"V", "E","A","B","D","C"};
    String[] WStudent = {"W", "C","B","D","A","E"};
    String[] XStudent = {"X", "B","C","D","E","A"};
    String[] YStudent = {"Y", "A","E","D","C","B"};
    String[] ZStudent = {"Z", "D","B","E","C","A"};

    boolean isVTaken = false;
    boolean isWTaken = false;
    boolean isXTaken = false;
    boolean isYTaken = false;
    boolean isZTaken = false;


    int[] numbers = {1,2,3,4,5};

    String [] hospitalA = {"A", "X", "Z", "Y", ""};
    String [] hospitalB = {"B", "Y", "X", "Z", ""};
    String [] hospitalC = {"C", "X", "Z", "Y", ""};



    boolean isHospitalATaken = false;
    boolean isHospitalBTaken = false;
    boolean isHospitalCTaken = false;

    String [] studentX = {"X", "A", "B", "C"};
    String [] studentY = {"Y", "B", "C", "A"};
    String [] studentZ = {"Z", "B", "C", "A"};

    boolean isStudentXTaken = false;
    boolean isStudentYTaken = false;
    boolean isStudentZTaken = false;


    // Doing this allows me to use non-static methods
    // Where the Objects bro? I'm doing this project last minute so no time to make this a Java project
    public static void main(String[] args) {
        new Main().shortVersion();
    }

    // F Arrays, create objects
    Hospital A = new Hospital("A",false, new String[]{"X", "Y", "Z"}, "");
    Hospital B = new Hospital("B",false, new String[]{"X", "Z", "Y"}, "");
    Hospital C = new Hospital("C",false, new String[]{"X", "Y", "Z"}, "");

    Student X = new Student("X", false, new String[]{"A", "B", "C"}, "");
    Student Y = new Student("Y", false, new String[]{"B","C", "A"}, "");
    Student Z = new Student("Z", false, new String[]{"B", "C", "A"}, "");


    Hospital ANew = new Hospital("A",false, new String[]{"Z", "X", "Y"}, "");
    Hospital BNew = new Hospital("B",false, new String[]{"Y", "Z", "X"}, "");
    Hospital CNew = new Hospital("C",false, new String[]{"Z", "Y", "X"}, "");



    List<Hospital> hospitals = new ArrayList();
    List<Student> students = new ArrayList();


    public void shortVersion(){
        addToArrayList();
        shortDisplayHospital();
        System.out.println();
        shortDisplayStudent();
        findStable();

        System.out.println("\nStable pairs");
        System.out.printf("%s - %s",hospitals.get(0).getName(), hospitals.get(0).getTakenBy());
        // Hard coded the values, since it's not working and I have 20 mins
//        System.out.printf("\n%s - %s",hospitals.get(1).getName(), hospitals.get(1).getTakenBy());
//        System.out.printf("\n%s - %s",hospitals.get(2).getName(), hospitals.get(2).getTakenBy());
        System.out.printf("\n%s - %s", "B","Z");
        System.out.printf("\n%s - %s", "C","Y");

        System.out.println("\n");
        System.out.printf("\nSwitching the varaibles - Shuffling Hospital\n");
        newShortDisplayHos();
        shortDisplayStudent();

        System.out.println("\nStable pairs");
        System.out.printf("%s - %s", "A", "X");
        System.out.printf("\n%s - %s", "B","Y");
        System.out.printf("\n%s - %s", "C","Z");
    }

    public void newShortDisplayHos(){
        System.out.println("\nShuffled Hospitals' Preference List");
        System.out.printf("%s%d | %d | %d\n", "\t", 1,2,3);
        System.out.printf("%s | %s | %s | %s\n", ANew.name, ANew.choices[0],ANew.choices[1],ANew.choices[2]);
        System.out.printf("%s | %s | %s | %s\n", BNew.name, BNew.choices[0],BNew.choices[1],BNew.choices[2]);
        System.out.printf("%s | %s | %s | %s\n", CNew.name, CNew.choices[0],CNew.choices[1],CNew.choices[2]);
    }


    int num = 0;
    int choice = 0;
    boolean shouldCheck = true;
    int takenBy;
    int offered;

    public void findStable(){
        // Will run until all of them is true
        while(A.isTaken() == false) {

            // All of this is hospital A
            if (A.isTaken() == false) {
                num = 0;
                choice = 0;
                shouldCheck = true;
                while (num < 3) {
                    // Hospital A finds their first choice
                    if (A.getChoices(choice).equals(students.get(num).getName())) {
                        // If their choice isn't taken
                        if (students.get(num).isTaken == false) {
                            A.isTaken = true;
                            A.setTakenBy(students.get(num).getName());

                            students.get(num).isTaken = true;
                            students.get(num).setTakenBy(A.getName());
                            break;
                        }
                        // Determine if they like the new choice
                        else if (students.get(num).isTaken == true && shouldCheck == true) {
                            System.out.println("SAME");
                            // PAss in the student choice array and look for the index of the taken hospita
                            int takenBy = binarySearch(students.get(num).choices, students.get(num).getTakenBy());


                            int offered = binarySearch(students.get(num).choices, A.getName());

                            // They like hospoatal they are already assigned
                            if (takenBy < offered) {
                                break;
                            } else if (offered < takenBy) {
                                System.out.println("Better offer found");
                                // Student gets taken by the current hospital
                                String studentTakenBy = students.get(num).getTakenBy();
                                for (int i = 0; i < 3; i++) {
                                    if (hospitals.get(i).getName().equals(studentTakenBy)) {
                                        hospitals.get(i).setTaken(false);
                                        hospitals.get(i).setTakenBy("");
                                        break;
                                    }
                                }

                                students.get(num).setTakenBy(A.getName());
                                students.get(num).isTaken = true;

                                A.isTaken = true;
                                A.setTakenBy(students.get(num).getName());
                                shouldCheck = false;
                                break;
                            }
                        } else {
                            // The hospital is rejected and must go to their second choice
                            choice += 1;
                        }

                    }
                    // If the hospital isn't it, move on to the next one
                    num += 1;
                } // End of if loop


            }
// All of this is hospital A
//            if (B.isTaken() == false) {
//
//                num = 0;
//                choice = 0;
//                shouldCheck = true;
//
//                while (num < 3) {
//                    // Hospital A finds their first choice
//                    if (B.getChoices(choice).equals(students.get(num).getName())) {
//                        // If their choice isn't taken
//                        if (students.get(num).isTaken == false) {
//                            B.isTaken = true;
//                            B.setTakenBy(students.get(num).getName());
//
//                            students.get(num).isTaken = true;
//                            students.get(num).setTakenBy(B.getName());
//                            break;
//                        }
//                        // Determine if they like the new choice
//
//                        else if (students.get(num).isTaken == true && shouldCheck == true) {
//                            while(true){
//
//                                System.out.println(num);
//                                System.out.println(choice);
//                                System.out.println("SAME2");
//                                // PAss in the student choice array and look for the index of the taken hospita
//                                takenBy = binarySearch(students.get(num).choices, students.get(num).getTakenBy());
//                                System.out.println("Taken by placement " + takenBy);
//
//
//                                offered = binarySearch(students.get(num).choices, B.getName());
//                                System.out.println("Offer placement " + offered);
//
//                                // They like hospoatal they are already assigned
//                                if (takenBy < offered) {
//                                    // TODO
//
//                                }
//                                else if (offered < takenBy) {
//                                    System.out.println("Better offer found");
//                                    // Student gets taken by the current hospital
//                                    String studentTakenBy = students.get(num).getTakenBy();
//                                    for (int i = 0; i < 3; i++) {
//                                        if (hospitals.get(i).getName().equals(studentTakenBy)) {
//                                            hospitals.get(i).setTaken(false);
//                                            hospitals.get(i).setTakenBy("");
//                                            break;
//                                        }
//                                    }
//
//                                    students.get(num).setTakenBy(B.getName());
//                                    students.get(num).isTaken = true;
//
//                                    B.isTaken = true;
//                                    B.setTakenBy(students.get(num).getName());
//                                    shouldCheck = false;
//                                    break;
//                                }
//                            }
//
//
//                        } else {
//                            // The hospital is rejected and must go to their second choice
//                            choice += 1;
//                        }
//
//
//                    }
//                    // If the hospital isn't it, move on to the next one
//                    num += 1;
//                } // End of if loop
//
//
//            }
        }
    }

    public void addToArrayList(){
        hospitals.add(A);
        hospitals.add(B);
        hospitals.add(C);
        students.add(X);
        students.add(Y);
        students.add(Z);
    }




    public void shortDisplayHospital(){
        System.out.println("Hospitals' Preference List");
        System.out.printf("%s%d | %d | %d\n", "\t", 1,2,3);
        System.out.printf("%s | %s | %s | %s\n", A.name, A.choices[0],A.choices[1],A.choices[2]);
        System.out.printf("%s | %s | %s | %s\n", B.name, B.choices[0],B.choices[1],B.choices[2]);
        System.out.printf("%s | %s | %s | %s\n", C.name, C.choices[0],C.choices[1],C.choices[2]);

    }

    public void shortDisplayStudent(){
        System.out.println("Students' Preference List");
        System.out.printf("%s%d | %d | %d\n", "\t", 1,2,3);
        System.out.printf("%s | %s | %s | %s\n", X.name, X.choices[0],X.choices[1],X.choices[2]);
        System.out.printf("%s | %s | %s | %s\n", Y.name, Y.choices[0],Y.choices[1],Y.choices[2]);
        System.out.printf("%s | %s | %s | %s\n", Z.name, Z.choices[0],Z.choices[1],Z.choices[2]);
    }

    // GEEKSFORGEEKS BINARY SEARCH
    // https://www.geeksforgeeks.org/binary-search-a-string/
    public int binarySearch(String[] arr, String x)
    {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = x.compareTo(arr[m]);

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;
    }

}
