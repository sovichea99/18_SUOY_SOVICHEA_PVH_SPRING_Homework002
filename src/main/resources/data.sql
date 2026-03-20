INSERT INTO instructor (instructor_name, instructor_email) VALUES
        ('Sok Sophea', 'sophea.sok@rupp.edu.kh'),
        ('Chan Vanna', 'vanna.chan@rupp.edu.kh'),
        ('Chea Samnang', 'samnang.chea@rupp.edu.kh'),
        ('Keo Pich', 'pich.keo@rupp.edu.kh'),
        ('Kim Socheata', 'socheata.kim@rupp.edu.kh'),
        ('Seng Rithy', 'rithy.seng@rupp.edu.kh'),
        ('Heng Bopha', 'bopha.heng@rupp.edu.kh'),
        ('Chhay Phirun', 'phirun.chhay@rupp.edu.kh'),
        ('Duong Sovanna', 'sovanna.duong@rupp.edu.kh'),
        ('Mao Dara', 'dara.mao@rupp.edu.kh');

INSERT INTO courses (course_name, description, instructor_id) VALUES
      ('Introduction to Java', 'Basics of Java programming', 1),
      ('Advanced Java', 'Deep dive into Java concepts', 1),
      ('Web Development with PHP', 'Building websites with PHP & MySQL', 2),
      ('Laravel Framework', 'Modern PHP development using Laravel', 2),
      ('Data Structures', 'Understanding core data structures', 3),
      ('Algorithms', 'Solving problems efficiently', 3),
      ('Database Systems', 'Relational database design and SQL', 4),
      ('Operating Systems', 'OS concepts and processes', 4),
      ('Mobile App Development', 'Building apps with Flutter', 5),
      ('UI/UX Design Basics', 'Introduction to user interface and experience design', 5);

INSERT INTO students (student_name, email, phone_number) VALUES
     ('Sok Dara', 'sok.dara@example.com', '012345678'),
     ('Chan Sophea', 'chan.sophea@example.com', '011223344'),
     ('Meun Vanna', 'meun.vanna@example.com', '010987654'),
     ('Leng Sreynith', 'leng.sreynith@example.com', '015556677'),
     ('Chea Ratana', 'chea.ratana@example.com', '017889900'),
     ('Kim Sovanna', 'kim.sovanna@example.com', '069112233'),
     ('Heng Dalin', 'heng.dalin@example.com', '098334455'),
     ('Tang Vichetra', 'tang.vichetra@example.com', '097667788'),
     ('Bun Sopheap', 'bun.sopheap@example.com', '088445566'),
     ('Um Sreypov', 'um.sreypov@example.com', '093778899');

INSERT INTO student_course (student_id, course_id) VALUES
    (1, 1),
    (1, 2),
    (2, 1),
    (2, 3),
    (3, 2),
    (4, 4),
    (5, 5),
    (6, 6),
    (7, 7),
    (8, 8);