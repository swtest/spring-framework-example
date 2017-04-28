package kr.co.swtest.springframework.aop.example.step03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 트랜잭션 서비스 프록시 <br/>
 * 서비스 호출시 트랜잭션을 관리해준다. (proxy 사용)
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class TransactionServiceProxyStep03 implements ServiceProxy, InvocationHandler {

	/** 서비스 호출 대상 */
	private Object targetService;

	// -------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------

	/**
	 * private 생성자
	 *
	 * @param targetService 서비스 호출 대상
	 */
	private TransactionServiceProxyStep03(Object targetService) {
		this.targetService = targetService;
	}

	// -------------------------------------------------------------------------
	// Public Method
	// -------------------------------------------------------------------------

	/**
	 * 서비스 호출 대상(targetService)의 프록시 인스턴스 생성
	 *
	 * @param targetService 서비스 호출 대상
	 * @return 서비스 호출 대상(targetService)의 프록시 인스턴스
	 */
	public static Object newInstance(Object targetService) {
		return Proxy.newProxyInstance(targetService.getClass().getClassLoader(),
			targetService.getClass().getInterfaces(), new TransactionServiceProxyStep03(targetService));
	}

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
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		before();

		Object result = null;
		try {
			result = method.invoke(this.targetService, args);
			afterReturning();
		} catch (Exception e) {
			afterThrowing();
		}

		after();
		return result;
	}

}
