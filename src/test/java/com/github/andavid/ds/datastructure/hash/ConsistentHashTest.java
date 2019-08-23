package com.github.andavid.ds.datastructure.hash;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ConsistentHashTest {

  @Test
  public void testConsistentHash() {
    List<String> servers = new ArrayList<>();
    servers.add("192.168.1.1");
    servers.add("192.168.1.2");
    servers.add("192.168.1.3");

    ConsistentHash<String> hash = new ConsistentHash<String>(2, servers);
    hash.print();

    System.out.println();
    hash.add("192.168.1.4");
    hash.print();

    System.out.println();
    hash.remove("192.168.1.2");
    hash.print();

    System.out.println();
    String node = hash.get("apple");
    System.out.println(hash.hash(node) + " --> " + node);
  }
}
