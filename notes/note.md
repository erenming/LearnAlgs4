# 算法思想

## 贪心算法

- 多用于最优解的求解
- Greedy algorithms take all of the data in a particular problem, and then set a rule for which elements to add to the solution at each step of the algorithm.
- 满足以下两个条件，可考虑用贪心算法
    1. **Greedy choice property**: A global (overall) optimal solution can be reached by choosing the optimal choice at each step.
    2. **Optimal substructure**: A problem has an optimal substructure if an optimal solution to the entire problem contains the optimal solutions to the sub-problems.

---

## 分治算法

- 分治一种处理问题的思想，递归是一种编程技巧
- 分治算法的递归实现中，每一层递归涉及以下3个步骤
    1. 将原问题分解成一系列子问题
    2. 递归地求解各个子问题，若子问题足够小，则直接求解
    3. 将子问题的结果合并成原问题
- 满足以下条件，一般可考虑分治算法
    1. 原问题与分解成的小问题具有相同的模式；
    2. 原问题分解成的子问题可以独立求解，子问题之间没有相关性，这一点是分治算法跟动态规划的明显区别，等我们讲到动态规划的时候，会详细对比这两种算法
    3. 具有分解终止条件，也就是说，当问题足够小时，可以直接求解
    4. 可以将子问题合并成原问题，而这个合并操作的复杂度不能太高，否则就起不到减小算法总体复杂度的效果了

## 回溯算法

- 本质上是枚举，通过剪枝少走冤枉路
- 多适用于缺乏规律、或不了解内部规律的搜索场景