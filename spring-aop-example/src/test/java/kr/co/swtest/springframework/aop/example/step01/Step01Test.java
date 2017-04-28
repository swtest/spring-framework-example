package kr.co.swtest.springframework.aop.example.step01;

import org.junit.Before;
import org.junit.Test;

import kr.co.swtest.springframework.aop.example.service.CustomerService;

/**
 * Step01 테스트 : 상속
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class Step01Test {

	/** CustomerService */
	private CustomerService customerService;

	@Before
	public void before() {
		this.customerService = new CustomerServiceImplStep01();
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
