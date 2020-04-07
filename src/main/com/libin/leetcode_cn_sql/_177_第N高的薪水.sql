/* 1、题目
    编写一个 SQL 查询，获取 Employee 表中第 n 高的薪水（Salary）。
    +----+--------+
    | Id | Salary |
    +----+--------+
    | 1  | 100    |
    | 2  | 200    |
    | 3  | 300    |
    +----+--------+
    
    例如上述 Employee 表，n = 2 时，应返回第二高的薪水 200。如果不存在第 n 高的薪水，那么查询应返回 null。  
    +------------------------+
    | getNthHighestSalary(2) |
    +------------------------+
    | 200                    |
    +------------------------+
*/
-- 2.1、解法一：
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      select if(count<N,null,min) from
      (
          select min(A.Salary) as min,count(*) as count from
                (select distinct Salary from Employee order by Salary desc limit N)A
      )B
  );
END

-- 2.2、解法二：
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set n = N -1 ;
  RETURN (
      select ifnull(
            (select distinct Salary from Employee order by Salary desc limit n,1)
      ,null) getNthHighestSalary
  );
END

-- 2.3、有问题的解法：
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  set n = N-1 ;
  RETURN (
      select Salary as getNthHighestSalary from Employee order by Salary desc limit n,1
  );
END
    
--#输入: {"headers": {"Employee": ["Id", "Salary"]}, "argument": 2, "rows": {"Employee": [[1, 100], [2, 100]]}}
--#输出 {"headers": ["getNthHighestSalary(2)"], "values": [[100]]}
--#预期结果 {"headers":["getNthHighestSalary(2)"],"values":[[null]]}
