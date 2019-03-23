package libin.leetcode;

import java.util.ArrayList;

/**
 * Copyright (c) 2019/03/21. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 返回两个区间列表的交集
 */
public class _986_Interval_List_Intersections {
    public static void main(String[] args) {
        Interval[] a = {new Interval(0, 2),
                new Interval(5, 10),
                new Interval(13, 23),
                new Interval(24, 25)};
        Interval[] b = {new Interval(1, 5),
                new Interval(8, 12),
                new Interval(15, 24),
                new Interval(25, 26)};
        new _986_Interval_List_Intersections().intervalIntersection(a, b);
    }

    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        int startA = 0, endA = 0, startB = 0, endB = 0;
        int indexA = 0, indexB = 0;
        int lenA = A.length;
        int lenB = B.length;

        while (indexA < lenA && indexB < lenB) {
            startA = A[indexA].start;
            endA = A[indexA].end;
            startB = B[indexB].start;
            endB = B[indexB].end;
            if (endA < startB) {
                indexA++;
            } else if (endB < startA) {
                indexB++;
            } else if (startA >= startB && endA <= endB) {
                intervals.add(A[indexA]);
                indexA++;
            } else if (startB >= startA && endB <= endA) {
                intervals.add(B[indexB]);
                indexB++;
            } else if (startA >= startB && endA >= endB) {
                intervals.add(new Interval(startA, endB));
                indexB++;
            } else if (startB >= startA && endB >= endA) {
                intervals.add(new Interval(startB, endA));
                indexA++;
            }
        }
        int index = 0;
        Interval[] inter = new Interval[intervals.size()];
        for (Interval i : intervals) {
            inter[index++] = i;
        }
        return inter;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
