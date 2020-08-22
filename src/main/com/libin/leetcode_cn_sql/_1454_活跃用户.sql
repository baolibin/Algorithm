/* 1454.  活跃用户
    表 Accounts:
    +---------------+---------+
    | Column Name   | Type    |
    +---------------+---------+
    | id            | int     |
    | name          | varchar |
    +---------------+---------+
    id 是该表主键.
    该表包含账户 id 和账户的用户名.

    表 Logins:
    +---------------+---------+
    | Column Name   | Type    |
    +---------------+---------+
    | id            | int     |
    | login_date    | date    |
    +---------------+---------+
    该表无主键, 可能包含重复项.
    该表包含登录用户的账户 id 和登录日期. 用户也许一天内登录多次.

    写一个 SQL 查询,  找到活跃用户的 id 和 name.
    活跃用户是指那些至少连续 5 天登录账户的用户.
    返回的结果表按照 id 排序.
    结果表格式如下例所示:

    Accounts 表:
    +----+----------+
    | id | name     |
    +----+----------+
    | 1  | Winston  |
    | 7  | Jonathan |
    +----+----------+

    Logins 表:
    +----+------------+
    | id | login_date |
    +----+------------+
    | 7  | 2020-05-30 |
    | 1  | 2020-05-30 |
    | 7  | 2020-05-31 |
    | 7  | 2020-06-01 |
    | 7  | 2020-06-02 |
    | 7  | 2020-06-02 |
    | 7  | 2020-06-03 |
    | 1  | 2020-06-07 |
    | 7  | 2020-06-10 |
    +----+------------+

    Result 表:
    +----+----------+
    | id | name     |
    +----+----------+
    | 7  | Jonathan |
    +----+----------+
    id = 1 的用户 Winston 仅仅在不同的 2 天内登录了 2 次, 所以, Winston 不是活跃用户.
    id = 7 的用户 Jonathon 在不同的 6 天内登录了 7 次, , 6 天中有 5 天是连续的, 所以, Jonathan 是活跃用户.
    后续问题:
    如果活跃用户是那些至少连续 n 天登录账户的用户, 你能否写出通用的解决方案?
*/

-- 2.1、解法一：
select id,name
from Accounts
where id in
(select distinct l1.id
from Logins l1,Logins l2
where l1.id=l2.id
and DATEDIFF(l2.login_date,l1.login_date) between 0 and 4
group by l1.id,l1.login_date
having count(distinct l2.login_date)=5)
order by id;
