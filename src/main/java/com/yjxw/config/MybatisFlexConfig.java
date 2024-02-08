package com.yjxw.config;

import com.mybatisflex.core.audit.AuditManager;
import com.mybatisflex.core.audit.ConsoleMessageCollector;
import com.mybatisflex.core.audit.MessageCollector;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisFlexConfig {

    public MybatisFlexConfig() {
        //开启审计功能
        AuditManager.setAuditEnable(true);

//设置 SQL 审计收集器
        MessageCollector collector = new ConsoleMessageCollector();
        AuditManager.setMessageCollector(collector);
    }


}
