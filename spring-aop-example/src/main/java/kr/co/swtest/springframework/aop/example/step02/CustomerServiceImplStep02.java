package kr.co.swtest.springframework.aop.example.step02;

import kr.co.swtest.springframework.aop.example.service.CustomerService;

/**
 * 고객 서비스 구현체 (step02 : 프록시 패턴 또는 데코레이터 패턴)
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class CustomerServiceImplStep02 implements CustomerService {

	/** CustomerService */
	private CustomerService customerService;

	// -------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------

	/**
	 * 생성자 
	 * 
	 * @param customerService 고객 서비스
	 */
	public CustomerServiceImplStep02(CustomerService customerService) {
		this.customerService = customerService;
	}

	// -------------------------------------------------------------------------
	// Public Method
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void someProcess(int customerLevel) {
		System.out.println("transaction start");

		try {
			this.customerService.someProcess(customerLevel);

			System.out.println("commit");
		} catch (Exception e) {
			System.out.println("rollback");
		}

		System.out.println("transaction end");
	}

}
