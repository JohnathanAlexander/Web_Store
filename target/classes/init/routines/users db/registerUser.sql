CREATE DEFINER=`root`@`localhost` PROCEDURE `registerUser`(
                                     IN new_username VARCHAR(50),
                                     IN new_password VARCHAR(50),
                                     IN new_email       VARCHAR(100),
                                     IN new_first_name VARCHAR(50),
                                     IN new_last_name VARCHAR(50),
                                     OUT message VARCHAR(20)
                                 )
BEGIN
    -- Must check that username doesn't already exist and that email doesn't exist
    DECLARE NUM_USERNAME_DUP INT;
    DECLARE NUM_EMAIL_DUP INT;
    
    SELECT FOUND_ROWS()
    FROM login
    WHERE username = new_username
    INTO NUM_USERNAME_DUP;
    
    -- SELECT FOUND_ROWS() INTO NUM_USERNAME_DUP;
    
    SELECT FOUND_ROWS()
    FROM user_information
    where email = new_email
    INTO NUM_EMAIL_DUP;
    
    -- SELECT FOUND_ROWS() INTO NUM_EMAIL_DUP;
    SET message = 'success';
    IF NUM_USERNAME_DUP > 0 THEN
        SET message = 'usernameError';
    END IF;
    IF NUM_EMAIL_DUP > 0 THEN
        SET message = 'emailError';
    END IF;
       
    IF STRCMP(message, 'success') THEN -- message = 'success' THEN
        INSERT INTO user_information(username, first_name, last_name, email)
        VALUES(new_username, new_first_name, new_last_name, new_email);

        INSERT INTO login(username, password, userAuthLevel)
        VALUES(new_username, new_password, "user");
    END IF;
    select message;
    
    
END