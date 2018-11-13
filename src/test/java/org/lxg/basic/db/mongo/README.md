# mongo 

## 设置用户名密码

```
use admin # 连接管理数据库

# 创建管理员用户
db.createUser({ 
 user: 'mongo-admin', 
 pwd: 'mongo-password', 
 roles: [ { role: "root", db: "admin" } ] });

db.auth("mongo-admin","mongo-password")

# 创建普通用户
use test
db.createUser({ user: 'test', pwd:'test', roles: [ {role:"readWrite",db:"testdb"}]});
db.auth("test","test")
```
Read：允许用户读取指定数据库
readWrite：允许用户读写指定数据库
dbAdmin：允许用户在指定数据库中执行管理函数，如索引创建、删除，查看统计或访问system.profile
userAdmin：允许用户向system.users集合写入，可以找指定数据库里创建、删除和管理用户
clusterAdmin：只在admin数据库中可用，赋予用户所有分片和复制集相关函数的管理权限。
readAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读权限
readWriteAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的读写权限
userAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的userAdmin权限
dbAdminAnyDatabase：只在admin数据库中可用，赋予用户所有数据库的dbAdmin权限。
root：只在admin数据库中可用。超级账号，超级权限
