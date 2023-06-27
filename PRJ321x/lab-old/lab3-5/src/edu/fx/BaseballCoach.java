package edu.fx;


public class BaseballCoach implements Coach {
	
	private FortuneService fortuneService;
	
	/**
	 * @param theFortuneService
	 */
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}
}
