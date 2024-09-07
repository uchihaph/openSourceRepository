package com.open.source.platform.entity;

import com.alibaba.druid.util.HttpClientUtils;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author hanguo
 * @date 2022/1/20
 * @Description 请填写描述信息
 */
public class Test {

    private static Set<User> set = new HashSet<>();

    private static ThreadLocal<Engine> e1 = new ThreadLocal<>();


    static {
        User user = new User();
        user.setName("zhangsan");
        set.add(user);

    }

    public static void main1(String[] args) {

        List<User> list = new ArrayList();

        User user = new User();
        user.setId(1L);
        user.setEmail("aaa");
        user.setName("bbb");

        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        user1.setName("1");
        User user2 = new User();
        BeanUtils.copyProperties(user, user2);
        user2.setName("2");
        list.add(user);
        list.add(user1);
        list.add(user2);
        System.out.println(list.toString());
    }

    public static void main2(String[] args) {
        User user = new User();
        BeanUtils.copyProperties(null, user);
        System.out.println(user);
    }

    public static void main3(String[] args) {
        System.out.println(set);
    }

    public static void main4(String[] args) {
        List<String> date = new ArrayList<>();
        date.add("2022-01");
        date.add("2022-02");
        date.add("2022-03");
        date.add("2022-04");
        date.add("2023-01");
        List<Integer> data = new ArrayList<>();
        data.add(1);

//        Integer integer = data.stream().reduce(BigDecimal::add).get();

        Map<String, List<String>> collect = date.stream().collect(Collectors.groupingBy(e -> e.split("-")[0]));
        System.out.println(collect);


        List<Map> dataList = new ArrayList<>();
        Map<String, List<Map>> dateMaping = dataList.stream().collect(Collectors.groupingBy(e -> ((String) e.get("DATE")).split("-")[0]));
        if (false) {//判空
        }
        for (String year : dateMaping.keySet()) {
            List<String> collect1 = dateMaping.get(year).stream().filter(e -> StringUtils.isNotBlank((String) e.get("BUILD_ELECONSUM"))).map(e -> (String) e.get("BUILD_ELECONSUM")).collect(Collectors.toList());
            collect1.stream().reduce((x, y) -> x + y).get();

        }

    }

    public static void main5(String[] args) {
        String str = "";
        Map map = JSONObject.parseObject(str, Map.class);
        System.out.println(map.toString());
    }

    public static void main6(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("bbb");
            }
        });
        t1.start();
        t1.join();
        System.out.println("zzz");
    }

    public static void main7(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            int i = 100;

            @Override
            public void run() {
                try {
                    while (true) {
                        i--;
                        System.out.println(i);
                        if (i == 0) {
                            break;
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
        Thread t11 = new Thread(t1);
        Thread t12 = new Thread(t1);
        t1.start();
        t11.start();
        t12.start();
    }

    public static void main8(String[] args) {

        //main线程数据
        Engine engine0 = new Engine(1, 2);
        e1.set(engine0);

        Thread thread1 = new Thread(() -> {
            Engine engine1 = new Engine(3, 4);
            e1.set(engine1);
            System.out.println("thread1==>" + e1.get());
            e1.remove();
            System.out.println("thread1==>" + e1.get());
        });
        Thread thread2 = new Thread(() -> {
            Engine engine2 = new Engine(5, 6);
            e1.set(engine2);
            System.out.println("thread2==>" + e1.get());
            e1.remove();
            System.out.println("thread2==>" + e1.get());

        });

        thread1.start();
        thread2.start();
        System.out.println("main线程数据" + e1.get());
        e1.remove();

    }

    public static void main9(String[] args) {


        Thread t1 = new Thread(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                try {
                    i++;
                    System.out.println(i);

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        Thread e1 = new Thread(t1);
        Thread e2 = new Thread(t1);
        e1.start();
        e2.start();

    }

    public static void main10(String[] args) {
        Car car1 = new Car();
        Car car2 = car1;
        car1 = null;

        System.out.println(car1);
        System.out.println(car2);


    }

    public static void main11(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        TicketCounter ticketCounter = new TicketCounter();

        executor.execute(ticketCounter);
        executor.execute(ticketCounter);

        executor.shutdown();
    }

    public static void main(String[] args) {
        Integer a1 = 100;
        Integer a2 = 100;
        System.out.println(a1 == a2);
    }

}
