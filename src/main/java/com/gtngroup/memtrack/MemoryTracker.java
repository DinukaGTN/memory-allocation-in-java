package com.gtngroup.memtrack;

import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class MemoryTracker {

    private List<String> stringList = new ArrayList<>();
    private static final long TARGET_MEMORY_BYTES = 1024 * 1024 * 1; // 1MB in Bytes

    public void trackMemoryUsage() {
        String totalMemString = "0";
//        int count = 0;
        /*
        while (Long.parseLong(totalMemString) < TARGET_MEMORY_BYTES) {
                stringList.add(UUID.randomUUID().toString());
                System.out.println(stringList.get(count));
                // totalMemString = getUsedMemory();
                // System.gc(); // Explicitly call garbage collector after each add
                count++;
        }
        */

        stringList.add(UUID.randomUUID().toString());
        totalMemString = getUsedMemory();

        System.out.println("Memory usages: " + totalMemString);
//        System.out.println("Number of elements in the list: " + stringList.size());
    }

    private String getUsedMemory() {
        return ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().toString();
    }
}
