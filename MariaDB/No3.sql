SELECT name AS rank , (SELECT MAX(mount) FROM salary) hightestSalary 
FROM rank WHERE id = (SELECT rank_id FROM user WHERE id = (SELECT user_id FROM salary WHERE mount = (SELECT MAX(mount) FROM salary)) )


