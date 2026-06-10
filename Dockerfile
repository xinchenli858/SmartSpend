# Use the official Eclipse Temurin image as the base environment
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy all files from your GitHub repository to the container
COPY . .

# Compile all Java source files
RUN javac *.java

# Start the main application
CMD ["java", "FinanceController"]
