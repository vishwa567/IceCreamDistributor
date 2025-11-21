-- USER (Password must be encrypted later)
--INSERT INTO users (username, password, role)
--VALUES ('admin', '$2a$10$wHnHOuLrQv3m4yha2she3dpa5ss3word6sample', 'ADMIN');

-- PRODUCTS
INSERT INTO product (name, brand, category, purchase_price, selling_price)
VALUES
('Chocolate Cone', 'Amul', 'Cone', 15, 25),
('Vanilla Cup', 'Kwality', 'Cup', 10, 20),
('Butterscotch Family Pack', 'Amul', 'Family', 80, 120);

-- STOCK (Initial Stock)
INSERT INTO stock (product_id, quantity)
VALUES
(1, 50),
(2, 80),
(3, 20);

-- PURCHASES (Stock Increases)
INSERT INTO purchase (product_id, quantity, total_price)
VALUES
(1, 30, 450),
(2, 20, 200),
(3, 10, 800);

-- SALES (Sale Bills)
INSERT INTO sale (total_amount)
VALUES (145), (260);

-- SALE ITEMS (Sold Items)
INSERT INTO sale_item (sale_id, product_id, quantity, price)
VALUES
(1, 1, 3, 75),      -- Chocolate Cone 3 qty
(1, 2, 2, 40),      -- Vanilla Cup 2 qty
(2, 3, 2, 240);     -- Family pack 2 qty
