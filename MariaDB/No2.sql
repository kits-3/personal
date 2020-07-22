SELECT a.name  , Sum(c.mount) totalSalary 
FROM dprtmt a, user b, salary c
WHERE a.id = b.dprtmt_id AND b.id = c.user_id
GROUP BY	b.dprtmt_id
ORDER BY Sum(c.mount) DESC
LIMIT 1
		

		
		
		


 