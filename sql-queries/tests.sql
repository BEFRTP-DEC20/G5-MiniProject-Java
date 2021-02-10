delete from course where course_id = 51;
# get all categories present in database (Aditi/Shivam)
select * from category;
# get all courses present in respective category (Aditi/Shivam)
select * from course where category_id = 1;

# get all enrolled courese from course table for particular user
select course_id from enrolled_course where user_id =1002;
# select course detail using course_id fetched from above
select * from course where course_id = 51; #using for loop;

#Select enrolled course detail for a particular user using its id.(Amir/nitya)
select * from course left join enrolled_course on course.course_id = enrolled_course.course_id where enrolled_course.user_id = 1001;
select * from course where course_id = ( select course_id from enrolled_course where user_id =1001 ); #another aproach.alter

#Add data to enrolled_course after enrolling in a course using user_id.
insert into enrolled_course values(201,'2020-01-12',450,2,false,51,1001,'');

#check whether course is completed or not
