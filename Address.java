package COURSE.homework4;

public class Address {
    private String index;
    private String city;
    private String street;
    private String houseNumber;
    private String apartmentNumber;

    public Address(String index, String city, String street, String houseNumber, String apartmentNumber) {
    }

    public String toString() {
        return index + " " + city + " " + street + " " + houseNumber + " " + apartmentNumber;
    }
}
