package me.laudukang.persistence.util;

import org.springframework.data.domain.Page;

import java.util.List;

/**
 * <p>Created with IDEA
 * <p>Author: laudukang
 * <p>Date: 2016/2/6
 * <p>Time: 17:29
 * <p>Version: 1.0
 */
public class PrintUtil<T> {
    public PrintUtil() {
    }

    public void printPageToConsole(Page<T> result) {
        System.out.println("\n================= info ==================");
        System.out.println("          getNumber= " + result.getNumber());
        System.out.println("getNumberOfElements= " + result.getNumberOfElements());
        System.out.println("   getTotalElements= " + result.getTotalElements());
        System.out.println("      getTotalPages= " + result.getTotalPages());
        System.out.println("            getSize= " + result.getSize());
        System.out.println("================= info ==================\n");
        for (T entity : result.getContent()) {
            System.out.println(entity);
        }
    }

    public void printListToConsole(List<T> list) {
        for (T value : list
                ) {
            System.out.println(value);
        }
    }

    public void printListObejctToConsole(List<Object[]> list) {
        for (Object[] value : list
                ) {
            for (Object obj : value
                    ) {
                System.out.println(obj);
            }
        }
    }
}
