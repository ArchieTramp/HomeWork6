/**
 * @author Artur Gilyazov
 * Generator
 * Создание текста по особым правилам.
 */


import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    private static String word;
    private static String bigword;
    private static int c;
    private static String[] phaser;
    private String bigwordliter;
    private String bigwordfl;

    public static void main(String[] args) {

        Generator generator = new Generator();


        /** создание предложения */
        ThreadLocalRandom random2 = ThreadLocalRandom.current();
        int howManyWords = random2.nextInt(0, 13);
        phaser = new String[howManyWords];
        for (c = 0; c < howManyWords; c++) {
            phaser[c] = generator.word();
        }
        String phaserstr = String.join(" ", phaser);

        String phrase = generator.bigword() + " " + phaserstr + generator.dot();
        System.out.println(phrase);


    }

    /**
     * создание обычного слова
     *
     * @return
     */

    public String word() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int numword = random.nextInt(1, 15);
        StringBuilder q = new StringBuilder();
        for (int t = 0; t < numword; t++) {
            q.append((char) random.nextInt(97, 123));
        }
        word = q.toString();
        return word;

    }

    /**
     * создание начального слова
     *
     * @return
     */

    public String bigword() {
        ThreadLocalRandom random1 = ThreadLocalRandom.current();
        int numwordfirst = random1.nextInt(1, 2);
        StringBuilder e = new StringBuilder();
        for (int y = 0; y < numwordfirst; y++) {
            e.append((char) random1.nextInt(65, 90));
        }

        ThreadLocalRandom random3 = ThreadLocalRandom.current();
        int numwordofbig = random3.nextInt(0, 14);
        StringBuilder a = new StringBuilder();
        for (int o = 0; o < numwordofbig; o++) {
            a.append((char) random3.nextInt(97, 123));
        }

        bigwordfl = a.toString();
        bigwordliter = e.toString();
        bigword = bigwordliter + bigwordfl;
        return bigword;

    }

    public String dot() {
        ThreadLocalRandom random4 = ThreadLocalRandom.current();
        int dot = random4.nextInt(1, 4);
        if (dot == 0) {
            return ".";
        } else if (dot == 1) {
            return "!";
        } else {
            return "?";
        }


    }
}




