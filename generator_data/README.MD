
# 配置

 - config 文件里可配置需要批量导入数据的数据源
## 启动
- db文件里test.sql需要插入数据的测试表，支持：oracle、mysql、postgre
- 启动是，直接进入generatorData文件内java -jar generator-tools.jar 需要指定参数：
例如：
- java -jar generator-tools.jar --filename mysql(mysql可以不指定)
- java -jar generator-tools.jar --filename postgre
- java -jar generator-tools.jar --filename oracle

