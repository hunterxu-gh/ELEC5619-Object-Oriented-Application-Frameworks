# ELEC5619
CUSPCrusher

# Project description
##  Aims

Our project aims to create a web application platform that helps students find out information of a unit or a lecturer via reviews. It also allows users to provide reviews on a unit or a lecturer, as well as creating and viewing sample questions for the preparation of quizzes or exams.

## Overview

The platform provides detailed information of all units and lecturers in School of Information Technology in USyd to any user. First time users need to register in order to get access to contents of the platform. Upon a successful log-in, registered users will be presented by a user profile page where they can view and edit their user information. The profile page also serves as a portal to direct users to other components of the website, including Unit Review, Lecturer Review and Sample Question.

A Unit Review page displays reviews and information about a unit, as well as allowing users to create, edit, and upvote reviews. A Lecturer Review page offers similar functionality, but with the context being a lecturer. To facilitate information access for users, a search function will be implemented where the users can find any unit review page by name or unit code, or any lecturer review page by name. The platform also allows registered users to create and share sample questions, view and solve questions made by others, as well as upvoting questions to their likings. Users can keep track on their own reviews and sample questions they have created in the user profile page.

## Primary User

Our target users would be USYD students who are overwhelmed by different units at the beginning of a semester, who ask like crazy on social media &amp;quot;how&amp;#39;s this unit? Is it hard? Is it programming involved? Is the final torturing?&amp;quot;. In addition, our platform suits USYD students who want to get prepared for the quizzes and exams by self-testing online instead of going through slides for a hundred times and finding out that none of them appears in the exam.

##  Project Outline
The project primarily uses Spring, Maven and Hibernate as backbone frameworks, Tomcat 8.5 as the Java Servlet Container, h2 for data persistence and Thymeleaf as the template engine. On top of that, Spring Boot is chosen to simplify the bootstrapping and development of the project. Languages, tools and frameworks on the client-side include HTML, CSS/SCSS, Bootstrap, JavaScript (ES5/6), jQuery, etc.

The server-side system architecture follows the typical Spring MVC design.
