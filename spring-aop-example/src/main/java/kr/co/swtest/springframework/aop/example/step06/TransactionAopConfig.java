package kr.co.swtest.springframework.aop.example.step06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import kr.co.swtest.springframework.aop.example.step03.ServiceProxy;

/**
 * 트랜잭션 AOP 설정 
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
@Aspect
public class TransactionAopConfig implements ServiceProxy {
	
	// -------------------------------------------------------------------------
	// Public Method
	// -------------------------------------------------------------------------
	
	@Pointcut("execution(* kr.co.swtest.springframework.aop.example.service.CustomerService.someProcess(..))")
	public void transactionPointCut() {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Before("transactionPointCut()")
	@Override
	public void before() {
		System.out.println("transaction start");
	}

	/**
	 * {@inheritDoc}
	 */
	@After("transactionPointCut()")
	@Override
	public void after() {
		System.out.println("transaction end");
	}

	/**
	 * {@inheritDoc}
	 */
	@AfterReturning("transactionPointCut()")
	@Override
	public void afterReturning() {
		System.out.println("commit");
	}

	/**
	 * {@inheritDoc}
	 */
	@AfterThrowing("transactionPointCut()")
	@Override
	public void afterThrowing() {
		System.out.println("rollback");
	}

}
