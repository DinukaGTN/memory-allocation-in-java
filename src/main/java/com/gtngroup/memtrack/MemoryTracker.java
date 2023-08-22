package com.gtngroup.memtrack;

import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class MemoryTracker {

    private List<String> stringList = new ArrayList<>();
    private static final long MB_IN_BYTES = 1024 * 1024; // 1MB in Bytes

    public void trackMemoryUsage() {
        for (int i = 0; i < (1024*1024); i++) {
            stringList.add(UUID.randomUUID().toString());
        }

        MemoryUsage heapMemoryUsage = ManagementFactory.getMemoryMXBean().getHeapMemoryUsage();

        System.out.println(" ");
//        System.out.println("Initial Memory: " + getMemoryInMBs(heapMemoryUsage.getInit()));
//        System.out.println("Maximum Memory: " + getMemoryInMBs(heapMemoryUsage.getMax()));
        System.out.println("Used Memory: " + getMemoryInMBs(heapMemoryUsage.getUsed()));
//        System.out.println("Committed Memory: " + getMemoryInMBs(heapMemoryUsage.getCommitted()));
        System.out.println(" ");
        System.out.println("Number of elements in the list: " + stringList.size());
    }

    private long getMemoryInMBs(long mem) {
        return (mem / MB_IN_BYTES);
    }
}
