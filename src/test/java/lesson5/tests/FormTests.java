package lesson5.tests;

import org.junit.jupiter.api.Test;

public class FormTests extends BaseTest {

    String firstName = "Mr",
            lastName = "Smith",
            email = "mr-smith@mail.gl",
            gender = "Male",
            phoneNumber = "2835541120",

    birthMonth = "October",
            birthYear = "1993",
            birthDay = "23",

    subject = "Maths",
            hobby = "Sports",
            picturesRoot = "imgs/",
            pictureName = "Screenshot_94.png",
            currentAddress = "Current address",
            state = "Haryana",
            city = "Karnal";

    @Test
    public void basicFormTest() {
        registrationFromPage.openPage();
        registrationFromPage.setFirstName(firstName);
        registrationFromPage.setLastName(lastName);
        registrationFromPage.setEmail(email);
        registrationFromPage.setGender(gender);
        registrationFromPage.setPhoneNumber(phoneNumber);
        registrationFromPage.setDateOfBirth(birthDay, birthMonth, birthYear);
        registrationFromPage.setSubject(subject);
        registrationFromPage.setHobby(hobby);
        registrationFromPage.uploadImage(picturesRoot + pictureName);
        registrationFromPage.setAddress(currentAddress);
        registrationFromPage.setState(state);
        registrationFromPage.setCity(city);

        registrationFromPage.submitForm();
    }

    @Test
    public void fluentApiFormTest() {
        registrationFromPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .uploadImage(picturesRoot + pictureName)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city);
        registrationFromPage.submitForm();
        registrationFromPage.checkTable("Student Name", firstName + " " + lastName)
                .checkTable("Student Email", email)
                .checkTable("Gender", gender)
                .checkTable("Mobile", phoneNumber)
                .checkTable("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .checkTable("Subjects", subject)
                .checkTable("Hobbies", hobby)
                .checkTable("Picture", pictureName)
                .checkTable("Address", currentAddress)
                .checkTable("State and City", state + " " + city);
    }
}
