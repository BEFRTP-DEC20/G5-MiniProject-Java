INSERT INTO `cybage_learning`.`enrolled_course`
(`enrollment_id`,
`purchase_date`,
`course_price`,
`current_video`,
`course_complete`,
`course_id`,
`user_id`,
`certificate_url`)
VALUES
(<{enrollment_id: }>,
<{purchase_date: }>,
<{course_price: }>,
<{current_video: }>,
<{course_complete: }>,
<{course_id: }>,
<{user_id: }>,
<{certificate_url: }>);

CREATE TABLE `enrolled_course` (
  `enrollment_id` int DEFAULT NULL,
  `purchase_date` date DEFAULT NULL,
  `course_price` int DEFAULT NULL,
  `current_video` int DEFAULT NULL,
  `course_complete` tinyint(1) DEFAULT NULL,
  `course_id` int NOT NULL,
  `user_id` int NOT NULL,
  `certificate_url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`course_id`,`user_id`),
  KEY `enrolled_course_user_fk` (`user_id`),
  CONSTRAINT `enrolled_course_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE,
  CONSTRAINT `enrolled_course_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `enrolled_course_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  CONSTRAINT `enrolled_course_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
SELECT * FROM cybage_learning.enrolled_course;