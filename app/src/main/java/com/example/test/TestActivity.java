package com.example.test;

import static com.example.test.MyApplication.FONT_PATH_CIVIL;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.aminography.primecalendar.PrimeCalendar;
import com.aminography.primecalendar.common.CalendarFactory;
import com.aminography.primecalendar.common.CalendarType;
import com.aminography.primedatepicker.common.PickType;
import com.aminography.primedatepicker.picker.PrimeDatePicker;
import com.aminography.primedatepicker.picker.callback.RangeDaysPickCallback;
import com.aminography.primedatepicker.picker.theme.LightThemeFactory;
import com.aminography.primedatepicker.picker.theme.base.ThemeFactory;
import androidx.fragment.app.FragmentManager;
import java.util.Calendar;
import java.util.Locale;

public class TestActivity extends AppCompatActivity implements RangeTimePickerDialog.ISelectedTime{

    Button b1,time_selection,button2_timpic;
    private static final String PICKER_TAG = "PrimeDatePickerBottomSheet";
    private PrimeDatePicker datePicker = null;

    public static final String TIMERANGEPICKER_TAG = "timerangepicker";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        b1 = findViewById(R.id.button_test);
        time_selection = findViewById(R.id.time_selection);
        button2_timpic = findViewById(R.id.button2_timpic);
        button2_timpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                final TimeRangePickerDialog timePickerDialog = TimeRangePickerDialog.newInstance(
//                        TestActivity.this, false);
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                timePickerDialog.show(fragmentManager, TIMERANGEPICKER_TAG);
            }
        });
        time_selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RangeTimePickerDialog dialogs = new RangeTimePickerDialog();
                dialogs.newInstance();
                dialogs.setRadiusDialog(20); // Set radius of dialog (default is 50)
                dialogs.setIs24HourView(false); // Indicates if the format should be 24 hours
                dialogs.setColorBackgroundHeader(R.color.blue); // Set Color of Background header dialog
                dialogs.setColorTextButton(R.color.blue); // Set Text color of button
                FragmentManager fragmentManager = getSupportFragmentManager();
                dialogs.show(fragmentManager,"");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalendarType calendarType = CalendarType.CIVIL;
                Locale locale = Locale.ENGLISH;
                ;
                PickType pickType = PickType.RANGE_START;
                PrimeCalendar minDateCalendar = getMinDateCalendar(calendarType);
                PrimeCalendar maxDateCalendar = getMaxDateCalendar(calendarType);
                final String typeface = FONT_PATH_CIVIL;
                ThemeFactory theme = getDefaultTheme(typeface);
                PrimeCalendar today = CalendarFactory.newInstance(calendarType, locale);

                datePicker = PrimeDatePicker.Companion.bottomSheetWith(today)
                        .pickRangeDays(rangeDaysPickCallback)
                        .minPossibleDate(minDateCalendar)
                        .maxPossibleDate(maxDateCalendar)
                        .applyTheme(theme)
                        .build();
                datePicker.show(getSupportFragmentManager(), PICKER_TAG);
            }

            private PrimeCalendar getMinDateCalendar(CalendarType calendarType) {
                PrimeCalendar minDateCalendar = null;
                minDateCalendar = CalendarFactory.newInstance(calendarType);
                minDateCalendar.add(Calendar.MONTH, -5);
                return minDateCalendar;
            }

            private PrimeCalendar getMaxDateCalendar(CalendarType calendarType) {
                PrimeCalendar maxDateCalendar = null;
                maxDateCalendar = CalendarFactory.newInstance(calendarType);
                maxDateCalendar.add(Calendar.MONTH, +5);
                return maxDateCalendar;
            }

            private ThemeFactory getDefaultTheme(final String typeface) {
                return new LightThemeFactory() {
                    @Nullable
                    @Override
                    public String getTypefacePath() {
                        return typeface;
                    }
                };
            }
            private final RangeDaysPickCallback rangeDaysPickCallback = new RangeDaysPickCallback() {
                @Override
                public void onRangeDaysPicked(PrimeCalendar startDay, PrimeCalendar endDay) {
                    longToast(String.format("From: %s\nTo: %s", startDay.getLongDateString(), endDay.getLongDateString()));
                }
            };
            private void longToast(String text) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
            }

        });

    }

    @Override
    public void onSelectedTime(int hourStart, int minuteStart, int hourEnd, int minuteEnd) {
        Toast.makeText(this, "Start: "+hourStart+":"+minuteStart+"\nEnd: "+hourEnd+":"+minuteEnd, Toast.LENGTH_SHORT).show();
    }

//    @Override
//    public void onTimeRangeSelected(int startHour, int startMin, int endHour, int endMin) {
//        String startTime = startHour + " : " + startMin;
//        String endTime = endHour + " : " + endMin;
//        Toast.makeText(TestActivity.this,startTime+" "+endTime,Toast.LENGTH_LONG).show();
//    }
}