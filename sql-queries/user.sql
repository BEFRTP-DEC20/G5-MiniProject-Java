INSERT INTO `cybage_learning`.`user`
(`user_id`,
`full_name`,
`user_name`,
`user_password`,
`user_role`,
`user_security_question`,
`user_security_answer`)
VALUES
(<{user_id: }>,
<{full_name: }>,
<{user_name: }>,
<{user_password: }>,
<{user_role: }>,
<{user_security_question: }>,
<{user_security_answer: }>);
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `full_name` varchar(20) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_password` varchar(20) DEFAULT NULL,
  `user_role` varchar(10) DEFAULT NULL,
  `user_security_question` varchar(100) DEFAULT NULL,
  `user_security_answer` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
