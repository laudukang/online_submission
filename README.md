# Online Submission
网络投稿系统

## 技术实现
- JSP
- Spring MVC
- Apache Shiro
- Spring Data
  - Spring Data JPA
  - Spring Data Commons

## 依赖环境
- JDK 1.7+
- Maven
- Tomcat 8
- MySQL 5.7

## 功能列表
- 多用户
- 多角色：管理员、审稿员、普通用户，支持角色权限自定义分配
- 在线审稿
- 邮件支持
- 用户信息维护
- 信息检索
- 系统日志
- 在线支付（未实现）

## 配置
- src\main\resources\system.properties
- src\main\resources\ehcache.xml
- src\main\resources\persistence-mysql.properties, and config `hibernate.hbm2ddl.auto=update` in `persistence-mysql.properties` to init table
