# DeepCare Agent Instructions

## 项目目标

DeepCare 是基于 Spring Boot 3 的家庭健康助手后端，当前包含用户账号、健康档案、生理指标、问诊记录、药品库、处方记录和 AI 模型配置七个业务模块。

## 开发约定

- 使用 Java 17+、Spring Boot 3、MyBatis-Plus 和 MySQL。
- 遵循 `Entity / Mapper / Service / Controller` 分层结构。
- 数据库字段使用小写下划线命名，Java 属性使用驼峰命名。
- 健康、问诊、处方和模型密钥相关数据属于敏感数据，不提交真实密钥或个人信息。
- 新增接口时保持统一的 `success / data / message` 响应结构，并同步更新 README 或需求文档。
- 修改数据库表结构时同步更新 `db/schema.sql`、`docs/database-design.md` 和 `docs/er-diagram.md`。

## 验证要求

- 构建前确认使用 JDK 17 或更高版本。
- 使用 Maven 执行 `mvn clean package` 和 `mvn test`。
- 涉及 API 修改时补充或更新测试，并验证 `/api/health`。
- 不要直接覆盖已有用户改动；修改前先检查工作区状态。
