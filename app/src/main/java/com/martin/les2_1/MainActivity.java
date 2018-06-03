package com.martin.les2_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;

import rx.Subscription;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.my_textview);
        EditText editText = findViewById(R.id.my_edittext);

        Subscription editTextSub = RxTextView.textChanges(editText).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                textView.setText(charSequence.toString());
            }
        });
    }
}
