package com.github.jwxa.java8lambda.article1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2017/7/20 ProjectName: coding-myself Version: 1.0
 */
public class StreamFlatMap {
    public static void main(String[] args) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map1 = new HashMap<>();
        map1.put("param1", "map1");
        map1.put("param2", "map1");

        mapList.add(map1);
        Map<String, String> map2 = new HashMap<>();
        map2.put("param1", "map2");
        map2.put("param2", "map2");

        mapList.add(map2);

        mapList.stream().flatMap((map) -> map.entrySet().stream()).forEach((e) -> System.out.println(e.getKey() + "--------------" + e.getValue()));


    }


}
