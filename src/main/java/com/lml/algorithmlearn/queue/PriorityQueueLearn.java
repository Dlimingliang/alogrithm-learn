package com.lml.algorithmlearn.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class PriorityQueueLearn {

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(6, Comparator.reverseOrder());
        Random rand = new Random();
        for(int i=0;i<7;i++){
            queue.add(new Integer(rand.nextInt(100)));

        }
        for(int i=0;i<7;i++){
            Integer in = queue.poll();
            System.out.println("Processing Integer:"+in);

        }
    }
}
