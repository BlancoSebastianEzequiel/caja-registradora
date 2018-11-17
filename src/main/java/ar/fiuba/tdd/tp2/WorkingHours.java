package ar.fiuba.tdd.tp2;

public class WorkingHours {
	private Integer hourFrom;
	private Integer minuteFrom;
	private Integer hourTo;
	private Integer minuteTo;
	public WorkingHours(String from, String to) {
		 String [] timeFrom = from.split(":");
		 String [] timeTo = to.split(":");
		 this.checkTime(timeFrom);
		 this.checkTime(timeTo);
		 this.hourFrom = Integer.parseInt(timeFrom[0]);
		 this.minuteFrom = Integer.parseInt(timeFrom[1]);
		 this.hourTo = Integer.parseInt(timeTo[0]);
		 this.minuteTo = Integer.parseInt(timeTo[1]);
	}
	
	private void checkTime(String [] time) {
		if (time.length == 2) return;
		throw new RuntimeException("Wrong time of time");
	}
}
