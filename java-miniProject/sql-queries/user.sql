  
create database e_learning;
use e_learning;

create table user(user_id int primary key auto_increment, full_name varchar(20),user_name varchar(20) unique, user_password varchar(20), user_role varchar(10), user_security_question varchar(100), user_security_answer varchar(100), is_prime_user boolean);

desc user;
insert into user values(1,'amir jadahv','amirjadhav','amir@123','user','fav color?','black',true);
insert into user values(2,'vijay sharma','vijaybhau','vijay123','user','fav sport','tennis',false);
insert into user values(3,'neeraj nehera','neerajnehra','neerajnehra123','user','fav book','clean code',true);
select * from user;
