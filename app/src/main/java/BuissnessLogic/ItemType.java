package BuissnessLogic;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rob2cool on 10/5/15.
 *
 */
public class ItemType implements Parcelable{

    private String mItemName;
    private int    mItemImage;

    protected ItemType(Parcel in) {
        mItemName = in.readString();
        mItemImage = in.readInt();
        mItemCount = in.readInt();
        mItemPrice = in.readDouble();
    }

    public static final Creator<ItemType> CREATOR = new Creator<ItemType>() {
        @Override
        public ItemType createFromParcel(Parcel in) {
            return new ItemType(in);
        }

        @Override
        public ItemType[] newArray(int size) {
            return new ItemType[size];
        }
    };

    public int getmItemImage() {
        return mItemImage;
    }

    public void setmItemImage(int mItemImage) {
        this.mItemImage = mItemImage;
    }

    public ItemType(String mItemName, int mItemCount, double mItemPrice, int mItemImage) {
        this.mItemName = mItemName;
        this.mItemCount = mItemCount;
        this.mItemPrice = mItemPrice;
        this.mItemImage= mItemImage;

    }

    public int getmItemCount() {
        return mItemCount;
    }

    public void  removeItem(){

        if (mItemCount > 0)
        mItemCount--;

    }

    public void setmItemCount(int mItemCount) {
        this.mItemCount = mItemCount;
    }

    public double getmItemPrice() {
        return mItemPrice;
    }

    public void setmItemPrice(double mItemPrice) {
        this.mItemPrice = mItemPrice;
    }

    private int    mItemCount;
    private double mItemPrice;

    public String getmItemName() {
        return mItemName;
    }

    public void setmItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mItemName);
        dest.writeInt(mItemImage);
        dest.writeInt(mItemCount);
        dest.writeDouble(mItemPrice);
    }
}
