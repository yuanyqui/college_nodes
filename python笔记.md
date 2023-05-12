# Python的基本用法

## 函数

### 函数作为参数传递

引例：具体数字作为传入参数

```python
def addDemo(x,y)//逻辑关系明确，传入参数不明确
	result=x+y
    print(f"结果是{result}")
```

实例：函数作为参数传递

```python
def add(addDemo)//逻辑关系不明确传入数字明确
	result1=addDemo(1,2)
    print(f"结果是{result}")
```

总结：数字作为参数和函数作为参数的异同点

| 关系     | 数字作为参数 | 函数作为参数 |
| -------- | ------------ | ------------ |
| 逻辑关系 | 明确         | 不明确       |
| 传入数字 | 不明确       | 明确         |



### lambda函数的特点

1.只有一行

2.只能调用一次以后就不能再调用了

3.无名称

#### 定义的语法

lambda 传入参数：函数体（一行代码）

```python
def addDemo(add)
	result=add(x,y)
    print(f"结果是{result}")
相当于
addDemo(lambda x,y:x+y)//求两数之和
也可以是
addDemo(lambda x,y:xy)//求两数之积
```



### 函数多个返回值的定义

实例：

```python
def Function_demo()
	return 1,"hello","union"
x,y,z=Function_demo()
print(x)//1
print(y)//"hello"
print(z)//"union"
```

### 函数的不同传参方式

```python
def exam(name,age,home,gender)
    print(f"{name}的年龄是{age},家乡在{home},性别是{gender}")
```



#### 位置传参

```python
exam("胡洪彬",19,"信阳","男")
```

#### 关键字传参

```python
exam(name="刘新伟",home="周口",gender="男",age=18)//顺序可以换
```

优点:位置顺序可以交换

#### 关键字传参和位置传参混合使用

```python
exam("张飞",age=21,home="许昌",gender="男")//可以混合使用但第一个必须是顺序传参的第一个
```

#### 可变参数

一般形式

```python
def calc(l):
    sum = 0
    for n in l:
        sum += n
    return sum
calc([1,2,3]) #参数传入的是列表，结果为7
```

可变参数传参

实现方式:*nums将所有的实参的位置参数聚合到一个元组，并将这个元组赋值给nums

```python
def calc(*nums):
    sum = 0
    for n in nums:
        sum += n
    return sum
```

**优点：传入参数的数量可以随便**

**缺点：因为是元组，其本身还是有次序的，这就仍然存在一定的束缚，在对参数操作上也会有一些不便**

#### 可变字典参数传参

**优点： fun4(* *kargs)最为灵活，其是以键值对字典的形式向函数传参，含有关键字传参的灵活的同时具有可变参数传参方式的数量上的无限制。**

```python

```

## 文件

### 文件的操作

#### 文件的打开

open（name,mode,encoding）

mode的三个参数：

1.r :用只读的模式打开文件，指针已经默认的放在了开头

2.w:打开文件只用于文件已经存在了才能打开，并且开始从头的进行覆盖，如果不存在则会创建这样的一个文件

3.a:打开一个文件如果文件已经存在则会追加，如果文件不存在则会创建

| 参数 | 对文件的权限 | 如果文件存在       | 如果文件不存在 |
| ---- | ------------ | ------------------ | -------------- |
| r    | 只读         | 指针默认在开头     | 报错           |
| w    | 写入         | 指针从头开始写入   | 创建           |
| a    | 追加         | 指针从末尾开始追加 | 创建           |

实例

```python
f=open("D:/test01","w",encoding="UTF-8")//文件的写入
f.write("huhhuhuhu")
f.close()
f=open("D:/test01","a",encoding="UTF-8")//文件的追加
f.write("胡洪彬66666")
f.close()
f=open("D:/test01","a",encoding="UTF-8")//文件的追加
f.write("感觉不如胡洪比")
f.close()
```



#### 文件的读取

read（）方法就是读取的方法

read（10）就是读取十个字符以后的结果

文件读取全部的行是readlines（）

读取其中的一行是readline（）

line是一个字符类型的数据容器

#### 利用for循环对文件中的行进行遍历

```python
for line in f:
    print(f"line的内容是{line},line的数据类型是{type(line)}")
```

#### 文件的关闭

```python
f.close()
```



## 异常

### 异常的捕获以及结构

#### 1.基本的异常捕获

```python
try:
    f=open("D:/aaa.txt","r",encoding="UTF-8")
 except:
     print("不存在该文件")
```

#### 2.捕获指定的异常

```python
try:
    print(name)
except NameError as e:
    print("名字为定义异常")
    print(e)              
```

#### 3.定义多个异常

```python
try:
    1/0
except(NameError,ZeroDivisionError) as e:
    print("发生了名字没有定义异常或者是运算法则异常")
```

#### 4.捕获多个异常与1功能相似

```python
try:
    1/0
except Exception as e:
    print(e)
```

#### 5.finally的引入

```python
try:
f=open("D:/bill.txt","r",encoding="UTF-8")
except:
    print("不存在该文件")
else:
    print("没有异常好高兴")
finally:
    f.close()#最终有没有异常都要执行的代码
```

### 异常的传递性

```python
def function_01():
    print("函数1开始执行")
    print(1/0)           #不符合规范的命令
    print("函数结束执行")
def function_02():
    print("函数二开始执行")
    function_01()        #包含function_01()函数
    print("1")
    print("函数二结束执行")
try:
    function_02()        #运行function_02()
except Exception:
    print("通过调用含有异常方法一的方法二方法会导致try结构体造成异常从而说明函数的异常具有传递性")
```

## 数据容器

### 列表

#### 列表的基本形式



#### 列表的基本方法

```python
#对列表进行排序
#generic function
my_list=[["a",1],["b",2],["c",3]]
def paixu(element):
    return element[1]
my_list.sort(key=paixu,reverse=True)#if not reverse,this will be ascending(升序) else will be descend(降序)
print(my_list)
#lambda function
# my_list=[["a",1],["b",2],["c",3]]
# my_list.sort(key=lambda element:element[1],reverse=True)
# print(my_list)
```

### 字典

#### 字典的基本形式

```python
my_dict={"张信哲":100,"胡洪彬":101,"牛心伟":100}
```

#### 字典的基本方法

```python
my_dict={"张信哲":100,"胡洪彬":101,"牛心伟":100}
#1.新增元素
my_dict["周杰伦"]=200
print(my_dict)
#2.修改元素
my_dict["张信哲"]=87
print(my_dict)
#3.元素的删除
element=my_dict.pop("周杰伦")
print(f"删除的元素为{element},删除以后的数据为{my_dict}")
#4,清空元素’
# my_list.clear()
# print(my_list)
#special获取全部的key值
keys=my_dict.keys()
print(f"全部的值是{keys},keys的数据类型是{type(keys)}")
#变量字典
my_dict={"周杰伦":100,"胡洪斌":200,"牛欣炜":100}
#方法1
keys=my_dict.keys()
for key in keys:
    print(f"字典中的key为{key}")
    print(f"字典中的值是{my_dict[key]}")
#方法2
for key in my_dict:
    print(f"字典中的key为{key}")
    print(f"字典中的值是{my_dict[key]}")
#统计数组中的元素数量
num=len(my_dict)
print(f"字典中的所有的元素个数等于{num}")
#空集合的定义
# my_empt_dict={}  
# my_empt_dict2=dict()
# print(f"my_dict的内容是{my_dict},它的数据类型是{type(my_dict)}")
# print(f"空的集合类型是{my_empt_dict}它的数据类型是{type(my_empt_dict)}")
#定义重复的字典
# my_dict1={"周杰伦":100,"胡洪彬":200,"牛欣炜":100,"胡洪彬":100}#会自动保留后面的那个值
# print(f"应有重复的元组的数据是{my_dict1}")
#不能通过下标索引只能通过对应的key值进行搜索值
# score_zhoujielun=my_dict["周杰伦"]
# print(f"周杰伦的成绩是{score_zhoujielun}")
#my_dict={"hu":1,"liu":2}
#print(my_dict.get("hu", 1))#如果my_dict中有hu这个键的话函数的返回值值不会变，而如果没有这个hu键的话函数的返回值会变成1
#定义嵌套字典
my_student={
    "胡洪彬":{
        "chinese":100,
        "math":99,
        "english":199
    },
    "牛心伟":{
        "chinese":100,
        "math:":100,
        "english":100
    },
    "张腾飞":{
        "chinese":100,
        "math":100,
        "english":100
    }
}
print(my_student)
score=my_student["牛心伟"]["chinese"]
print(f"牛心伟的语文成绩是{score}")
```

### 集合

#### 集合的基本形式

```python
my_set={"python","niubi","666","python","niubi","666","python","niubi","666"}
```

#### 集合的基本方法

```python
#添加元素
# my_set.add("java")
# print(f"my_set添加完元素以后为{my_set}")
#移除元素
# my_set.remove("python")
# print(f"my_sey移除完元素python以后为{my_set}")
#随机取元素，取完以后元素被移除
# element=my_set.pop()
# print(f"随机去取元素以后为{my_set},取出来的元素是{element}")
#清空元素
# my_set.clear()
# print(f"清空元素以后为{my_set}")
#取出差集
my_set2={"java","niubi","666"}
set=my_set.difference(my_set2)
print(f"my_set与my_set2的差集为{set}")
#消除差集
# my_set.difference_update(my_set2)
# print(f"my_set集合消除差集以后的值为{my_set}")
# print(f"消除差集以后的集合2的值是{my_set2}")#集合2不发生变化
#两个集合合并功能
# hb=my_set.union(my_set2)
# print(f"my_set和my_set2的合并值是{hb}")
#统计集合的个数
# count=len(my_set)
# count2=len(my_set2)
# print(f"my_set里面有{count}个元素，my_set2里面有{count2}个元素")
#集合无序没有下标所以无法进行while循环进行遍历
#只能够将集合进行for循环进行输出
# for elemnet in my_set:
#     print(f"集合myset里面有元素{elemnet}")
```

## 模板

### 导入



#### 1.使用import导入模板（mudule)可以使用这个模板里面的全部方法

```python
import time
print("你好")
time.sleep(3)
print("我好")
time.sleep(3)
print("大家好")
```

#### 2. 通过from 包名 方法导入模板中的方法，只能是用这一个方法剩余的方法无法使用

```python
from time import sleep
print("你好")
sleep(3)
print("我好")
sleep(3)
print("大家好")
```

#### 3.使用as作为整个包的别名

```python
import time as t#作为一整个包的别名
print("你好")
t.sleep(3)
print("我好")
```

#### 4.使用as作为一个包里面的某个模块的别名

```python
from time import sleep as s
print("你好")
s(1)
print("我好")
```

### 模块的自定义

```python
#my_module01
__all__=["addA"]##这代表从from my_module01 import *这个函数里查找方法所以只能调用addA不能调用addB
def addA(x,y):
    print(x + y)
def addB(x,y):
    print(x*y)
# if __name__ == '__main__':#这时候标记这个名字叫做main，当这个方法被倒包进入其他包里面以后就不会调用下面这个方法
#     addA(1, 2)
```

```python
#my_module02
def add(x,y):
    print(x - y)
```

```python
#主函数对两个模板函数的测试
# import my_module01
# import my_module02
# #调用
# my_module01.addA(1,3)
#从不同模板里面倒入相同名称的函数方法
# from my_module01 import addA
# from my_module02 import add#当调用不同模块里面的同名方法的时候后一个的定义会覆盖掉第一个定义的方法所以下面调用此方法的是偶显示的是第二个里面的方法
# add(3,4)
#_main_变量
# from my_module01 import addA
# addA(1,4)
#__all__变量
from my_module01 import *#这个*就代表从__all__这个函数里查找方法所以只能调用addA不能调用addB
addA(1,4)
```

==几个模板文件之间位置的关系==

![image-20221128031600227](C:\Users\tortelee\Desktop\笔记\picture\image-20221128031600227.png)

### 包的自定义

==包里面必须包含一个_init_.py的文件这也是包与目录的区别之一==

```python
__all__=["my_module01"]
#有这个包才算是package没有这个包就只是一个普通的文件夹
```

```python
def exam2():
    print("这是包里面模块2的功能名")
```

```python
def exam1():
    print("这是包里面模块1的功能名")
```

```python
#调用包里面模块的方法
#方法1就很特美抽象
import my_package.my_module01
import my_package.my_module02
my_package.my_module01.exam1()
my_package.my_module02.exam2()
#方法2
# from my_package.my_module01 import exam1
# from my_package.my_module02 import exam2
# exam1()
# exam2()
#方法三
# from my_package import my_module02
# from my_package import my_module01
# my_module01.exam1()
# my_module02.exam2()
#__all_变量
# from  my_package import *
# my_module01.exam1()#通过修该_init_里面的__all__参数的值使得只能调用*只能调用包里面的第一个自定义模块
# my_module02.exam2()
```

==包以内的文件的节构==

![image-20221128031810638](C:\Users\tortelee\Desktop\笔记\picture\image-20221128031810638.png)

## 图形可视化

数据的一种格式：json数据格式

```python
#利用dumps()方法将列表元素转换为了json
# import json
# my_list=[{"胡鸿基":18,"牛心伟":22,"胡红笔":11},{"胡鸿基":14,"牛心伟":26,"胡红笔":19}]
# json_str=json.dumps(my_list,ensure_ascii=False)#ensure_ascii=False含义是转换为ascii关闭就是转换的是真正的汉字而不是ascii码
# print(f"json转换以后的数据类型是{type(json_str)}")#数据类型是ascii码形式
# print(f"json转换以后的数据是{json_str}")
```

```python
#准备字典将字典转换成json元素
# import json
# my_dict={"胡鸿基":18,"牛心伟":22,"胡红笔":11}
# json_str=json.dumps(my_dict,ensure_ascii=False)
# print(f"转换以后的json内容为{json_str},且转换以后的数据类型是{type(json_str)}")
```

```python
#将字符串通过json方法转变为python类型
# import json
# my_str='{"胡鸿基": 18, "牛心伟": 22, "胡红笔": 11}'
# p_dict=json.loads(my_str)
# print(f"p_dict的数据类型是{type(p_dict)},它的内容是{p_dict}")
```

### 线型图

pyecharts官方网站pyecharts.org
画廊工具gallary.pyechart.org可以参考许多的可视化数据的实现的代码
导入的模板与自己的模板不能一个名字要不然会报错

#### 折线图

```python
from pyecharts.charts import Line
from pyecharts.options import TitleOpts,LegendOpts,ToolboxOpts,VisualMapOpts   #即倒这个包
line =Line()
line.add_xaxis(["中国","美国","日本"])
line.add_yaxis("GDP",[3,2,1])
#导入全局配置
line.set_global_opts(
    title_opts=TitleOpts("GDP总量",pos_left="center",pos_bottom="1%"),#需要设置目录标题等的东西需要再次倒包
    legend_opts=LegendOpts(is_show=False),            #控制图里的输出默认就是显示的
    toolbox_opts=ToolboxOpts(is_show=True),         #工具箱是否显示
    visualmap_opts=VisualMapOpts(is_show=True)      #数据映射是否显示
)
```

#### 地图

```python
from pyecharts.charts import Map
from pyecharts.options import VisualMapOpts
map=Map()
data=[
    ("北京",199),
    ("上海",299),
    ("湖南",99),
    ("台湾",399),
    ("广东",499)
]
map.add("测绘地图",data,"china")
#设置全局选项
map.set_global_opts(
    visualmap_opts=VisualMapOpts(
        is_show=True,
        is_piecewise=True,
        pieces=[
            {"min":1,"max":10,"lable":"1-9人","color":"#CCFFFF"},
            {"min":11,"max":100,"lable":"1-9人","color":"#FFFF99"},
            {"min":101,"max":1000,"lable":"1-9人","color":"#CC3333"}
        ]
    )
)

map.render()
```

#### 柱状图

##### 静态柱状图

```python

from pyecharts.charts import Bar
bar1=Bar()
bar1.add_xaxis(["中国","美国","日本"])
bar1.add_yaxis("GDP:",["1","2","3"])
bar1.reversal_axis()
bar1.render("基本1.html")
```

##### 动态柱状图

```python
from pyecharts.charts import Bar,Timeline
from pyecharts.options import LabelOpts
bar1=Bar()
bar1.add_xaxis(["中国","美国","日本"])
bar1.add_yaxis("GDP:",["1","2","3"],label_opts=LabelOpts(position="right"))
bar1.reversal_axis()
bar1.render("基本1.html")

bar2=Bar()
bar2.add_xaxis(["中国","美国","日本"])
bar2.add_yaxis("GDP:",["2","3","4"],label_opts=LabelOpts(position="right"))
bar2.reversal_axis()
bar2.render("基本2.html")

bar3=Bar()
bar3.add_xaxis(["中国","美国","日本"])
bar3.add_yaxis("GDP:",["7","7","5"],label_opts=LabelOpts(position="right"))
bar3.reversal_axis()
bar3.render("基本3.html")

t1=Timeline()
t1.add(bar1,"点1")
t1.add(bar2,"点2")
t1.add(bar3,"点3")
#设置自动播放
t1.add_schema(
    play_interval=100,#播放间隔时间ms
    is_timeline_show=False,#是否自动播放的时候显示时间线
    is_auto_play=True,#是否自动播放
    is_loop_play=True#是否循环播放
)
t1.render("动态现状图.html")
```
