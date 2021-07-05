package COURSE.homework4;

public class View {
    public final String GREETING = "Welcome!";
    public final String END = "Program finished.";

    public final String FIELD_INFO = "Enter!";

    public void showMessage(String message){
        System.out.println(message);
    }

    public void showMessage(String viewMessage, String field) {
        System.out.printf((viewMessage) + "%", field);
    }

}
