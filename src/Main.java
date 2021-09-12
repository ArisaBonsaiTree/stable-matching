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


    public static void main(String[] args) {
        new Main().runMe();
    }

    // Use Me so I can run objects and such
    public void runMe(){
        displayHospital();
        System.out.println();
        displayStudent();
    }


    // YES I AM AWARE THIS IS ALL COD DUPLICATIOPNS!!!
    public void displayHospital(){
        System.out.println("Hospitals' Preference List");
        System.out.printf("%s%d | %d | %d | %d | %d\n", "\t",numbers[0],numbers[1],numbers[2],numbers[3], numbers[4]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", AHospital[0], AHospital[1], AHospital[2], AHospital[3], AHospital[4], AHospital[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", BHospital[0], BHospital[1], BHospital[2], BHospital[3], BHospital[4], BHospital[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", CHospital[0], CHospital[1], CHospital[2], CHospital[3], CHospital[4], CHospital[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", DHospital[0], DHospital[1], DHospital[2], DHospital[3], DHospital[4], DHospital[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", EHospital[0], EHospital[1], EHospital[2], EHospital[3], EHospital[4], EHospital[5]);
    }

    public void displayStudent(){
        System.out.println("Students' Preference List");
        System.out.printf("%s%d | %d | %d | %d | %d\n", "\t",numbers[0],numbers[1],numbers[2],numbers[3], numbers[4]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", VStudent[0], VStudent[1], VStudent[2], VStudent[3], VStudent[4], VStudent[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", WStudent[0], WStudent[1], WStudent[2], WStudent[3], WStudent[4], WStudent[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", XStudent[0], XStudent[1], XStudent[2], XStudent[3], XStudent[4], XStudent[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", YStudent[0], YStudent[1], YStudent[2], YStudent[3], YStudent[4], YStudent[5]);
        System.out.printf("%s | %s | %s | %s | %s | %s\n", ZStudent[0], ZStudent[1], ZStudent[2], ZStudent[3], ZStudent[4], ZStudent[5]);
    }
}
