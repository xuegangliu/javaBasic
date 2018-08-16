# javaBasic

[![Build Status](https://travis-ci.org/xuegangliu/javaBasic.svg?branch=master)](https://travis-ci.org/xuegangliu/javaBasic)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)](https://github.com/xuegangliu/javaBasic/pulls)
[![GitHub stars](https://img.shields.io/github/stars/xuegangliu/javaBasic.svg?style=social&label=Stars)](https://github.com/xuegangliu/javaBasic)
[![GitHub forks](https://img.shields.io/github/forks/xuegangliu/javaBasic.svg?style=social&label=Fork)](https://github.com/xuegangliu/javaBasic)

java基础学习
- crawler 爬虫
- patterns 设计模式
- sort 排序
- struct 数据结构
- web socket

## ftp测试
利用docker构建ftp服务
```
docker pull docker.io/fauria/vsftpd
docker run -d -v /home/vsftpd:/home/vsftpd -p 20:20 -p 21:21 -p 21100-21110:21100-21110 -e FTP_USER=test -e FTP_PASS=test --name vsftpd fauria/vsftpd
```
- 会以登录用户名 (test) 创建一个目录 (/home/vsftpd/test) 作为 ftp 根目录
- 测试时发现不加 -p 20:20 依然可以正常操作