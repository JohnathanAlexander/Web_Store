CREATE DEFINER=`student`@`localhost` PROCEDURE `getAllFeaturedProducts`(
											OUT productId VARCHAR(15),
                                            OUT productTitle VARCHAR(20),
                                            OUT productDescription VARCHAR(200),
                                            OUT price DECIMAL,
                                            OUT inStockNum INT,
                                            OUT image BLOB,
                                            OUT imageExtension varchar(10)
										  )
BEGIN
	SELECT p.productId, p.productName, p.productDescription, p.price, i.quantityOnHand, p.image, p.imageExtension
    FROM products as p
    JOIN inventory as i
    ON p.productId = i.productId
    WHERE isFeatured = 'TRUE';
    
    
    SELECT productId, productTitle, productDescription, price, inStockNum, image, imageExtension;
END