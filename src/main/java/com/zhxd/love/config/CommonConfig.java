package com.zhxd.love.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author hanyuhao
 * @PackageName com.zhxd.love.config
 * @Class CommonConfig
 * @Date 2021/8/18 13:58
 */
@Configuration
@Data
public class CommonConfig {

    @Value("${file.prefix}")
    private String exportTmpPath;

}
