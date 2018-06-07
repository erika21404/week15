package eisc.tku.week15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {


    private TextView Message;
    private RadioGroup Gender;
    private Switch sw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    public  void findviews(){
        Message = (TextView) findViewById(R.id.textView);
        Gender = (RadioGroup)findViewById(R.id.RadioGroup);
        sw = (Switch)findViewById(R.id.switch1);

        Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton=(RadioButton)group.findViewById(checkedId);
                Message.setText(radioButton.getText());
            }
        });

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Switch swit=(Switch)buttonView;
                String swName=swit.getText().toString();
                String message="";
                if(isChecked){
                    message=swName+" "+swit.getTextOn();
                }
                else{
                    message=swName+" "+swit.getTextOff();
                }
                Message.setText(message);
            }
        });

        }

    public void onPlaceClick(View v){
        CheckBox checkBox=(CheckBox)v;
        String boxname=checkBox.getText().toString();
        String message;
        if(checkBox.isChecked()){
            message=getString(R.string.checked)+" "+boxname;
        }
        else{
            message=getString(R.string.unchecked)+" "+boxname;
        }
        Message.setText(message);
    }

    public void onVibrateClick(View v){
        ToggleButton toggleButton=(ToggleButton)v;
        Message.setText(toggleButton.getText());
    }

}
