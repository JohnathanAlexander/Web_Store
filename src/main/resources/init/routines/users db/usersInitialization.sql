CREATE DEFINER=`student`@`localhost` PROCEDURE `usersInitialization`()
BEGIN
    
    
    DROP TABLE IF EXISTS `login`;
    DROP TABLE IF EXISTS `user_information`;
    
    CREATE TABLE login(
						recordId int primary key not null unique auto_increment,
						username varchar(50) not null unique,
                        password varchar(50) not null,
                        userAuthLevel varchar(15) not null default 'user'
					  );
	CREATE TABLE user_information(
						recordId int primary key not null unique auto_increment,
                        username varchar(50) not null unique,
                        first_name varchar(20),
                        last_name varchar(20),
                        email varchar(50) not null unique
						);
    
    INSERT INTO login(username, password, userAuthLevel)
    VALUES('masteruser', 'admin1', 'admin'),('jalexander32', 'Schlicher12!', 'user'),('jalex135','Schlicher12!john','manager');
    
    INSERT INTO user_information(username, first_name, last_name, email)
    VALUES('masteruser', 'master', 'master', 'master@alexandersEmp.com'),('jalexander32', 'Johnathan', 'Alexander', 'j@aol.com'),
          ('jalex135', 'Justin', 'Alexander', 'justinAlex@gmail.com');
    
END