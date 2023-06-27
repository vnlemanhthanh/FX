package edu.fx;


public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	/**
	 * @param theFortuneService 
	 */
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	/**
	 * default
	 */
	public TrackCoach() {
	}



	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it: " + fortuneService.getFortune();
	}
	
}
