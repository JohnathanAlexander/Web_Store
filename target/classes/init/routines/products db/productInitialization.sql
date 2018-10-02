CREATE DEFINER=`student`@`localhost` PROCEDURE `productInitialization`()
BEGIN
	DROP TABLE IF EXISTS inventory;
    DROP TABLE IF EXISTS products;
    DROP TABLE IF EXISTS purchases;
    DROP TABLE IF EXISTS sales;
    
    
END