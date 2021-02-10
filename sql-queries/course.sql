INSERT INTO `cybage_learning`.`course`
(`course_id`,
`course_name`,
`course_price`,
`course_duration`,
`course_author`,
`course_description`,
`image_url`,
`total_sub_course`,
`category_id`)
VALUES
(<{course_id: }>,
<{course_name: }>,
<{course_price: }>,
<{course_duration: }>,
<{course_author: }>,
<{course_description: }>,
<{image_url: }>,
<{total_sub_course: }>,
<{category_id: }>);
CREATE TABLE `course` (
  `course_id` int NOT NULL,
  `course_name` varchar(20) DEFAULT NULL,
  `course_price` int DEFAULT NULL,
  `course_duration` int DEFAULT NULL,
  `course_author` varchar(20) DEFAULT NULL,
  `course_description` varchar(200) DEFAULT NULL,
  `image_url` varchar(100) DEFAULT NULL,
  `total_sub_course` int DEFAULT NULL,
  `category_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `course_category_fk` (`category_id`),
  CONSTRAINT `course_category_fk` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE,
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
