package com.viinet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class TaskExecutorConfig {

    @Bean(name="asyncThreadPoolTaskExecutor")
    public ThreadPoolTaskExecutor getAsyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(500);
        taskExecutor.setMaxPoolSize(3500);
        taskExecutor.setQueueCapacity(10000);
        taskExecutor.setKeepAliveSeconds(1000);
        taskExecutor.setThreadNamePrefix("async thread pool - ");
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        taskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        taskExecutor.setAwaitTerminationSeconds(1000);
        taskExecutor.initialize();
        return taskExecutor;
    }



}
