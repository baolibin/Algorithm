/*1、题目
    编写一个 SQL 查询，查找所有至少连续出现三次的数字。
    +----+-----+
    | Id | Num |
    +----+-----+
    | 1  |  1  |
    | 2  |  1  |
    | 3  |  1  |
    | 4  |  2  |
    | 5  |  1  |
    | 6  |  2  |
    | 7  |  2  |
    +----+-----+

    例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。
    +-----------------+
    | ConsecutiveNums |
    +-----------------+
    | 1               |
    +-----------------+
*/
-- 2.1、解法一：
select distinct l1.Num ConsecutiveNums from Logs l1,Logs l2,Logs l3
where l1.Id=l2.Id-1 and l1.Id=l3.Id-2 and l1.Num=l2.Num and l1.Num=l3.Num;

-- 2.2、解法二：
select distinct Num ConsecutiveNums from Logs
where Num=(select Num from Logs l1 where l1.Id-1=Logs.Id)
and Num=(select Num from Logs l2 where l2.Id+1=Logs.Id)

-- 2.3、解法三(SQL SERVER)：
select distinct Num ConsecutiveNums from
(
    select Num,count(*) as n from
    (
        select
            Id,Num,row_number() over(order by Id)-row_number() over(partition by num order by Id) as diff
        from Logs
    )A
    group by Num,diff
)B where n>=3;
