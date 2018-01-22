# spring-thymeleaf-simple-repo

How to run project

1.Create a Mysql Schema name "spring"

2. Change DB credentials in com.mpc.demo.config.DatabaseConfiguration Class

3. Open application.properties file and comment {spring.jpa.hibernate.ddl-auto = update} this line by adding #
(i.e #spring.jpa.hibernate.ddl-auto = update) and uncommet {#spring.jpa.hibernate.ddl-auto = create} this line by (i.e : spring.jpa.hibernate.ddl-auto = create)removing #

4. After first time run complete uncomment {#spring.jpa.hibernate.ddl-auto = update} this line by removing #
(i.e spring.jpa.hibernate.ddl-auto = update) and uncommet {spring.jpa.hibernate.ddl-auto = create} this line by (i.e : #spring.jpa.hibernate.ddl-auto = create)adding #

5. Go to Project directory

6.  for mvn clean build  == $ mvn clean install   

7. For run jar  ==  java -jar target/spring-jap-demo-1.0.jar   

Project Access url ==  http://localhost:9070/
