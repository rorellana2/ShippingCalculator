package edu.orangecoastcollege.cs273.rorellana2.shippingcalculator;
/**
 * Created by Romario on 9/14/2016.
 */
public class ShipItem {

    private double mWeight;
    private double mBaseCost;
    private double mAddedCost;
    private double mTotalCost;

    public ShipItem()
    {
        mWeight = 0.0;
        mBaseCost = 3.0;
        mAddedCost = 0.0;
        mTotalCost = 0.0;
    }

    public ShipItem(double mWeight)
    {
        this.mWeight = mWeight;
        recalculateAmounts();
    }

    public double getWeight() {
        return mWeight;
    }

    public void setWeight(double mWeight) {
        this.mWeight = mWeight;
        recalculateAmounts();
    }

    public double getBaseCost() {
        return mBaseCost;
    }

    public double getTotalCost() {
        return mTotalCost;
    }

    public double getAddedCost() {
        return mAddedCost;
    }

    private void recalculateAmounts()
    {
        if (getWeight() > 16.0)
        {
            mAddedCost = (Math.ceil((mWeight - 16.0) / 4.0)) * 0.5;
        }
        mTotalCost = mAddedCost + mBaseCost;
    }

}

