FROM maven:3.9.4-openjdk-11-slim AS build

WORKDIR /app

# 复制Maven配置和源代码
COPY pom.xml .
COPY src ./src

# 编译和测试
RUN mvn clean package -DskipTests

# 运行时镜像
FROM openjdk:11-jre-slim

WORKDIR /app

# 复制编译后的jar包
COPY --from=build /app/target/*.jar app.jar

# 暴露端口（如有需要）
EXPOSE 8080

# 定义测试命令
CMD ["mvn", "test"]