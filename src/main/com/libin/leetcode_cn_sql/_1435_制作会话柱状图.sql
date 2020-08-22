/* 1435. 制作会话柱状图
    表：Sessions
    +---------------------+---------+
    | Column Name         | Type    |
    +---------------------+---------+
    | session_id          | int     |
    | duration            | int     |
    +---------------------+---------+
    session_id 是该表主键
    duration 是用户访问应用的时间, 以秒为单位
     
    你想知道用户在你的 app 上的访问时长情况。因此决定统计访问时长区间分别为 "[0-5>", "[5-10>", "[10-15>" 和 "15 or more" （单位：分钟）的会话数量，并以此绘制柱状图。
    写一个SQL查询来报告（访问时长区间，会话总数）。结果可用任何顺序呈现。

    下方为查询的输出格式：
    Sessions 表：
    +-------------+---------------+
    | session_id  | duration      |
    +-------------+---------------+
    | 1           | 30            |
    | 2           | 199           |
    | 3           | 299           |
    | 4           | 580           |
    | 5           | 1000          |
    +-------------+---------------+

    Result 表：
    +--------------+--------------+
    | bin          | total        |
    +--------------+--------------+
    | [0-5>        | 3            |
    | [5-10>       | 1            |
    | [10-15>      | 0            |
    | 15 or more   | 1            |
    +--------------+--------------+
    对于 session_id 1，2 和 3 ，它们的访问时间大于等于 0 分钟且小于 5 分钟。
    对于 session_id 4，它的访问时间大于等于 5 分钟且小于 10 分钟。
    没有会话的访问时间大于等于 10 分钟且小于 15 分钟。
    对于 session_id 5, 它的访问时间大于等于 15 分钟。
*/

-- 2.1、解法一：
select "[0-5>" as bin,count(*) as  total from Sessions where duration/60>=0 and duration/60<5
union
select "[5-10>" as bin,count(*)  as  total  from Sessions where duration/60>=5 and duration/60<10
union
select "[10-15>" as bin,count(*) as  total  from Sessions where duration/60>=10 and duration/60<15
union
select "15 or more" as bin,count(*) as  total  from Sessions where duration/60>=15
