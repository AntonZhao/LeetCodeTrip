大部分题目都有注释哦

leetcode SQL题目

#### 175. 组合两个表
编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：FirstName, LastName, City, State


```sql
select FirstName, LastName, City, State
from Person left join Address
on Person.PersonId = Address.PersonId;
```
- 因为表 Address 中的 personId 是表 Person 的外关键字，所以我们可以连接这两个表来获取一个人的地址信息。
- 考虑到可能不是每个人都有地址信息，我们应该使用 outer join 而不是默认的 inner join。

> 相关知识

    left join(左联接) 返回包括左表中的所有记录和右表中联结字段相等的记录 
    right join(右联接) 返回包括右表中的所有记录和左表中联结字段相等的记录
    inner join(等值连接) 只返回两个表中联结字段相等的行
    
#### 176. 第二高的薪水
如果不存在第二高的薪水，那么查询应返回 null。

```sql
select (
  select distinct Salary from Employee order by desc limit 1,1
) as SecondHighestSalary;
```
- 直接搜的话不能处理没有第二高工资的情况
- 所以将其作为临时表，因为可以 `select null`

#### 177. 第N高的薪水
编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。

```sql
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set N = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct Salary
      from Employee
      order by Salary desc
      limit N,1
  );
END
```
- 和上一题很像哦

#### 178. 分数排名

```sql
select 
  a.Score as `Score`, 
  count(distinct b.Score) as `Rank` -- 统计b表符合条件的不重复的分数的数量作为排名
from Scores a join Scores b
where b.Score >= a.Score  -- 条件是这个分数不小于我，因为a、b表数据相同，所以排名值最小是1
group by a.Id  -- a表中每个数据都进行排名
order by a.Score DESC --  最后按分数（跟排名一样）降序排列
```