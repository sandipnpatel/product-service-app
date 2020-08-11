INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME) values (1, 'Sandip', 'Patel');
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME) values (2, 'Laksh', 'Arunachalam');
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME) values (3, 'Sunil', 'Sharma');
INSERT INTO CUSTOMER (ID, FIRST_NAME, LAST_NAME) values (4, 'Radhika', 'Lakshminarayanan');


INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (1, 'pg_savings', 'p_orange_savings', 3.5);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (2, 'pg_savings', 'p_child_savings', 4.1);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (3, 'pg_savings', 'p_unicef_savings', 2.5);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (4, 'pg_savings', 'p_bonus_savings', 4.5);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (5, 'pg_savings', 'p_deposit_savings', 5.0);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (6, 'pg_savings', 'p_green_savings', 3.9);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (7, 'pg_mortgage', 'p_saving_mortgage', 5.2);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (8, 'pg_mortgage', 'p_interest_only_mortgage', 5.3);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (9, 'pg_mortgage', 'p_annuity_mortgage', 5.4);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (10, 'pg_mortgage', 'p_linear_mortgage', 5.5);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (11, 'pg_payments', 'p_payments_account', 1.8);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (12, 'pg_payments', 'p_debit_card', 1.9);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (13, 'pg_payments', 'p_quarterly_limit', 2.1);
INSERT INTO PRODUCT (ID, PRODUCT_GROUP, NAME, INTEREST_RATE) values (14, 'pg_payments', 'p_continuously_limit', 2.1);

INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 1, 1000, 1050, '1234567890');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 2, 2000, 2060, '1234567891');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 3, 3000, 3090, '1234567892');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 4, 4000, 4110, '1234567893');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 5, 5000, 5150, '1234567894');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 6, 6000, 6340, '1234567895');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 7, 7000, 7030, '1234567896');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 8, 8000, 8540, '1234567897');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 9, 9000, 9280, '1234567898');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 10, 10000, 10189, '1234567899');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 11, 11000, 11230, '1234567811');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 12, 12000, 12580, '1234567812');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 13, 13000, 13800, '1234567813');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (1, 14, 14000, 14650, '1234567814');

INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (2, 1, 25000, 25500, '1234557890');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (2, 4, 50000, 50800, '1234557891');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (2, 6, 75000, 76000, '1234557892');

INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (3, 7, 300000, 304000, '1234577890');
INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (3, 9, 400000, 408000, '1234577891');

INSERT INTO CUSTOMER_PRODUCT (CUSTOMER_ID, PRODUCT_ID, AMOUNT, MATURITY_AMOUNT, ACCOUNT_NUMBER) values (4, 12, 60000, 62000, '1234568891');