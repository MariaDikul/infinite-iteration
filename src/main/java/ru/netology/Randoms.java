package ru.netology;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private int min;
    private int max;
    private int currentNum;
    private int previousNum;
    protected Random random = new Random();

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        currentNum = random.nextInt(max - min + 1) + min;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                previousNum = currentNum;
                currentNum = random.nextInt(max - min + 1) + min;
                return previousNum;
            }
        };
    }
}