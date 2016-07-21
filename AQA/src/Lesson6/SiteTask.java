package Lesson6;

import Lesson1.Browser;
public class SiteTask extends Browser{
    static String privatLink = "https://www.privat24.ua";

//    {
//        String html = "lalallaa clas. 56 ja2das";
//        int begin = html.indexOf("s.") + "s.".length();
//        int end = html.indexOf("ja2");
//
//        html = html.substring(begin, end);
//        html = html.trim();
//
//        int i = Integer.parseInt(html);
//    }

    public static void main(String[] args) {
        String str = "asdasdasd .45 lpl22 .5";
        int begin = str.indexOf(" .") + " .".length();
        int end = str.indexOf("lp");

        str = str.substring(begin, end);
        str = str.trim();
        System.out.println(str);

        int i = Integer.parseInt(str);
        System.out.println(i);

        String s = "Ok";
        StringBuilder sb = new StringBuilder(s);
        System.out.println(s.hashCode() + " " + sb.hashCode());
        String t = "Ok";
        StringBuilder tb = new StringBuilder(t);
        System.out.println(t.hashCode() + " " + tb.hashCode());
    }
}
