FROM gradle:latest

WORKDIR /app

COPY . .

EXPOSE 8000

CMD ["./gradlew",  "bootRun", "--no-daemon"]
