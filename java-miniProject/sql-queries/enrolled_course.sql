use e_learning;
create table enrolled_course(enrollment_id int,purchase_date date,course_price int ,current_video int,course_complete boolean,course_id int, user_id int,certificate_url varchar(100), primary key(course_id, user_id), foreign key (course_id) references course(course_id), foreign key (user_id) references user(user_id),
CONSTRAINT enrolled_course_course_fk
        FOREIGN KEY (course_id) 
        REFERENCES course(course_id) ON DELETE CASCADE,
        
CONSTRAINT enrolled_course_user_fk
        FOREIGN KEY (user_id) 
        REFERENCES user(user_id) ON DELETE CASCADE
);
desc enrolled_course;
insert into enrolled_course values(201,'2020-01-12',450,2,false,51,1,'');
insert into enrolled_course values(202,'2020-01-15',600,2,false,52,1,'');
insert into enrolled_course values(203,'2020-02-02',450,3,false,51,2,'');
select * from enrolled_course;
