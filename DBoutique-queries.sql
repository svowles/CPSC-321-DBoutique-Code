-- View what inventory is doing well or not well for particular stores
 -- Doing well = most purchases
 -- Not doing well = least amount of purchases
-- View what inventory is doing well or not well for all stores
 -- Doing well = most purchases
 -- Not doing well = least amount of purchases
-- What brands do well in the stores
 -- Do well = most sales

-- To display sales of particular store, we’ll need to use aggregation and grouping
SELECT s1.store_name, SUM(s.sale_price), COUNT(*)
FROM sale s, store s1 
WHERE s.store_id = s1.store_id 
AND s1.store_id = 01;

SELECT s1.store_id, SUM(s.sale_price), COUNT(*)
FROM sale s, store s1 
WHERE s1.store_name = 'Sew Lovely'
AND s.store_id = s1.store_id; 

-- View what inventory is doing well or not well for particular stores
 -- Doing well = most purchases
 -- Not doing well = least amount of purchases

 -- For a particular store, this displays the inventory items that have been sold at least once
 -- and the count of how many times this item has been sold 
SELECT s.inventory_item_id, b.brand_name, ic.category_name, COUNT(*) 
FROM sale s JOIN store s1 JOIN inventory_item i JOIN inventory_category ic JOIN brand b
WHERE s1.store_id = 01
AND s.store_id = s1.store_id
AND s.inventory_item_id = i.inventory_item_id
AND i.category_id = ic.category_id
AND i.brand_id = b.brand_id 
GROUP BY s.inventory_item_id 
ORDER BY COUNT(*) DESC;

-- For a particular store, what inventory_items have not been sold, just realized we can't do this
-- because don't record what items a particular store holds just what they sell.
SELECT i.inventory_item_id, s.sale_id, s1.store_name, s1.store_id
FROM inventory_item i LEFT JOIN sale s USING(inventory_item_id) JOIN store s1
WHERE s.store_id = s1.store_id
AND s.store_id = 1;

SELECT i.inventory_item_id, s.sale_id, s1.store_name, s1.store_id
FROM (select i2.inventory_item_id
      from inventory_item, store s2
      where )

 LEFT JOIN sale s USING(inventory_item_id) JOIN store s1
WHERE s.store_id = s1.store_id
AND s.store_id = 1;


-- inventory items that have not been sold at a particular store
SELECT inventory_item.inventory_item_id 
FROM inventory_item LEFT JOIN sale USING(inventory_item_id)
WHERE sale.store_id = 0;

SELECT inventory_item.inventory_item_id 
FROM inventory_item;

SELECT * FROM inventory_item LEFT JOIN sale USING (inventory_item_id);
WHERE sale.store_id = 0;

-- !! this is a good one, inventory that has not been sold at a particular store
select * from
(select i.inventory_item_id, brand_id, category_id from inventory_item i
LEFT JOIN (select i2.inventory_item_id, store_id from inventory_item i2 JOIN sale USING (inventory_item_id) where store_id = 0) AS T
ON (T.inventory_item_id = i.inventory_item_id)
WHERE store_id IS NULL) AS U JOIN brand JOIN inventory_category WHERE U.brand_id = brand.brand_id and U.category_id = inventory_category.category_id;
-- inventory that has not been sold at any of the stores.
SELECT inventory_item.inventory_item_id, brand.brand_name, inventory_category.category_name
FROM inventory_item LEFT JOIN sale USING(inventory_item_id) JOIN brand JOIN inventory_category
WHERE sale.sale_id IS NULL
AND inventory_item.brand_id = brand.brand_id
AND inventory_item.category_id = inventory_category.category_id;


-- what items are selling the best in all stores?
SELECT sale.inventory_item_id, brand.brand_name, inventory_category.category_name, COUNT(*) 
FROM sale, inventory_item, brand, inventory_category
WHERE sale.inventory_item_id = inventory_item.inventory_item_id 
and inventory_item.category_id = inventory_category.category_id
and inventory_item.brand_id = brand.brand_id
GROUP BY inventory_item_id
HAVING COUNT(*) >= ALL (SELECT COUNT(*) FROM sale GROUP BY inventory_item_id);

-- what item/items are selling the best in a particular store?
SELECT sale.inventory_item_id, brand.brand_name, inventory_category.category_name, COUNT(*) 
FROM sale, inventory_item, brand, inventory_category
WHERE sale.inventory_item_id = inventory_item.inventory_item_id 
and inventory_item.category_id = inventory_category.category_id
and inventory_item.brand_id = brand.brand_id
and sale.store_id = 01
GROUP BY inventory_item_id
HAVING COUNT(*) >= ALL (SELECT COUNT(*) FROM sale WHERE sale.store_id = 01 GROUP BY inventory_item_id);

-- to display what brands are doing well? WHat brand has the most sales?
SELECT brand.brand_id, brand.brand_name, COUNT(*), SUM(sale.sale_price)
FROM sale, inventory_item, brand
WHERE sale.inventory_item_id = inventory_item.inventory_item_id
AND inventory_item.brand_id = brand.brand_id
GROUP BY brand.brand_id
ORDER BY SUM(sale.sale_price) DESC;

-- to display what brands are doing well for a particular store
SELECT brand.brand_id, brand.brand_name, COUNT(*), SUM(sale.sale_price)
FROM sale, inventory_item, brand
WHERE sale.inventory_item_id = inventory_item.inventory_item_id
AND inventory_item.brand_id = brand.brand_id
AND sale.store_id = 01
GROUP BY brand.brand_id
ORDER BY SUM(sale.sale_price) DESC;

