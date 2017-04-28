package kr.co.swtest.springframework.aop.example.step05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.swtest.springframework.aop.example.service.CustomerService;

/**
 * Step05 테스트 : Spring AOP (xml)
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextHierarchy({@ContextConfiguration("/step05-applicationContext.xml")})
public class Step05Test {

	/** CustomerService */
	@Autowired
	private CustomerService customerService;

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
	@Test(expected = RuntimeException.class)
	public void testFail() {
		this.customerService.someProcess(0);
	}

}
