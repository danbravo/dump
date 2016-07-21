package JavaTasks;

public class DzLesson7 {
    public static void countTime(String str, String stringToConcat) {
        long startTimeS = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            str += stringToConcat;
        }
        long timeSpentS = System.currentTimeMillis() - startTimeS;
        System.out.println("String concatenation x100000 times took " + timeSpentS/1000 + " seconds");

        StringBuilder builder = new StringBuilder(str);
        long startTimeSbuilder = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            builder.append(stringToConcat);
        }
        long timeSpentSbuilder = System.currentTimeMillis() - startTimeSbuilder;
        System.out.println("StringBuilder concatenation x100000 times took " + timeSpentSbuilder + " milliseconds");

        StringBuffer buffer = new StringBuffer(str);
        long startTimeSbuffer = System.currentTimeMillis();
        for (int i=0; i<100000; i++) {
            buffer.append(stringToConcat);
        }
        long timeSpentSbuffer = System.currentTimeMillis() - startTimeSbuffer;
        System.out.println("StringBuffer concatenation x100000 times took " + timeSpentSbuffer + " milliseconds");
    }

    public static void main(String[] args) {
        countTime("asd", "asd");
    }
}
