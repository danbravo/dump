package FbAndVk;

import Lesson1.Browser;
import org.openqa.selenium.By;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class VkDateChange extends Browser {
    private static final String LOGIN = "mrbravo@bigmir.net";
    private static final String PASS = "2342925bravo";

    static String VkLink = "http://vk.com/";
    static By logField = By.cssSelector("input#quick_email.text");
    static By passField = By.cssSelector("input#quick_pass.text");
    static By logInBtn = By.cssSelector("button#quick_login_button");

    static By editBtn = By.cssSelector("a#myprofile_edit");
    static By yearDropDown = By.xpath("//*[@id='dropdown6']");
    static String newYearString = "//*[@id='container6']//li[@val='%%input%%']";
    static By monthDropDown = By.xpath("//*[@id='dropdown5']");
    static String newMonthString = "//*[@id='container5']//li[%%input%%]";
    static By dateDropDown = By.xpath("//*[@id='dropdown4']");
    static String newDateString = "//*[@id='container4']//li[%%input%%]";
    static By saveBtn = By.xpath("//*[@id='pedit_general']/div[17]/button");

    static String currMonth;
    static String currDate;
    static String currYear;
    static String newYear;
    static String newMonth;
    static String newDate;

    public static void logIn(String log, String pass) {
        goTo(VkLink);
        type(logField, log);
        type(passField, pass);
        press(logInBtn);
    }

    public static void changeBirthDate(int date, int month, int year) {
        logIn(LOGIN, PASS);

        press(editBtn);
        press(yearDropDown);
        currYear = getAttribute(By.xpath("//*[@id='container6']//td[1]/input[2]"), "value");
        press(monthDropDown);
        currMonth = getAttribute(By.xpath("//*[@id='container5']//tr/td[1]/input[2]"), "value");
        press(dateDropDown);
        currDate = getAttribute(By.xpath("//*[@id='pedit_bday']"), "value");

        press(yearDropDown);
        String y = String.valueOf(year);
        newYearString = newYearString.replace("%%input%%", y);
        press(By.xpath(newYearString));
        press(monthDropDown);
        String m = String.valueOf(month);
        newMonthString = newMonthString.replace("%%input%%", m);
        press(By.xpath(newMonthString));
        press(dateDropDown);
        String d = String.valueOf(date);
        newDateString = newDateString.replace("%%input%%", d);
        press(By.xpath(newDateString));
        try {
            press(By.cssSelector("button.flat_button"));
        } finally {
            press(saveBtn);
        }

        press(dateDropDown);
        newDate = getAttribute(By.xpath("//*[@id='pedit_bday']"), "value");
        press(monthDropDown);
        newMonth = getAttribute(By.xpath("//*[@id='container5']//tr/td[1]/input[2]"), "value");
        press(yearDropDown);
        newYear = getAttribute(By.xpath("//*[@id='container6']//td[1]/input[2]"), "value");
    }

    public static void getDateDiff() throws ParseException {
        String old = currMonth + "/" + currDate + "/" + currYear;
        String updated = newMonth + "/" + newDate + "/" + newYear;
        SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");
        Date d1 = format.parse(old);
        Date d2 = format.parse(updated);
        long diff;
        if (d2.getTime() < d1.getTime()) {
            diff = d1.getTime() - d2.getTime();
        } else {
            diff = d2.getTime() - d1.getTime();
        }
        long diffSeconds = TimeUnit.MILLISECONDS.toSeconds(diff);
        long diffMinutes = TimeUnit.MILLISECONDS.toMinutes(diff);
        long diffDays = TimeUnit.MILLISECONDS.toDays(diff);
        long diffMonths = (TimeUnit.MILLISECONDS.toDays(diff)) / 30;

        System.out.println("Time difference in seconds: " + diffSeconds + " seconds.");
        System.out.println("Time difference in minutes: " + diffMinutes + " minutes.");
        System.out.println("Time difference in days: " + diffDays + " days.");
        System.out.println("Time difference in months: " + diffMonths + " months.");
    }

    public static void main(String[] args) throws ParseException {
        startChrome();
        changeBirthDate(15, 9, 2001);
        exitChrome();
        System.out.println("User has changed his birthday from " +
                currDate + " " + currMonth + " " + currYear + " to " +
                newDate + " " + newMonth + " " + newYear);
        getDateDiff();
    }
}
