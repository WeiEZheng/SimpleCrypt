import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    Integer offset;
    ROT13(Character cs, Character cf) {
        offset = cf-cs;
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        return encryption(text, 13);
    }

    public String encrypt(String text) {
        return encryption(text, offset);
    }

    public String decrypt(String text) {
        return encryption(text, 26-offset);
    }

    public String encryption(String text, Integer offset){
        String newString = "";
        for (int i=0; i<text.length(); i++){
            if (Character.isLowerCase(text.charAt(i)))
                newString += (char) ('a' + ((text.charAt(i) - 'a') + (offset)) % 26);
            else if (Character.isUpperCase(text.charAt(i)))
                newString += (char) ('A' + ((text.charAt(i) - 'A') + (offset)) % 26);
            else
                newString += text.charAt(i);
        }
        return newString;
    }

    public static String rotate(String s, Character c) {
        String temp = "";
        for (int i=0; i<s.length();i++){
            if (s.charAt(i)==c){
                temp = s.substring(i) + temp;
                break;
            }
            temp += s.charAt(i);
        }
        return temp;
    }

}
