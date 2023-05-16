package boardr.models.common;

public enum Status {
        OPEN("Open"),
        TO_DO("To Do"),
        IN_PROGRESS("In Progress"),
        DONE("Done"),
        VERIFIED("Verified");
        public final String label;
        Status(String label) {
            this.label = label;
        }
}
