package JavaTasks;

public class DzLsn3 {

    //task1
    public static int lowestNum(int one, int two, int three, int four) {
        int[] intArr = {one, two, three, four};
        int low = intArr[0];
        for (int i=0; i<intArr.length; i++) {
            if (low>intArr[i]) {
                low = intArr[i];
            }
        }
        return low;
    }

    //task2
    public static int sumWithoutLowest(int o, int t, int th, int f) {
        int lowest = lowestNum(o,t,th,f);
        return (o+t+th+f)-lowest;
    }

    //task3
    public static String maxMinValues(int... value) {
        int[] ints = new int[value.length];
        System.arraycopy(value, 0, ints, 0, ints.length);

        int max = ints[0];
        int min = ints[0];

        for (int i=0; i<ints.length; i++) {
            if (max < ints[i]) {
                max = ints[i];
            }
            if (min > ints[i]) {
                min = ints[i];
            }
        }
        return "Max value: " + max + "\n" + "Min value: " + min;
    }

    //task4
    public static boolean nameCompare(String name1, String name2) {
        return name1.equalsIgnoreCase(name2);
    }

    //task5
    public static String timeOfYear (int month) {
        String m;
        switch (month) {
            case 12:case 1:case 2:
                m = "It's Winter!";
                break;
            case 3:case 4:case 5:
                m = "It's Spring!";
                break;
            case 6:case 7:case 8:
                m ="It's Summer!";
                break;
            case 9:case 10:case 11:
                m = "It's Fall!";
                break;
            default:
                m = "wrong num u dumb duck";
                break;
        }
        return m;
    }

    //task6
    public static boolean even(int num) {
        return num!=0 && num%2==0;
    }

    //task7
    public static String numOfMonth(int num) {
        String m;
        switch (num) {
            case 1: m="Month is January"; break;
            case 2: m="Month is February"; break;
            case 3: m="Month is March"; break;
            case 4: m="Month is April"; break;
            case 5: m="Month is May"; break;
            case 6: m="Month is June"; break;
            case 7: m="Month is July"; break;
            case 8: m="Month is August"; break;
            case 9: m="Month is September"; break;
            case 10: m="Month is October"; break;
            case 11: m="Month is November"; break;
            case 12: m="Month is December"; break;
            default: m="No equal month"; break;
        }
        return m;
    }
    public static void main(String[] args) {
        System.out.println(lowestNum(5,6,8,9));
        System.out.println(sumWithoutLowest(2,10,0,10));
        System.out.println(maxMinValues(15,546,2314,54,5,1,56,46));
        System.out.println(nameCompare("dan", "daN"));
        System.out.println(timeOfYear(88));
        System.out.println(even(2));
        System.out.println(numOfMonth(4));
    }
}
