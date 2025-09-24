-- 1. Create and use database
CREATE DATABASE banksystem;
USE banksystem;

-- 2. Table: signup (Page 1 of signup)
CREATE TABLE signup (
    Form_No VARCHAR(30) PRIMARY KEY,
    name VARCHAR(30),
    Fathers_Name VARCHAR(30),
    DOB VARCHAR(30),
    gender VARCHAR(30),
    email VARCHAR(60),
    MaritalStatus VARCHAR(30),
    address VARCHAR(60),
    cities VARCHAR(30),
    pin VARCHAR(20),
    stateOfcountry VARCHAR(50)
);

-- 3. Table: signupsql2 (Page 2 of signup)
CREATE TABLE signupsql2 (
    Form_No VARCHAR(30) PRIMARY KEY,
    Religion VARCHAR(30),
    Category VARCHAR(30),
    Income VARCHAR(30),
    Education VARCHAR(30),
    Occupation VARCHAR(60),
    PAN_Number VARCHAR(30),
    Senior_Citizen VARCHAR(60),
    Existin_Account VARCHAR(30)
);

-- 4. Table: signupsql3 (Page 3 of signup - generates card & PIN)
CREATE TABLE signupsql3 (
    Form_No VARCHAR(30) PRIMARY KEY,
    Account_type VARCHAR(40),
    card_number VARCHAR(30),
    pin VARCHAR(30),
    Faciltiy VARCHAR(200)  
);

-- 5. Table: login (Used in loginForm.java)
CREATE TABLE login (
    form_no VARCHAR(30),
    card_number VARCHAR(50),
    pin VARCHAR(30),
    PRIMARY KEY (card_number, pin)  
);

-- 6. Table: bank (Transaction history — MOST IMPORTANT for ATM logic)
CREATE TABLE bank (
    Pin VARCHAR(10),
    Date DATETIME,           -- Changed from VARCHAR to DATETIME for proper sorting
    Type VARCHAR(20),        -- "Deposit" or "Withdrawal"
    Amount VARCHAR(20)       -- You store as string — OK for now
);

-- Optional: Add index on Pin for faster balance calculation
CREATE INDEX idx_bank_pin ON bank(Pin);

-- 7. Table: user (You created it — but not used in your Java code)
-- Optional — you can keep or drop
CREATE TABLE user (
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    password VARCHAR(100)
);

-- DONE! Now insert sample data for testing (optional)
INSERT INTO signup VALUES ('1001', 'John Doe', 'Robert Doe', '1990-05-15', 'Male', 'john@email.com', 'Married', '123 Main St', 'New York', '10001', 'NY');
INSERT INTO signupsql2 VALUES ('1001', 'Christian', 'General', '<5,00,000', 'Graduate', 'Salaried', 'ABCDE1234F', 'No', 'Yes');
INSERT INTO signupsql3 VALUES ('1001', 'Saving Account', '1234567890123456', '1234', 'ATM CARD, Internet Banking');
INSERT INTO login VALUES ('1001', '1234567890123456', '1234');

-- Sample transactions
INSERT INTO bank VALUES ('1234', NOW(), 'Deposit', '5000');
INSERT INTO bank VALUES ('1234', NOW(), 'Deposit', '3000');
INSERT INTO bank VALUES ('1234', NOW(), 'Withdrawal', '2000');

select * from bank;
select * from login;
