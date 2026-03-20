create database school_db;

create table instructor(
        instructor_id SERIAL PRIMARY KEY,
        instructor_name VARCHAR(100),
        instructor_email VARCHAR(100)
);

create table courses (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100),
    description VARCHAR(100),
    instructor_id INT,
    CONSTRAINT fk_instructor FOREIGN KEY (instructor_id) REFERENCES instructor ON DELETE CASCADE ON UPDATE CASCADE
);
create table students (
    student_id SERIAL PRIMARY KEY,
    student_name VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(100)
);

create table student_course (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id),
    constraint fk_student foreign key (student_id) references students(student_id) on delete cascade on update cascade,
    constraint fk_course foreign key (course_id) references courses(course_id) on delete cascade on update cascade
)