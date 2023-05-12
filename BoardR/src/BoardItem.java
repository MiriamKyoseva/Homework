import java.time.LocalDate;

public class BoardItem {
    private String title;
    private LocalDate dueDate;
    private enum Status {
        OPEN("Open"),
        TO_DO("To Do"),
        IN_PROGRESS("In Progress"),
        DONE("Done"),
        VERIFIED("Verified");
        public final String label;
        private Status(String label) {
            this.label = label;
        }
    }
    Status status;
    public BoardItem (String title, LocalDate dueDate) {
        setTitle(title);
        setDueDate(dueDate);
        status = Status.OPEN;
        Board.items.add(this);
    }

    public String getTitle(){
        return title;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    public Status getStatus(){
        return status;
    }
    public void setTitle(String title){
        if (title == null) throw new IllegalArgumentException("Title not entered");
        if (title.isEmpty() || title.isBlank()) throw new IllegalArgumentException("Title must not be blank");
        if (title.length() < 5 || title.length() > 30) throw new IllegalArgumentException("Title's length must be between 5 characters and 30 characters");
        this.title = title;
    }
    public void setDueDate(LocalDate dueDate){
        if (dueDate.isBefore(LocalDate.now())) throw new IllegalArgumentException("Invalid due date");
        this.dueDate = dueDate;
    }
    public void revertStatus() {
        if (status.ordinal() != 0) status = Status.values()[status.ordinal()-1];
    }
    public void advanceStatus() {
        if (status.ordinal() != Status.values().length-1) status = Status.values()[status.ordinal()+1];
    }
    public void viewInfo() {
        System.out.printf("'%s', [%s | %s]\n", title, status.label, dueDate);
    }
}
