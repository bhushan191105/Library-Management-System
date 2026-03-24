create database librarydb ;
use librarydb ;
create table students(
	student_id  int  primary key  auto_increment,
    student_name varchar(50),
    student_course varchar(30),
    student_branch varchar(30)
);
SELECT * FROM students;

create table admin_info(admin_id int primary key , admin_name varchar(40) not null unique , admin_pass varchar(12) not null );
insert into admin_info(admin_id , admin_name , admin_pass) values (1001 , "Mukesh Patel" , "mukesh@1001"),
																(1002 , "Rohit Sharma" , "rohit@45");
select * from admin_info ;


create table books(
	book_id int primary key ,
    book_title varchar(50) not null ,
    author_name varchar(50) not null ,
	isbn int not null unique 
);

select * from books ;

create table book_copies(
	copy_id int primary key ,
    book_id int  ,
    status enum ('Available','Issued' , 'Lost') ,
    FOREIGN KEY (book_id) REFERENCES books(book_id)
    -- constraint foreign key (book_id) references books(book_id) on delete restrict on update cascade 
);

insert into book_copies(copy_id , book_id , status) values (1,2,'Available'),
(2,2,'Issued'),(3,1,'Available'),(4,1,'Available'),(5,1,'Available') ;
insert into book_copies(copy_id , book_id , status) values (6,3,'Available') ;

update book_copies set status = 'Available' where copy_id = 2 ;

select * from book_copies ;

create table transactions (
	transaction_id int primary key ,
    student_id int ,
    copy_id int ,
    issue_date date ,
    due_date date ,
    return_date date ,
    fine_amount decimal(10,2),
    foreign key(student_id) references students(student_id) ,
    foreign key(copy_id) references book_copies(copy_id)
);

alter table transactions modify transaction_id int auto_increment ;
select * from transactions ;
