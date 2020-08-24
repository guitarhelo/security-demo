CREATE TABLE EMPLOYEE
(
    ID INT NOT NULL AUTO_INCREMENT,
    FIRSTNAME VARCHAR(30),
    LASTNAME VARCHAR(30),
    PRIMARY KEY(ID)
);

insert into Employee (ID,FIRSTNAME,LASTNAME) values(101, 'John','Smith');
insert into Employee (ID,FIRSTNAME,LASTNAME) values(102, 'David','Jones');