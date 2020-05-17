/**
 * @author Artur Gilyazov
 * Generator
 * Создание текста по особым правилам.
 */


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;


public class Generator {

    private String word;
    private String bigword;
    private static String texter;
    private String bigwordliter;
    private String bigwordfl;
    private int c, v, b;
    private String[] phaser;
    private String[] text;
    private String[] paragrath;
//    private String phrase;


    /**
     * метод для создания текста и записи его в вф айл
     */
    public static void main(String[] args) throws IOException {

        Generator generator = new Generator();

        texter = generator.text();

        try (FileOutputStream out = new FileOutputStream("textgen.txt");
             BufferedOutputStream bos = new BufferedOutputStream(out)) {
            byte[] buffer = texter.getBytes();
            bos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * создание обычного слова
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

    /**
     * выбор знака препинания
     */
    public String dot() {
        ThreadLocalRandom random4 = ThreadLocalRandom.current();
        int dot = random4.nextInt(0, 4);
        if (dot == 1) {
            return ". ";
        } else if (dot == 2) {
            return "! ";
        } else {
            return "? ";
        }


    }

    /**
     * создание предложения
     *
     * @return
     */
    public String phrase() {

        Generator generator = new Generator();

        ThreadLocalRandom random2 = ThreadLocalRandom.current();
        int howManyWords = random2.nextInt(0, 13);
        phaser = new String[howManyWords];
        for (c = 0; c < howManyWords; c++) {
            phaser[c] = generator.word();
        }
        String phaserstr = String.join(" ", phaser);
        /*if (howManyWords > 6) { */
            String phrase = generator.bigword() + " " + phaserstr + generator.dot();
        /*} else {
            String phrase = generator.bigword() + " " + phaserstr + generator.arrayword() + generator.dot();
        }*/


        return phrase;
    }

//    private String arrayword() {
//        getFiles("C://arrayofwords.txt", 1000, 7, "words", 1 / 7);
//        return null;
//    }

    /**
     * создание абзаца
     */
    public String paragrath() {
        Generator generator = new Generator();

        ThreadLocalRandom random5 = ThreadLocalRandom.current();
        int howManyphrase = random5.nextInt(1, 21);
        paragrath = new String[howManyphrase];
        for (v = 0; v < howManyphrase; v++) {
            paragrath[v] = generator.phrase();
        }
        String parastr = String.join(" ", paragrath);

        return parastr;

    }

    /**
     * создание текста
     */
    public String text() {
        Generator generator = new Generator();
        ThreadLocalRandom random6 = ThreadLocalRandom.current();
        int howManytext = random6.nextInt(1, 10);
        text = new String[howManytext];
        for (b = 0; b < howManytext; b++) {
            text[b] = generator.paragrath();
        }
        String texter = String.join("\r", text);

        return texter;

    }

    private void getFiles(String s, int i, int i1, String words, int i2) {
    }

}




