package COURSE.homework4;

import lombok.Data;

import java.util.Calendar;
import java.util.GregorianCalendar;

@Data
public class User {
    private String surname;
    private String name;
    private String patronymic;

    /**
     * Is created with pattern:
     * surname + whitespace + first letter of name + dot.
     */
    private String fullName;

    private String username;
    private String comment;

    private Group group;

    private String homePhone;
    private String mobilePhone;
    private String secondMobilePhone;

    private String email;
    private String skype;

    private Address address;

    /**
     * Is created from the fields of class Address.
     * @see Address
     */
    private String fullAddress;

    private GregorianCalendar creationDate;
    private GregorianCalendar updateDate;

    public void setFullName() {
        if (surname != null && name != null)
            fullName = surname + " " + name.charAt(0) + ".";
    }

    public String toString() {
        return "User Data:\n" + surname + "\n" + name + "\n" + patronymic + "\n" +
                fullName + "\n" + username + "\n" + comment + "\n" + group.toString() + "\n" +
                homePhone + "\n" + mobilePhone + "\n" + secondMobilePhone + "\n" + email + "\n" +
                skype + "\n" + fullAddress + "\n" + gregorianCalendarString(creationDate) + "\n" + gregorianCalendarString(updateDate) + "\n";
    }

    public static String gregorianCalendarString(GregorianCalendar calendar) {
        return calendar.get(Calendar.YEAR) + "/" + calendar.get(Calendar.MONTH) + "/" + calendar.get(Calendar.DAY_OF_MONTH) + " "
                + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE);
    }
}
