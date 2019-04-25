package sevenkey.open.utils.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import sevenkey.open.utils.aop.aspect.ZebraMasterAspect;

/**
 * @author weijianyu
 */
@Configuration
@EnableAspectJAutoProxy
public class AopConfiguration {

    @Bean
    public ZebraMasterAspect zebraMasterAspect() {
        return new ZebraMasterAspect();
    }
}
