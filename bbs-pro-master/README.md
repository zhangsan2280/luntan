###  前后端分离版管理后台前端请移步至 [https://github.com/zhangsan2280/vue3-management-forum/tree/main/bbs-web-admin-master]
###  前台前后端分离电脑版前端请移步至 [[https://github.com/zhangsan2280/vue3-web-forum](https://github.com/zhangsan2280/vue3-web-forum/tree/main/bbs-web-pc-master)]
###  前后端分离版SpringBoot轻论坛后端请移步至 [[https://gitee.com/diyhi/bbs-web-admin](https://github.com/zhangsan2280/springboot-forum/tree/main/bbs-pro-master)]

<br>

#### 项目介绍
反诈轻论坛Pro版基于 SpringBoot 开发。包含论坛、问答模块。自适应手机端和电脑端。部分数据库表结构设计使用分表方案。

<br>
部分数据库表使用分表设计,默认分为4个表,表中有数据后不建议再调整分表数量。程序带有图形安装界面，服务器部署时可以用来初始化数据。前台所有页面均支持返回HTML和JSON格式数据,API接口文档可在【页面管理】 - 【模板列表】 - 【布局】 - 【版块】 中查看。前台各模块模板和 资源均可在线编辑和管理。前台电脑版和手机版各有一套模板,默认页面使用的模板技术:电脑版使用FreeMarker标签，手机版使用Vue2.0,当然也可以使用其它前端模板框架设计页面进行展示。管理后台带有升级接口，新版本jar包覆盖旧版本jar包后，可以在管理后台操作升级。 

  
<br><br>



#### 技术选型
Spring Boot + JPA + Ehcache + Lucene


反诈网站：
https://www.telegramfanzha.com/ 测试账号：test 密码:1234567


<br><br>
#### 使用平台
JDK 1.8及以上 + MySQL 5.5.3及以上

<br><br>
#### 源码运行教程

1、将源代码导入到Eclipse中(基于Maven)


2、修改配置文件:修改项目下src\main\resources\application.yml文件，请自行替换数据库信息<br>
![输入图片说明](https://images.gitee.com/uploads/images/2021/0803/000136_dcefac4e_2024507.jpeg "1.jpg")

3、Eclipse项目上点击鼠标右键 --> Run As --> Maven install (mvn install命令)将项目生成<br>
![输入图片说明](https://images.gitee.com/uploads/images/2021/0803/000147_01329980_2024507.jpeg "2.jpg")

4、在Eclipse中打开src\test\java\forum\Init.java选中install方法用JUnit执行，此操作会创建外部文件夹和将SQL导入到数据库<br>
![输入图片说明](https://images.gitee.com/uploads/images/2021/0803/000154_928711b0_2024507.jpeg "3.jpg")

5、然后启动项目即可正常运行。<br>
![输入图片说明](https://images.gitee.com/uploads/images/2021/0803/000208_2283b057_2024507.jpeg "4.jpg")
<br><br>
管理员后台地址为 http://您的地址:8080/admin/login <br>
管理员初始账号admin 密码1234567(可自行修改)




<br><br>
	
#### 使用限制

本轻论坛项目禁止商业上使用。
	
<br><br><br><br>
	
#### 主要功能
（1）话题（发表话题、编辑话题、发表评论、编辑评论、删除评论、发表回复、编辑回复、删除回复、审核话题、审核评论、审核回复、搜索话题

、收藏、点赞、上传视频、话题输入密码可见、话题评论可见、话题达到等级可见、话题支付积分可见、话题支付现金可见、

、标签设置角色、红包）


（2）问答（发表问题、追加问题、发表答案、编辑答案、发表回复、编辑回复、审核问题、审核答案、审核回复、搜索问题

、悬赏现金、悬赏积分、收藏、设置最佳答案）

（3）会员（会员等级、会员注册项、会员角色、会员注册禁止用户名称、会员搜索、登录日志、更换头像、私信、系统通知

、提醒、收藏夹、点赞、关注、粉丝、微信登录）

（4）员工管理(员工列表、角色列表、登录日志)

（5）会员卡管理(会员卡列表、会员卡订单)

（6）模板管理（模板列表、导出模板、导入模板、版块代码管理、资源管理、布局管理、栏目管理、代码编辑）

（7）在线帮助管理（在线帮助分类、合并分类、在线帮助列表）

（8）浏览量管理(浏览量列表)

（9）友情链接管理(友情链接列表)

（10）留言管理（留言列表）

（11）文件打包管理(压缩文件列表、打包文件)

（12）系统通知管理(系统通知列表)

（13）平台收益管理(解锁话题隐藏内容分成、问答悬赏平台分成)

（14）全站设置(基本设置、维护数据、敏感词、数据库备份/还原、服务器节点参数、升级)

（15）支付管理(在线支付接口)

（16）短信管理(短信接口列表、短信发送错误日志)

（17）第三方服务管理(第三方登录接口列表)

（18）缩略图管理(缩略图列表)

			




<br><br>
#### 前端界面(电脑版)
![输入图片说明](image/1.jpg)
<br><br>

![输入图片说明](image/2.jpg)
<br><br>

![输入图片说明](image/3.jpg)
<br><br>
![输入图片说明](image/4.jpg)
<br><br>
![输入图片说明](image/5.jpg)
<br><br>
![输入图片说明](image/6.jpg)
<br><br>
![输入图片说明](image/7.jpg)
<br><br>
![输入图片说明](image/8.jpg)
<br><br>
![输入图片说明](image/9.jpg)
<br><br><br>

#### 前端界面(手机版)
![输入图片说明](https://images.gitee.com/uploads/images/2020/0602/101713_299d05ba_2024507.jpeg "m1.jpg")

<br><br>

![输入图片说明](https://images.gitee.com/uploads/images/2020/0602/101730_3d5930f7_2024507.jpeg "m2.jpg")

<br><br>
![输入图片说明](https://images.gitee.com/uploads/images/2020/0630/090734_b7b618c7_2024507.jpeg "m3.jpg")
<br><br>
