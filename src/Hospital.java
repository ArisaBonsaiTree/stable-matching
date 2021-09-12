import java.util.ArrayList;

//Comment
public class Hospital {
    String name;
    boolean isTaken;
    String[] choices;
    String takenBy;
    int startCount = 0;
    ArrayList<String> list = new ArrayList<>();


    public Hospital(String name, boolean isTaken, String[] choices, String takenBy) {
        this.name = name;
        this.isTaken = isTaken;
        this.choices = choices;
        this.takenBy = takenBy;
        // Add the values of choice into an array list so we can remove it
        for(int i = 0; i < choices.length; i++){
            list.add(choices[i]);
        }
    }

    // Access to the values
    public String getListString(int i) {
        return list.get(i);
    }

    // Access to the list
    public ArrayList<String> getArrayList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public int getStartCount() {
        return startCount;
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public String getChoices(int n) {
        return choices[n];
    }

    public void setChoices(int n, String input) {
        choices[n] = input;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }
}
