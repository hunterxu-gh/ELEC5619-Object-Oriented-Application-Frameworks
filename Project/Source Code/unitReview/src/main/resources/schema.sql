CREATE TABLE IDENTITY(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NULL,
    last_name VARCHAR(20) NULL,
    email VARCHAR(60) NULL UNIQUE,
    avator VARCHAR(100) ,
    nationality VARCHAR(10) ,  
);

CREATE TABLE STUDENT(
    id BIGINT PRIMARY KEY,
    degree VARCHAR(60) NULL,
    skills VARCHAR(300),
    password VARCHAR(70) NOT NULL,
    FOREIGN KEY (id) REFERENCES IDENTITY(id) ON DELETE CASCADE,
);

CREATE TABLE UNIT(
  unit_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  unit_code VARCHAR(30) NULL,
  unit_name VARCHAR(100) NULL,
  unit_year INT NULL,
  unit_semester VARCHAR(30) NULL,
  unit_mode VARCHAR(30) NULL,
  faculty_school VARCHAR(50) NULL,
  lecturer VARCHAR(50) NULL,
  session_option VARCHAR(50) NULL,
);

CREATE TABLE UREVIEW(
	unit_review_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  	unit_id BIGINT  NULL,
  	unit_code VARCHAR(30) NULL,
  	difficulty INT NULL,
  	stress INT NULL,
  	usefulness INT NULL,
  	upvotes INT  NULL,
  	review_time TIMESTAMP NULL,
	comment VARCHAR(1024),
	reviewer BIGINT NULL,
	FOREIGN KEY (reviewer) REFERENCES IDENTITY(id) ON DELETE NO ACTION,
);

CREATE TABLE LECTURER(
	lecturer_id BIGINT AUTO_INCREMENT PRIMARY KEY,
	lecturer_name VARCHAR(100) NOT NULL,
	faculty_school VARCHAR(50) NOT NULL,
	specialty_area VARCHAR(100) NOT NULL,
	teaching_history VARCHAR(100) NOT NULL,
);

CREATE TABLE LREVIEW(
	lecturer_review_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  	lecturer_id BIGINT  NULL,
  	ability INT NULL,
  	responsiveness INT NULL,
  	upvotes INT  NULL,
  	review_time TIMESTAMP NULL,
	comment VARCHAR(1024),
	reviewer BIGINT NULL,
	FOREIGN KEY (reviewer) REFERENCES IDENTITY(id) ON DELETE NO ACTION,
);

CREATE TABLE QUESTION(
  question_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  question_title VARCHAR(1024),
  unit_code VARCHAR(64),
  user_id BIGINT NULL,
  question_content VARCHAR(1024),
  sample_answer VARCHAR(1024),
  vote_number INT NULL,
  down_number INT NULL,
);

CREATE TABLE QUESTIONCOMMENT(
  question_comment_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  unit_code VARCHAR(64),
  question_id BIGINT NULL,
  user_id BIGINT NULL,
  comment_content VARCHAR(1024),
  vote_numbers INT NULL,
  down_numbers INT NULL,
);

CREATE TABLE TEST(
	test_id BIGINT AUTO_INCREMENT PRIMARY KEY,
  	test_content VARCHAR(1024)
);

