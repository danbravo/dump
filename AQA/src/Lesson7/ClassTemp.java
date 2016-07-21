package Lesson7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassTemp {

//    public static boolean regExCheck(String test) {
//        Pattern p = Pattern.compile(".+\\.(com|ua|ru)");
//        Matcher m = p.matcher(test);
//        return m.matches();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(regExCheck("lelelef.ru"));
//    }
    public static final String TEXT = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";

    public static void main(String[] args){

        System.out.println(TEXT.replaceAll("[Тт]а[ий]ланд", "БАНАНЫ"));

    }
}
