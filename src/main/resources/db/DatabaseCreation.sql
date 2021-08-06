create table if not exists "Basket"
(
	id serial not null
		constraint basket_pk
			primary key,
	userid integer not null,
	productid integer not null,
	basketstate varchar not null
);
create table "Product"
(
	id serial not null
		constraint "Product_pkey"
			primary key,
	prodname varchar not null,
	price integer not null,
	prodquantity integer not null,
	prodinfo varchar not null
);
create table "User"
(
	id serial not null
		constraint "User_pkey"
			primary key,
	username varchar not null,
	role varchar not null,
	mailcontact varchar not null,
	login varchar not null,
	password varchar not null
);