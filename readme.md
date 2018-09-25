# MJ_WebMagic

## 项目描述
> 本项目基于springboot开发爬虫功能，爬虫基于WebMagic框架，爬取数据持久化到出具库，使用ES生成索引，方便快速检索

## 项目目录结构
```
└── com
    └── mj
        ├── controller
        ├── entity
        ├── mapper
        ├── service
        ├── spider
        │   ├── downloader // WebMagic的默认Downloader基于HttpClient。一般来说，你无须自己实现Downloader。
        │   ├── pageprocesser //在WebMagic里，实现一个基本的爬虫只需要编写一个类，实现PageProcessor接口即可。这个类基本上包含了抓取一个网站，你需要写的所有代码。
        │   ├── pipeline // Pileline是抽取结束后，进行处理的部分，它主要用于抽取结果的保存，也可以定制Pileline可以实现一些通用的功能
        │   └── scheduler //Scheduler是WebMagic中进行URL管理的组件。一般来说，Scheduler包括两个作用：1. 对待抓取的URL队列进行管理。2. 对已抓取的URL进行去重。
        └── util
```