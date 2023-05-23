# spring

**地位：** 全世界最受欢迎的java开发框架

## springboot

springboot是spring家族的一个子项目 是springframe的一个简化版本，使得基于spring的软件开发的尽可能的快速

**内嵌Tomcat服务器**：基于springboot开发的web程序内嵌了Tomcat服务器，当启动类运行的时候会自动的启用内嵌的Tomcat服务器

**springboot中接收简答形参：**

- 要求参数名与接收数据名必须相同

- 会自动进行类型转换

**springboot中的@requestParam方法：**
- 方法名与接收的数据名不相同的时候用

- 该注释的require的属性的默认值是**true**代表请求参数必须传递

  ```java
  @RestController
  public class requestcontroller {
      @RequestMapping("/simpleParam")
      public  String simpleParam(@RequestParam(name="name")String username, Integer age){
          System.out.println("name:"+username+"age:"+age);
          return "OK";
      }
  }
```

  

**springboot中接收具体对象**：只需要满足一个条件

- 那就是传递的变量名与具体的对象的属性必须一致

```java
@RestController
public class requestcontroller {
    @RequestMapping("/POJO")
    public String pojo(student s){
        System.out.println(s);
        return "OK";
    }
}
```

**springboot接受数组**

```java
@RestController
public class requestcontroller {
    @RequestMapping("/shuzu")
    public String shuzu(String []s){
        System.out.println(Arrays.toString(s));
        return "OK";
    }

}
```

**springboot接受列表**：

- 需要注意：必须在方法的后面加上@requestparam，因为参数的默认接受对象是数组

  ```java
  @RestController
  public class requestcontroller {
      @RequestMapping("/list")
      public String list(@RequestParam List<String> Lt){
          System.out.println(Lt);
          return "OK";
      }
  }
  ```