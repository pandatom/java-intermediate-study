package com.changxiong.StreamTest;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author changxiong
 * @create 2020-12-15-2:51 PM
 */
public class StreamDemo {

    /**
     * 创建Stream方式二: 通过数组。
     * Java8中的Arrays的静态方法stream()可以获取数组流:
     * ●static <T> Stream<T> stream(T0 array):返回-一个流
     * 重载形式，能够处理对应基本类型的数组:
     * ●public static IntStream stream(int[] array)
     * ●public static LongStream stream(longD array)
     * ●public static DoubleStream stream(double[] array)
     */
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //创建一个顺序流
        Stream<Employee> stream = list.stream();

        //创建一个并行流
        Stream<Employee> listParallel = list.parallelStream();

    }

    @Test
    public void test2() {
        int[] arr=new int[]{1,2,3,4,5,6};

        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee("1001", "Tom");
        Employee e2 = new Employee("1002", "Mery");

        Employee[] arr1=new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    /**
     * 。创建Stream方式三:通过Stream的of()
     * 可以调用Stream类静态方法of(),通过显示值创建-一个
     * 流。它可以接收任意数量的参数。
     * ●public static<T> Stream<T> of(T.. values):返回一个流
     */
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<String> s = Stream.of("a", "b", "c");
    }

    @Test
    public void test4() {
        //迭代
        // public static <T>Stream<Integer> iterate(Integer seed, UnaryOperator<Integer> f)
        // unaryOperator 传入一个类型，返回一个同类型的值
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        System.out.println();

        //生成
        //public static <T> Stream<T> generate(@NotNull java.util.function.Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //====================================Stream的中间件==============================

    /**
     * Stream的中间操作。
     * 多个中间操作可以连接起来形成一个流水线，除非流水线上触发终止
     * 操作，否则中间操作不会执行任何的处理!而在终止操作时一次性全
     * 部处理，称为“惰性求值”
     * 1-筛选与切片
     * 方法
     * 描述
     * filter(Predicate p)
     * 接收Lambda,从流中排除某些元素
     * distinct()
     * 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     * limit(long maxSize)截断流， 使其元素不超过给定数量
     * 跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一
     * skip(long n)
     * 个空流。与limit(n)互补
     */
    @Test
    public void test5() {
        //filter(redicate p)排除某些元素
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();

        stream.filter(e->e.getAge()>50).forEach(e-> System.out.println(e.getName()));

        System.out.println("============");

        //limit(n) 截断流 元素不超过指定个数
        employees.stream().limit(10).forEach(e-> System.out.println(e.getName()));
        System.out.println();

        //skip 跳过元素
        employees.stream().skip(3).forEach(System.out::println);
        System.out.println();
        //distinct 去重 需要重写对象的hashCode和equal方法才能去重
        employees.add(new Employee("1012","虎妹",40,100));
        employees.add(new Employee("1012","虎妹",40,100));
        employees.add(new Employee("1012","虎妹",40,100));
        employees.add(new Employee("1012","虎妹",40,100));
        employees.add(new Employee("1012","虎妹",40,100));
        employees.add(new Employee("1012","虎妹",40,100));

        employees.stream().distinct().forEach(System.out::println);

    }

    //=========================================中间操作 之 映射========================================
    @Test
    public void test6() {
        //map(Function)
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        list.stream().map(s->s.toUpperCase()).forEach(System.out::println);

        System.out.println();

        //获取员工名称长度为3的员工
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> streamMap = employees.stream().map(Employee::getName);
        streamMap.filter(s->s.length()>=3).forEach(System.out::println);

        //练习
        Stream<Stream<Character>> streamStream = list.stream().map(StreamDemo::fromToString);
        streamStream.forEach(s->s.forEach(System.out::println));

        System.out.println();

        Stream<Character> characterStream = list.stream().flatMap(StreamDemo::fromToString);
        characterStream.forEach(System.out::println);

    }

    public static Stream<Character> fromToString(String str) {
        ArrayList<Character> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            list.add(aChar);
        }

        return list.stream();
    }

    //=========================================中间操作 之 排序========================================

    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(10, 23, 45, 23, 28, 84, 9, 10, 83, 45);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->Integer.compare(e1.getAge(),e2.getAge()))
                .forEach(System.out::println);

        System.out.println();

        employees.stream().sorted(
                (e1,e2)->{
                    int ageValue = Integer.compare(e1.getAge(), e2.getAge());
                    if (ageValue!=0){
                        return ageValue;
                    }else{
                        int salaryValue = Integer.compare(e1.getSalary(), e2.getSalary());
                        return salaryValue;
                    }
                }
        ).forEach(System.out::println);
    }

    //===============Stream终止符===================
    @Test
    public void test8() {
        //是否匹配所有元素 allmatch(predicate p)
        //是否所有员工年龄都大于18
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        System.out.println();

        //anyMath(predicate p )至少匹配一个
        boolean b1 = employees.stream().anyMatch(e -> e.getAge() > 18);
        System.out.println(b1);

        System.out.println();

        //noneMatch(predicate p) 没有匹配的
        boolean b2 = employees.stream().noneMatch(e -> e.getAge() > 10);
        System.out.println(b2);

        System.out.println();

    }

    @Test
    public void test9() {
        List<Employee> employees = EmployeeData.getEmployees();

        //返回第一个元素 findFirst
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

        System.out.println();

        //返回任意一个对象 findany
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);

        System.out.println();

        //返回流中元素统计数量 count
        long count = employees.stream().filter(e -> e.getSalary() > 100).count();
        System.out.println(count);

        System.out.println();

        //max（comparator c） 返回流中元素最大值
         //返回员工工资最高的
        Stream<Integer> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Integer> max = salaryStream.max(Double::compare);
        System.out.println(max);

        System.out.println();
        //min（comparator c）返回流中最小值 返回年龄最小的
        Stream<Integer> ageStream = employees.stream().map(e -> e.getAge());
        Optional<Integer> min = ageStream.min(Integer::compare);
        System.out.println(min);

        System.out.println();
        //foreach 内部遍历
        employees.stream().forEach(e-> System.out.println(e.toString()));
    }

    //--------------终止 之 规约----------------------
    @Test
    public void test10() {
        //reduce(T identify,BinaryOperator p) 归约 将流中的值反复结合起来得到一个值
        //第一个参数是传入的参数 第二个是function的子类
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);
        Integer max = list.stream().reduce(0, Integer::sum);
        System.out.println(max);

        System.out.println();

        //reduce（binaryoperator）
        //计算员工工资总和
        Stream<Integer> integerStream = EmployeeData.getEmployees().stream().map(e -> e.getSalary());
        Optional<Integer> reduce = integerStream.reduce(Integer::sum);
        System.out.println(reduce);
    }

    //================终止操作 之 收集
    @Test
    public void test11() {
        //collect(collector c)
        //查找工资大于103 返回一个list或者set集合
        List<Employee> collect = EmployeeData.getEmployees().stream().filter(e -> e.getSalary() > 103).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();

        Set<Employee> collect1 = EmployeeData.getEmployees().stream().filter(e -> e.getSalary() > 103).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }

}














