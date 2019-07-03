package com.github.andavid.ds.datastructure.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueUsage {

  public static void main(String[] args) {
    Queue<Integer> queue1 = new PriorityQueue<Integer>();
    queue1.add(2);
    queue1.add(1);
    queue1.add(3);

    while (!queue1.isEmpty()) {
      System.out.println(queue1.poll());
    }

    Comparator<Student> comparator = new Comparator<Student>() {
      @Override
      public int compare(Student o1, Student o2) {
        return o1.id - o2.id;
      }
    };

    Queue<Student> queue2 = new PriorityQueue<Student>(comparator);
    queue2.add(new Student(2, "B"));
    queue2.add(new Student(1, "A"));
    queue2.add(new Student(3, "C"));

    while (!queue2.isEmpty()) {
      System.out.println(queue2.poll().toString());
    }
  }

  public static class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
      this.id = id;
      this.name = name;
    }

    public String toString() {
      return id + "-" + name;
    }
  }

}