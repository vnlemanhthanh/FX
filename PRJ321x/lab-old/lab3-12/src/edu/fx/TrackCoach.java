package edu.fx;


public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	/**
	 * @param theFortuneService 
	 */
	public TrackCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}


	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just do it: " + fortuneService.getFortune();
	}
	
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside method doMyStartupStuff");
	}
	
	public void doMyCleanupStuffYoYo() {
		System.out.println("TrackCoach: inside method doMyCleanupStuffYoYo");
	}	
	
}
