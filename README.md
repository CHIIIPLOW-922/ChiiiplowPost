# ChiiiPlowPost项目


## 项目介绍
#### 这是一个小型的社交媒体平台，用户可以注册、创建个人资料、发布帖子、关注其他用户、点赞和评论帖子等。这个项目将涵盖用户管理、帖子管理、社交功能等多个方面，让你更深入地了解Web应用程序开发。

## 技术栈

#### 1. 后端

- Spring Boot
- Spring Security

#### 2. 数据库及中间件
- MyBatis
- MySQL
- Redis
- ElasticSearch

#### 3. 前端
- Vue3
- Vite
- Vue Router
- Element Plus

## 项目业务逻辑
#### 1. 用户管理和认证：

- 用户注册：用户可以注册一个新的账户，提供用户名、电子邮件地址和密码。
- 用户登录：已注册的用户可以使用用户名和密码登录。
- 用户个人资料：每个用户可以创建个人资料，包括头像、个人信息和社交链接。
- 密码重置：实现密码重置功能，允许用户通过电子邮件请求密码重置链接。

#### 2.帖子管理：
- 创建帖子：已登录的用户可以创建新的帖子，可以包含文本、图片和其他多媒体。
- 编辑和删除帖子：用户可以编辑和删除自己的帖子。
- 帖子详情：用户可以查看帖子的详细信息，包括帖子内容、作者信息、评论等。

#### 3. 社交功能：
- 关注用户：用户可以关注其他用户，以获得其最新帖子的更新。
- 点赞和评论：用户可以点赞和评论其他用户的帖子。
- 帖子排序：实现不同的帖子排序选项，如最新、最热、关注等。

#### 4. 通知系统：
- 新消息通知：用户会收到通知，以告知他们是否有新的关注、点赞或评论。
- 实时通知：使用WebSocket或长轮询技术，以实时更新通知。

#### 5. 数据存储和数据库设计：
- 存储用户信息、帖子信息、评论信息等。
- 使用数据库索引来提高查询性能。
- 处理用户上传的图片和多媒体文件。

#### 6. 安全性和隐私：
- 使用JWT或其他安全协议来保护用户数据和身份。
- 实施隐私设置，允许用户控制其帖子的可见性。

#### 7. 前端界面：
- 创建用户友好的界面，包括用户个人资料页、帖子流、通知中心等。
- 使用Vue Router来管理不同页面之间的导航。

## 数据库设计


#### 1. 用户表
```sql
-- 用户表 (User)
CREATE TABLE IF NOT EXISTS PostUser (
    UserID INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户ID',
    Username VARCHAR(255) UNIQUE NOT NULL DEFAULT '' COMMENT '用户名',
    Email VARCHAR(255) UNIQUE NOT NULL DEFAULT '' COMMENT '电子邮件',
    PasswordHash VARCHAR(255) NOT NULL DEFAULT '' COMMENT '密码哈希',
    Avatar VARCHAR(255) DEFAULT NULL COMMENT '头像',
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    IsDeleted BOOLEAN DEFAULT false COMMENT '是否删除',
    LastUpdated timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT='用户信息表';

-- 帖子表 (Post)
CREATE TABLE IF NOT EXISTS Post (
    PostID INT AUTO_INCREMENT PRIMARY KEY COMMENT '帖子ID',
    UserID INT DEFAULT 0 COMMENT '作者ID',
    Content TEXT COMMENT '帖子内容',
    Media VARCHAR(255) DEFAULT NULL COMMENT '多媒体',
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    IsDeleted BOOLEAN DEFAULT false COMMENT '是否删除',
    LastUpdated timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT='帖子信息表';

-- 评论表 (PostComment)
CREATE TABLE IF NOT EXISTS PostComment (
    CommentID INT AUTO_INCREMENT PRIMARY KEY COMMENT '评论ID',
    PostID INT DEFAULT 0 COMMENT '帖子ID',
    UserID INT DEFAULT 0 COMMENT '用户ID',
    Content TEXT COMMENT '评论内容',
    CreatedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    IsDeleted BOOLEAN DEFAULT false COMMENT '是否删除',
    LastUpdated timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) COMMENT='评论信息表';

-- 关注表 (PostFollow)
CREATE TABLE IF NOT EXISTS PostFollow (
    FollowID INT AUTO_INCREMENT PRIMARY KEY COMMENT '关注ID',
    FollowerID INT DEFAULT 0 COMMENT '关注者ID',
    FollowingID INT DEFAULT 0 COMMENT '被关注者ID',
    IsDeleted BOOLEAN DEFAULT false COMMENT '是否删除'
) COMMENT='关注信息表';

-- 点赞表 (PostLike)
CREATE TABLE IF NOT EXISTS PostLike (
    LikeID INT AUTO_INCREMENT PRIMARY KEY COMMENT '点赞ID',
    PostID INT DEFAULT 0 COMMENT '帖子ID',
    UserID INT DEFAULT 0 COMMENT '用户ID',
    IsDeleted BOOLEAN DEFAULT false COMMENT '是否删除'
) COMMENT='点赞信息表';

-- 创建管理员表 (Admin)
CREATE TABLE IF NOT EXISTS PostAdmin (
    id INT AUTO_INCREMENT PRIMARY KEY COMMENT '管理员ID',
    username VARCHAR(255) UNIQUE NOT NULL COMMENT '用户名',
    password VARCHAR(255) NOT NULL COMMENT '密码',
    email VARCHAR(255) UNIQUE NOT NULL DEFAULT '' COMMENT '电子邮件地址',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    last_login TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后登录时间',
    IsDeleted BOOLEAN DEFAULT false COMMENT '是否删除'
) COMMENT '管理员信息表';


```
