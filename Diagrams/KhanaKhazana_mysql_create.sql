CREATE TABLE `Users` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`username` varchar(255) NOT NULL UNIQUE,
	`password` varchar(255) NOT NULL,
	`mobile` varchar(10) NOT NULL,
	`email` varchar(255) NOT NULL UNIQUE,
	`role` varchar(255) NOT NULL,
	`address` varchar(255) NOT NULL,
	`profilePic` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Restaurant` (
	`restaurantId` bigint NOT NULL AUTO_INCREMENT,
	`restaurantName` varchar(255) NOT NULL UNIQUE,
	`restaurantDesc` varchar(255) NOT NULL,
	`restaurantRating` FLOAT NOT NULL DEFAULT '1',
	`restaurantAddr` varchar(255) NOT NULL,
	`managerId` varchar(255) NOT NULL,
	`restaurantLogo` varchar(255) NOT NULL,
	PRIMARY KEY (`restaurantId`)
);

CREATE TABLE `Cart` (
	`userId` bigint NOT NULL,
	`foodTitle` varchar(255) NOT NULL,
	`foodType` varchar(255) NOT NULL,
	`foodCost` double NOT NULL,
	`inStock` BOOLEAN NOT NULL,
	`restaurantId` bigint NOT NULL,
	`foodQty` int NOT NULL
);

CREATE TABLE `Payment` (
	`paymentId` bigint NOT NULL AUTO_INCREMENT,
	`amount` double NOT NULL,
	`paymentType` varchar(255) NOT NULL,
	`paymentStatus` BOOLEAN NOT NULL,
	`couponId` bigint NOT NULL,
	PRIMARY KEY (`paymentId`)
);

CREATE TABLE `CheckOut` (
	`transactionId` bigint NOT NULL AUTO_INCREMENT,
	`timeStamp` DATE NOT NULL,
	`paymentType` varchar(255) NOT NULL,
	`restaurantAddr` varchar(255) NOT NULL,
	`deliveryAddr` varchar(255) NOT NULL,
	PRIMARY KEY (`transactionId`)
);

CREATE TABLE `Food` (
	`foodId` bigint NOT NULL AUTO_INCREMENT,
	`foodTitle` varchar(255) NOT NULL,
	`foodType` varchar(255) NOT NULL,
	`foodDesc` varchar(255) NOT NULL,
	`foodCost` double NOT NULL,
	`restaurantId` bigint NOT NULL,
	`inStock` BOOLEAN NOT NULL,
	`foodImage` varchar(255) NOT NULL,
	PRIMARY KEY (`foodId`)
);

CREATE TABLE `Coupons` (
	`couponId` bigint NOT NULL AUTO_INCREMENT,
	`couponAmt` bigint NOT NULL,
	PRIMARY KEY (`couponId`)
);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk0` FOREIGN KEY (`userId`) REFERENCES `Users`(`id`);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk1` FOREIGN KEY (`inStock`) REFERENCES `Food`(`inStock`);

ALTER TABLE `Cart` ADD CONSTRAINT `Cart_fk2` FOREIGN KEY (`restaurantId`) REFERENCES `Restaurant`(`restaurantId`);

ALTER TABLE `Payment` ADD CONSTRAINT `Payment_fk0` FOREIGN KEY (`couponId`) REFERENCES `Coupons`(`couponId`);

ALTER TABLE `CheckOut` ADD CONSTRAINT `CheckOut_fk0` FOREIGN KEY (`paymentType`) REFERENCES `Payment`(`paymentType`);

ALTER TABLE `CheckOut` ADD CONSTRAINT `CheckOut_fk1` FOREIGN KEY (`restaurantAddr`) REFERENCES `Restaurant`(`restaurantAddr`);

ALTER TABLE `CheckOut` ADD CONSTRAINT `CheckOut_fk2` FOREIGN KEY (`deliveryAddr`) REFERENCES `Users`(`address`);

ALTER TABLE `Food` ADD CONSTRAINT `Food_fk0` FOREIGN KEY (`restaurantId`) REFERENCES `Restaurant`(`restaurantId`);








