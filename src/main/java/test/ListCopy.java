package test;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCopy {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(new Integer[]{1,2,3});
        List<Integer> b = new ArrayList<>(a);

        System.out.println(a);
        System.out.println(b);

        b.add(4);
        printList(a);
        printList(b);

        String s1 = new String("s1");
        String s2 = "s2";
        String s3 = "s3";
        List<String> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        list1.add(s3);
        List<String> list2 = new ArrayList<>();
        list2.add(s1);
        list2.add(s2);

        s1 = "hhh";
        s2 = "s2222";
        printList(list1);
        printList(list2);

        System.out.println(s1);

        // 浅拷贝
        AB ab1 = new AB();
        ab1.setA(1);
        ab1.setB("ab1");
        AB ab2 = new AB();
        ab2.setA(2);
        ab2.setB("ab2");
        List<AB> listAB = new ArrayList<>();
        listAB.add(ab1);
        listAB.add(ab2);

        System.out.println(listAB.get(0).getA() + " " + listAB.get(0).getB());
        ab1.setB("change ab1");
        System.out.println(listAB.get(0).getA() + " " + listAB.get(0).getB());
    }

    public static <T> void printList(List<T> list) {
        for(int i=0; i<list.size(); i++) {
            System.out.print(list.get(i));
        }
        System.out.println();
    }
}
@Data
class AB {
    Integer a;
    String b;
}
