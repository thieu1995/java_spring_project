# Spring JPA
- 3 tầng là: Presentation, Business Logic, Data 
- Có component tương ứng các tầng là: Controller, Service, Repository 


## Controller 
- Giải quyết các request sắp gửi đến và trả về các response 
- Tương tác chủ yếu với Service.
- Nếu tương tác trực tiếp với Repository tức là app đang ko có tầng Business Logic 


## Service 
- Tầng chịu trách nhiệm tương tác với các business logic 
- Kêu gọi Repository để lấy dữ liệu từ Database 
- Trả về các đối tượng cho Controller 

## Repository 
- Tầng tạo Object Relational Mapping (ORM) tương ứng với Database 
- Mỗi thằng Object tương ứng với 1 bảng. 


## Tool database for Intelj 
https://www.youtube.com/watch?v=P3C0iO1yqhk
https://plugins.jetbrains.com/category/45-database/idea
https://www.jetbrains.com/help/idea/2017.1/generate-persistence-mapping-import-dialogs.html
https://www.jetbrains.com/help/idea/2017.1/database-tool-window.html

## Localization 
http://memorynotfound.com/spring-mvc-internationalization-i18n-example/

## Persitence.xml in Spring Boot 
- Có thể dùng hoặc không dùng. Câu trả lời bên dưới 
https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-jta.html
https://stackoverflow.com/questions/20848485/spring-boot-cannot-use-persistence
https://docs.spring.io/spring-boot/docs/current/reference/html/howto-data-access.html
https://stackoverflow.com/questions/20808290/spring-jpa-hibernate-no-qualifying-bean-of-type-javax-persistence-entitymanag/20850535?noredirect=1#comment31278706_20850535


## JPA (Java Persitence API)
- JPa là interface của ORM (Object Relational Mapping )
- ORM là specific implementation của JPA 
- Nó dùng để định danh các truy cập, mapping giữa Java object và Database tables;

- Jpa không phải là SQL 
- Nó sử dụng JPQL (Java Persistence Query Language) để giao tiếp giữa POJOs và Java objects 

- Vì nó là interface provider nên có rất nhiều loại để chọn 
- TopLink(EclipseLink), OpenJPA, Versant, Hibernate ,...

- Thường dùng Hibernate.
- Câu hỏi là: Tại sao ta không dùng trực tiếp Hibernate mà phải dùng Hibernate thông qua JPA 

+ Vì: Nếu ta muốn đổi Provider thì sao? 
        
## Entity 
- POJO kèm theo @Entity, @Id 


https://app.pluralsight.com/player?course=spring-jpa-hibernate&author=bryan-hansen&name=springjpa-m7-jpaannotation&clip=0&mode=live


## Create Database

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


===

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `active` int(11) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;


===


DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

====


mysql> INSERT INTO `role` VALUES (1,'SUBSCRIBER');

mysql> INSERT INTO `role` VALUES (2,'MEMBER');

mysql> INSERT INTO `role` VALUES (3,'CONTRIBUTOR');

mysql> INSERT INTO `role` VALUES (4,'AUTHOR');

mysql> INSERT INTO `role` VALUES (5,'EDITOR');

mysql> INSERT INTO `role` VALUES (6,'ADMIN');

mysql> INSERT INTO `role` VALUES (7,'SUPER_ADMIN');


https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d
