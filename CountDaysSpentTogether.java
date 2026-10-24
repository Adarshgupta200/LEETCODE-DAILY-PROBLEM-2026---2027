class CountDaysSpentTogether {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int arriveA = getDay(arriveAlice);
        int leaveA = getDay(leaveAlice);
        int arriveB = getDay(arriveBob);
        int leaveB = getDay(leaveBob);
        
        int overlapStart = Math.max(arriveA, arriveB);
        int overlapEnd = Math.min(leaveA, leaveB);
        
        return Math.max(0, overlapEnd - overlapStart + 1);
    }
    
    private int getDay(String date) {
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int m = Integer.parseInt(date.substring(0, 2));
        int d = Integer.parseInt(date.substring(3, 5));
        
        int dayOfYear = 0;
        for (int i = 0; i < m - 1; i++) {
            dayOfYear += months[i];
        }
        dayOfYear += d;
        
        return dayOfYear;
    }
    public static void main(String[] args) {
        CountDaysSpentTogether solution = new CountDaysSpentTogether();
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";
        
        int daysTogether = solution.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println("Days spent together: " + daysTogether);
    }
}