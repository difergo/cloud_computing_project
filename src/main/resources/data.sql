INSERT INTO tbl_currencies (id,name,symbol,rank) VALUES(1,'Bitcoin','BTC',1);
INSERT INTO tbl_currencies (id,name,symbol,rank) VALUES(2,'Dogecoin','DOGE',2);

insert into tbl_quotes (id,name,symbol,price,last_update,currency_id) values (1,'Dolar','USD',5000.5,CURRENT_TIMESTAMP(),1);
insert into tbl_quotes (id,name,symbol,price,last_update,currency_id) values (2,'Dolar','USD',4000.4,CURRENT_TIMESTAMP(),2);


