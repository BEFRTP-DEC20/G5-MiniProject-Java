INSERT INTO `cybage_learning`.`category`
(`category_id`,
`category_name`,
`image_url`)
VALUES
(<{category_id: }>,
<{category_name: }>,
<{image_url: }>);

CREATE TABLE `category` (
  `category_id` int NOT NULL,
  `category_name` varchar(30) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
