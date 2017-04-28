package kr.co.swtest.springframework.aop.example.step03;

/**
 * 서비스 프록시 
 * 
 * @author <a href="mailto:scroogy@swtest.co.kr">최영목</a>
 */
public interface ServiceProxy {

	/**
	 * 서비스 호출 전 수행
	 */
	public void before();

	/**
	 * 서비스 호출 후 수행
	 */
	public void after();

	/**
	 * 성공적으로 서비스 호출 완료시 수행
	 */
	public void afterReturning();

	/**
	 * 서비스 호출 후 예외발생시 수행
	 */
	public void afterThrowing();

}
