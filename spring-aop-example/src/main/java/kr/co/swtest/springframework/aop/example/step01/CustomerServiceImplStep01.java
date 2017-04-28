package kr.co.swtest.springframework.aop.example.step01;

import kr.co.swtest.springframework.aop.example.service.impl.CustomerServiceImpl;

/**
 * 고객 서비스 구현체 (step01 : 상속)
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class CustomerServiceImplStep01 extends CustomerServiceImpl {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void someProcess(int customerLevel) {
		System.out.println("transaction start");

		try {
			super.someProcess(customerLevel);

			System.out.println("commit");
		} catch (Exception e) {
			System.out.println("rollback");
		}

		System.out.println("transaction end");
	}

}
