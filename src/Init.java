import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Init {
    // Hospital Objects

    //Remove V and W
    Hospital A = new Hospital("A",false, new String[]{"Y", "Z", "X"}, "");
    Hospital B = new Hospital("B",false, new String[]{"Y","X", "Z"}, "");
    Hospital C = new Hospital("C",false, new String[]{"Z", "X", "Y"}, "");
    // Hospital D = new Hospital("C",false, new String[]{"V", "Y", "X", "W", "Z"}, "");
    // Hospital E = new Hospital("C",false, new String[]{"W", "Y", "V", "Z", "X"}, "");

    // Student Objects
    // Student V = new Student("X", false, new String[]{"E","A","B","D","C"}, "");
    // Student W = new Student("X", false, new String[]{"C","B","D","A","E"}, "");
    Student X = new Student("X", false, new String[]{"B","C","A"}, "");
    Student Y = new Student("Y", false, new String[]{"A","C","B"}, "");
    Student Z = new Student("Z", false, new String[]{"B","C","A"}, "");

    // Group the objects for ease of access
    List<Hospital> hospitals = new ArrayList();
    List<Student> students = new ArrayList();

    public Init() {
        // Adds objects into an ArrayList
        addToArrayList();

        // Print the hospital table
        shortDisplayHospital();

        System.out.println(

        );
        // Print the student table
        shortDisplayStudent();

        System.out.println();

        System.out.println("Stable pair:");
        // Runs the algo
        findStable();

        // Print the results
        printStable();
    }



    public void printStable(){
        System.out.println("\nStable pairs");
        for(int i = 0; i < hospitals.size(); i++){
            System.out.format("%s - %s\n", hospitals.get(i).getName(), hospitals.get(i).getTakenBy());
        }


    }


    int num = 0;
    int choice = 0;
    boolean shouldCheck = true;
    int takenBy;
    int offered;
    // Index for hospitals
    int i = 0;
    // Index for hospitals losing their student
    int m = 0;

    public void findStable(){
        // Keep running until All of the hospitals are true
        // hospitals.get(i) 0 - A  1 - B 2 - C
        //|| D.isTaken() == false || E.isTaken() == false
        while(A.isTaken() == false || B.isTaken() == false || C.isTaken() == false ) {
            // Detect that Hospital A is false
            outer:
            if (hospitals.get(i).isTaken() == false) {


                // Keep running until Hospital A is true Go here

                while(hospitals.get(i).isTaken == false) {
                    // Hospital A finds their first choice
                    // If they are rejected the hospital will delete that choice and move on

                    // Hospital A is looking for their 'first' choice For this example it will be X

                    checkAgain:
                        if (hospitals.get(i).getListString(0).equals(students.get(num).getName()) && hospitals.get(i).isTaken == false) {

                            // If their choice isn't taken
                            if (students.get(num).isTaken == false) {
                                // The hospital is now taken, taken by student, and remove that choice from their list
                                hospitals.get(i).isTaken = true;
                                hospitals.get(i).setTakenBy(students.get(num).getName());
                                hospitals.get(i).getArrayList().remove(0);

                                students.get(num).isTaken = true;
                                students.get(num).setTakenBy(hospitals.get(i).getName());

                                // Reset the counter back to zero, just in case
                                num = 0;
                                i = 0;
                                break outer;
                            }
                            // Already taken, now see if they like their current or offered
                            else if (students.get(num).isTaken == true) {
                                // Get the pref of the hospital they are taken by {A,B,C}, 'B'
                                int takenByValue = binarySearch(students.get(num).choices, students.get(num).getTakenBy());

                                // Get the pref of the hospital they are offered by {A,B,C}, 'B'
                                String check = hospitals.get(i).getName();
                                int offeredValue = binarySearch(students.get(num).choices, hospitals.get(i).getName());

                                // They prefer the hospital they are assigned to compare to the offer
                                if (takenByValue < offeredValue) {
                                    // Remove that choice so they can ask their next candidate
                                    hospitals.get(i).getArrayList().remove(0);
                                    // Reset the counter and check again for a match for their new 'first' choice
                                    num = 0;
                                    i = 0;
                                    break checkAgain;
                                }
                                // The student prefers the offered hospital over the one they are taken by
                                else if (offered < takenBy) {
                                    m = 0;
                                    System.out.println("Better offer found");

                                    // Student gets taken by the current hospital This student was orginnal taken by A
                                    String studentTakenBy = students.get(num).getTakenBy();
                                    for (int j = 0; i < hospitals.size(); j++) {
                                        if (hospitals.get(j).getName().equals(studentTakenBy)) {
                                            // Found the hospital that the student ws taken by
                                            m = j;
                                            break;
                                        }
                                    }


                                    hospitals.get(i).isTaken = true;
                                    hospitals.get(i).setTakenBy(students.get(num).getName());
                                    hospitals.get(i).getArrayList().remove(0);

                                    students.get(num).isTaken = true;
                                    students.get(num).setTakenBy(hospitals.get(i).getName());

                                    // Taken hospita
                                    hospitals.get(m).isTaken = false;
                                    hospitals.get(m).setTakenBy("");
                                    hospitals.get(m).getArrayList().remove(0);
                                    i = 0;
                                    break outer;


                                }
                            }
                        }
                        // If Student[0] doesn't match, they will look at student[1] and student[2]
                        else{
                            // If the hospital isn't it, move on to the next one

                            num += 1;

                        }


                } // Keep looping until Hospital A is true  END OF WHILE LOOP

            }
            i+=1;
        }
    }




    // Place the objects into an ArrayList
    public void addToArrayList(){
        hospitals.add(A);
        hospitals.add(B);
        hospitals.add(C);
        // hospitals.add(D);
        // hospitals.add(E);

        // students.add(V);
        // students.add(W);
        students.add(X);
        students.add(Y);
        students.add(Z);
    }

    public void shortDisplayHospital(){
        System.out.println("Hospitals' Preference List");
        System.out.format("%s%d | %d | %d | %d | %d\n", "\t", 1, 2, 3, 4, 5);
        for(int i = 0; i < hospitals.size(); i++){
            System.out.printf("%s | ", hospitals.get(i).getName());
            for(int j = 0; j < hospitals.get(i).choices.length; j++){
                System.out.format("%s | ", hospitals.get(i).choices[j]);
            }
            System.out.println();

        }
    }

    public void shortDisplayStudent(){
        System.out.println("Students' Preference List");
        System.out.format("%s%d | %d | %d | %d | %d\n", "\t", 1, 2, 3, 4, 5);

        for(int i = 0; i < students.size(); i++){
            System.out.printf("%s | ", students.get(i).getName());
            for(int j = 0; j < students.get(i).choices.length; j++){
                System.out.format("%s | ", students.get(i).choices[j]);
            }
            System.out.println();

        }


    }

    // GEEKSFORGEEKS BINARY SEARCH
    // https://www.geeksforgeeks.org/binary-search-a-string/
    public int binarySearch(String[] arr, String x)
    {
        int prefValue = 0;
        for(int i = 0; i < students.size(); i++){
            if(arr[i].equals(x)){
                return i;
            }
        }
        return -1;

        // int initialValue = 0;
        // int arrayLength = arr.length - 1;
        // while (initialValue <= arrayLength) {
        //     int m = initialValue + (arrayLength - initialValue) / 2;
        //     int res = x.compareTo(arr[m]);
        //     // Check if x is present at mid
        //     if (res == 0)
        //         return m;
        //
        //     // If x greater, ignore left half
        //     if (res > 0)
        //         initialValue = m + 1;
        //
        //         // If x is smaller, ignore right half
        //     else
        //         arrayLength = m - 1;
        // }
        //
        // return -1;
    }
}
