package kr.co.swtest.springframework.aop.example.step04;

import org.junit.Before;
import org.junit.Test;

import kr.co.swtest.springframework.aop.example.service.CustomerService;
import kr.co.swtest.springframework.aop.example.service.impl.CustomerServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * Step04 테스트 : cglib
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class Step04Test {

	/** CustomerService */
	private CustomerService customerService;

	@Before
	public void before() {
		Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CustomerServiceImpl.class);
        enhancer.setCallback(new TransactionServiceProxyStep04());
        this.customerService = (CustomerService) enhancer.create();
	}

	// -------------------------------------------------------------------------
	// Test Method
	// -------------------------------------------------------------------------

	/**
	 * 성공 케이스
	 */
	@Test
	public void testSuccess() {
		this.customerService.someProcess(2);
	}

	/**
	 * 실패 케이스
	 */
	@Test
	public void testFail() {
		this.customerService.someProcess(0);
	}

}
