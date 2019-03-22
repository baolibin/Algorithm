package libin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Copyright (c) 2019/03/18. xixi Inc. All Rights Reserved.
 * Authors: libin <2578858653@qq.com>
 * <p>
 * Purpose : 给定一组牌，每张牌上都有一个数字，选的一个X，可以使整副牌分成一组或更多组
 * 每组都有X张牌
 * 组内所有牌都写着相同的元素
 * 仅当X>=2时，返回true
 * <p>
 * 求每个数字出现的次数，然后求这些次数的公约数
 */
public class _914_X_of_a_Kind_in_a_Deck_of_Cards {
    public static void main(String[] args) {
        int[] tmp = {1, 1, 1, 2, 2, 2, 3, 3};
        boolean b = new _914_X_of_a_Kind_in_a_Deck_of_Cards().hasGroupsSizeX(tmp);
        System.out.println(b);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2)
            return false;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int aDeck : deck) {
            if (!map.containsKey(aDeck)) {
                map.put(aDeck, 1);
            } else {
                Integer tmp = map.get(aDeck);
                map.put(aDeck, ++tmp);
            }
        }
        int res = Integer.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<Integer>(map.values());
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                int tmp = number(list.get(i), list.get(i + 1));
                if (res > tmp) res = tmp;
            } else {
                int tmp = number(list.get(i + 1), list.get(i));
                if (res > tmp) res = tmp;
            }
        }
        return res >= 2;
    }

    private int number(int max, int min) {
        return max % min == 0 ? min : number(min, max % min);
    }
}
