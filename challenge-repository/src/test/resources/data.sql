/**
 * Author:  carlos
 * Created: 28/09/2019
 */

INSERT INTO category (id, name) VALUES (1, 'Brinquedo');
INSERT INTO category (id, name) VALUES (2, 'Medicamento');

INSERT INTO product (id, name) VALUES (1, 'HotWheels');
INSERT INTO product (id, name) VALUES (2, 'Xarope');

INSERT INTO category_product(category_id, product_id) values (1, 1); 
INSERT INTO category_product(category_id, product_id) values (2, 2);