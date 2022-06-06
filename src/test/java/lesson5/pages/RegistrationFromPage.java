package lesson5.pages;

import lesson5.pages.components.CalendarComponent;
import lesson5.pages.components.ResultsTableComponent;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFromPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public RegistrationFromPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public RegistrationFromPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationFromPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationFromPage setEmail(String email) {
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationFromPage setGender(String gender) {
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationFromPage setPhoneNumber(String phoneNumber) {
        $("#userNumber").setValue(phoneNumber);

        return this;
    }

    public RegistrationFromPage setSubject(String subject) {
        $("#subjectsInput").sendKeys(subject);      //sendKeys() is used as workaround for this buggy form
        $("#subjectsInput").sendKeys(Keys.TAB);

        return this;
    }

    public RegistrationFromPage setHobby(String hobby) {
        $("#hobbiesWrapper").$(byText(hobby)).click();

        return this;
    }

    public RegistrationFromPage uploadImage(String pictureClassPath) {
        $("#uploadPicture").uploadFromClasspath(pictureClassPath);

        return this;
    }

    public RegistrationFromPage setAddress(String currentAddress) {
        $("#currentAddress").setValue(currentAddress);

        return this;
    }

    public RegistrationFromPage setState(String state) {
        $("#state").click();
        $(byText(state)).click();

        return this;
    }

    public RegistrationFromPage setCity(String city) {
        $("#city").click();
        $(byText(city)).click();

        return this;
    }

    public RegistrationFromPage submitForm() {
        $("#submit").click();

        return this;
    }

    public RegistrationFromPage setDateOfBirth(String birthDay, String birthMonth, String birthYear) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(birthDay, birthMonth, birthYear);

        return this;
    }

    public RegistrationFromPage checkTable(String columnName, String columnValue) {
        resultsTableComponent.checkTable(columnName, columnValue);

        return this;
    }
}
