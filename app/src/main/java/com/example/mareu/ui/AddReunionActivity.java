package com.example.mareu.ui;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.models.Reunion;
import com.example.mareu.services.ReunionApiService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.mareu.services.DummyReunionGenerator.DUMMY_REUNION_IMAGE_RANDOM;


public class AddReunionActivity extends AppCompatActivity {

    @BindView(R.id.avatar)
    ImageView avatar;
    @BindView(R.id.subjectLyt)
    TextInputLayout subjectInput;
    @BindView(R.id.roomLyt)
    TextInputLayout roomInput;
    @BindView(R.id.date)
    TextView dateView;
    @BindView(R.id.start_timeLyt)
    TextView start_timeView;
    @BindView(R.id.end_timeLyt)
    TextView end_timeView;
    @BindView(R.id.mails_timeLyt)
    TextInputLayout mailsInput;
    @BindView(R.id.create)
    MaterialButton addButton;

    private ReunionApiService mApiservice;
    private String mAvatarUrl;
    private Calendar myCalendar = Calendar.getInstance();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reunion);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mApiservice = DI.getReunionApiService();
        init();
        getDate();
        getStart_Time();
        getEnd_time();


    }

    private void init() {
        mAvatarUrl = random();
        Glide.with(this).load(mAvatarUrl).placeholder(R.drawable.ic_baseline_announcement_24)
                .apply(RequestOptions.circleCropTransform()).into(avatar);
        subjectInput.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                addButton.setEnabled(s.length() > 0);
            }
        });


    }

    private void getDate() {
        DatePickerDialog.OnDateSetListener date = (dateView, year, monthOfYear, dayOfMonth) ->{
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        };

        dateView.setOnClickListener(view -> {
            DatePickerDialog myDatePicker = new DatePickerDialog(AddReunionActivity.this, date,
                    myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH));
            myDatePicker.show();

        });
    }

    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        dateView.setText(sdf.format(myCalendar.getTime()));
    }

    private void getStart_Time() {

        TimePickerDialog.OnTimeSetListener time = (timePicker, hour, minute) -> {
            myCalendar.set(Calendar.HOUR_OF_DAY, hour);
            myCalendar.set(Calendar.MINUTE, minute);
            updateLabelStart_Time();

        };

        start_timeView.setOnClickListener(view -> new TimePickerDialog(AddReunionActivity.this, time,
                myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),
                false).show());

    }
    private void updateLabelStart_Time() {
        String myFormat = "HH 'h' mm";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        start_timeView.setText(sdf.format(myCalendar.getTime()));

    }

    private void getEnd_time() {
        TimePickerDialog.OnTimeSetListener time = (timePicker, hour, minute) -> {
            myCalendar.set(Calendar.HOUR_OF_DAY, hour);
            myCalendar.set(Calendar.MINUTE, minute);
            updateLabelEnd_Time();
        };

        end_timeView.setOnClickListener(view -> new TimePickerDialog(AddReunionActivity.this,time,
                myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE),
                false).show());
    }

    private void updateLabelEnd_Time() {
        String myFormat = "HH 'h' mm";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);

        end_timeView.setText(sdf.format(myCalendar.getTime()));
    }



    String random() {
        return DUMMY_REUNION_IMAGE_RANDOM.get(new Random().nextInt(DUMMY_REUNION_IMAGE_RANDOM.size()));
    }


    @OnClick(R.id.create)
    void addReunion() {
        Reunion reunion = new Reunion(
                (int) System.currentTimeMillis(),
                subjectInput.getEditText().getText().toString(),
                myCalendar.getTime(),
                roomInput.getEditText().getText().toString(),
                start_timeView.getText().toString(),
                end_timeView.getText().toString(),
                mailsInput.getEditText().toString(),
                mAvatarUrl
        );
        mApiservice.createReunion(reunion);
        finish();

    }


    public static void navigate(Activity activity) {
        Intent intent = new Intent(activity, AddReunionActivity.class);
        ActivityCompat.startActivity(activity, intent, null);
    }
}


