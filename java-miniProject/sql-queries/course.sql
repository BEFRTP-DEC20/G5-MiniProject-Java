create table course(course_id int primary key, course_name varchar(20),course_price int, course_duration int,course_author varchar(20),course_description varchar(200), image_url varchar(100),total_sub_course int, category_id int , foreign key (category_id) references category(category_id) ON DELETE CASCADE,
CONSTRAINT course_category_fk
        FOREIGN KEY (category_id) 
        REFERENCES category(category_id) ON DELETE CASCADE
);
desc course;
insert into course values(51,'python',450,180,'james','A complete practical Python course for both beginners & intermediates! Master Python 3 by making 10 amazing Python apps.','https://d1q6f0aelx0por.cloudfront.net/product-logos/library-python-logo.png',5,1);
insert into course values(52,'java',600,'600','Tim Buchalka','Learn Java In This Course And Become a Computer Programmer. Obtain valuable Core Java Skills And Java Certification','https://miro.medium.com/max/840/1*iIXOmGDzrtTJmdwbn7cGMw.png',5,1);
select * from course;