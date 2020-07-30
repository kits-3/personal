SELECT * FROM product
WHERE brand_id = (
	SELECT id FROM brand
	WHERE id = 2
) 

SELECT * FROM product 
WHERE cate_id = (SELECT id FROM category WHERE id = 1)product

SELECT * FROM category c JOIN product p ON c.id = p.cate_id WHERE c.id = 2

SELECT * FROM product p WHERE p.cate_id = 2customer`order`brand

ALTER TABLE category AUTO_INCREMENT=3;

ALTER TABLE product AUTO_INCREMENT=7;

ALTER TABLE customer AUTO_INCREMENT=1;

SELECT * FROM admin customer

update product set cate_id=2, NAME='Honda CRVV', price=3000, detail='ffff' WHERE id =6 