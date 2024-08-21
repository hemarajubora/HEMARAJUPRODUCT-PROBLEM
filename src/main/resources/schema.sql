create table if not exists product(
    productId int PRIMARY KEY AUTO_INCREMENT,
    productName varchar(250),
    price double 
);
create table if not exists review(
    reviewId int PRIMARY KEY AUTO_INCREMENT,
    reviewContent varchar(250),
    rating int,
    productId int,
    FOREIGN KEY(productId) REFERENCES product(productId)
);