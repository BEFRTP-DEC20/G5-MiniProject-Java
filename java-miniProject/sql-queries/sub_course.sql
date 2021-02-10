create table sub_course(sub_course_id int primary key,sub_course_name varchar(50),sub_course_duration int,sub_course_description varchar(100),video_url varchar(100),video_sequence int unique,course_id int, foreign key (course_id) references course(course_id) ON DELETE CASCADE,
	CONSTRAINT sub_course_course_fk
        FOREIGN KEY (course_id) 
        REFERENCES course(course_id) ON DELETE CASCADE
);
desc sub_course;
insert into sub_course values (101,'Introduction to python',30,'Introduction to python programming language','videos/python/1.mp4',1,51);
insert into sub_course values (102,'Data types in python',30,'data types in python programming language','videos/python/2.mp4',2,51);
insert into sub_course values (103,'Control statements in python',30,'Control statements in python programming language','videos/python/1.mp4',3,51);
insert into sub_course values (104,'Data structure in python',30,'Data structure in python programming language','videos/python/1.mp4',4,51);
insert into sub_course values (105,'OOP in python',30,'OOP in python programming language','videos/python/1.mp4',5,51);
select * from sub_course;