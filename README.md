学习内容
=======

java 基本知识
java 包及命令行构建分离
okhttp 获取页面
gson 解析 json 格式
jdbc 数据库连接访问

java 8 特性 (lambda, 日期, forEach等)

weather09 多线程获取天气预报
weather11 jdbc 写入数据库
weather14 jdbc 读取数据库，并转为对象
weather15 单元测试 entity, dao, service分离

annotation 注解 (lombok等)

spring jdbc template
spring data jpa (hibernate)
设计模式

j2ee servlet
控制反转、依赖注入 (spring ioc, google guice)
页面模板引擎 (jtwig, pebble, freemarker)
spring boot

另: 了解gradle, groovy, jsp等
注: zetcode.com 网站有相当多的代码示例

多项目构建
========

采用 gradle 构建
settings.gradle 包含子项目
weather09, weather11, weather14 子项目中各包含 build.gradle 文件

并且使用 shadowJar 打包

参数外部文件
==========
含在 jar 包内，如 weather14 的 db.properties, weather11 的 _city.json
读取时需要采用特别的处理 classload.getResourceAsStream()

新建gradle子项目
==============
将其中的build文件夹删除 

执行gradle子项目
==============
只编译
gradle :weather15:compileJava

编译打包
gradle :weather15:build

运行
gradle :weather15:run

测试
gradle :weather15:test

执行jar包
========
在子项目--build.gradle--plugins增加一条
    id 'com.github.johnrengelman.shadow' version '5.0.0'

在终端执行命令行:
    java -jar weather15/build/libs/jar包名
