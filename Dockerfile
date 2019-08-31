FROM openjdk:8
ADD target/coffee-shop-webapp.jar coffee-shop-webapp.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "coffee-shop-webapp.jar"]