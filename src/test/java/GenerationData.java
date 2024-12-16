import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;


public class GenerationData {

    Faker faker = new Faker(new Locale("en"));

    private String name;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String dayBirth;
    private String monthBirth;
    private String yearBirth;
    private String subject;
    private String hobbies;
    private String fileName;
    private String address;
    private String state;
    private String city;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getAddress() {
        return address;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getFileName() {
        return fileName;
    }

    public String getSubject() {
        return subject;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDayBirth() {
        return dayBirth;
    }

    public String getMonthBirth() {
        return monthBirth;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }


    private List<String> genderList = List.of("Male", "Female", "Other");
    private List<String> month = List.of("January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December");
    private List<String> subjectsList = List.of("Maths", "Physics", "Chemistry", "Biology", "English", "History", "Computer Science",
            "Commerce", "Hindi");
    private List<String> hobbiesList = List.of("Sports", "Reading", "Music");
    private List<String> statesOfCity = List.of("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    private List<String> cityOfNCR = List.of("Delhi", "Gurgaon", "Noida");
    private List<String> cityOfUttar = List.of("Agra", "Lucknow", "Merrut");
    private List<String> cityOfHaryana = List.of("Karnal", "Panipat");
    private List<String> cityOfRajasthan = List.of("Jaipur", "Jaiselmer");



    public String generationName(){
        name =faker.name().firstName();
        return name;
    }

    public String generationLastName(){
        lastName = faker.name().lastName();
        return lastName;
    }

    public String generationEmail(){
        email = faker.internet().emailAddress();
        email = email.substring(email.indexOf('@'));
        email = name + email;
        return email;
    }

    public String generationGender(){
        gender = genderList.get(faker.number().numberBetween(0,genderList.toArray().length));
        return gender;
    }

    public String generationPhoneNumber(){
        phoneNumber = faker.phoneNumber().subscriberNumber(10);
        return phoneNumber;
    }

    public String generationDayBirth(){
        int tmp = faker.number().numberBetween(1,28);
        if(tmp < 10){
            dayBirth = "0" + tmp;
        } else {
            dayBirth = String.valueOf(tmp);
        }
        return dayBirth;
    }

    public String generationMonthBirth(){
        monthBirth = month.get(faker.number().numberBetween(0,month.toArray().length));
        return monthBirth;
    }

    public String generationYearBirth(){
        yearBirth = String.valueOf(faker.number().numberBetween(1924,2006));
        return yearBirth;

    }

    public String generationSubject(){
        subject = subjectsList.get(faker.number().numberBetween(0, subjectsList.toArray().length));
        return subject;
    }

    public String generationHobbies(){
        hobbies = hobbiesList.get(faker.number().numberBetween(0, hobbiesList.toArray().length));
        return hobbies;
    }

                    //Доработать после увелечение тех экспертизы. Данный прекрасный метод НЕ будет работать в Jenkins-е
                    //т.к. указан локальный путь который необходимо заменить на что-то другое

    public String generationFile(){
        try{
            File file = Files.createFile(Path.of("build/resources/test", faker.file().fileName("", null, null, "/"))).toFile();
            fileName = file.getName();
            return fileName;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return "Some problems with create files";
    }

    public String generationAddress(){
        address = faker.address().fullAddress();
        return address;
    }

    public String generationState(){
        state = statesOfCity.get(faker.number().numberBetween(0,statesOfCity.toArray().length));
        return state;
    }

    public String generationCity(){

        if(state.equals("NCR")){
            city = cityOfNCR.get(faker.number().numberBetween(0,cityOfNCR.toArray().length));
        }
        else if(state.equals("Uttar Pradesh")){
            city = cityOfUttar.get(faker.number().numberBetween(0,cityOfUttar.toArray().length));
        }
        else if(state.equals("Haryana")){
            city = cityOfHaryana.get(faker.number().numberBetween(0,cityOfHaryana.toArray().length));
        }else {
            city = cityOfRajasthan.get(faker.number().numberBetween(0,cityOfRajasthan.toArray().length));
        }
        return city;
    }
}
