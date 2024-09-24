## 1.2.1. 功能说明

本工程是区块链浏览器的后端服务，功能是解析天玄链节点数据储存数据库，向前端提供数据接口，页面展示。

## 1.2.2. 前提条件

| 环境  | 版本                |
| ----- | ------------------- |
| Java  | JDK8或以上版本      |
| MySQL | MySQL-5.6或以上版本 |
| Maven | Maven-3.3或以上版本 |

## 1.2.3. 部署说明

### 1.2.3.1. 下载物料包
* 获取相关物料包（thanos-web3j和thanos-common已推到本地 Maven 仓库中的直接跳过即可）

需要从 *GitHub* 上拉取 `thanos-web3j` 代码，由于 `thanos-web3j` 编译依赖于 `thanos-common.jar` ，所以还需要拉取 `thanos-common` 代码。

```bash
cd /root
git clone https://github.com/TianXuan-Chain/thanos-web3j.git # thanos-web3j代码库
git clone https://github.com/TianXuan-Chain/thanos-common.git # thanos-common代码库 
```

* 编译

按照依赖顺序，在编译 *thanos-common* 前，还需将其依赖的 `bctls-gm-jdk15on.jar` 加载到本地 *Maven* 仓库当中。

```
mvn install:install-file -Dfile=bctls-gm-jdk15on.jar -DgroupId=org.bouncycastle -DartifactId=bctls-gm-jdk15on -Dversion=0.1 -Dpackaging=jar
```

该文件可以从此处获取：[https://github.com/TianXuan-Chain/thanos-package-generate/blob/main/dependencies/jar/bctls-gm/bctls-gm-jdk15on.jar ](https://github.com/TianXuan-Chain/thanos-package-generate/blob/main/dependencies/jar/bctls-gm/bctls-gm-jdk15on.jar)

而后，编译 `thanos-common` 。

```bash
cd /root/thanos-common
mvn clean install -Dmaven.test.skip=true
```

编译后，`thanos-common.jar` 应已被加载到了本地 *Maven* 仓库当中。可以开始编译 *thanos-web3j* 了。

请先检查 *thanos-web3j* 内部文件是否具备可执行权限，如果不具备，可以使用以下指令。

```sh
chmod -R 777 thanos-web3j # 赋予目录内文件最高权限
```

而后运行编译脚本。

```sh
cd /root/thanos-web3j
./compile.sh build
```

编译成功后会在当前目录下产生一个 dist 文件夹，该文件夹结构如下：

```
| 目录             | 说明                                       |
| -------------- | ---------------------------------------- |
| dist/apps      | web3sdk项目编译生成的jar包web3sdk.jar             |
| dist/bin       | - web3sdk: 可执行脚本，调用web3sdk.jar执行web3sdk内方法(如部署系统合约、调用合约工具方法等) <br>  - compile.sh: 调用该脚本可将dist/contracts目录下的合约代码转换成java代码，该功能便于用户基于web3sdk开发更多应用 |
| dist/conf      | 配置目录, 用于配置节点信息、证书信息、日志目录等，详细信息会在下节叙述     |
| dist/contracts | 合约存放目录，调用compile.sh脚本可将存放于该目录下的.sol格式合约代码转换成java代码 |
| dist/lib       | 存放web3sdk依赖库的jar包                         |
| dist/solc      | 存放合约编译工具,solc需要安装到/usr/local/bin/         |
```

如果 `compile.sh` 脚本执行失败，可能是服务器存在网络连接问题或者系统不兼容。可以手动安装 gradle 后进行编译。gradle 安装流程如下：

```bash
# Linux 系统
# 下载 gradle 文件
wget https://services.gradle.org/distributions/gradle-5.6.2-all.zip -P /software
# 解压
sudo unzip -d /software/gradle /software/gradle-5.6.2-all.zip
```

修改配置，将下面内容写入到 `gradle.sh` 中。

```bash
sudo vim /etc/profile.d/gradle.sh
```

```editorconfig
# 将下面写入 gradle.sh 中
export GRADLE_HOME=/software/gradle/gradle-5.6.2
export PATH=${GRADLE_HOME}/bin:${PATH}
```

而后执行脚本

```bash
sudo chmod +x /etc/profile.d/gradle.sh
source /etc/profile.d/gradle.sh
# 验证 gradle 安装
gradle -v
```

注意：如果第一步拉取 *gradle* 安装包失败，表明服务器网络连接 *gradle* 官网存在限制，请到 [官方网站](https://services.gradle.org/distributions/gradle-5.6.2-all.zip) 下载后上传到服务器。

*gradle* 安装完成后，如果是国内服务器，可以看需求是否修改为国内的镜像源。在 `{USER_HOME}/.gradle/` 目录下创建 `init.gradle` 文件，并添加下面内容：

```editorconfig
allprojects {
    repositories {
        def ALIYUN_REPOSITORY_URL = 'https://maven.aliyun.com/repository/public'
        all { ArtifactRepository repo ->
            if (repo instanceof MavenArtifactRepository) {
                def url = repo.url.toString()
                if (url.startsWith('https://repo1.maven.org/maven2')) {
                    project.logger.lifecycle "Repository ${repo.url} replaced by $ALIYUN_REPOSITORY_URL."
                    remove repo
                }
            }
        }
        maven { url ALIYUN_REPOSITORY_URL }
    }
}
```

安装配置完后，进入 `thanos-web3j` 目录，执行以下指令：

```
# 考虑到后续可能会依赖到 thanos-web3j.jar，所以将其发布到本地 Maven 仓库中
gradle publishToMavenLocal
# 如果不需要将 thanos-web3j.jar 发布到本地 Maven 仓库
# 可以使用 gradle build 指令
```


### 1.2.3.2. 拉取代码

```sh
cd /root
git clone git@github.com:TianXuan-Chain/thanos-browser-backend.git
```

```sh
cd /root/thanos-browser-backend
```

### 1.2.3.3. 修改配置

* 进入配置文件

```sh
vim /root/thanos-browser-backend/thanos-browser-web/src/main/resources/application.properties
```

* 修改MySQL配置

```properties
# 在配置文件中找到这三个配置,修改成需要连接的MySQL的配置
nv.db.url=jdbc:mysql://127.0.0.1:3306/thanos_browser?useSSL=false
nv.db.username=root
nv.db.password=123456
```

* 修改测试链配置

```properties
# 根据自己部署的天玄链节点网关(thanos-gateway) ip 和 port 修改,具体配置见 thanos-gateway.conf
thanos.rpc.ip.List=127.0.0.1:8580
chain.node.list=[{"ip":"127.0.0.1","rpcPort":8580}]
```

### 1.2.3.4. 编译代码

```sh
mvn clean package -U -Dmaven.test.skip=true
```

### 1.2.3.5. 数据初始化

* 新建数据库

```sh
#登录MySQL:
mysql -u ${your_db_account} -p${your_db_password}  例如：mysql -u root -p123456
```

```mysql
#新建数据库：
CREATE DATABASE IF NOT EXISTS thanos_browser DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
```

* 运行SQL文件

```mysql
#退出MySQL客户端
exit;
```

```sh
#运行SQL文件
mysql -u ${your_db_account} -p${your_db_password} thanos_browser < thanos_browser.sql
```

### 1.2.3.6. 服务启动

* 拷贝jar包

```sh
#拷贝jar到root路径下
cp /root/thanos-browser-backend/thanos-browser-web/target/thanos-browser-web-1.0-SNAPSHOT.jar /root/
cd /root
```

```sh
#启动
nohup java -jar thanos-browser-web-1.0-SNAPSHOT.jar >/dev/null 2>&1 &
```

### 1.2.3.7. 查看日志

```sh
#启动日志
tail -f /root/logs/thanos-browser-normal.log
#运行日志
tail -f /root/logs/thanos-browser.log
```

## 1.2.4. 问题排查

### 1.2.4.1. 同步区块信息报错

`java.sql.SQLException: Table has no partition for value ${your_error_partition}`

数据库表分区未创建

注：标题中${your_error_partition}为报错日期，根据实际报错日志填写sql

```mysql
#SQL中的日期填写报错日期+1
ALTER TABLE thanos_evm_transaction ADD PARTITION(PARTITION p${your_error_partition} + 1 VALUES LESS THAN (${your_error_partition} + 1) ENGINE = InnoDB);
```

```mysql
例：
报错日志：java.sql.SQLException: Table has no partition for value 20240923
执行SQL:ALTER TABLE thanos_evm_transaction ADD PARTITION(PARTITION p20240924 VALUES LESS THAN (20240924) ENGINE = InnoDB);
```

## 1.2.5. 安装教程

### 1.2.5.1. Oracle JDK \[1.8] 安装

```sh
# 创建新的文件夹，安装Java 8或以上的版本，将下载的jdk放在software目录
# 从Oracle官网( https://www.oracle.com/java/technologies/javase/javase8-archive-downloads.html ) 选择Java 8版本下载，推荐下载jdk-8u201-linux-x64.tar.gz
mkdir /software
# 解压jdk
tar -zxvf jdk-8u201-linux-x64.tar.gz
# 配置Java环境，编辑/etc/profile文件
vim /etc/profile
```

```editorconfig
# 打开以后将下面三句输入到文件里面并退出
export JAVA_HOME=/software/jdk1.8.0_201  #这是一个文件目录，非文件
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
```

```sh
# 生效profile
source /etc/profile
# 查询Java版本，出现的版本是自己下载的版本，则安装成功。
java -version
```

### 1.2.5.2. Maven \[3.3.9] 安装

```sh
# 下载安装文件
cd /software
wget https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
# 解压maven
tar -zxvf apache-maven-3.3.9-bin.tar.gz
# 配置环境变量
# 使用vim编辑/etc/profile文件
vim /etc/profile
```

```editorconfig
# 在 /etc/profile 文件末尾增加以下配置：
MAVEN_HOME=/software/apache-maven-3.3.9
export PATH=${MAVEN_HOME}/bin:${PATH}
```

```sh
# 生效profile
source /etc/profile
# 查询Maven版本，出现的版本是自己下载的版本，则安装成功。
mvn -v
```

国内服务器有需要的话，在 *Maven* 的 `setting.xml` 中更新一下 *aliyun* 的镜像源，后续在执行 *Maven* 执行的时候，下载速度会快一些。

```xml
<mirror>
  <id>nexus-aliyun</id>
  <mirrorOf>central</mirrorOf>
  <name>Nexus aliyun</name>
  <url>>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>
```

### 1.2.5.3. Git 安装

下载开发部署工具的源码需要依赖 *Git* ，安装命令如下：

```sh
CentOS:sudo yum install -y git
Ubuntu:sudo apt install -y git
```

配置 *git* 密钥 (可选) ：

* 将自己的 *github* 账户私钥上传到 `~/.ssh/` 目录下
* 修改私钥访问权限 `chmod 600 ~/.ssh/id_rsa ~/.ssh/id_rsa.pub`
* 启动ssh-agent `eval $(ssh-agent)`
* 添加私钥到ssh-agent `ssh-add ~/.ssh/id_rsa`

### 1.2.5.4. MySQL安装

*MariaDB*数据库是 MySQL 的一个分支，主要由开源社区在维护，采用 GPL 授权许可。*MariaDB*完全兼容 MySQL，包括API和命令行。其他安装方式请参考[MySQL官网](https://dev.mysql.com/downloads/mysql/)。

**安装MariaDB**

* 安装命令

```sh
CentOS：sudo yum install -y mariadb*
Ubuntu：sudo apt install mariadb-server
```

* 启停

```sh
启动：sudo systemctl start mariadb.service
停止：sudo systemctl stop  mariadb.service
```

* 设置开机启动

```sh
sudo systemctl enable mariadb.service
```

* 初始化

```sh
执行以下命令：
sudo mysql_secure_installation
以下根据提示输入：
Enter current password for root (enter for none):<–初次运行直接回车
Set root password? [Y/n] <– 是否设置root用户密码，输入y并回车或直接回车
New password: <– 设置root用户的密码
Re-enter new password: <– 再输入一次你设置的密码
Remove anonymous users? [Y/n] <– 是否删除匿名用户，回车
Disallow root login remotely? [Y/n] <–是否禁止root远程登录，回车
Remove test database and access to it? [Y/n] <– 是否删除test数据库，回车
Reload privilege tables now? [Y/n] <– 是否重新加载权限表，回车
```

**授权访问和添加用户**

* 使用root用户登录，密码为初始化设置的密码

```sh
mysql -uroot -p -h localhost -P 3306
```

* 授权root用户远程访问

```mysql
mysql > GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY '123456' WITH GRANT OPTION;
mysql > flush PRIVILEGES;
```

* 创建test用户并授权本地访问

```mysql
mysql > GRANT ALL PRIVILEGES ON *.* TO 'test'@localhost IDENTIFIED BY '123456' WITH GRANT OPTION;
mysql > flush PRIVILEGES;
```

**测试连接和创建数据库**

* 登录数据库

```sh
mysql -utest -p123456 -h localhost -P 3306
```

* 创建数据库

```mysql
mysql > create database thanos_browser;
```

  