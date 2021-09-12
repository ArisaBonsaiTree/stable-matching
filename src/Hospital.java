//Comment
public class Hospital {
    String name;
    boolean isTaken = false;
    String[] choices;
    String takenBy;
    int startCount = 0;

    public Hospital(String name, boolean isTaken, String[] choices, String takenBy) {
        this.name = name;
        this.isTaken = isTaken;
        this.choices = choices;
        this.takenBy = takenBy;
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
