package com.fgs.fgscashbook.utils;

import org.springframework.cglib.beans.BeanCopier;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Evan Gui on 2018/8/9.
 * 时间工具类
 */
public class BeanCopierUtils {

    // hash map 用来缓存copier实例
    private static Map<String, BeanCopier> beanCopierMap = new HashMap<String, BeanCopier>();

    // 拷贝主程序
    public static void copyProperties(Object source, Object target) {
        // 首先转换hashmap的key用来查看是否有缓存的copier实例
        String beanKey = generateKey(source.getClass(), target.getClass());

        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    // 拷贝主程序
    public static void copyPropertieslist(List source, List target) {
        // 首先转换hashmap的key用来查看是否有缓存的copier实例
        String beanKey = generateKey(source.getClass(), target.getClass());

        BeanCopier copier;
        if (!beanCopierMap.containsKey(beanKey)) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        } else {
            copier = beanCopierMap.get(beanKey);
        }
        copier.copy(source, target, null);
    }

    // key生成
    private static String generateKey(Class<?>class1, Class<?>class2) {
        return class1.toString() + class2.toString();
    }
}
