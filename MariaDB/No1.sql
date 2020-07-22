SELECT NAME , (SELECT MAX(mount) FROM salary) hightestSalary
FROM user 
WHERE id =  (	SELECT user_id 
					FROM salary 
					WHERE mount =  (SELECT MAX(mount) 
											FROM salary) )
											
							
SELECT a.name, AVG(b.mount) n  
FROM user a, salary b
WHERE a.id = b.user_id
GROUP BY b.user_id
ORDER BY AVG(b.mount) DESC	
LIMIT 3 
