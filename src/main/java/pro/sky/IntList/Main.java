package pro.sky.IntList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IntList int2 = new IntListImpl(4);
        System.out.println(int2.add(1));
        System.out.println(int2.add(2));
        int2.remove(1);
        System.out.println(Arrays.toString(int2.toArray()));
        System.out.println(int2.contains(1));
        System.out.println(int2.contains(2));
    }
}
