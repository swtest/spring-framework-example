package kr.co.swtest.springframework.aop.example.service;

/**
 * 고객 서비스
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public interface CustomerService {

	/**
	 * 특정 프로세스 처리
	 *
	 * @param level 고객레벨
	 * @return 처리여부
	 */
	public void someProcess(int customerLevel);

}
