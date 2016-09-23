/**
 * Created by Mirjam on 13.02.2016.
 */
public class EX03 {

    /**
     * Given text and a rotation, encrypts text.
     * @param plainText plain text, readable by humanoids
     *                  with relative ease.
     * @param rotation
     * @return encrypted text
     */
    public static String encrypt(String plainText, int rotation) {

        int newLetter, letter, l;
        String decryptText = "";
        if (plainText == null || rotation < 0) {
            return null;}
        else {
            plainText = plainText.toLowerCase();
            plainText = minimizeText(plainText);
            System.out.println(plainText);
            for (int i = 0; i < plainText.length(); i++) {
                letter = plainText.charAt(i);
                System.out.println("uus täht: " + letter);

                if (letter >= 'a' && letter <= 'z') {
                    l = letter - 'a';
                    System.out.println("l: " + l);
                    newLetter = Math.floorMod(l + rotation, 26) + 'a';
                    System.out.println("newLetter: " + newLetter);
                    //newLetter = ((l + rotation) % 26) + 97;
                    char ch = (char) newLetter;
                    decryptText = decryptText + ch;
                    System.out.println(decryptText);
                }
                else {
                    newLetter = letter;
                    char ch = (char) newLetter;
                    decryptText = decryptText + ch;
                    System.out.println("Else "+decryptText);
                }
            }
            return decryptText;
        }
    }

    /**
     * Finds the most frequently occurring letter in text.
     * @param text either plain or encrypted text.
     * @return the most frequently occurring letter in text.
     */

    public static String findMostFrequentlyOccurringLetter(String text) {

        if (text == null) {
            return null;
        }
        if (text.equals("")) {
            return "";
        }

        else{
            int maxLetter = 0;
            int count = 0;
            char letter, fLetter;
            String s;

            text = text.toLowerCase();
            fLetter = text.charAt(0);
            for (int i = 0; i < text.length(); i++) {
                letter = text.charAt(i);
                if (letter == ' ') continue;
                for (int j = 0; j < text.length(); j++) {
                    if (letter == text.charAt(j)) count++;
                }
                if (count == maxLetter) {
                    int l1, l2;
                    l1 = letter;
                    l2 = fLetter;
                    if (l1 < l2) {
                        fLetter = letter;
                        maxLetter = count;
                    }
                }
                if (count > maxLetter) {
                    fLetter = letter;
                    maxLetter = count;
                }
                count = 0;
            }
            return s = "" + fLetter;

        }
    }

    /**
     * Removes the most prevalent letter from text.
     * @param text either plain or encrypted text.
     * @return text in which the most prevalent letter has been removed.
     */
    public static String minimizeText(String text) {

        if (text == null) {
            return null;
        }
        if (text.equals("")) {
            return "";
        }
        else {
            String letter;
            String newText;

            letter = findMostFrequentlyOccurringLetter(text);
            text = text.toLowerCase();
            newText = text.replaceAll(letter, "");
            return newText;
        }
    }

    /**
     * Given the initial rotation and the encrypted text, this method
     * decrypts said text.
     * @param cryptoText Encrypted text.
     * @param rotation How many letters to the right the alphabet was
     *                 shifted in order to encrypt text.
     * @return Decrypted text.
     */
    public static String decrypt(String cryptoText, int rotation) {

        if (cryptoText != null || rotation < 0) {
        int newLetter, letter, l;
        String decryptText = "";

        cryptoText = cryptoText.toLowerCase();
        for (int i = 0; i < cryptoText.length(); i++)
        {
            letter = cryptoText.charAt(i);
            if (letter >= 'a' && letter <= 'z')
            {
                l = letter - 'a';
                //System.out.println("l: " + l);
                newLetter = Math.floorMod(l - rotation, 26) + 'a';
                //System.out.println("newLetter: " + newLetter);
                char ch = (char) newLetter;
                //System.out.println("newletter after cast: " + newLetter);
                decryptText = decryptText + ch;
                //System.out.println(decryptText);
            }
            else
            {
                newLetter = letter;
                char ch = (char) newLetter;
                decryptText = decryptText + ch;
            }
        }
        return decryptText;
        }
        else return null;
    }

    /**
     * The main method, which is the entry point of the program.
     * @param args Arguments from the command line
     */
    public static void main(String[] args) {
        System.out.println(encrypt("you too Brutus?", 1)); // => zv u csvuvt?
        // (both u and o appear 3 times, o comes earlier in alphabet)
        System.out.println(decrypt("zpv upp csvuvt?", 1)); // => you too brutus?
        System.out.println(findMostFrequentlyOccurringLetter("you too Brutus?")); // => o
        System.out.println(minimizeText("you too Brutus?")); // yu t brutus?

     /*   System.out.println(encrypt("a bcdefghijklm noprstuvxyz", 2)); // => zv u csvuvt?
        // (both u and o appear 3 times, o comes earlier in alphabet)
        System.out.println(decrypt("a defghijklm nopqrtuvwxzab", 2)); // => you too brutus?
        System.out.println(findMostFrequentlyOccurringLetter("")); // => o
        System.out.println(minimizeText("")); // yu t brutus?*/

    }
}