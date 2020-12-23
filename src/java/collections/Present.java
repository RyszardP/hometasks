package collections.main_task;

import collections.main_task.candy.Candy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Present {
    private final ArrayList<Candy> candies;
    private double totalWeight;

    public Present(ArrayList<Candy> candies) {
        this.candies = candies;
    }

    public Present() {
        candies = new ArrayList<>();
        totalWeight = 0;
    }

    public ArrayList<Candy> getCandies() {
        return candies;
    }
    public void addCandy(Candy candy){
        candies.add(candy);
        totalWeight += candy.getWeight();
    }

    public void sortCandiesByProducer(){
        candies.sort(Comparator.comparing(Candy::getProducer));
    }

    public void sortCandiesByWeight(){
        candies.sort(Comparator.comparing(Candy::getWeight));
    }

    public List<Candy> getCandiesWithContentOfSugarInRange(double of, double to){
        return candies.stream().filter(x -> (x.getSugarContent() >= of) && (x.getSugarContent() <= to)).collect(Collectors.toList());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Present present = (Present) o;

        if (Double.compare(present.totalWeight, totalWeight) != 0) return false;
        return candies != null ? candies.equals(present.candies) : present.candies == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = candies != null ? candies.hashCode() : 0;
        temp = Double.doubleToLongBits(totalWeight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Present{" +
                "candies=" + candies +
                ", totalWeight=" + totalWeight +
                '}';
    }
}
