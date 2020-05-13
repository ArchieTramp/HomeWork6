/**
 * @author Artur Gilyazov
 * Reader
 * Читает готовый файл в фотрмате txt
 * слова из файла формирует в отсортированном порядке в новый файл, убирая повторы
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


import static java.nio.charset.StandardCharsets.UTF_8;

public class Reader {

    public static void main(String[] args) throws IOException {
        /** чтение из файла, запись в список lines и перевод в массив linearr для удобства работы,
         *  возможно можно оптимизировать, но пока не уверен как*/
        List<String> lines = Files.readAllLines(Paths.get("C://readmepls.txt"), UTF_8);
        String[] linearr = lines.toArray(new String[lines.size()]);
        System.out.println("Массив: " + Arrays.toString(linearr));
        /** удаляем из строк пробелы и добавляем отдельные слова в List*/
        int i;
        String[] parts = new String[0];
        List<String> listword = new ArrayList<String>();
        for (i = 0; i < linearr.length; i++) {
            parts = linearr[i].split(" ");
            Collections.addAll(listword, parts);}

            System.out.println("Лист полученных значений " + listword);
        /**зачем придумывать сложный метод для сонртирорвки если java предлагает нам TreeSet?*/
            Set<String>  setWord = new TreeSet<String>(listword);
            System.out.println("Убрали повторы " + setWord);

            /** запишем полученный результат в файл*/
            Files.write(Paths.get("C://readmepls_new.txt"), setWord);


        }

}




