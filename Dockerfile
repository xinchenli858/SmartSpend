# Use the official OpenJDK image as the base environment
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy all files from your GitHub repository to the container
COPY . .

# Compile all Java source files
RUN javac *.java

# Start the main application
CMD ["java", "FinanceController"]
