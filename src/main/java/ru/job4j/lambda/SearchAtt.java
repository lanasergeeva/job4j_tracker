package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        Predicate<Attachment>  p1 = attachment -> attachment.getSize() > 100;
        return filterAt(list, p1);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment>  p2 = attachment -> attachment.getName().contains("bug");
        return filterAt(list, p2);
    }

    public static List<Attachment> filterAt(List<Attachment> al, Predicate<Attachment> pr) {
        ArrayList<Attachment> rsl = new ArrayList<>();
        for (Attachment at : al) {
            if (pr.test(at)) {
                rsl.add(at);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        Attachment at1 = new Attachment("Lana", 159);
        Attachment at2 = new Attachment("Masha", 103);
        Attachment at3 = new Attachment("bug", 90);
        List<Attachment> al = new ArrayList<>();
        al.add(at1);
        al.add(at2);
        al.add(at3);
        System.out.println(filterSize(al));
        System.out.println(filterName(al));

    }
}
