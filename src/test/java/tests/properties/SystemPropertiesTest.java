package tests.properties;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SystemPropertiesTest {

    //        System.getProperty("key");      System- это системное хранилище в джаве
    //        System.setProperty("key", "value");

    @Test
    void someTest1() {
        String someValue = System.getProperty("someKey");
        System.out.println(someValue); // null
    }


    @Test
    void someTest2() {
        System.setProperty("someKey", "red value");
        String someValue = System.getProperty("someKey");
        System.out.println(someValue); // red value
    }


    @Test
    void someTest3() {
        String someValue = System.getProperty("someKey", "blue value");   // если по somevalue пусто, то ему поставится дефолтное значение "blue"
        System.out.println(someValue);  //blue
    }


    @Test
    void someTest4() {   //set property работает только со стрингами, поэтому нужно парсить? так же парсится integer
        Boolean someValue = Boolean.parseBoolean(
                System.getProperty("someKey", "true"));

        assertTrue(someValue);  // проверка, что это true
        System.out.println(someValue);
    }

    @Test
    @Tag("properties")   //выбрать настройки, которые мы указываем в дженкинс
    void someTest5() {
        String browser = System.getProperty("browser");
        System.out.println(browser);

        //  gradle clean properties_tests
        //  null
        //  gradle clean properties_tests -Dbrowser=chrome
        //  chrome
    }

    @Test
    @Tag("properties")
    void someTest6() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);
    }

    @Test
    @Tag("properties")
    void someTest7() {
        System.out.println("I want to say: " + System.getProperty("someText"));
    }

    // @BeforeAll              если нужно
//    static void setUp() {
//        Configuration.browser = System.getProperty("browser", "chrome");
//        Configuration.browserVersion = System.getProperty("version", "91");
//        Configuration.browserSize = System.getProperty("browserSize", "300x300");
//    }



}
