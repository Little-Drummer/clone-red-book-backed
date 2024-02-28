# 阶段一：使用 Maven 镜像构建 Spring Boot 应用
FROM maven:latest AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# 使用JDK 17作为基础镜像
FROM openjdk:17

# 设置维护者信息
LABEL maintainer="w1085561450@gmail.com"

# 设置工作目录
#WORKDIR /app

# 将构建好的jar文件复制到镜像中
COPY --from=build /home/app/target/clone-red-book-back-end-0.0.1-SNAPSHOT.jar /home/app.jar

# 声明运行时容器将监听8080端口
EXPOSE 8080

# 配置容器启动时执行的命令
ENTRYPOINT ["java","-jar","/home/app.jar"]
