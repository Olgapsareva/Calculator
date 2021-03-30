package ru.geekbrains.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.radiobutton.MaterialRadioButton;

public class SettingsActivity extends AppCompatActivity {

    //имя файла с настройками
    private static final String SHARED_PREFERENCES = "THEME_SET_UP";

    //задаем ключ для записи/чтения в файле с настройками
    private static final String SELECTED_THEME = "APP_THEME";

    public static final int LIGHT_THEME = 0;
    public static final int DARK_THEME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getCustomStyle(getThemeFromPreferences()));
        setContentView(R.layout.activity_settings);

        initView();
    }

    //читаем файл с настройками

    private int getThemeFromPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        //если в преференсах нет записи по ключу - возвращаем код светлой темы
        return sharedPreferences.getInt(SELECTED_THEME, LIGHT_THEME);
    }
    private void initView() {
        RadioButton lightTheme = findViewById(R.id.radioButton_light);
        RadioButton darkTheme = findViewById(R.id.radioButton_dark);

        //сетим листнер и задаем код соответствующей темы
        initRadioButton(lightTheme, LIGHT_THEME);
        initRadioButton(darkTheme, DARK_THEME);

        RadioGroup rg = findViewById(R.id.radioButtons);
        ((MaterialRadioButton)rg.getChildAt(getThemeFromPreferences())).setChecked(true);

        Button returnButton = findViewById(R.id.button_return);

        returnButton.setOnClickListener(v->{
            finish();
        });

    }

    private void initRadioButton(RadioButton btn, int themeCode) {
        btn.setOnClickListener(v->{
            setAppTheme(themeCode);
            recreate();
        });
    }

    //сохраняем в файл с настройками

    private void setAppTheme(int themeCode) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(SELECTED_THEME, themeCode);
        editor.apply();
    }

   private int getCustomStyle(int themeFromPreferences) {
        switch (themeFromPreferences){
            case DARK_THEME : return R.style.Dark_Theme;
            default: return R.style.Light_Theme;

        }
    }
}