package kr.co.swtest.springframework.aop.example.step02;

import org.junit.Before;
import org.junit.Test;

import kr.co.swtest.springframework.aop.example.service.CustomerService;
import kr.co.swtest.springframework.aop.example.service.impl.CustomerServiceImpl;

/**
 * Step02 테스트 : 프록시 패턴 또는 데코레이터 패턴
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class Step02Test {

	/** CustomerService */
	private CustomerService customerService;

	@Before
	public void before() {
		this.customerService = new CustomerServiceImplStep02(new CustomerServiceImpl());
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
