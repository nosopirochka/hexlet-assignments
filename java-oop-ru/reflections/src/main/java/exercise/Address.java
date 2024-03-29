package exercise;

class Address {
    // BEGIN
    @NotNull
    // END
    private String country;

    // BEGIN
    @NotNull
    @MinLength
    // END
    private String city;

    // BEGIN
    @NotNull
    @MinLength
    // END
    private String street;

    // BEGIN
    @NotNull
    // END
    private String houseNumber;

    @MinLength(minLength = 1)
    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}
