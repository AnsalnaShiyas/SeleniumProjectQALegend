package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class RandonDataGenerator {

	public static String getName() {

		Faker faker = new Faker();
		return faker.name().name();
	}

	public static String getFirstName() {
		Faker faker = new Faker(new Locale("en-IND")); // Command inside function Bracket is to set a locality to create random name in that locality
		return faker.name().firstName();
    }

	public static String getLastName() {

		Faker faker = new Faker(new Locale("en-IND"));
		return faker.name().lastName();
	}

    public static String getPrefix() {
	
	Faker faker=new Faker();
	return faker.name().prefix();
}
    
    public static String generateEmail() {
    	Faker faker=new Faker();
        String firstName = faker.name().firstName().toLowerCase();
        String lastName = faker.name().lastName().toLowerCase();
        int randomNum = faker.number().numberBetween(100, 999);
        String domain = faker.internet().domainName(); // e.g., "example.com"

        return firstName + "." + lastName + randomNum + "@" + domain;
    }
    public static String getEmail() {
    	Faker faker=new Faker();
    	return faker.internet().emailAddress();
    	
    }
    public static String getEmailId1() {
    	Faker faker=new Faker();
    	return faker.name().firstName().concat("@gmail.com");
    }
    public static String getPhoneNumebr() {
    	Faker faker=new Faker(new Locale("en-IND"));
    	String extension= faker.phoneNumber().extension();
    	String phNumber=faker.phoneNumber().cellPhone().concat(extension);
    	return phNumber;
    }
    public static String getPassword() {

		Faker faker = new Faker();
		return faker.internet().password();
	}
    public static String getUsername() {

		Faker faker = new Faker();
		return faker.name().username();
	}
}
