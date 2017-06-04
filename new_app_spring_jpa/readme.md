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