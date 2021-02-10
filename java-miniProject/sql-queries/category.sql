
create table category(category_id int primary key,category_name varchar(30),image_url varchar(100));
desc category;
insert into category values(1,'Development','https://s.udemycdn.com/home/top-categories/lohp-category-development.jpg');
insert into category values(2,'Music','https://s.udemycdn.com/home/top-categories/lohp-category-music.jpg');
insert into category values(3,'Personality Development','https://s.udemycdn.com/home/top-categories/lohp-category-business.jpg');
select * from category;
