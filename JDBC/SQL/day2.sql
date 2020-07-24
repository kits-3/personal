SELECT NAME FROM user WHERE id = (SELECT user_id FROM salary WHERE mount=(SELECT MAX(mount) FROM salary))

SELECT a.name FROM user a, salary b WHERE a.id=b.user_id GROUP BY b.user_id ORDER BY AVG(b.mount) DESC LIMIT 1

SELECT a.name, SUM(c.mount) FROM dprtmt a, user b, salary c WHERE a.id = b.dprtmt_id AND b.id=c.user_id 
GROUP BY b.dprtmt_id ORDER BY SUM(c.mount) DESC LIMIT 1

SELECT a.name,AVG(c.mount) FROM rank a, user b, salary c WHERE a.id = b.rank_id AND b.id=c.user_id 
GROUP BY b.rank_id ORDER BY AVG(c.mount) DESC LIMIT 1

SELECT AVG(mount) FROM salary WHERE user_id=1car