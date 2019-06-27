三个关键点
========

weather09 多线程获取天气预报
weather11 jdbc 写入数据库
weather14 jdbc 读取数据库，并转为对象

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
