package COURSE.homework4;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    private final User user;
    private final View view;

    public Controller(User user, View view) {
        this.user = user;
        this.view = view;
    }

    public void run() {
        view.showMessage(view.GREETING);
        processInput();
        view.showMessage(user.toString());
        view.showMessage(view.END);
    }

    private void processInput() {
        processFullName();
        processGroup();
        processContactInformation();
        processAddress();
        processDates();
    }

    private void processFullName() {
        String surname = getCorrectInput(Regex.NAME, "surname");
        user.setSurname(surname);

        String name = getCorrectInput(Regex.NAME, "name");
        user.setName(name);

        String patronymic = getCorrectInput(Regex.NAME, "patronymic");
        user.setPatronymic(patronymic);

        user.setFullName();

        String username = getCorrectInput(Regex.USERNAME, "username");
        user.setUsername(username);

        String comment = getCorrectInput(Regex.COMMENT, "comment");
        user.setComment(comment);
    }

    private void processGroup() {
        Regex.generateGroupRegex();
        String group = getCorrectInput(Regex.GROUP, "group");
        user.setGroup(Group.valueOf(group));
    }

    private void processContactInformation() {
        String homePhone = getCorrectInput(Regex.HOME_PHONE, "home phone");
        user.setHomePhone(homePhone);

        String mobilePhone = getCorrectInput(Regex.MOBILE_PHONE, "mobile phone");
        user.setMobilePhone(mobilePhone);

        String secondMobilePhone = getCorrectInput(Regex.MOBILE_PHONE_2, "second mobile phone (can be absent)");
        user.setSecondMobilePhone(secondMobilePhone);

        String email = getCorrectInput(Regex.EMAIL, "email");
        user.setEmail(email);

        String skype = getCorrectInput(Regex.SKYPE, "skype");
        user.setSkype(skype);
    }

    private void processAddress() {
        String index = getCorrectInput(Regex.INDEX, "index");
        String city = getCorrectInput(Regex.ADDRESS_STRING, "city");
        String street = getCorrectInput(Regex.ADDRESS_STRING, "street");
        String houseNumber = getCorrectInput(Regex.ADDRESS_NUMBER, "house number");
        String apartmentNumber = getCorrectInput(Regex.ADDRESS_NUMBER, "apartment number");

        Address address = new Address(index, city, street, houseNumber, apartmentNumber);
        user.setAddress(address);
        user.setFullAddress(address.toString());
    }

    private void processDates() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT+3:00"));
        user.setCreationDate(gregorianCalendar);
        user.setUpdateDate(gregorianCalendar);
    }

    private String getCorrectInput(Regex regex, String fieldName) {
        Scanner scanner = new Scanner(System.in);
        String regexString = regex.getRegexString();

        Pattern pattern = Pattern.compile(regexString);
        Matcher matcher;

        String userInput;
        do {
            view.showMessage(view.FIELD_INFO, fieldName);
            userInput = scanner.nextLine();
            matcher = pattern.matcher(userInput);
        } while (!matcher.matches());

        return userInput;
    }

}
