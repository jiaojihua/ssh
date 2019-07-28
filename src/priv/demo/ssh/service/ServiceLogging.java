package priv.demo.ssh.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 日志输出实现类
 * @author 焦计划
 * @date 2019年7月27日  下午10:43:48
 */
@Aspect//通过注解定义切面
public class ServiceLogging {
	private Logger log = Logger.getLogger(this.getClass());//获取日志对象
	
	//配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("execution(public * priv.demo.ssh.service..*(..))" )
	public void aspect() {}
	
	@Before("aspect()") //定义切点和增强类型
	public void beforeService(JoinPoint joinPoint) {
		log.info("##业务方法被 调用==="+joinPoint.getTarget().getClass().getSimpleName()+"."+joinPoint.getSignature());
	}
	
	public void afterReturning(Object returnVal) {
		log.info("业务方法正常运行完成，并成功返回："+returnVal);
	}
	
	public void afterThrowing(Exception ex) {
		log.info("业务方法抛出了异常："+ ex.getMessage());
	}
	
	public void afterService() {
		log.info("业务方法完成");
	}
	
	public Boolean around(ProceedingJoinPoint pjp) throws Throwable{
		log.info("业务方法被 调用==="+pjp.getTarget().getClass().getSimpleName()+"."+pjp.getSignature()+"("+pjp.getArgs()[0]+")");
		Boolean b = null;
		if(true) {
			b = (Boolean) pjp.proceed(pjp.getArgs());
		}
		log.info("目标方法的返回值为："+b);
		log.info("业务方法执行结束");
		return b;
		
	}
	
	

}
