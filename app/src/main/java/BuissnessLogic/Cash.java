package BuissnessLogic;

/**
 * Created by rob2cool on 10/5/15
 * A Singelton to Keep Track of Amounts
 *
 */
public class Cash {
    private static Cash ourInstance = null;

    public double getmCashAmount() {
        return mCashAmount;
    }

    public void setmCashAmount(double mCashAmount) {
        this.mCashAmount += mCashAmount;
    }

    public void setAmount(double mCashAmount){this.mCashAmount=mCashAmount;}

    public void PayUp(double mAmountDue){
         mCashAmount =mCashAmount-mAmountDue;}
    public static Cash getOurInstance() {
        return ourInstance;
    }
    public static void setOurInstance(Cash ourInstance) {
        Cash.ourInstance = ourInstance;
    }
    private double mCashAmount;
    public static Cash getInstance() {

        if (ourInstance == null)
            ourInstance = new Cash();
        return ourInstance;
    }
    private Cash() {
        mCashAmount = 0.00;
    }

    public void removeItem() {

    }
}
