package com.alarmer.braceletbutton.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alarmer.braceletbutton.App;
import com.alarmer.braceletbutton.R;
import com.alarmer.braceletbutton.databinding.ActivityEnterCodeBinding;

public class ActivityEnterCode extends AppCompatActivity {

    private static final String CorrectCode="1984";
    private String Code = "";
    ActivityEnterCodeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_code);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_enter_code);
        binding.setBsHandler(new BtnBsHandler());
        binding.setDigitHandler(new BtnDigitHandler());
    }

    public boolean setCodeCheck(String Code) {
        return (Code == CorrectCode);
    }

    public class BtnDigitHandler {

        public void onPress(View view) {
            Button btn = (Button) view;
            Code += btn.getText();
            if (setCodeCheck(Code)) {
                binding.textViewTimer.setText("");
                Toast.makeText(App.mContext, R.string.correct, Toast.LENGTH_SHORT).show();
                finish();
            } else
                binding.textViewCode.append("*");
        }
    }

    public class BtnBsHandler {

        public void onPress(View view) {
            if (Code.length() > 0) {
                Code = Code.substring(0, Code.length() - 1);
                CharSequence S = binding.textViewCode.getText();
                binding.textViewCode.setText(S.subSequence(0, S.length() - 1));
            }
        }
    }
}