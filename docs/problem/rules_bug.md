# 规则常见bug

#### bug 

- 分母不能为0
- 日期格式化`SimpleDateFormat` 利用y表示年,不是Y
- 变量不应自赋值,例如：`int a=1; a=a;`
- 自增自减的使用
- 锁被持有时,用wait(),而非sleep()
- 禁止使用浮点型数字做判断,使用BigDecimal

sonar rules bug 110
