import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class main {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Stream<Integer> st1 = list.stream().map(n -> n * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, n -> n + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        Stream<Long> st4 = Stream.iterate(new long[] {0L, 1L}, n -> new long[] {n[1], n[0] + n[1]}).map(n -> n[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));
    }
}
