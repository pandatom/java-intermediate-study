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
     * ����Stream��ʽ��: ͨ�����顣
     * Java8�е�Arrays�ľ�̬����stream()���Ի�ȡ������:
     * ��static <T> Stream<T> stream(T0 array):����-һ����
     * ������ʽ���ܹ������Ӧ�������͵�����:
     * ��public static IntStream stream(int[] array)
     * ��public static LongStream stream(longD array)
     * ��public static DoubleStream stream(double[] array)
     */
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        //����һ��˳����
        Stream<Employee> stream = list.stream();

        //����һ��������
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
     * ������Stream��ʽ��:ͨ��Stream��of()
     * ���Ե���Stream�ྲ̬����of(),ͨ����ʾֵ����-һ��
     * ���������Խ������������Ĳ�����
     * ��public static<T> Stream<T> of(T.. values):����һ����
     */
    @Test
    public void test3() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<String> s = Stream.of("a", "b", "c");
    }

    @Test
    public void test4() {
        //����
        // public static <T>Stream<Integer> iterate(Integer seed, UnaryOperator<Integer> f)
        // unaryOperator ����һ�����ͣ�����һ��ͬ���͵�ֵ
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        System.out.println();

        //����
        //public static <T> Stream<T> generate(@NotNull java.util.function.Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    //====================================Stream���м��==============================

    /**
     * Stream���м������
     * ����м�����������������γ�һ����ˮ�ߣ�������ˮ���ϴ�����ֹ
     * �����������м��������ִ���κεĴ���!������ֹ����ʱһ����ȫ
     * ��������Ϊ��������ֵ��
     * 1-ɸѡ����Ƭ
     * ����
     * ����
     * filter(Predicate p)
     * ����Lambda,�������ų�ĳЩԪ��
     * distinct()
     * ɸѡ��ͨ����������Ԫ�ص�hashCode()��equals()ȥ���ظ�Ԫ��
     * limit(long maxSize)�ض����� ʹ��Ԫ�ز�������������
     * ����Ԫ�أ�����һ���ӵ���ǰn��Ԫ�ص�����������Ԫ�ز���n�����򷵻�һ
     * skip(long n)
     * ����������limit(n)����
     */
    @Test
    public void test5() {
        //filter(redicate p)�ų�ĳЩԪ��
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();

        stream.filter(e->e.getAge()>50).forEach(e-> System.out.println(e.getName()));

        System.out.println("============");

        //limit(n) �ض��� Ԫ�ز�����ָ������
        employees.stream().limit(10).forEach(e-> System.out.println(e.getName()));
        System.out.println();

        //skip ����Ԫ��
        employees.stream().skip(3).forEach(System.out::println);
        System.out.println();
        //distinct ȥ�� ��Ҫ��д�����hashCode��equal��������ȥ��
        employees.add(new Employee("1012","����",40,100));
        employees.add(new Employee("1012","����",40,100));
        employees.add(new Employee("1012","����",40,100));
        employees.add(new Employee("1012","����",40,100));
        employees.add(new Employee("1012","����",40,100));
        employees.add(new Employee("1012","����",40,100));

        employees.stream().distinct().forEach(System.out::println);

    }

    //=========================================�м���� ֮ ӳ��========================================
    @Test
    public void test6() {
        //map(Function)
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");

        list.stream().map(s->s.toUpperCase()).forEach(System.out::println);

        System.out.println();

        //��ȡԱ�����Ƴ���Ϊ3��Ա��
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> streamMap = employees.stream().map(Employee::getName);
        streamMap.filter(s->s.length()>=3).forEach(System.out::println);

        //��ϰ
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

    //=========================================�м���� ֮ ����========================================

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

    //===============Stream��ֹ��===================
    @Test
    public void test8() {
        //�Ƿ�ƥ������Ԫ�� allmatch(predicate p)
        //�Ƿ�����Ա�����䶼����18
        List<Employee> employees = EmployeeData.getEmployees();
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        System.out.println();

        //anyMath(predicate p )����ƥ��һ��
        boolean b1 = employees.stream().anyMatch(e -> e.getAge() > 18);
        System.out.println(b1);

        System.out.println();

        //noneMatch(predicate p) û��ƥ���
        boolean b2 = employees.stream().noneMatch(e -> e.getAge() > 10);
        System.out.println(b2);

        System.out.println();

    }

    @Test
    public void test9() {
        List<Employee> employees = EmployeeData.getEmployees();

        //���ص�һ��Ԫ�� findFirst
        Optional<Employee> employee = employees.stream().findFirst();
        System.out.println(employee);

        System.out.println();

        //��������һ������ findany
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);

        System.out.println();

        //��������Ԫ��ͳ������ count
        long count = employees.stream().filter(e -> e.getSalary() > 100).count();
        System.out.println(count);

        System.out.println();

        //max��comparator c�� ��������Ԫ�����ֵ
         //����Ա��������ߵ�
        Stream<Integer> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Integer> max = salaryStream.max(Double::compare);
        System.out.println(max);

        System.out.println();
        //min��comparator c������������Сֵ ����������С��
        Stream<Integer> ageStream = employees.stream().map(e -> e.getAge());
        Optional<Integer> min = ageStream.min(Integer::compare);
        System.out.println(min);

        System.out.println();
        //foreach �ڲ�����
        employees.stream().forEach(e-> System.out.println(e.toString()));
    }

    //--------------��ֹ ֮ ��Լ----------------------
    @Test
    public void test10() {
        //reduce(T identify,BinaryOperator p) ��Լ �����е�ֵ������������õ�һ��ֵ
        //��һ�������Ǵ���Ĳ��� �ڶ�����function������
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7, 8, 9);
        Integer max = list.stream().reduce(0, Integer::sum);
        System.out.println(max);

        System.out.println();

        //reduce��binaryoperator��
        //����Ա�������ܺ�
        Stream<Integer> integerStream = EmployeeData.getEmployees().stream().map(e -> e.getSalary());
        Optional<Integer> reduce = integerStream.reduce(Integer::sum);
        System.out.println(reduce);
    }

    //================��ֹ���� ֮ �ռ�
    @Test
    public void test11() {
        //collect(collector c)
        //���ҹ��ʴ���103 ����һ��list����set����
        List<Employee> collect = EmployeeData.getEmployees().stream().filter(e -> e.getSalary() > 103).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println();

        Set<Employee> collect1 = EmployeeData.getEmployees().stream().filter(e -> e.getSalary() > 103).collect(Collectors.toSet());
        collect1.forEach(System.out::println);
    }

}














