# 搜索

- 映射(Mapping)：数据在每个字段中的解释说明

- 分析(Analysis)：全文是如何处理的可以被搜索的

- 领域特定语言查询(Query DSL)：Elasticsearch使用的灵活的、强大的查询语言

- 空搜索(/_search)

```
      hits:total文档总数、hits匹配的数组(数据[显示10条])
      _score:相关性得分
      max_score:匹配文档_score的最大值
      took:搜索花费的毫秒数
      _shards:total查询的分片数、successful成功、failed失败
      time_out:是否超时
```

- 多索引和多类型(按索引和类型搜索文档)

- 分页

```
      size:结果数，默认10
      from:跳过开始的结果数
```

- 字符串查询

```
      简易查询:点对点
      机构化查询DSL
```
