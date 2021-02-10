INSERT INTO `cybage_learning`.`sub_course`
(`sub_course_id`,
`sub_course_name`,
`sub_course_duration`,
`sub_course_description`,
`video_url`,
`video_sequence`,
`course_id`)
VALUES
(<{sub_course_id: }>,
<{sub_course_name: }>,
<{sub_course_duration: }>,
<{sub_course_description: }>,
<{video_url: }>,
<{video_sequence: }>,
<{course_id: }>);

CREATE TABLE `sub_course` (
  `sub_course_id` int NOT NULL,
  `sub_course_name` varchar(50) DEFAULT NULL,
  `sub_course_duration` int DEFAULT NULL,
  `sub_course_description` varchar(100) DEFAULT NULL,
  `video_url` varchar(200) DEFAULT NULL,
  `video_sequence` int DEFAULT NULL,
  `course_id` int DEFAULT NULL,
  PRIMARY KEY (`sub_course_id`),
  KEY `sub_course_course_fk` (`course_id`),
  CONSTRAINT `sub_course_course_fk` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE,
  CONSTRAINT `sub_course_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

SELECT * FROM cybage_learning.sub_course;