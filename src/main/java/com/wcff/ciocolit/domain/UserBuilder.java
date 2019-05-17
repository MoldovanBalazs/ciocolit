package com.wcff.ciocolit.domain;

public class UserBuilder {

    private User underConstruction;

    private UserBuilder() {
        this.underConstruction = new User();
    }

    public static UserBuilder createUserBuilder() {
        return new UserBuilder();
    }

    public UserBuilder name(String field) {
        this.underConstruction.setName(field);
        return this;
    }

    public UserBuilder username(String field) {
        this.underConstruction.setUsername(field);
        return this;
    }

    public UserBuilder email(String field) {
        this.underConstruction.setEmail(field);
        return this;
    }

    public UserBuilder password(String field) {
        this.underConstruction.setPassword(field);
        return this;
    }

    public UserBuilder telephoneNumber(String field) {
        this.underConstruction.setTelephoneNumber(field);
        return this;
    }

    public UserBuilder position(String field) {
        this.underConstruction.setPosition(field);
        return this;
    }

    public UserBuilder photo(Byte[] field) {
        this.underConstruction.setPhoto(field);
        return this;
    }

    public User build() {
        return this.underConstruction;
    }


}
