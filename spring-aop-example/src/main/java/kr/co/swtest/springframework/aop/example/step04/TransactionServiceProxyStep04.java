package kr.co.swtest.springframework.aop.example.step04;

import java.lang.reflect.Method;

import kr.co.swtest.springframework.aop.example.step03.ServiceProxy;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 트랜잭션 서비스 프록시 <br/>
 * 서비스 호출시 트랜잭션을 관리해준다. (cglib 사용)
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class TransactionServiceProxyStep04 implements ServiceProxy, MethodInterceptor {

	// -------------------------------------------------------------------------
	// Public Method
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void before() {
		System.out.println("transaction start");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void after() {
		System.out.println("transaction end");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterReturning() {
		System.out.println("commit");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void afterThrowing() {
		System.out.println("rollback");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object intercept(Object targetService, Method method, Object[] args, MethodProxy methodProxy)
		throws Throwable {
		before();

		Object result = null;
		try {
			result = methodProxy.invokeSuper(targetService, args);
			afterReturning();
		} catch (Exception e) {
			afterThrowing();
		}

		after();
		return result;
	}

}
