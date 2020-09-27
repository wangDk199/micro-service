package com.soft1851.sprintboot.coursecenter.ribbonConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ke
 * @ClassName RibbonConfiguration
 * @Description TOOD
 * @Date 2020/9/25
 * @Version 1.0
 **/
//@Configuration
public class RibbonConfiguration {
    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
