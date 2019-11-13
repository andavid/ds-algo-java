# ds-algo-java

数据结构和算法必知必会的 50 个代码实现（Java）

## 参考

* https://github.com/wangzheng0822/algo
* https://github.com/kkzfl22/datastruct

## 数组

* 实现一个 [支持动态扩容的数组][dynamic-array]
* 实现一个 [大小固定的有序数组][sorted-array]，支持动态增删改操作
* 实现 [两个有序数组合并为一个有序数组][merge-two-sorted-array]

[dynamic-array]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/array/DynamicArray.java
[sorted-array]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/array/SortedArray.java
[merge-two-sorted-array]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/array/MergeTwoSortedArray.java

## 链表

* 实现 [单链表][singly-linked-list]、[循环链表][circular-linked-list]、[双向链表][doubly-linked-list]，支持增删操作
* 实现 [单链表反转][reverse-linked-list]
* 实现 [两个有序的链表合并为一个有序链表][merge-two-linked-list]
* 实现 [求链表的中间结点][find-middle-node]
* 实现 [链表中环的检测][cycle-linked-list]
* 实现 [删除链表倒数第 n 个结点][remove-nth-node]

[singly-linked-list]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/SinglyLinkedList.java
[circular-linked-list]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/CircularLinkedList.java
[doubly-linked-list]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/DoublyLinkedList.java
[reverse-linked-list]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/ReverseLinkedList.java
[merge-two-linked-list]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/MergeTwoLinkedList.java
[find-middle-node]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/FindMiddleNode.java
[cycle-linked-list]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/CycleLinkedList.java
[remove-nth-node]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/linkedlist/RemoveNthNode.java

## 栈

* 用数组实现一个 [顺序栈][array-stack]
* 用链表实现一个 [链式栈][linked-stack]
* 编程模拟实现一个 [浏览器的前进、后退][sample-browser] 功能

[array-stack]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/stack/ArrayStack.java
[linked-stack]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/stack/LinkedStack.java
[sample-browser]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/stack/SampleBrowser.java

## 队列

* 用数组实现一个 [顺序队列][array-queue]
* 用链表实现一个 [链式队列][linked-queue]
* 实现一个 [循环队列][circular-queue]

[array-queue]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/queue/ArrayQueue.java
[linked-queue]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/queue/LinkedQueue.java
[circular-queue]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/queue/CircularQueue.java

## 递归

* 编程实现 [斐波那契数列求值][fibonacci] f(n)=f(n-1)+f(n-2)
* 编程实现 [求阶乘n!][factorial]
* 编程实现一组数据集合的 [全排列][permutation]

[fibonacci]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/recursion/Fibonacci.java
[factorial]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/recursion/Factorial.java
[permutation]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/recursion/Permutation.java

## 排序

* 实现 [归并排序][MergeSort]、[快速排序][QuickSort]、[插入排序][InsertionSort]、[冒泡排序][BubbleSort]、[选择排序][SelectionSort]、[希尔排序][ShellSort]、[堆排序][HeapSort]、[桶排序][BucketSort]、[计数排序][CountingSort]、[基数排序][RadixSort]
* 编程实现O(n)时间复杂度内 [找到一组数据的第K大元素][FindKthLargest]

[MergeSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/MergeSort.java
[QuickSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/QuickSort.java
[BubbleSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/BubbleSort.java
[InsertionSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/InsertionSort.java
[SelectionSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/SelectionSort.java
[ShellSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/ShellSort.java
[HeapSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/HeapSort.java
[BucketSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/BucketSort.java
[CountingSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/CountingSort.java
[RadixSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/RadixSort.java
[FindKthLargest]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/sort/FindKthLargest.java

## 二分查找

* 实现一个有序数组的 [二分查找算法][binary-search]
* 实现 [模糊二分查找算法][binary-search]（比如大于等于给定值的第一个元素）

[binary-search]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/search/BinarySearch.java

## 跳表

* 实现一个 [跳表][skip-list]

[skip-list]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/skiplist/SkipList.java

## 散列表

* 实现一个 [基于链表法解决冲突问题的散列表][my-hash-map]
* 实现一个 [LRU缓存淘汰算法][lru-cache]
* [一致性哈希算法][consistent-hash]

[my-hash-map]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/hash/MyHashMap.java
[lru-cache]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/hash/LruCache.java
[consistent-hash]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/hash/ConsistentHash.java


## 二叉树

* 实现一个 [二叉查找树][BinarySearchTree]，并且支持插入、删除、查找操作
* 实现查找 [二叉查找树中某个节点的后继、前驱节点][BinarySearchTree]
* 实现 [二叉树前、中、后序以及按层遍历][BinaryTree]

[BinarySearchTree]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/tree/BinarySearchTree.java
[BinaryTree]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/tree/BinaryTree.java

## 堆

* 实现一个小顶堆、[大顶堆][MaxHeap]、[优先级队列][PriorityQueue]
* 实现 [堆排序][HeapSort]
* 利用优先级队列 [合并K个有序数组][MergeSortedArray]
* 求一组动态数据集合的 [最大Top K][Topk]

[MaxHeap]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/heap/Heap.java
[PriorityQueue]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/heap/PriorityQueueUsage.java
[HeapSort]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/sort/HeapSort.java
[MergeSortedArray]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/heap/MergeSortedArray.java
[Topk]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/heap/Topk.java

## 图

* 实现有向图、[无向图][graph]、有权图、无权图的邻接矩阵和邻接表表示方法
* 实现 [图的深度优先搜索、广度优先搜索][graph]
* 实现Dijkstra算法、A*算法
* 实现拓扑排序的Kahn算法、DFS算法

[graph]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/datastructure/graph/Graph.java

## 字符串

* 实现一个字符集，只包含a～z这26个英文字母的 [Trie 树][trie-tree]
* 实现 [朴素的字符串匹配算法][brute-force]
* 实现 [RK 字符串匹配算法][RK]
* 实现 [KMP 字符串匹配算法][kmp]

[trie-tree]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/stringmatch/TrieTree.java
[brute-force]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/stringmatch/BruteForce.java
[RK]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/stringmatch/RabinKarp.java
[kmp]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/stringmatch/Kmp.java

## 贪心

* 霍夫曼编码

## 分治

* 利用分治算法求一组数据的 [逆序对个数][CountInversePairs]

[CountInversePairs]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/divideandconquer/CountInversePairs.java

## 回溯

* 利用回溯算法求解 [八皇后问题][EightQueen]
* 利用回溯算法求解 [0-1 背包问题][Package]

[EightQueen]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/backtracking/EightQueen.java
[Package]: https://github.com/andavid/ds-algo-java/blob/master/src/main/java/com/github/andavid/ds/algorithm/backtracking/Package.java

## 动态规划

* 0-1背包问题
* 最小路径和
* 编程实现莱文斯坦最短编辑距离
* 编程实现查找两个字符串的最长公共子序列
* 编程实现一个数据序列的最长递增子序列
