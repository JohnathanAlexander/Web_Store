CREATE DEFINER=`student`@`localhost` PROCEDURE `getProductByProductId`(
											IN prodId VARCHAR(15),
                                            out title VARCHAR(50),
                                            out description VARCHAR(200),
                                            out cost FLOAT,
                                            out price FLOAT,
                                            out image BLOB,
                                            out	inStock INT,
                                            out onOrder INT,
                                            out totalSalesLifetime INT
										 )
BEGIN
	SELECT productName, productDescription, cost, price, image,
		   quantityOnHand, quantityOnOrder, totalSales
	FROM products as p join sales as s join inventory as i
    ON p.productId = s.productId = i.productId
    INTO title, description, cost, price, image, inStock, onOrder, totalSalesLifetime;
    
    SELECT title, description, cost, price, image, inStock, onOrder, totalSalesLifetime;
END