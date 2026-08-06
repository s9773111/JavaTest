package bomteng.Collection.List;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 1150731 List轉Map 效能測試
 */
public class ListToMapTest {
    public static void main(String[] args) {
        // 1.準備模擬資料
        int dataSize = 50000;
        List<JobResult> jobList = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            jobList.add(new JobResult("JOB_" + i, "SUCCESS", i));
        }

        // 要搜尋的目標是：第49999筆資料 (末尾)
        String targetJobId = "JOB_49999";
        int searchCount = 3000; // 模擬搜尋1,000次

        System.out.println("--- 開始效能測試 | 資料量: " + dataSize + " 筆, 搜尋次數: " + searchCount + "次 ---");

        // 測試1: 直接使用 List 流 (Stream: filter) 搜尋
        long startTime1 = System.currentTimeMillis();
        for (int i = 0; i < searchCount; i++) {
            JobResult jobResult = jobList.stream()
                    .filter(j -> j.getJobId().equals(targetJobId))
                    .findFirst()
                    .orElse(null);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("1. 直接用 List 搜尋 總耗時: " + (endTime1 - startTime1) + " ms");

        // 測試2: 先轉成Map，在用 .get 搜尋
        long startTime2 = System.currentTimeMillis();

        Map<String, JobResult> jobResultMap = jobList.stream()
                .collect(Collectors.toMap(JobResult::getJobId, Function.identity()));
        //      .collect(Collectors.toMap(JobResult::getJobId, jobResult -> jobResult));
        for (int i = 0; i < searchCount; i++) {
            JobResult jobResult = jobResultMap.get(targetJobId);
        }
        long endTime2 = System.currentTimeMillis();
        System.out.println("2. 先轉 Map 用 get 搜尋 總耗時: " + (endTime2 - startTime2) + " ms");

    }
}

class JobResult {
    private String jobId;
    private String status;
    private int progress;

    public JobResult(String jobId, String status, int progress) {
        this.jobId = jobId;
        this.status = status;
        this.progress = progress;
    }

    public String getJobId() {
        return jobId;
    }
}
