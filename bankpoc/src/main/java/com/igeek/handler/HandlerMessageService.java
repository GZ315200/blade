package com.igeek.handler;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Gyges Zean
 * @date 2018/2/5
 */
public class HandlerMessageService {


    private static int fetchSize = 100;

    private static List<String> messages = Lists.newArrayList();

    private static List<Integer> keys = Lists.newArrayList();

    private static void addMessage() {
        for (int i = 0; i <= 100000; i++) {
            messages.add("" + i);
        }
    }

    private static void addKey() {
        for (int i = 0; i <= 100000; i++) {
            keys.add(i);
        }
    }

    private static void fetchMessage() {
        int size = messages.size();
//       计算需要遍历数组的次数
        int num = (size) % fetchSize == 0 ? size / fetchSize : size / (fetchSize + 1);
        int start = 0;
        int end = 0;
        List<String> fetchList = Lists.newArrayList();

//        for (int i = 1; i <= num; i++) {
//            end = (i * fetchSize) > size ? size : (i * fetchSize);
//            start = (i - 1) * fetchSize;
//            for (; start < end; start++) {
//                fetchList.add(messages.get(start));
//            }
//            System.out.println("out data:" + fetchList.toString());
//            fetchList.clear();
//        }

        for (int i = 1; i <= num; i++) {
//          计算数据结束的位置
            end = (i * fetchSize) > size ? size : (i * fetchSize);
//            计算数据开始拉取的位置
            start = (i - 1) * fetchSize;
            System.out.println(start + "--" + end);
            fetchList = messages.subList(start, end);
            System.out.println("out data" + fetchList.toString());
        }
    }

    public static void main(String[] args) {
        addMessage();
        addKey();
//        fetchMessage();
        messages.stream().parallel().forEach(s -> {
            FutureTask<Map<Integer,String>> task = new FutureTask<Map<Integer,String>>(
                    new Callable<Map<Integer,String>>() {
                        @Override
                        public Map<Integer,String> call() throws Exception {
                            Map<Integer,String> maps = Maps.newHashMap();
                            for (int i = 1; i <= keys.size(); i ++) {
                                maps.put(i,s);
                            }
                            return maps;
                        }
                    }
            );
            try {
                System.out.println(task.get().values().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            new Thread(task).start();
        });
    }
}
