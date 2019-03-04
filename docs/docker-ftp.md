docker ftp 搭建
---
|名称|描述|日期|作者|
|---|---|---|---|
|基于docker的ftp搭建|ftp服务器搭建|@date:2019-01-07|by xuegangliu|

## 利用docker构建ftp服务

```
docker pull docker.io/fauria/vsftpd
docker run -d -v /home/vsftpd:/home/vsftpd -p 20:20 -p 21:21 -p 21100-21110:21100-21110 -e FTP_USER=test -e FTP_PASS=test --name vsftpd fauria/vsftpd
```

- 会以登录用户名 (test) 创建一个目录 (/home/vsftpd/test) 作为 ftp 根目录

- 测试时发现不加 -p 20:20 依然可以正常操作