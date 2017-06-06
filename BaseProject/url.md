# url接口文档
### 打开大漩涡帖子列表 
http://bbs.nga.cn/thread.php?fid=-7&page=1&lite=js&noprefix
| key | value |
| --- | ----- |
| fid | 板块id
| lite | 返回格式
| page | 页码

### 打开帖子详情
http://bbs.nga.cn/read.php?&page=1&lite=js&noprefix&v2&tid=11729153
| key | value |
| --- | ----- |
| tid | 帖子id |
| lite| 返回格式 |
| page| 页码 |

### 获取图形验证码
#### http请求方式
`get`
http://account.178.com/q_vcode.php?_act=gen_reg

### 登陆
#### http请求方式
`post`
http://account.178.com/q_account.php?_act=login&print=login
| key | value |
| --- | ----- |
| email	| 用户名或邮箱|
| password | 密码|
| vcode | 验证码 |
