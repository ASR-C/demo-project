FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

# 🔥 Give permission to mvnw
RUN chmod +x mvnw

# Build project
RUN ./mvnw clean package -DskipTests

# Run app
CMD ["java","-jar","target/demo-0.0.1-SNAPSHOT.jar"]