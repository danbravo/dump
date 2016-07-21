package Lesson7;

public class AnotherClass {
    public static void main(String[] args) {
        StringBuilder st = new StringBuilder();
        int startOfSubstrIncl = 3;
        int endOfSubstrExcl = 5;
        int indexOffset = 4;
        int charIndex = 4;
        st.append("new");
//        st.delete(startOfSubstrIncl, endOfSubstrExcl);
//        st.insert(indexOffset, "some sub string");
        st.replace(0, 8, "replace");
//        st.setCharAt(charIndex, 'a');
        String builderString = st.toString();
        System.out.println(builderString);
    }
}
