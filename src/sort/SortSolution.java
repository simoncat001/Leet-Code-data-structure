package sort;

import backTracking.BackTrackSolution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortSolution {
    /**
     * 253 会议室 II
     */
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }
    
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int room=1;
        PriorityQueue<Integer> minEnd = new PriorityQueue<>();
        minEnd.offer(intervals[0][1]);
        for(int i = 1; i< intervals.length; i++){
            if (intervals[i][0]<minEnd.peek()){
                room++;
                minEnd.offer(intervals[i][1]);
            }else {
                minEnd.poll();
                minEnd.offer(intervals[i][1]);
            }
        }
        return room;
    }
    
    public static void main(String[] args) {
        SortSolution bs = new SortSolution();
        int res = bs.minMeetingRooms(new int[][]{{7,10},{2,4}});
        System.out.println(res);
    }
}
