SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Indexes */

DROP INDEX FKh1rpx0qlb42dq81f2v1ow5oqh ON categorysecond;
DROP INDEX FK3933auil4yrjm19ay5e6hqh5r ON orderitem;
DROP INDEX FK7mcli5k2f54bo1qfowdshbqgb ON orderitem;
DROP INDEX uid ON orders;
DROP INDEX FKplnnjf0f0gfppee3hnnxnwx9p ON pet;



/* Drop Tables */

DROP TABLE IF EXISTS adminuser;
DROP TABLE IF EXISTS orderitem;
DROP TABLE IF EXISTS pet;
DROP TABLE IF EXISTS categorysecond;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS wallet;
DROP TABLE IF EXISTS user;



create database pettrade;
/* Create Tables */

CREATE TABLE adminuser
(
	uid int NOT NULL AUTO_INCREMENT,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	PRIMARY KEY (uid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE category
(
	-- 主键
	cid int NOT NULL AUTO_INCREMENT COMMENT '主键',
	-- 一级类目名称
	cname varchar(255) NOT NULL COMMENT '一级类目名称',
	discount float DEFAULT 0 NOT NULL,
	privilegeTime datetime,
	PRIMARY KEY (cid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE categorysecond
(
	-- 二级类目主键
	csid int NOT NULL AUTO_INCREMENT COMMENT '二级类目主键',
	-- 二级类目名
	csname varchar(255) NOT NULL COMMENT '二级类目名',
	-- 主键
	cid int NOT NULL COMMENT '主键',
	PRIMARY KEY (csid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE orderitem
(
	-- 订单详情ID
	itemid int NOT NULL AUTO_INCREMENT COMMENT '订单详情ID',
	-- 数量
	count int DEFAULT 0 NOT NULL COMMENT '数量',
	-- 小计
	subtotal float DEFAULT 0 NOT NULL COMMENT '小计',
	-- 宠物主键
	pid int NOT NULL COMMENT '宠物主键',
	oid int NOT NULL,
	PRIMARY KEY (itemid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE orders
(
	oid int NOT NULL AUTO_INCREMENT,
	-- 收货地址
	address varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci COMMENT '收货地址',
	-- 真实姓名
	-- 
	name varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci COMMENT '真实姓名
',
	-- 电话
	phone varchar(16) CHARACTER SET gbk COLLATE gbk_chinese_ci COMMENT '电话',
	-- 状态
	state int DEFAULT 0 NOT NULL COMMENT '状态',
	-- 订单支付总金额
	total float DEFAULT 0 NOT NULL COMMENT '订单支付总金额',
	uid int NOT NULL,
	order_time datetime,
	PRIMARY KEY (oid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE pet
(
	-- 宠物主键
	pid int NOT NULL AUTO_INCREMENT COMMENT '宠物主键',
	-- 宠物名
	pname varchar(255) NOT NULL COMMENT '宠物名',
	-- 市场价格
	mark_price float NOT NULL COMMENT '市场价格',
	-- 实际价格
	shop_price float NOT NULL COMMENT '实际价格',
	-- 宠物库存
	inventory int DEFAULT 0 NOT NULL COMMENT '宠物库存',
	-- 宠物图片
	image varchar(255) COMMENT '宠物图片',
	-- 宠物描述
	pdesc varchar(255) COMMENT '宠物描述',
	-- 热门宠物
	is_hot int NOT NULL COMMENT '热门宠物',
	-- 日期
	pdate datetime NOT NULL COMMENT '日期',
	-- 二级类目主键
	csid int NOT NULL COMMENT '二级类目主键',
	PRIMARY KEY (pid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE user
(
	uid int NOT NULL AUTO_INCREMENT,
	-- 用户名
	username varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
	-- 密码
	password varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
	-- 真实姓名
	-- 
	name varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '真实姓名
',
	-- 邮箱
	email varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '邮箱',
	phone varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	-- 收货地址
	address varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '收货地址',
	-- 状态
	state int DEFAULT 0 NOT NULL COMMENT '状态',
	code varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
	pwd_key varchar(6) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
	PRIMARY KEY (uid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;


CREATE TABLE wallet
(
	-- 钱包
	wid int NOT NULL AUTO_INCREMENT COMMENT '钱包',
	money float DEFAULT 0 NOT NULL,
	uid int NOT NULL,
	PRIMARY KEY (wid),
	UNIQUE (uid)
) DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;



/* Create Foreign Keys */

ALTER TABLE categorysecond
	ADD CONSTRAINT FKh1rpx0qlb42dq81f2v1ow5oqh FOREIGN KEY (cid)
	REFERENCES category (cid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE categorysecond
	ADD CONSTRAINT categorysecond_ibfk_1 FOREIGN KEY (cid)
	REFERENCES category (cid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE pet
	ADD CONSTRAINT FKplnnjf0f0gfppee3hnnxnwx9p FOREIGN KEY (csid)
	REFERENCES categorysecond (csid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE pet
	ADD CONSTRAINT pet_ibfk_1 FOREIGN KEY (csid)
	REFERENCES categorysecond (csid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE orderitem
	ADD CONSTRAINT FK3933auil4yrjm19ay5e6hqh5r FOREIGN KEY (oid)
	REFERENCES orders (oid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE orderitem
	ADD CONSTRAINT orderitem_ibfk_1 FOREIGN KEY (oid)
	REFERENCES orders (oid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE orderitem
	ADD CONSTRAINT orderitem_ibfk_2 FOREIGN KEY (pid)
	REFERENCES pet (pid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE orderitem
	ADD CONSTRAINT FK7mcli5k2f54bo1qfowdshbqgb FOREIGN KEY (pid)
	REFERENCES pet (pid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE orders
	ADD CONSTRAINT orders_ibfk_1 FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE orders
	ADD CONSTRAINT FK58x4l9shxmkb7pismj4ilt7pj FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE wallet
	ADD CONSTRAINT FKqpgqqo01nnlyat6maj8maskl1 FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;


ALTER TABLE wallet
	ADD CONSTRAINT wallet_ibfk_1 FOREIGN KEY (uid)
	REFERENCES user (uid)
	ON UPDATE NO ACTION
	ON DELETE NO ACTION
;



/* Create Indexes */

CREATE INDEX FKh1rpx0qlb42dq81f2v1ow5oqh USING BTREE ON categorysecond (cid ASC);
CREATE INDEX FK3933auil4yrjm19ay5e6hqh5r USING BTREE ON orderitem (oid ASC);
CREATE INDEX FK7mcli5k2f54bo1qfowdshbqgb USING BTREE ON orderitem (pid ASC);
CREATE INDEX uid USING BTREE ON orders (uid ASC);
CREATE INDEX FKplnnjf0f0gfppee3hnnxnwx9p USING BTREE ON pet (csid ASC);



