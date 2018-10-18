- 符号表：一张抽象的表，将信息（值）存储在其中，然后按照指定的键来搜索并获取这些信息
- 有序符号表：保持键有序的符号表
- 无序链表中的顺序查找
- 有序数组中的二分查找：
    1. 使用一对平行的数组，一个储存键一个储存值
- 二叉查找树
    - 定义：是一棵二叉树，其中每个节点都含有一个Comparable的键（以及相关联的值）且每个节点的键都大于其左子树中的任意节点的键而小于右子树的任意节点的键
    - 表示：
        1. 节点：一个键、一个值、一条左链接、一条右链接和一个节点计数器（1（自身）+子树中的所有节点数）
    - 查找：
        1. 如果树是空的，则查找未命中
        2. 如果被查找的键和根节点的键相等，查找命中，否则我们就（递归地）在适当的子树中继续查找
        3. 如果被查找的键小于就选择左子树，较大则选择右子树
    - 插入：
        1. 如果树是空的，就返回一个含有该键值对的新节点
        2. 如果被查找的键小于根节点的键，我们会继续在左子树中插入该键，否则在右子树插入该键
    - 删除：用被删除节点x的后继节点填补它的位置
        1. 将指向即将被删除的节点的链接保存为t
        2. 将x指向它的后继节点min(t.right)
        3. 将x的右链接指向deleteMin(t.right)，也就是在删除后所有节点仍然都大于x.key的子二叉树
        4. 将x的左链接设为t.left
    - 最小键（最大键同理）
        1. 如果根节点的左链接为空，那么一棵二叉查找树中最小的键就是根节点
        2. 如果左链接非空，那么树中最小键就是左子树中的最小键
    - 向下取整（向上取整同理）
        1. 如果给定的键key小于BST的根节点的键，那么小于等于key的最大键floor(key)一定在根节点的左子树中
        - 如果给定的键key大于BST的根节点，那么只有当根节点右子树中存在小于等于key的节点时，小于等于key的最大键才会出现在右子树中，否则根节点就是小于等于key的最大键
    - 选择排名为k的键
        1. 如果左子树中的节点数t大于k，那么我们就继续在左子树中查找排名为k的键
        2. 如果t等于k，我们就返回根节点中的键
        3. 如果t小于k，我们就在右子树中查找排名为(k-t-1)的键
    - 范围查找
        1. 中序遍历：左->根->右
        ```java
            private void print(Node x)
            {
                if (x == null) return;
                print(x.left);
                StdOut.println(x.key);
                print(x.right);
            }
        ```
        2. 使用Queue来收集符合条件的键
        