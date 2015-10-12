package Views;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import BuissnessLogic.HandleItemChange;
import BuissnessLogic.ItemType;
import BuissnessLogic.ListAdapter;
import vendingexample.zipcar.com.vendingmachine.R;

/**
 * Created by rob2cool on 10/5/15.
 */
public class GridViewFragment extends Fragment {

    ArrayList<ItemType> items = new ArrayList<ItemType>();
    int mReload = 0;
    public static GridViewFragment NewInstance (int reload)
    {
        GridViewFragment f = new GridViewFragment();
        Bundle args= new Bundle();
        args.putInt("MachineRefill",reload);
       f.setArguments(args);
        return f;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        if (getArguments() != null) {
            Toast.makeText(getActivity(), "Good", Toast.LENGTH_SHORT).show();
            mReload = getArguments().getInt("MachineRefill");


        }
       View v = inflater.inflate(R.layout.item_grid_view, container, false);



        setRetainInstance(true);
return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        LoadList(items);
    }

    private void CreateGrid(ArrayList<ItemType> items) {
        RecyclerView mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.my_recycler_view);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 3);
        RecyclerView.Adapter RecyclerView_Adapter = new ListAdapter(items, getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(RecyclerView_Adapter);
    }

    private void LoadList(ArrayList<ItemType> items) {

        items.add(new ItemType("Skittles",30,1.25,R.drawable.skittles));
        items.add(new ItemType("OrbitGum",30,0.75,R.drawable.orbit));
        items.add(new ItemType("Ruffles",30,1.12,R.drawable.ruffles));
        items.add(new ItemType("Peanuts",30,1.25,R.drawable.peanuts));
        items.add(new ItemType("CocoNut Water",30,1.29,R.drawable.cocnutwater));
        items.add(new ItemType("ToosieRoll",30,1.07,R.drawable.toosieroll));
        items.add(new ItemType("Carmel Camdy",30,1.22,R.drawable.carmel));
        items.add(new ItemType("Diet Cock",30,1.25,R.drawable.dietcoke));
        items.add(new ItemType("KitKat",30,1.25,R.drawable.kitkat));
        items.add(new ItemType("Penta",30,1.25,R.drawable.penta));
        items.add(new ItemType("Zenvia",30,1.25,R.drawable.zenvia));
        items.add(new ItemType("Hasens",30,1.25,R.drawable.hazen));
        CreateGrid(items);
    }


}
