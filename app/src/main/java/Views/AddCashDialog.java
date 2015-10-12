package Views;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import BuissnessLogic.Cash;
import BuissnessLogic.HandleItemChange;
import vendingexample.zipcar.com.vendingmachine.R;

/**
 * Created by rob2cool on 10/6/15.
 */
public class AddCashDialog extends DialogFragment {
    ImageView addImage;
    TextView currentAmount;
    HandleItemChange updateAmount;
    boolean amountchanged=false;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog_fragment,null);
        updateAmount = (HandleItemChange) getActivity();
        builder.setView(view).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               if (amountchanged) {
                   Toast.makeText(getActivity(), "Amount Added", Toast.LENGTH_SHORT).show();

               amountchanged=false;
               } else {
                   Toast.makeText(getActivity(), "No Changes Made", Toast.LENGTH_SHORT).show();
               }

            }
        });
         addImage= (ImageView) view.findViewById(R.id.add_image);
        currentAmount = (TextView) view.findViewById(R.id.currentamount);
        currentAmount.setText("" + Cash.getInstance().getmCashAmount());
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cash.getInstance().setmCashAmount(0.25);
                updateAmount.CurrentAmountUpdate();


                currentAmount.setText("" + Cash.getInstance().getmCashAmount());
                amountchanged=true;
            }

        });

        return builder.create();
    }

}
