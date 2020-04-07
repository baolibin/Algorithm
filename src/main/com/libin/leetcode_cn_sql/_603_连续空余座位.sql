/*  603. 连续空余座位
    几个朋友来到电影院的售票处，准备预约连续空余座位。
    你能利用表 cinema ，帮他们写一个查询语句，获取所有空余座位，并将它们按照 seat_id 排序后返回吗？
    | seat_id | free |
    |---------|------|
    | 1       | 1    |
    | 2       | 0    |
    | 3       | 1    |
    | 4       | 1    |
    | 5       | 1    |
     
    对于如上样例，你的查询语句应该返回如下结果。
    | seat_id |
    |---------|
    | 3       |
    | 4       |
    | 5       |
    注意：
    seat_id 字段是一个自增的整数，free 字段是布尔类型（'1' 表示空余， '0' 表示已被占据）。
    连续空余座位的定义是大于等于 2 个连续空余的座位。
*/

-- 2.1、解法一：
select distinct C1.seat_id
from cinema C1,cinema C2
where C1.free=1 and C2.free=1 and (C1.seat_id+1=C2.seat_id or C1.seat_id-1=C2.seat_id)
