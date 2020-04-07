/*197. 上升的温度
    给定一个 Weather 表，编写一个 SQL 查询，来查找与之前（昨天的）日期相比温度更高的所有日期的 Id。
    +---------+------------------+------------------+
    | Id(INT) | RecordDate(DATE) | Temperature(INT) |
    +---------+------------------+------------------+
    |       1 |       2015-01-01 |               10 |
    |       2 |       2015-01-02 |               25 |
    |       3 |       2015-01-03 |               20 |
    |       4 |       2015-01-04 |               30 |
    +---------+------------------+------------------+

    例如，根据上述给定的 Weather 表格，返回如下 Id:
    +----+
    | Id |
    +----+
    |  2 |
    |  4 |
    +----+
*/

-- 2.1、解法一：
select A.Id from Weather A,Weather B
where A.Temperature>B.Temperature and DATEDIFF(A.RecordDate,B.RecordDate)=1

-- 2.2、解法二：
select A.Id from Weather A join Weather B
on A.Temperature>B.Temperature and DATEDIFF(A.RecordDate,B.RecordDate)=1
