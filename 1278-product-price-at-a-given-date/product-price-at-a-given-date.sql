# Write your MySQL query statement below

SELECT P.product_id, COALESCE(latest_prices.new_price, 10) AS price
FROM (SELECT DISTINCT product_id FROM Products) P
LEFT JOIN (
    SELECT product_id, change_date, new_price
    FROM Products
    WHERE (product_id, change_date) IN (
        SELECT product_id, MAX(change_date) 
        FROM Products 
        WHERE change_date <= '2019-08-16' 
        GROUP BY product_id
    ) 
) AS latest_prices
ON P.product_id = latest_prices.product_id;