import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class GenerationData {

    Faker faker = new Faker(new Locale("en"));

    String name;
    List<String> gender = new ArrayList<>();
    gender.add("Man");


    public String getName(){
        name =faker.name().firstName();
        return name;
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getEmail(){
        String email = faker.internet().emailAddress();
       email = email.substring(email.indexOf('@'));
        return name + email;
    }







    public static void main(String[] args) {
        GenerationData generationData = new GenerationData();

        System.out.println(generationData.getName());
        System.out.println(generationData.getEmail());
    }
}
