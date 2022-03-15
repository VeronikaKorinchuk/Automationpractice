package com.coherentsolutions.korinchuk.lab.java.web.models;

import com.github.javafaker.Faker;

public class AccountFormFactory {

    private static Faker faker = new Faker();

    public static AccountForm get() {
        return new AccountForm(faker.name().firstName(), faker.name().lastName(), "pswrd",
                faker.name().firstName(), faker.name().lastName(), faker.address().fullAddress(),
                faker.address().city(), faker.address().state(), "12345",  faker.address().country(),
                faker.phoneNumber().cellPhone(), "My address");
    }
}
