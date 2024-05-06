INSERT INTO products(product_id,name,description, price, stock, create_at,url_imagen) values(5,'Aretes hilo negro','Aretes',35000,6,now(),'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_IMG_20240223_121702-8d263f7f-fa97-445f-ad96-d57d02ca0e98.jpg');
INSERT INTO products(product_id,name,description, price, stock, create_at,url_imagen) values(110,'Bufanda turquesa','Bufandas',140000,6,now(),'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/product-10-image-2-053b771e-b32f-4ba1-8952-db0a5f10182d.jpg');
INSERT INTO products(product_id,name,description, price, stock, create_at,url_imagen) values(75,'Aretes blancos','Aretes',35000,63,now(),'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/IMG_20240223_121045-16a5e407-e839-4433-9a86-e1aa3a2f4f6f.jpg');
INSERT INTO products(product_id,name,description, price, stock, create_at,url_imagen) values(10,'Ruana negro y verde 66E2','Ruanas',330000,63,now(),'https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/PhotoRoom_011_20221206_194939_compressed-e02f34d9-6211-4ee4-a74d-f86c2b5b9114.jpg');
INSERT INTO Category(name) values('Aretes');
INSERT INTO Category(name) values('Bufandas');
INSERT INTO Category(name) values('Ruanas');
INSERT INTO Category(name) values('Prenda');
INSERT INTO Category(name) values('Accesorio');

INSERT INTO product_category (product_id, id_category) VALUES (5, (SELECT id_category FROM Category WHERE name = 'Aretes'));
INSERT INTO product_category (product_id, id_category) VALUES (10,(SELECT id_category FROM Category WHERE name = 'Ruanas'));
INSERT INTO product_category (product_id, id_category) VALUES (75,(SELECT id_category FROM Category WHERE name = 'Aretes'));
INSERT INTO product_category (product_id, id_category) VALUES (110,(SELECT id_category FROM Category WHERE name = 'Bufandas'));

INSERT INTO product_category (product_id, id_category) VALUES (5, (SELECT id_category FROM Category WHERE name = 'Accesorio'));
INSERT INTO product_category (product_id, id_category) VALUES (75,(SELECT id_category FROM Category WHERE name = 'Accesorio'));

INSERT INTO product_category (product_id, id_category) VALUES (10,(SELECT id_category FROM Category WHERE name = 'Prenda'));
INSERT INTO product_category (product_id, id_category) VALUES (110,(SELECT id_category FROM Category WHERE name = 'Prenda'));

--INSERT INTO product_category(product_id, id_category) VALUES (5, (SELECT id_category FROM Category WHERE name = 'Song'));
--INSERT INTO product_category(product_id, id_category) VALUES (110, (SELECT id_category FROM Category WHERE name = 'Song'));
--INSERT INTO product_category(product_id, id_category) VALUES (75, (SELECT id_category FROM Category WHERE name = 'Objeto'));
--INSERT INTO product_category(product_id, id_category) VALUES (5, (SELECT id_category FROM Category WHERE name = 'Objeto'));


--product.setUrlImagen("https://storagemultimediapro.blob.core.windows.net/9ff1d81a-f5b9-4fe3-8268-8b9b2b601b00/thumbnail_IMG_20240223_121045-16a5e407-e839-4433-9a86-e1aa3a2f4f6f.jpg");