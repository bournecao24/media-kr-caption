package com.kr.caption.effective;

import org.w3c.dom.Element;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

public class StreamTest {


    private void test() {
//        File file = new File("");
//        // Uses the streams API but not the paradigm--Don't do this!
//        Map<String, Long> freq = new HashMap<>();
//        try (Stream<String> words = new Scanner(file)) {
//            words.forEach(word -> {
//                freq.merge(word.toLowerCase(), 1L, Long::sum);
//            });
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }


    private void ForTest() {
        List<Element> c = new ArrayList<>();
// Not the best way to iterate over a collection!
        for (Iterator<Element> i = c.iterator(); i.hasNext(); ) {
            Element e = i.next();
        }


        for (int i = 0; i < c.size(); i++) {
        }
    }


    private void testToMap() {

        List<String> words = new ArrayList<>();

        Map<String, Long> freq = words.stream().collect(Collectors.groupingBy(String::toLowerCase, counting()));

//        Collectors.to
//        有一系列不同艺术 家(artists)的唱片集(albums)，我们想要一张从唱片艺术家到最畅销专辑的 map。
//        Map<Artist, Album> topHits = albums.collect( toMap(Album::artist, a->a, maxBy(comparing(Album::sales))));
    }


    /**
     * list 选择了不同的重载，
     *
     * @param args
     */
    public static void main(String[] args) {

        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set + " " + list);
    }

}
