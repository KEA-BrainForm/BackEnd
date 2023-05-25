# Base image
FROM openjdk:17

# 애플리케이션 디렉토리 생성
WORKDIR /app

# 애플리케이션 종속성 복사
COPY build/libs/brainform-0.0.1-SNAPSHOT.jar app.jar

# 애플리케이션 실행
CMD ["java", "-jar", "app.jar"]
