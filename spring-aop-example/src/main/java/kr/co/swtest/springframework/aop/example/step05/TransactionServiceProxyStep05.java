package kr.co.swtest.springframework.aop.example.step05;

import kr.co.swtest.springframework.aop.example.step03.ServiceProxy;

/**
 * 트랜잭션 서비스 프록시<br/>
 * 서비스 호출시 트랜잭션을 관리해준다.
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class TransactionServiceProxyStep05 implements ServiceProxy {

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

}
