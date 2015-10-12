package vendingexample.zipcar.com.vendingmachine;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;



import BuissnessLogic.Cash;
import BuissnessLogic.HandleItemChange;
import Views.AddCashDialog;
import Views.CashDispenseDialog;
import Views.GridViewFragment;

public class MainActivity extends AppCompatActivity implements HandleItemChange {
TextView currentAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currentAmount= (TextView) findViewById(R.id.updateAmount);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       FragmentManager fragmentManager =getFragmentManager();
        FragmentTransaction transaction =fragmentManager.beginTransaction();
        GridViewFragment mGridViewFragment= new GridViewFragment();
        transaction.add(R.id.gridholder,mGridViewFragment,"frag1");
        transaction.commit();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Insert Cash", Snackbar.LENGTH_LONG)
                        .setAction("Action", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                AddCashDialog mAddCashDialog = new AddCashDialog();
                                mAddCashDialog.show(getFragmentManager(), "here");

                            }
                        }).show();


            }

    });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refill) {

            FragmentManager fragmentManager =getFragmentManager();
            FragmentTransaction transaction =fragmentManager.beginTransaction();
            GridViewFragment mGridViewFragment= GridViewFragment.NewInstance(1);
            transaction.add(R.id.gridholder,mGridViewFragment,"frag1");
            transaction.commit();
            return true;
        }

        return super.onOptionsItemSelected(item);


    }


    public void HandleItemClick(double amounCount){
        Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();

        CashDispenseDialog dispenseDialog = new CashDispenseDialog();
        dispenseDialog.show(getFragmentManager(),"DialogDispenser");

    }

    @Override
    public void DispenceChange(double change) {

            CashDispenseDialog dispenseDialog = new CashDispenseDialog();
            dispenseDialog.show(getFragmentManager(),"DialogDispenser");

    }

    @Override
    public void CurrentAmountUpdate() {

        currentAmount.setText("" + Cash.getInstance().getmCashAmount());
    }
}
