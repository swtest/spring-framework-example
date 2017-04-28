package kr.co.swtest.springframework.aop.example.step03;

import org.junit.Before;
import org.junit.Test;

import kr.co.swtest.springframework.aop.example.service.CustomerService;
import kr.co.swtest.springframework.aop.example.service.impl.CustomerServiceImpl;

/**
 * Step03 테스트 : proxy
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class Step03Test {

	/** CustomerService */
	private CustomerService customerService;

	@Before
	public void before() {
		this.customerService = (CustomerService)TransactionServiceProxyStep03.newInstance(new CustomerServiceImpl());
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
