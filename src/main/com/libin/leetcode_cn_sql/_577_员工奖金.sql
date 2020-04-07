/*577. 员工奖金
    选出所有 bonus < 1000 的员工的 name 及其 bonus。
    Employee 表单
    +-------+--------+-----------+--------+
    | empId |  name  | supervisor| salary |
    +-------+--------+-----------+--------+
    |   1   | John   |  3        | 1000   |
    |   2   | Dan    |  3        | 2000   |
    |   3   | Brad   |  null     | 4000   |
    |   4   | Thomas |  3        | 4000   |
    +-------+--------+-----------+--------+
    empId 是这张表单的主关键字
    Bonus 表单
    +-------+-------+
    | empId | bonus |
    +-------+-------+
    | 2     | 500   |
    | 4     | 2000  |
    +-------+-------+
    empId 是这张表单的主关键字
    输出示例：
    +-------+-------+
    | name  | bonus |
    +-------+-------+
    | John  | null  |
    | Dan   | 500   |
    | Brad  | null  |
    +-------+-------+
*/

-- 2.1、解法一：
select E.name,B.bonus
from Employee E
left join Bonus B
on E.empId=B.empId
where B.bonus is null or B.bonus<1000
