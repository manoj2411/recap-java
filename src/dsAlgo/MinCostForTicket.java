package dsAlgo;

public class MinCostForTicket {
    int[] days;
    int[] costs;
    int[] dailyCost;

    public MinCostForTicket(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        dailyCost = new int[366];
    }

    private int minCostForTheDay(int day) {
        int c1 = dailyCost[day - 1] + costs[0];
        int c7 = day - 7 > 0 ? dailyCost[day - 7] + costs[1] : costs[1];
        int c30 = day - 30 > 0 ? dailyCost[day - 30] + costs[2] : costs[2];
        return Math.min(c1, Math.min(c7, c30));
    }
    public int mincostTickets() {
        dailyCost[0] = 0;
        int i = 1;

        for (int day : days) {

            while(i < day) {
                dailyCost[i] = dailyCost[i - 1];
                i += 1;
            }
            dailyCost[day] = minCostForTheDay(day);
            i += 1;
        }

        return dailyCost[i - 1];
    }

    public static void main(String[] args) {

        int[] days = {1, 4, 6, 7, 8, 20}; //{1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2, 7, 15};
        MinCostForTicket mincostTicket = new MinCostForTicket(days, costs);
        System.out.println(mincostTicket.mincostTickets());
    }

}
