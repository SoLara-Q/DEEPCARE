# DeepCare 家庭健康助手

这是依据《专业综合实践（分方向）》实验任务书创建的 SpringBoot3 后端项目。当前版本完成实验要求中的项目初始化、七大业务模块拆解、MySQL 数据库设计，以及 MyBatis-Plus 的 Entity / Mapper / Service / Controller 分层骨架。

## 技术栈

- Java 17、Spring Boot 3.4.1
- MyBatis-Plus 3.5.9
- MySQL 8.0
- Spring AI Client Chat 1.0.0（`spring-ai` profile，模型供应商接入预留）
- Maven

## 快速启动

1. 确认本机已安装 JDK 17 和 Maven。
2. 启动 MySQL（可直接使用 Docker）：

   ```powershell
   docker compose up -d mysql
   ```

3. 使用 Maven 编译并启动：

   ```powershell
   mvn clean package
   java -jar target/deepcare-0.0.1-SNAPSHOT.jar
   ```

需要启用 Spring AI Client Chat 依赖时执行 `mvn -P spring-ai clean package`。

默认数据库连接为 `localhost:3306/deepcare`，用户名 `deepcare`，密码 `deepcare123`。正式环境请通过 `DEEPCARE_DB_URL`、`DEEPCARE_DB_USERNAME`、`DEEPCARE_DB_PASSWORD` 覆盖，勿把真实密码提交到代码库。

## 基础接口

服务启动后访问 `http://localhost:8080/` 打开 DeepCare 服务首页，访问 `GET http://localhost:8080/api/health` 检查服务状态。七个模块均提供基础 REST CRUD：

| 模块 | 路径 |
| --- | --- |
| 用户账号 | `/api/users` |
| 健康档案 | `/api/health-profiles` |
| 生理指标 | `/api/vitals` |
| 问诊记录 | `/api/consultations` |
| 药品库 | `/api/medicines` |
| 处方记录 | `/api/prescriptions` |
| AI 模型 | `/api/ai-models` |

每个资源支持 `GET /`、`GET /{id}`、`POST /`、`PUT /{id}`、`DELETE /{id}`，返回统一的 `success / data / message` 结构。

## 项目文档

- [实验需求拆解](docs/requirements.md)
- [数据库设计说明](docs/database-design.md)
- [E-R 图](docs/er-diagram.md)
- [数据库建表脚本](db/schema.sql)
- [Agent 协作说明](agents.md)
- [Design System](designsystem.md)

## 目录结构

```text
src/main/java/com/deepcare
├─ common                 公共响应、配置、健康检查
└─ modules
   ├─ user                用户账号
   ├─ profile             健康档案
   ├─ vital               生理指标
   ├─ consultation        问诊记录
   ├─ medicine             药品库
   ├─ prescription        处方记录
   └─ aimodel             AI 模型配置
db/schema.sql             MySQL 物理模型
docs/                     需求与数据库设计文档
```
