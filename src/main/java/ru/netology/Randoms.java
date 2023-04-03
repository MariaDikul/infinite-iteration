package ru.netology;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private int min;
    private int max;
    private int currentNum;
    private int previousNum;
    private int randomCalled;
    protected Random random = new Random();

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max;
        randomCalled++;
        currentNum = random.nextInt(max - min + 1) + min;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                if (randomCalled == 0) return false;
                return true;

            }

            @Override
            public Integer next() {
                if (currentNum >= 0) {
                    previousNum = currentNum;
                    currentNum = random.nextInt(max - min + 1) + min;
                    return previousNum;
                } else return null;
            }
        };
    }
}