package backend;

/**
 * Method to get the most poppular item ,
 * @author  Sam Raine , Adam Schmidt
 */
public class FoodFeq {
    String foodName;
    int feq;
    public FoodFeq(String foodName, int feq) {
        this.foodName = foodName;
        this.feq = feq;
    }
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFeq() {
        return feq;
    }

    public void setFeq(int feq) {
        this.feq = feq;
    }


}