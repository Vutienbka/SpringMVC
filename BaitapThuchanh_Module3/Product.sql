CREATE database Product;
use Product;
drop database Product;

CREATE TABLE Product(
productId int not null primary key auto_increment,
productName nvarchar(50),
price Int not null,
quantity Int not null,
color nvarchar(50),
description nvarchar(50),
categorize nvarchar(50)
);

INSERT INTO Product VALUES
(1,'Iphone X', 20000, 1, 'red','Good Product', 'Iphone'),
(2,'Iphone 10', 20000, 2, 'blue','Good Product', 'Iphone'),
(3,'Iphone 11', 20000, 1, 'cyan','Good Product', 'Iphone')
;

select * From Product;