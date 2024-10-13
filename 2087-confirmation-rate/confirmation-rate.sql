# Write your MySQL query statement below


SELECT S.user_id, IF(C.user_id IS NULL, 0, ROUND(SUM(C.action = 'Confirmed')/ COUNT(C.user_id), 2)) AS confirmation_rate
FROM Signups S
LEFT JOIN Confirmations C
ON S.user_id = C.user_id
GROUP BY S.user_id;
