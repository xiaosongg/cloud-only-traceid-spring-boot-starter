# 多个服务的调用链路日志打印唯一traceid插件 cloud-only-traceid-spring-boot-starter

# V1.0.0

## 介绍

多个服务之间的调用打印的日志中携带唯一traceId，用于出现问题后排查整个链路

## 前言

对于工程的开发，必然会伴随着各种bug，工程量越大，出现bug的概率也会越高。一般大型项目都会有很多个服务，一个核心操作基本都会请求多个服务，出了问题后如果没有什么标识则很难进行排查是哪出现了问题，使用此插件即可快速定位整个链路，并确认问题所在。

## 系统需求

![jdk版本](https://img.shields.io/badge/java-1.8%2B-red.svg?style=for-the-badge&logo=appveyor)
![maven版本](https://img.shields.io/badge/maven-3.2.5%2B-red.svg?style=for-the-badge&logo=appveyor)
![spring boot](https://img.shields.io/badge/spring%20boot-2.0.0.RELEASE%2B-red.svg?style=for-the-badge&logo=appveyor)

## 最快上手

- 将此工程通过``mvn clean install``打包到本地仓库中。
- 在你的所有服务工程中的``pom.xml``中做如下依赖

```
        <dependency>
            <groupId>com.wusong</groupId>
            <artifactId>cloud-only-traceid-spring-boot-starter</artifactId>
            <version>1.0.0-PERSONAL</version>
        </dependency>

```

### 开启traceId配置

- 在``application.properties``或者``application.yml``中做如下的配置：

```
cloud:
  only:
    trace:
      enabled: true

logging:
  pattern:
    console: "%d{yyyy-MM-dd-HH:mm:ss} [%X{traceId}] [%thread] %-5level %logger- %msg%n"
    file: "%d{yyyy-MM-dd-HH:mm:ss} [%X{traceId}] [%thread] %-5level %logger- %msg%n"
```

- 具体说明如下：

|名称|参数类型|说明|必要配置|
|:-:|:-:|:-:|:-:|
|cloud.only.trace.enabled|boolean|用于是否开启traceId|是|
|logging.pattern.console|string|日志打印格式|是|
|logging.pattern.file|string|日志打印格式|是|

- 以上配置好以后就可以写demo测试了，各服务之间都会在日志中打印相同的traceId：

```
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/demo")
public class DemoController {

    private final ServiceSampleClient serviceSampleClient;

    @ApiOperation("测试唯一id")
    @GetMapping("/sms-tracer-id")
    public String hello(HttpServletRequest request) {

        log.info("Request header with {}", request.getHeader("traceId"));
        
        return serviceSampleClient.hello();
    }
}
```

```
@FeignClient(name = "service-sample", url = "http://127.0.0.1:8001")
public interface ServiceSampleClient {

  @GetMapping("/hello")
  String hello();
}
```

```
@Slf4j
@RestController
@RequestMapping("/")
public class ServiceSampleController {

@GetMapping("/hello")
public String hello(HttpServletRequest request) {
    log.info("Received new request for hello api.");
    log.info("Request header with {}", request.getHeader("traceId"));
    return "Hello";
}
}
```

### 效果图
- 调起方服务
![效果](/doc/tuyi.png)

- 被调用的服务
![效果](/doc/tuer.png)

# 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request
