### build stage ###
FROM openjdk:11-jdk-slim as builder

# workspace 경로 선언
WORKDIR /workspace/app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

# 실행가능한 jar 파일 생성
RUN ./gradlew bootJar
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)


### create image stage ###
FROM openjdk:11-jdk-slim

# 호스트의 volume 설정
VOLUME /tmp

# jar 파일을 푼 다음 각각 디렉토리를 별도로 복사해준다.
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=builder ${DEPENDENCY}/BOOT-INF/lib     /app/lib
COPY --from=builder ${DEPENDENCY}/META-INF         /app/META-INF
COPY --from=builder ${DEPENDENCY}/BOOT-INF/classes /app

# 포트(8081) 설정
EXPOSE 8081

# 컨테이너 시작시 실행 (-cp(classpath)로 클래스를 지정해서 실행)
ENTRYPOINT ["java","-cp","app:app/lib/*","com.dpflsy.todo.TodoListApplication"]