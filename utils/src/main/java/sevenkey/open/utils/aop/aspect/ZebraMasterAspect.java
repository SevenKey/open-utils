package sevenkey.open.utils.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author weijianyu
 */
@Aspect
public class ZebraMasterAspect {
    private final Logger logger = LoggerFactory.getLogger(ZebraMasterAspect.class);

    @Around("@annotation(sevenkey.open.utils.aop.annotation.ZebraMaster)")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("ZebraMaster 注解前执行逻辑");
        Object obj = pjp.proceed();
        logger.info("ZebraMaster 注解后执行逻辑");
        return obj;
    }
}
