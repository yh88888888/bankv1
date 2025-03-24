insert into user_tb(username, password, fullname, createdAt)
values('ssar','1234','쌀',now());
insert into user_tb(username, password, fullname, createdAt)
values('cos','1234','코스',now());

insert into account_tb(number, password, balance, user_id, createdAt)
values(1111,'1234',900, 1,now());
insert into account_tb(number, password, balance, user_id, createdAt)
values(2222,'1234',1100, 1,now());
insert into account_tb(number, password, balance, user_id, createdAt)
values(3333,'1234',1000, 2,now());

insert into history_tb(withdraw_number, deposit_number, amount, withdraw_balance, createdAt)
values(1111,2222,100, 900, now());

insert into history_tb(withdraw_number, deposit_number, amount, withdraw_balance, createdAt)
values(1111,3333,100, 800, now());

insert into history_tb(withdraw_number, deposit_number, amount, withdraw_balance, createdAt)
values(3333,1111,100, 1000, now());