package Lesson7;

public class CipherRunner {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(25);
        System.out.println(cipher.encode("privet25"));
        System.out.println(cipher.decode("+;)3%1RU"));
    }
}
