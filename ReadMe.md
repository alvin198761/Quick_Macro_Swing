# swing 按键精灵
能记录大部分按键，鼠标动作，并回放显示
提供定时回放，按次数回放功能

# 安装步骤
### 1.下载并编译 mini-inject 
地址： https://github.com/alvin198761/mini-inject
```sql
执行命令：
git clone https://github.com/alvin198761/mini-inject.git
unzip mini-inject.zip
cd mini-inject
mvn install

```

### 2.现在并编译JNA
地址： https://github.com/alvin198761/Simplified-JNA
```sql
执行命令：
git clone https://github.com/alvin198761/Simplified-JNA.git
unzip Simplified-JNA.zip
cd Simplified-JNA
mvn install
```

### 4.编译项目
```sql
执行命令：
cd Quick_Macro_Swing
mvn install

```

### 5.运行项目
```sql
cd Quick_Macro_Swing/target
java -jar Quick_Macro_Swing-1.0-SNAPSHOT.jar &
```
