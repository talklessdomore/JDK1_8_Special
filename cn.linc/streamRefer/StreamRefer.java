package cn.linc.streamRefer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 描述:
 * 流的初尝试
 *
 * @author xiechenglin
 * @create 2019-02-22 14:05
 */
public class StreamRefer {

    public List<String> names = new ArrayList<>();
    /**
     * 流获取方式
     */
    @Test
    public void testGetStream(){
        //流的获取
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        //方式一：通过集合的stream方法获取
        Stream stream1 = names.stream();
        System.out.println(stream1);

        //方式二：通过stream的of方法获取
        Stream stream2 = Stream.of(names);
        System.out.println(stream2);

        //方式三：通过parallelStream来创建并行流
        Stream stream = names.parallelStream();
        System.out.println(stream);

    }

    /**
     * 流的方法测试
     */
    @Test
    public void testStreamMethodForeach(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        Stream<String> nameStream = names.stream();
        //void forEach(Consumer action)对流进行循环操作，输入一个参数，无参数输出，无法流式编程
        nameStream.forEach(s-> System.out.println(s.toUpperCase()));
    }

    @Test
    public void testStreamMethodFilter(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        Stream<String> nameStream = names.stream();
        //filter(Predicate p) 返回一个与给定判断条件匹配的元素组成的流,接受一个输入参数，返回一个booleal值，可以流式编程
        nameStream.filter(s->s.length()>4).forEach(System.out::println);
    }

    @Test
    public void testStreamMethodCount(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        Stream<String> nameStream = names.stream();
        //count() 返回一个参数流的个数
        System.out.println(nameStream.count());
    }

    @Test
    public void testStreamMethodLimit(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        Stream<String> nameStream = names.stream();
       /*
        * Stream limit(long maxSize) 获得流中前 maxSize 个元素，将元素添加到另一个流中返回
        *如果 maxSize 大于等于当前流的元素个数，则所有元素都会获取到
        *如果 maxSize 等于 0，则会获得一个空流。
        *可以流式编程
        */
       //1.获取前面几个流，当为0是为空流但不会为null
        Stream<String> limitStream = nameStream.limit(0);
        System.out.println(limitStream);
        limitStream.forEach(System.out::println);
        //2.获取前面几个流，当为大于size返回整个流
        Stream<String> limitStreamWhole = nameStream.limit(5);
        limitStreamWhole.forEach(System.out::println);
        //3.获取前面几个流，当为小于于size大于0返回整个流
        Stream<String> limitStreamPart = nameStream.limit(2);
        limitStreamPart.forEach(System.out::println);
    }


    @Test
    public void testStreamMethodSkip(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        Stream<String> nameStream = names.stream();
        //跳过前面几个，可以流式编程
        nameStream.skip(1).forEach(System.out::println);
    }

    @Test
    public void testStreamMethodMap(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        List<String> values = new ArrayList<>();
        values.add("张三");
        values.add("李四");
        Stream<String> nameStream = names.stream();
        Stream<String> valueStream = values.stream();
        // Stream concat(Stream a,Stream b)两个流合并返回一个新的流
        Stream.concat(nameStream,valueStream).forEach(System.out::println);
    }


    @Test
    public void testStreamMethodConcat(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        Stream<String> nameStream = names.stream();
        //map(Function mapper) 该接口需要一个 Function 函数式接口参数，可以将当前流中的 T 类型数据转换为另一种 R 类型的流。
        nameStream.map(name -> name.length()).forEach(System.out::println);
    }

    @Test
    public void testStreamMethodSort(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        Stream<String> nameStream = names.stream();
        //sorted(Comparator<? super T> comparator)排序
        nameStream.map(name -> name.length()).sorted().forEach(System.out::println);
    }

    @Test
    public void testStreamMethodCollect(){
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        //collect(toList())将流转成集合
        List<Integer> convertCoinTypes = names.stream().map(coinType -> coinType.length()).collect(toList());
        convertCoinTypes.forEach(System.out::println);

    }
















}
