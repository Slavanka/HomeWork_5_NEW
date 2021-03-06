package guru.qa.tests;

import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;

import java.util.Locale;


public class FirstWithPageTest extends TestBase {

    @Test
    void checkStudentRegistration() {
        Faker faker = new Faker(new Locale("ko"));
        RegistrationPage registrationPage = new RegistrationPage();

        String name = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress("com");
        String phone = faker.number().digits(10);
        String address = faker.address().streetAddress();
        String subject = "Biology";
        String gender = "Female";
        String image = "cv.png";

        registrationPage
                .openPage();

        registrationPage
                .setInputName(name)
                .setInputLastName(lastName)
                .clickCheckBoxFemale()
                .setInputEmail(email)
                .setInputPhone(phone)
                .chooseSubject(subject)
                .clickCheckBoxHobbies()
                .upLoadImageOnPage(image)
                .setAddressInTextarea(address)
                .chooseState()
                .chooseCity()
                .clickButtonSubmit();

        registrationPage
                .assertSubmitTitleIsVisible()
                .assertTableAfterRegistrationHave(name)
                .assertTableAfterRegistrationHave(lastName)
                .assertTableAfterRegistrationHave(email)
                .assertTableAfterRegistrationHave(gender)
                .assertTableAfterRegistrationHave(phone)
                .assertTableAfterRegistrationHave(subject)
                .assertTableAfterRegistrationHave(address)
                .assertTableAfterRegistrationHave(image);

    }
}

