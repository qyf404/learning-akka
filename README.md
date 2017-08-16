# learning-akka

![](https://travis-ci.org/qyf404/learning-akka.svg?branch=master)

Learn akka step by step.

# 十分重要

最新的文档请参阅[master分支](https://github.com/qyf404/learning-akka).

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
