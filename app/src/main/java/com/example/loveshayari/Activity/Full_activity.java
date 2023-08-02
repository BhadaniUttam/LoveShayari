package com.example.loveshayari.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.loveshayari.Adapter.GradientAdapter;
import com.example.loveshayari.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;


public class Full_activity extends AppCompatActivity implements  OnClickListener{

    ImageView next,back,bgGradient,bgGradient2,Edit;
    TextView textView;
    int position;
    String temp1[];
    int i = 0;
    TextView t1;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full);
        textView=findViewById(R.id.txt1);
        next=findViewById(R.id.b6);
        back=findViewById(R.id.b4);
        bgGradient=findViewById(R.id.b1);
        bgGradient2=findViewById(R.id.b2);
        Edit=findViewById(R.id.b5);

        position = getIntent().getIntExtra("pos", 0);
        temp1=getIntent().getStringArrayExtra("temp1");


        textView.setText(temp1[position]);
        t1=findViewById(R.id.t1);
        next.setOnClickListener(this);
        back.setOnClickListener(this);
        bgGradient.setOnClickListener(this);
        bgGradient2.setOnClickListener(this);
        Edit.setOnClickListener(this);
        t1.setText((position+1)+"/"+ temp1.length);

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == next.getId()) {
            if (position < temp1.length - 1) {
                position++;

                t1.setText((position + 1) + "/" + temp1.length);
                textView.setText(temp1[position]);

            }
        }
        if (v.getId() == back.getId()) {
            if (position > 0) {
                position--;
                t1.setText((position + 1) + "/" + temp1.length);
                textView.setText(temp1[position]);
            }

        }
        GradientAdapter config = null;
        if (v.getId() == bgGradient.getId()) {
            Log.d("TTT", "onClick: ");
            BottomSheetDialog dialog = new BottomSheetDialog(Full_activity.this);
            dialog.setContentView(R.layout.gradient_layout);
            GridView gridView = dialog.findViewById(R.id.gridView_gradient);
            GradientAdapter adapter = new GradientAdapter(Full_activity.this, config.gradArr);
            gridView.setAdapter(adapter);
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    textView.setBackgroundResource(config.gradArr[i]);
                }
            });
            dialog.show();
        }
        if (v.getId() == bgGradient2.getId()) {


            textView.setBackgroundResource(config.gradArr[i]);
            i++;
            if (i > config.gradArr.length - 1) {
                i = 0;
            }

        }
        if(v.getId()==Edit.getId())
        {
            Intent intent=new Intent(Full_activity.this, Edit_activity.class);
            intent.putExtra("pos",position);
            intent.putExtra("textview", String.valueOf(textView));
            startActivity(intent);
        }
    }
}