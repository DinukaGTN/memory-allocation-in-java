package com.gtngroup.memtrack;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class MemoryTracker {

    private List<String> stringList = new ArrayList<>();
    private static final long TARGET_MEMORY_BYTES = 1024 * 1024 * 1; // 1MB in Bytes

    public void trackMemoryUsage() {
        long totalMemory = 0;
        int count = 0;
        while (totalMemory < TARGET_MEMORY_BYTES) {
                stringList.add(UUID.randomUUID().toString());
                System.out.println(stringList.get(count));
                 totalMemory = getUsedMemory();
                // System.gc(); // Explicitly call garbage collector after each add
                count++;
        }
         System.out.println("Total memory used: " + Long.toString(totalMemory));
        System.out.println("Number of elements in the list: " + stringList.size());
    }

    private long getUsedMemory() {
        // Using Runtime to estimate used heap memory
        return Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    }
}
