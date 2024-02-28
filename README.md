# red-interview-api

> 项目演示地址：[RedInterviewHub](https://redinterview.yjxw.win/)

> 本项目是**RedInterviewHub**的后端API部分，前端部分请参考[red-interview-front](https://github.com/Little-Drummer/red-interview-front)

**RedInterviewHub**是一个仿小红书风格的面试分享平台，专注于提供高质量的面试经验、
技巧和问题解答。该平台旨在帮助求职者准备面试，通过分享和探索面试相关的笔记来增强求职者
的面试准备。我们的内容主要来源于小红书官方网站的优质面试相关笔记，通过先进的爬虫技术抓
取信息，将图片存储到自建的对象存储服务（OSS），同时将笔记的URL和相关数据存储到MySQL
数据库中。用户可以轻松浏览、搜索和学习这些有价值的面试经验，以更好地准备即将到来的面试。

## 技术栈：

- 前端：利用最新的Vue 3和TypeScript进行开发，采用Vue Router进行页面路由管理，Pinia作为状态管理库，ElementPlus为UI框架，通过axios进行HTTP通信。
- 后端：基于Spring Boot 3和Mybatis-flex构建RESTful API，使用Spring WebMVC处理HTTP请求，Sa-Token负责安全的Token验证机制。数据存储方面，使用MySQL作为主数据库，Redis用于缓存策略，优化性能和响应速度。
- 安全与认证：通过邮箱和验证码实现用户登录功能，利用Sa-Token进行安全的Token验证，确保平台的安全性和用户数据的保护。
- 数据抓取与存储：项目的核心内容通过定期爬取小红书官方的面试相关笔记，自动抓取并处理数据，将图片资源上传至自建的OSS，同时将笔记内容和相关信息存储至MySQL数据库，保证内容的时效性和丰富性。

RedInterviewHub致力于打造一个互动性强、内容丰富、用户友好的面试准备平台。
无论是即将面试的求职者，还是希望分享面试经验的职场人士，都能在这里找到属于自己的空间，
共同创造一个支持与帮助的社区环境。









该项目仅用于学习,不做任何商业用途,如有侵权,请联系我删除
