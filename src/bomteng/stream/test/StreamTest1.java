package bomteng.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 參：https://blog.csdn.net/weixin_42039228/article/details/123734269
 */
public class StreamTest1 {
	public static void main(String[] args) {
		
		// Stream 建立
		List<String> list = Arrays.asList("b", "a", "c", "6");
	
		
    	System.out.println("1.list: " + list);
    	System.out.println("列出全部:");
    	
    	// (一)比較時間：
    	// 1.stream()
    	long start = System.currentTimeMillis();
    	Stream<String> stream = list.stream();
    	stream.forEach(s -> System.out.println("2.stream:" +s));
    	long end = System.currentTimeMillis();
    	System.out.println("串行 Stream 的執行時間：" + (end - start));
    	
    	// 2.paralleStream()
    	start = System.currentTimeMillis();
    	Stream<String> paralleStream = list.parallelStream();
    	paralleStream.forEach(s-> System.out.println("3.paralleStream: " +s));
    	System.out.println("並行 Stream 的執行時間：" + (end - start));
    	System.out.println("------------------------------------------------------------------------");
    	
    	// (二)使用Arrays.stream()方法
    	int[] array = {1,3,5,6,8};
    	IntStream stream1 = Arrays.stream(array);
  
    	// (三)使用stream 靜態方法 : of(), iterate(), generate()
    	Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
    	stream2.forEach(s -> System.out.print("of:"+s+"\t"));
    	System.out.println();
    	Stream<Integer> stream3 = Stream.iterate(0, (x) -> x+3).limit(4);
//    	stream3.forEach(System.out::print);
//    	stream3.forEach(s-> System.out.print("stream3: " + s + "\t"));
    	stream3.forEach(s -> System.out.printf("stream3: %s\t", s));
    	System.out.println();
    	Stream<Double> stream4 = Stream.generate(Math::random).limit(3);
    	stream4.forEach(System.out::println);
    	System.out.println("------------------------------------------------------------------------");
    	
    	// (四) 處理數據大量時，可直接使用parallel() : 使用.parallel() 並行處理
    	List<Integer> list2 = Arrays.asList(1, 2, 3, 5, 6, 7, 8);
    	Optional<Integer> findFirst = list2.stream().parallel().filter(x->x>6).findFirst();
    	// 找到第一個大於6的 使用get()
    	System.out.println("findFirst: " + findFirst.get());
    	
	}
}
