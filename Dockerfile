# 使用JDK 17作为基础镜像
FROM openjdk:17

# 设置维护者信息
LABEL maintainer="w1085561450@gmail.com"

# 设置工作目录
WORKDIR /app

# 将构建好的jar文件复制到镜像中
COPY target/clone-red-book-back-end-0.0.1-SNAPSHOT.jar app.jar

# 声明运行时容器将监听8080端口
EXPOSE 8080

# 配置容器启动时执行的命令
ENTRYPOINT ["java","-jar","app.jar"]
