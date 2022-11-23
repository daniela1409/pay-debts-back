CREATE SCHEMA `db_pay_debts` ;

INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(1, 'Bancolombia', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(2, 'Banco de Bogota', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(3, 'Banco de Occidente', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(4, 'Banco Caja Social', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(5, 'Banco ABVillas', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(6, 'Banco Popular', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(7, 'Banco BBVA', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(8, 'Banco Davivienda', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(9, 'Banco Santander', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(10, 'Banco Agrario', NOW());
INSERT INTO db_pay_debts.banks (id, name, create_at) VALUES(11, 'Banco Colpatria', NOW());

INSERT INTO db_pay_debts.users (id, name, address, email, password, phone, create_at) VALUES('psX5PbFyD2ecmchB2pbMnFIycHP2','Paseo de Sevilla' , 'Daniela Osorio', 'jedagos1409@gmail.com', 140994, '3014510118', NOW());

INSERT INTO db_pay_debts.debts (id, quotas_number, total_count, total_debt, bank_id, user_id, status, quota_value, create_at) VALUES(1, 0, 10000000, 10000000,  1, 'psX5PbFyD2ecmchB2pbMnFIycHP2', true, 0, NOW());
INSERT INTO db_pay_debts.debts (id, quotas_number, total_count, total_debt, bank_id, user_id, status, quota_value,  create_at) VALUES(2, 0, 5000000, 5000000,  1, 'psX5PbFyD2ecmchB2pbMnFIycHP2', true, 0,  NOW());
INSERT INTO db_pay_debts.debts (id, quotas_number, total_count, total_debt, bank_id, user_id, status, quota_value,  create_at) VALUES(3, 0, 20000000, 20000000,  2, 'psX5PbFyD2ecmchB2pbMnFIycHP2', true, 0,  NOW());
INSERT INTO db_pay_debts.debts (id, quotas_number, total_count, total_debt, bank_id, user_id, status, quota_value,  create_at) VALUES(4, 0, 3000000, 3000000,  2, 'psX5PbFyD2ecmchB2pbMnFIycHP2', true, 0,  NOW());

INSERT INTO db_pay_debts.user_banks (user_id, bank_id) VALUES('psX5PbFyD2ecmchB2pbMnFIycHP2',1);
INSERT INTO db_pay_debts.user_banks (user_id, bank_id) VALUES('psX5PbFyD2ecmchB2pbMnFIycHP2',2);