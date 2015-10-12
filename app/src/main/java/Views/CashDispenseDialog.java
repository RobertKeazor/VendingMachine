package Views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import BuissnessLogic.Cash;
import BuissnessLogic.HandleItemChange;
import vendingexample.zipcar.com.vendingmachine.R;

/**
 * Created by rob2cool on 10/6/15.
 *
 */
public class CashDispenseDialog extends DialogFragment {
    int mQuater =0;
    int mNickel=0;
    int mDime = 0;
    int mPenny=0;
    TextView mQuaterView;
    TextView mNickelView;
    TextView mDimeView;
    TextView mPennyVIew;
    HandleItemChange updateItem;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.change_dispense, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view).setPositiveButton("OK",null);
        updateItem = (HandleItemChange) getActivity();
        mQuaterView= (TextView) view.findViewById(R.id.Quater);
        mDimeView= (TextView) view.findViewById(R.id.dime);
        mNickelView= (TextView) view.findViewById(R.id.Nickel);
        mPennyVIew= (TextView) view.findViewById(R.id.Penny);
        while (Cash.getInstance().getmCashAmount() >= 0.25)
        {
            mQuater++;
            Cash.getInstance().PayUp(0.25);
        }
       while (Cash.getInstance().getmCashAmount() >= 0.10)
       {
           mDime ++;
           Cash.getInstance().PayUp(0.10);

       }
        while (Cash.getInstance().getmCashAmount() >= 0.05)
        {
            mNickel ++;
            Cash.getInstance().PayUp(0.05);
        }
        while (Cash.getInstance().getmCashAmount() >= 0.01 )
        {
            mPenny ++;
            Cash.getInstance().PayUp(0.01);
        }

        if (Cash.getInstance().getmCashAmount() !=0.00)
        {
            mPenny++;
            Cash.getInstance().setAmount(0.00);
        }

        mQuaterView.setText(""+mQuater);
        mDimeView.setText(""+mDime);
        mNickelView.setText(""+mNickel);
        mPennyVIew.setText(""+mPenny);

        Cash.getInstance().setmCashAmount(0.00);
        updateItem.CurrentAmountUpdate();
        return builder.create();
    }
}
