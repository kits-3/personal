SELECT a.name  , avg(c.mount) totalSalary 
FROM rank a, user b, salary c
WHERE a.id = b.rank_id AND b.id = c.user_id
GROUP BY	b.rank_id
ORDER BY avg(c.mount) DESC
LIMIT 1