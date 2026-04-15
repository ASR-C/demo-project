FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy everything
COPY . .

# Build the project
RUN ./mvnw clean package -DskipTests

# Run the jar
CMD ["java","-jar","target/demo-0.0.1-SNAPSHOT.jar"]