package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.concurrent.Semaphore;

public class MapReduce extends RecursiveTask<Map<String, Long>> {
    private String[] fc;
    private int start;
    private int end;
    
    //构造函数
    public MapReduce(String[] fc, int fr, int to) {
        this.fc = fc;
        this.start = fr;
        this.end = to;
    }
    private Semaphore semaphore;
    
    public static void main(String[] args) {
    }
    
    @Override
    protected Map<String, Long> compute() {
        if (end - start == 1) {
            return calc(fc[start]);
        } else {
            int mid = (start + end) / 2;
            MapReduce mr1 = new MapReduce(fc, start, mid);
            mr1.fork();
            MapReduce mr2 = new MapReduce(fc, mid, end);
            //计算子任务，并返回合并的结果
            return merge(mr2.compute(), mr1.join());
        }
    }
    
    //合并结果
    private Map merge(Map r1, Map r2) {
        Map result = new HashMap<>();
        result.putAll(r1);
        //合并结果
        r2.forEach((k, v) -> {
            Long c = (Long) result.get(k);
            if (c != null) {
                Long res = (Long) v + c;
                result.put(k, res);
            } else {
                result.put(k, v);
            }
        });
        return result;
    }
    
    //统计单词数量
    private Map calc(String line) {
        Map result = new HashMap<>();
        //分割单词
        String[] words = line.split("\\s+");
        //统计单词数量
        for (String w : words) {
            Long v = (Long) result.get(w);
            if (v != null) result.put(w, v + 1);
            else result.put(w, 1L);
        }
        return result;
    }
}
