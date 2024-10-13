# Write your MySQL query statement below

SELECT M.name
FROM Employee E
JOIN Employee M
ON E.managerId = M.id
GROUP BY M.Id
HAVING COUNT(*) >= 5;
