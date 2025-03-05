FROM mysql:8.0.22

ENV DATABASE_URL jdbc:mysql://172.17.0.2:3306/Tienda
ENV DATABASE_USERNAME root
ENV DATABASE_PASSWORD 1234
ENV DATABASE_PLATFORM org.hibernate.dialect.MySQL57Dialect
ENV DATABASE_DRIVER com.mysql.cj.jdbc.Driver

ENTRYPOINT ["java" , "-jar" , "app.jar"]