package kr.co.swtest.springframework.aop.example.service.impl;

import kr.co.swtest.springframework.aop.example.service.CustomerService;

/**
 * 고객 서비스 구현체
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public class CustomerServiceImpl implements CustomerService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void someProcess(int customerLevel) {
		if (customerLevel < 1) {
			System.out.println("고객레벨이 유효하지 않음");
			throw new RuntimeException();
		}

		System.out.println("고객 프로세스 처리");
	}

}
