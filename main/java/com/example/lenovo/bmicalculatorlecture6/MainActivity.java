package com.example.lenovo.bmicalculatorlecture6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button cal;
    TextView display;
    TextView display2;
    EditText text1;
    EditText text2;
    float h,w,result,value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display= (TextView) findViewById(R.id.display);
        display2= (TextView) findViewById(R.id.result);
        cal= (Button) findViewById(R.id.button);
        text1= (EditText) findViewById(R.id.editText1);
        text2= (EditText) findViewById(R.id.editText2);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((text1.length() == 0 && text2.length() != 0))
                {
                    text1.setError("Please enter height");

                }
                else if((text1.length() != 0 && text2.length() == 0))
                {
                    text2.setError("Please enter weight");
                }
                else if((text1.length() == 0 && text2.length() == 0))
                {
                    text1.setError("Please enter height");
                    text2.setError("Please enter weight");
                }

                else{
                    h=Float.parseFloat(text1.getText().toString());
                    w=Float.parseFloat(text2.getText().toString());
                    value=(w*10000)/(h*h);
                    display.setText(String.valueOf(value));
                    display.setVisibility(View.VISIBLE);
                    if(value<16)
                    {
                        display2.setText("Severely Underweight");
                        display2.setVisibility(View.VISIBLE);
                    }
                    else if(value<18.5)
                    {
                        display2.setText("Underweight");
                        display2.setVisibility(View.VISIBLE);
                    }
                    else if(value<25)
                    {
                        display2.setText("Normal");
                        display2.setVisibility(View.VISIBLE);
                    }
                    else if(value<30)
                    {
                        display2.setText("Overweight");
                        display2.setVisibility(View.VISIBLE);
                    }
             /*               if(text1.getText().equals(null) && text2.getText().equals(null)) {
                       text1.setError("U have not entered any value!");
                   } }*/
                    else if(value>30)
                    {
                        display2.setText("Obese");
                        display2.setVisibility(View.VISIBLE);

                    }
                }



            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.item1:
                Intent intent=new Intent("com.example.lenovo.bmicalculatorlecture6.Main2Activity");
                startActivity(intent);
                Toast.makeText(this, "BMI Chart is opened!", Toast.LENGTH_SHORT).show();
                break;
            case  R.id.resultlist:
                Toast.makeText(this, "Previous Saved Results are opened!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
