package COURSE.homework4;

public enum Regex {

    NAME("[A-Z][a-z]{2,20}"),
    USERNAME("[A-Za-z0-9]{5,30}"),
    COMMENT("[A-Za-z0-9\\s]+"),
    GROUP(""),
    HOME_PHONE("[0-9]{5,10}"),
    MOBILE_PHONE("[+][0-9]{10,12}"),
    MOBILE_PHONE_2("[[+][0-9]{10,12}]|"),
    EMAIL("[A-Za-z0-9]{3,30}[@][a-z]{3,10}[.][a-z]{2,4}"),
    SKYPE("[0-9A-Za-z]{3,30}"),
    //There are countries in which letters are used in index
    INDEX("[0-9A-Za-z]{4,10}"),
    ADDRESS_STRING("[A-Za-z\\s]{3,30}"),
    ADDRESS_NUMBER("[0-9]{1,4}");

    private String regexString;

    /**
     * This method generates group regex, which is based on current fields of enum Group.
     * @see Group
     */
    public static void generateGroupRegex() {
        Group [] groups = Group.ANOTHER.getDeclaringClass().getEnumConstants();
        StringBuilder sb = new StringBuilder();
        for (Group group : groups) {
            sb.append(group.name());
            sb.append("|");
        }
        sb.deleteCharAt(sb.length()-1);
        GROUP.regexString = sb.toString();
    }

    Regex(String regexString) {
        this.regexString = regexString;
    }

    public String getRegexString() {
        return regexString;
    }
}
