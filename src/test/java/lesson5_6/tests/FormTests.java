package lesson5_6.tests;

import lesson5_6.utils.TestData;
import org.junit.jupiter.api.Test;

public class FormTests extends BaseTest {

    TestData testData = new TestData();

    @Test
    public void basicFormTest() {
        registrationFromPage.openPage();
        registrationFromPage.setFirstName(testData.firstName);
        registrationFromPage.setLastName(testData.lastName);
        registrationFromPage.setEmail(testData.email);
        registrationFromPage.setGender(testData.gender);
        registrationFromPage.setPhoneNumber(testData.phoneNumber);
        registrationFromPage.setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear);
        registrationFromPage.setSubject(testData.subject);
        registrationFromPage.setHobby(testData.hobby);
        registrationFromPage.uploadImage(testData.picturesRoot + testData.pictureName);
        registrationFromPage.setAddress(testData.currentAddress);
        registrationFromPage.setState(testData.state);
        registrationFromPage.setCity(testData.city);

        registrationFromPage.submitForm();
    }

    @Test
    public void fluentApiFormTest() {
        registrationFromPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setDateOfBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubject(testData.subject)
                .setHobby(testData.hobby)
                .uploadImage(testData.picturesRoot + testData.pictureName)
                .setAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city);
        registrationFromPage.submitForm();
        registrationFromPage.checkTable("Student Name", testData.firstName + " " + testData.lastName)
                .checkTable("Student Email", testData.email)
                .checkTable("Gender", testData.gender)
                .checkTable("Mobile", testData.phoneNumber)
                .checkTable("Date of Birth", testData.birthDay + " " + testData.birthMonth + "," + testData.birthYear)
                .checkTable("Subjects", testData.subject)
                .checkTable("Hobbies", testData.hobby)
                .checkTable("Picture", testData.pictureName)
                .checkTable("Address", testData.currentAddress)
                .checkTable("State and City", testData.state + " " + testData.city);
    }
}
