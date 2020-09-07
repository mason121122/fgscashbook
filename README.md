# fgscashbook
This is a personal project, the purpose is to achieve their own financial accounting


swagger2地址：http://127.0.0.1:8080/swagger-ui.html

Actuator

    /autoconfig用来查看自动配置的使用情况，包括：哪些被应用、哪些未被应用以及它们未被应用的原因、哪些被排除。 
    
    /configprops可以显示一个所有@ConfigurationProperties的整理列表。
    
    /beans可以显示Spring容器中管理的所有Bean的信息。 
    
    /dump用来查看应用所启动的所有线程，每个线程的监控内容如下图所示。 
    
    /env用来查看整个应用的配置信息，使用/env/[name]可以查看具体的配置项。 
    
    /health用来查看整个应用的健康状态，包括磁盘空间使用情况、数据库和缓存等的一些健康指标。 
    
    /info可以显示配置文件中所有以info.开头或与Git相关的一些配置项的配置信息。
    
    /mappings用来查看整个应用的URL地址映射信息。
    
    /metrics用来查看一些监控的基本指标，也可以使用/metrics/[name]查看具体的指标。 
    
    /shutdown是一个POST请求，用来关闭应用，由于操作比较敏感，默认情况下该请求是被禁止的，若要开启需在配置文件中添加以下配置：  
    
    endpoints.shutdown.enabled: true
    
    /trace用来监控所有请求的追踪信息，包括：请求时间、请求头、响应头、响应耗时等信息。 
