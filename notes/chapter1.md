1. 背包：不支持从中删除元素的集合类型
    - 无序
    - API:
        ![xx](https://github.com/erenming/LearnAlgs4/raw/master/notes/images/WX20190305-223458@2x.png)
2. 队列：基于先进先出(FIFO)策略的集合类型
    - 保存数据的同时保存它们的相对顺序：使它们入列顺序和出列书序相同
    - API:
        ![xx](https://github.com/erenming/LearnAlgs4/raw/master/notes/images/WX20190305-224038@2x.png)
    - 应用场景：
        1. 排队
3. 栈(下压栈)：基于后进先出(LIFO)策略的集合类型
    - API:
        ![xx](https://github.com/erenming/LearnAlgs4/raw/master/notes/images/WX20190305-224509@2x.png)
4. 链表：递归的数据结构，或者为空，或者指向一个节点(node)的引用，节点包括一个元素和一个指向另一个链表的引用
    - 节点：
    ```
    private class Node
    {
        Item item;
        Node next;
    }
    ```
    - 结构：
        ![xx](https://github.com/erenming/LearnAlgs4/raw/master/notes/images/WX20190305-225602@2x.png)
    - 表头的插入与删除:
        1. 插入：`Node oldfirst = first; first = new Node(); first.item = "xx"; first.next = oldfirst`
        2. 删除: `first = first.next;`
    - 表尾的插入:
        1. 插入：`oldlast.next = last;`
    - 其他位置的插入与删除: 应用双向链表，否则每次都得遍历链表
5. 解决问题之道：
    1. 定义API
    2. 根据特定的应用场景开发用例代码
    3. 描述一种数据结构，并在API所对应的抽象数据类型的实现中根据它定义类的实例变量
    4. 描述算法(实现一组操作的方式)，并根据它实现类中的实例方法
    5. 分析算法性能
