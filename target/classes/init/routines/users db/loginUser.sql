CREATE DEFINER=`root`@`localhost` PROCEDURE `loginUser`(
                                IN username VARCHAR(50),
                                IN password VARCHAR(50),
                                OUT authLevel VARCHAR(15),
                                OUT email VARCHAR(100),
                                OUT firstName VARCHAR(30),
                                OUT lastName VARCHAR(30),
                                OUT success VARCHAR(10)
                             )
BEGIN
    DECLARE dbPassword VARCHAR(50);
    DECLARE num int;
    
    SET success = 'false';
    
    SELECT FOUND_ROWS()
    FROM user_information AS u
    WHERE u.username = username
    INTO num;
    
    IF num > 0 THEN
		SELECT u.password
        FROM user_information as u
        WHERE u.username = username
        INTO dbPassword;
        
        IF dbPassword = password THEN
			SET success = 'true';
            SELECT u.userAuthLevel, u.email, u.first_name, u.last_name
            FROM  user_information as u
            WHERE u.username = username
            AND u.username = username
            INTO authLevel, email, firstName, lastName;
            
            UPDATE user_information as u
            SET mostRecentLogIn = current_timestamp
            WHERE u.username = username;
		END IF;
	END IF;
    
END