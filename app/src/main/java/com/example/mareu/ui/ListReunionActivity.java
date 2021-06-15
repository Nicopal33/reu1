package com.example.mareu.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.models.Reunion;
import com.example.mareu.services.ReunionApiService;

import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListReunionActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private List<Reunion> mReunions;
    private ReunionApiService mApiService;
    public MyReunionRecyclerViewAdapter myAdapter;

    @BindView(R.id.recycler_empty)
    TextView viewEmpty;
    @BindView(R.id.list_recycler_view)
    RecyclerView mRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reunion);
        ButterKnife.bind(this);
        initRecyclerView();
        showEmptyView();

    }

    private void initRecyclerView() {
        mApiService = DI.getReunionApiService();
        recyclerview = (RecyclerView) findViewById(R.id.list_recycler_view);
        mReunions = mApiService.getReunions();
        myAdapter = new MyReunionRecyclerViewAdapter(mReunions);
        recyclerview.setAdapter(myAdapter);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initList() {
        mReunions = mApiService.getReunions();
        recyclerview.setAdapter(new MyReunionRecyclerViewAdapter(mReunions));
    }

    @Override
    public void onResume() {
        super.onResume();
        this.mRecyclerView.getAdapter().notifyDataSetChanged();
        showEmptyView();

    }

    /*@Override
    public void onStart(){
        super.onStart();
        EventBus.getDefault().register(this);

    }*/


    @OnClick(R.id.addReunion)
    void addReunion() {AddReunionActivity.navigate(this);}

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    private void getDatePicker() {
        Calendar myCalendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date =(view, year, month, dayOfMonth) -> {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            mReunions = mApiService.dateFilter(myCalendar.getTime());
            myAdapter.setData(mReunions);
            showEmptyView();
        };
            DatePickerDialog myDatePicker = new DatePickerDialog(ListReunionActivity.this,date,myCalendar
                        .get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH));
            myDatePicker.show();
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.date_filter:getDatePicker();break;

            case R.id.filter_room_1:
                mReunions=mApiService.filterRoom("Salle 1");
                myAdapter.setData(mReunions);
                showEmptyView();
                break;

            case R.id.filter_room_2:
                mReunions=mApiService.filterRoom("Salle 2");
                myAdapter.setData(mReunions);
                showEmptyView();
                break;

            case  R.id.filter_room_3:
                mReunions=mApiService.filterRoom("Salle 3");
                myAdapter.setData(mReunions);
                showEmptyView();
                break;

            case R.id.filter_room_4:
                mReunions=mApiService.filterRoom("Salle 4");
                myAdapter.setData(mReunions);
                showEmptyView();
                break;

            default:
        }
        return super.onOptionsItemSelected(item);

    }

    private void showEmptyView() {
        if(myAdapter.getItemCount() ==0) {
            viewEmpty.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
        }
        else {
            viewEmpty.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        }
    }

}