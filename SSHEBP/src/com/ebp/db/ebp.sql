create database ebp;

use ebp;

create table category(
	id int primary key not null auto_increment,
	name varchar(20) not null unique,
	parent_id int default null
);

create table book(
	id int primary key not null auto_increment,
	name varchar(40) not null,
	author varchar(20) not null,
	descration varchar(200) not null,
	oldprice double(5, 2) not null,
	price double(5, 2) not null,
	filename varchar(100) not null,
	amount int(11) not null,
	category_id int not null,
	delete_id int not null default 0,
	constraint category_id_fk foreign key(category_id) references category(id)
);

create table adminuser(
	id int primary key not null,
	username varchar(20) not null unique,
	password varchar(36) not null
);

create table user(
	id int primary key not null auto_increment,
	name varchar(20),
	username varchar(20) not null unique,
	password varchar(36) not null,
	phone varchar(16),
	gender char(1),
	registerTime datetime not null,
	balance double(10, 2) default 0
);

create table orders(
	id varchar(40) primary key not null,
	orderNum varchar(40) not null unique,
	createTime datetime not null,
	price double(10, 2) not null,
	user_id int not null,
	isdelete int not null default 0s,
	constraint user_id_fk foreign key(user_id) references user(id)
);

create table item(
	id int primary key not null auto_increment,
	price double(5, 2) not null,
	amount int not null,
	orders_id varchar(40) not null,
	book_id int not null,
	constraint order_id_fk foreign key(order_id) references orders(id),
	constraint book_id_fk foreign key(book_id) references book(id)
);

insert into category(id, name, parent_id) values(7, '原创文学', null);
insert into category(id, name, parent_id) values(8, '文学理论', 7);
insert into category(id, name, parent_id) values(9, '影视文学', 7);
insert into category(id, name, parent_id) values(10, '民间文学', 7);
insert into category(id, name, parent_id) values(11, '戏曲曲艺', 7);
insert into category(id, name, parent_id) values(12, '自然科学', null);
insert into category(id, name, parent_id) values(13, '哲学', 12);
insert into category(id, name, parent_id) values(14, '社会学', 12);
insert into category(id, name, parent_id) values(15, '国学', 12);
insert into category(id, name, parent_id) values(16, '文化', 12);
insert into category(id, name, parent_id) values(17, '动漫', null);
insert into category(id, name, parent_id) values(18, '幽默', 17);
insert into category(id, name, parent_id) values(19, '爆笑', 17);
insert into category(id, name, parent_id) values(20, '军事', null);
insert into category(id, name, parent_id) values(21, '中国共产党', 20);

------------wangjiafu-----------

insert into category(id, name, parent_id) values(22, '历史', null);
insert into category(id, name, parent_id) values(23, '中华上下五千年', 22);
insert into category(id, name, parent_id) values(221, '大洋洲史', 22);
insert into category(id, name, parent_id) values(222, '地方志史', 22);
insert into category(id, name, parent_id) values(223, '风俗习惯', 22);
insert into category(id, name, parent_id) values(224, '文物考古', 22);
insert into category(id, name, parent_id) values(225, '史学理论', 22);

insert into category(id, name, parent_id) values(27, '传记其他', null);
insert into category(id, name, parent_id) values(271, '历代帝王', 27);
insert into category(id, name, parent_id) values(272, '科学家', 27);
insert into category(id, name, parent_id) values(273, '学者', 27);
insert into category(id, name, parent_id) values(274, '人物合集', 27);
insert into category(id, name, parent_id) values(275, '领袖首脑', 27);
-----------wangjiafu-----------

insert into category(id, name, parent_id) values(24, '少儿', null);
insert into category(id, name, parent_id) values(25, '启蒙', 24);
insert into category(id, name, parent_id) values(26, '进口原版', null);
insert into category(id, name, parent_id) values(28, '艺术', null); 
insert into category(id, name, parent_id) values(281, '书法', 28); 
insert into category(id, name, parent_id) values(282, '建筑', 28);
insert into category(id, name, parent_id) values(283, '摄影', 28); 
insert into category(id, name, parent_id) values(284, '舞蹈', 28);
insert into category(id, name, parent_id) values(29, '生活', null);
insert into category(id, name, parent_id) values(291, '政治军事', 20);
insert into category(id, name, parent_id) values(292, '政治理论', 20);
insert into category(id, name, parent_id) values(293, '中国政治', 20);
insert into category(id, name, parent_id) values(294, '美食', 29); 
insert into category(id, name, parent_id) values(295, '亲自家教', 29);
insert into category(id, name, parent_id) values(296, '养生保健', 29); 
insert into category(id, name, parent_id) values(297, '新闻人物', 29);

insert into category(id, name, parent_id) values(261, '艺术摄影', 26);
insert into category(id, name, parent_id) values(262, '童书', 26);
insert into category(id, name, parent_id) values(241, '幼儿启蒙', 24);
insert into category(id, name, parent_id) values(243, '科普百科', 24);
insert into category(id, name, parent_id) values(244, '少儿英语', 24);
insert into category(id, name, parent_id) values(245, '绘画书法', 24);
insert into category(id, name, parent_id) values(246, '智力游戏', 24);
insert into category(id, name, parent_id) values(171, '卡通画', 17);
insert into category(id, name, parent_id) values(172, '插图本', 17);
insert into category(id, name, parent_id) values(173, '建筑', 17);
insert into category(id, name, parent_id) values(174, '舞蹈', 17);
insert into category(id, name, parent_id) values(175, '摄影', 17);
insert into category(id, name, parent_id) values(176, '轻小说', 17);





insert into book(name, author, descration, oldprice, price, filename, amount, category_id) value('定位系列经典收藏版（共19册）', '牛顿', '商业人士必读系列，开创“胜出竞争”的营销之道。', '48.9', '25.6', 'images/3/12/FJLSDJF-FJOSF323-FJADF-DFJDSA.jpg', 2000, 4);
insert into book(name, author, descration, oldprice, price, filename, amount, category_id) value('经典超译本：理想国', '艾莉森', '内容广博，涉及哲学、政治伦理、教育、心理、社会、家庭、宗教、技术', '50.9', '45.6', 'images/4/3/3JDJF-FSF323-FJADF-DFJDSA.jpg', 1000, 9);


insert into user(name, username, password, registerTime) values('张三', 'zhangsan', 'FJDJFL7IF', now());


insert into orders(id, orderNum, createTime, price, user_id) values('FJDLJFLAHDF73213', '201691874921349326491297', now(), 628, 1);
insert into orders(id, orderNum, createTime, price, user_id) values('FJDLJFLAHDF73223', '201691874917349326491297', now(), 618, 2);
insert into orders(id, orderNum, createTime, price, user_id) values('FJDLJFLAHDF73233', '201691871927349322221297', now(), 648, 4);
insert into orders(id, orderNum, createTime, price, user_id) values('FJDLJFLAHDF73243', '201681874927349323391297', now(), 678, 5);
insert into orders(id, orderNum, createTime, price, user_id) values('FJDLJFLAHDF73253', '201691874927349116491297', now(), 78, 3);
insert into orders(id, orderNum, createTime, price, user_id) values('FJDLJFLAHDF73263', '201691874927349326111297', now(), 672, 4);
insert into orders(id, orderNum, createTime, price, user_id) values('FJDLJFLAHDF73273', '201691874927349326492297', now(), 670, 2);

insert into orders(id, orderNum, createTime, price, user_id, isdelete) values('FJDLJFLAHDF73293', '201691874927349326491297', now(), 678, 1, 0);
insert into orders(id, orderNum, createTime, price, user_id, isdelete) values('FJDLJFLAHDF12546', '201691874927349326491145', now(), 678, 1, 0);


insert into item(price, amount, order_id, book_id) values(213, 3, 'FJDLJFLAHDF73253', 1);
insert into item(price, amount, order_id, book_id) values(254, 1, 'FJDLJFLAHDF73293', 2);

insert into item(price, amount, order_id, book_id) values(123, 3, 'FJDLJFLAHDF12546', 2);



select u.name ,o.* , i.* from user u ,orders o,item i where u.id = o.user_id and o.id = i.order_id;
select u.name ,o.* , i.*,b.* from user u ,orders o,item i,book b where u.id = o.user_id and o.id = i.order_id and b.id = i.book_id;

