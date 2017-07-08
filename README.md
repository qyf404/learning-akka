# learning-akka
Learn akka step by step.

# 项目依赖

## 数据库

项目默认测试使用H2,运行使用postgres.postgres建库步骤如下:
    
```
$> brew install postgres
$> createuser postgres -P
$> sudo -u postgres psql -c 'alter user postgres with createdb' postgres
$> psql -U postgres
$> CREATE DATABASE learningakka WITH OWNER postgres ENCODING 'UTF8';

```