INSERT INTO IDENTITY (id, first_name, last_name, email, avator, nationality)
VALUES (
    0,
    'Rock',
    'Lee',
    'rock@example.com',
    'Im avator path',
    'CHINA',
);

INSERT INTO STUDENT (id, degree, skills, password) VALUES(
    0,
    'Electrical',
    'I can do anything',
    '$2a$12$khmFCynXRltX4wSuHNPEx.wlTyKCHZWk1DbjXOFNvqpPKP05sOdBS',
);

INSERT INTO IDENTITY (id, first_name, last_name, email, avator, nationality)
VALUES (
    3,
    'Wayne',
    'Yao',
    'wayne@example.com',
    'Im avator path',
    'CN',
);

INSERT INTO STUDENT (id, degree, skills, password) VALUES(
    3,
    'Master of IT',
    'Linux, Go, Python, Hacking',
    '$2a$12$khmFCynXRltX4wSuHNPEx.wlTyKCHZWk1DbjXOFNvqpPKP05sOdBS',
);

INSERT INTO IDENTITY (id, first_name, last_name, email, avator, nationality)
VALUES (
    1,
    'Jeffrey',
    'Morgan',
    'jeffrey@example.com',
    'Im avator path',
    'US',
);

INSERT INTO STUDENT (id, degree, skills, password) VALUES(
    1,
    'GDC',
    'Web development, Software architecture design, IT management',
    '$2a$12$khmFCynXRltX4wSuHNPEx.wlTyKCHZWk1DbjXOFNvqpPKP05sOdBS',
);

INSERT INTO IDENTITY (id, first_name, last_name, email, avator, nationality)
VALUES (
    5,
    'Glenn',
    'Rhee',
    'glenn@example.com',
    'Im avator path',
    'AU',
);

INSERT INTO STUDENT (id, degree, skills, password) VALUES(
    5,
    'Master of IT and IT management',
    'PHP, data mining, machine learning',
    '$2a$12$khmFCynXRltX4wSuHNPEx.wlTyKCHZWk1DbjXOFNvqpPKP05sOdBS',
);

INSERT INTO UNIT (unit_code, unit_name,unit_year, unit_semester, unit_mode, faculty_school, lecturer, session_option) 
VALUES (
	'ELEC5619',
	'Object Oriented Application Frameworks', 
	2018, 
	'Semester 2', 
	'Normal-Day',
	'School of Electrical & Information Engineering',
	'Dr Boland, David',
	'Semester 2');
	
INSERT INTO UNIT (unit_code, unit_name,unit_year, unit_semester, unit_mode, faculty_school, lecturer, session_option) 
VALUES (
	'COMP9007',
	'Algorithms', 
	2018, 
	'Semester 1', 
	'Normal-Day',
	'School of Electrical & Information Engineering',
	'Dr Joseph Godbehere',
	'Semester 1');

INSERT INTO UNIT (unit_code, unit_name,unit_year, unit_semester, unit_mode, faculty_school, lecturer, session_option) 
VALUES (
	'ELEC5616',
	'Computer And Network Security', 
	2018, 
	'Semester 1', 
	'Normal-Night',
	'School of Electrical & Information Engineering',
	'Luke Anderson',
	'Semester 2');

INSERT INTO UREVIEW (unit_id, unit_code,difficulty, stress, usefulness, upvotes, review_time, comment, reviewer) 
VALUES (
	1,
	'ELEC5619', 
	3, 
	3, 
	5,
	3,
	GETDATE(),
	'This guy is brilliant and this UoS is pretty useful indeed!',
	3);

INSERT INTO UREVIEW (unit_id, unit_code, difficulty, stress, usefulness, upvotes, review_time, comment, reviewer) 
VALUES (
	1,
	'ELEC5619', 
	5, 
	5, 
	3,
	0,
	CURRENT_TIMESTAMP,
	'But... its not my taste',
	5);
	
INSERT INTO UREVIEW (unit_id, unit_code, difficulty, stress, usefulness, upvotes, review_time, comment, reviewer) 
VALUES (
	1,
	'ELEC5619', 
	5, 
	5, 
	3,
	0,
	CURRENT_TIMESTAMP,
	'But I find the lecture pretty interesting. Em... alry its sort of ok',
	1);


INSERT INTO LECTURER (lecturer_name, faculty_school, specialty_area, teaching_history) 
VALUES (
	'Luke Anderson',
	'School of IT',
	'Network & Security',
	'ELEC5619'
	);	

INSERT INTO LECTURER (lecturer_name, faculty_school, specialty_area, teaching_history)
VALUES (
	'Luke Lin', 
	'Civil',
	'Fluid Dynamics',
	'CIVL3333'
	);	
	
INSERT INTO LECTURER (lecturer_name, faculty_school, specialty_area, teaching_history) 
VALUES (
	'David Boland',
	'School of IT',
	'Network & Security',
	'ELEC5619'
	);	
	
INSERT INTO LREVIEW (lecturer_id, ability, responsiveness, upvotes, review_time, comment, reviewer) 
VALUES (
	1,
	4, 
	3, 
	1,
	CURRENT_TIMESTAMP,
	'3 and 3 to Him. He is actually a good teacher',
	5);

INSERT INTO LREVIEW (lecturer_id, ability, responsiveness, upvotes, review_time, comment, reviewer) 
VALUES (
	1,
	5, 
	5, 
	2,
	CURRENT_TIMESTAMP,
	'5 and 5 to him. Best lecturer I have ever met',
	0);
	
INSERT INTO LREVIEW (lecturer_id, ability, responsiveness, upvotes, review_time, comment, reviewer) 
VALUES (
	1,
	4, 
	4, 
	2,
	CURRENT_TIMESTAMP,
	'4 and 4 to him. Best lecturer I have ever met',
	1);

INSERT INTO LREVIEW (lecturer_id, ability, responsiveness, upvotes, review_time, comment, reviewer) 
VALUES (
	2, 
	2, 
	1, 
	3,
	CURRENT_TIMESTAMP,
	'He is not good teacher',
	3);

INSERT INTO QUESTION ( question_title, unit_code,user_id, question_content, sample_answer, vote_number,down_number) 
VALUES (
    'Two sum',
	'ELEC5619', 
	1, 
	'Given an array of integers, return indices of the two numbers such that they add up to a specific target.You may assume that each input would have exactly one solution.', 
    'Given nums = [2, 7, 11, 15], target = 9,Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].',
    0,
    0,
    );	
    
INSERT INTO QUESTION ( question_title, unit_code,user_id, question_content, sample_answer, vote_number,down_number) 
VALUES (
    'String to Integer (atoi)',
	'ELEC5619', 
	2, 
	'Implement atoi to convert a string to an integer.', 
    'Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.',
    0,
    0,
    );	
    
INSERT INTO QUESTIONCOMMENT (unit_code,question_id,user_id, comment_content,  vote_numbers,down_numbers) 
VALUES (
    'ELEC5619',
	1, 
	1, 
	'the question is good ', 
    0,
    0,
    );	
INSERT INTO QUESTIONCOMMENT (unit_code,question_id,user_id, comment_content,  vote_numbers,down_numbers) 
VALUES (
    'ELEC5619',
	1, 
	2, 
	'the question is bad!', 
    0,
    0,
    );	 
INSERT INTO QUESTIONCOMMENT (unit_code,question_id,user_id, comment_content,  vote_numbers,down_numbers) 
VALUES (
    'ELEC5619',
	1, 
	3, 
	'It is very helpful!', 
    0,
    0,
    );	        
INSERT INTO QUESTIONCOMMENT (unit_code,question_id,user_id, comment_content,  vote_numbers,down_numbers) 
VALUES (
    'ELEC5619',
	2, 
	1, 
	'the question is not that good ', 
    0,
    0,
    );	
INSERT INTO QUESTIONCOMMENT (unit_code,question_id,user_id, comment_content,  vote_numbers,down_numbers) 
VALUES (
    'ELEC5619',
	2, 
	2, 
	'the sample answer is not correct, should be like this****', 
    0,
    0,
    );	 
INSERT INTO QUESTIONCOMMENT (unit_code,question_id,user_id, comment_content,  vote_numbers,down_numbers) 
VALUES (
    'ELEC5619',
	2, 
	3, 
	'I think user 2 got some point here.', 
    0,
    0,
    );	        

INSERT INTO TEST (test_id, test_content) 
VALUES (1,'test2');
