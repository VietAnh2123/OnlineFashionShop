--create database PRJ_OnlineShop
use PRJ_OnlineShop

create table category(
	id int identity(0,1) primary key,
	category_name nvarchar(255),
	category_img varchar(max)
)

create table products(
	id int identity(0,1) primary key,
	product_name nvarchar(255),
	[description] ntext,
	price money,
	discount int,
	category_id int,
	images nvarchar(max),
	color nvarchar(255),
	foreign key(category_id) references category(id)
)

/*create table products_img(
	id int identity(0,1) primary key,
	product_id int,
	product_img varchar(500),
	sort_order int,
	foreign key(product_id) references products(id)
)*/

create table size(
	id int identity(0,1) primary key,
	size_name varchar(150),
	stock int,
	product_id int,
	foreign key(product_id) references products(id)
)

create table customers(
	id int identity(0,1) primary key,
	username varchar(255),
	[password] varchar(120),
	fullname nvarchar(500),
	email varchar(255),
	phone_number varchar(20),
	[address] nvarchar(500),
	gender nvarchar(50)
)

create table cart(
	id int identity(0,1) primary key,
	product_id int,
	product_size_id int,
	customer_id int,
	quantity int,
	foreign key(product_id) references products(id),
	foreign key(product_size_id) references size(id),
	foreign key(customer_id) references customers(id)
)

create table orders(
	id int identity(0,1) primary key,
	customer_id int,
	[address] nvarchar(500),
	note ntext,
	total_price money,
	[status] nvarchar(500),
	create_date date,
	foreign key(customer_id) references customers(id)
)

create table order_detail(
	id int identity(0,1) primary key,
	product_size_id int,
	product_id int,
	order_id int,
	quantity int,
	foreign key(product_size_id) references size(id),
	foreign key(product_id) references products(id),
	foreign key(order_id) references orders(id),
)

create table [role](
	id int identity(0,1) primary key,
	role_name nvarchar(255)
)

create table [admin](
	id int identity(0,1) primary key,
	username varchar(255),
	[password] varchar(255),
	role_id int,
	foreign key(role_id) references [role](id)
)

--create database PRJ_OnlineShopDB

insert into role(role_name)
values('admin')

insert into admin(username, password, role_id)
values('vanh', 'admin1',0)
insert into admin(username, password, role_id)
values('tanh', 'admin2',0)
insert into admin(username, password, role_id)
values('thien', 'admin3',0)