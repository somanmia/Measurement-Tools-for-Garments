package com.example.lovely;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    ImageView backicon,menubar;
    TextView outputwidth,outputheight,wtitle,htitle;
    AppCompatButton resultbtn,resetbtn;
    TextInputEditText mmwidth,mmheight,synwidth,synheight;
double result,result2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wtitle=findViewById(R.id.wtitle);
        htitle=findViewById(R.id.htitle);

        backicon=findViewById(R.id.backicon);
        menubar=findViewById(R.id.menubaricon);

        outputwidth=findViewById(R.id.fmmwidth);
        outputheight=findViewById(R.id.fmmheight);

        mmwidth=findViewById(R.id.mmwidthid);
        mmheight=findViewById(R.id.mmheightid);

        synwidth=findViewById(R.id.synwidthid);
        synheight=findViewById(R.id.synheightid);

        resultbtn=findViewById(R.id.resultbtn);
        resetbtn=findViewById(R.id.resetbtn);

        resultbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String x=mmwidth.getText().toString();
                String y=mmheight.getText().toString();

                String a= synwidth.getText().toString();
                String b= synheight.getText().toString();

                if(x.length()<=0 && a.length()<=0 && y.length()<=0 && b.length()<=0){
                    Toast.makeText(MainActivity.this, "Please, Enter Valid Number.", Toast.LENGTH_LONG).show();

                }else{
                    if(x.length()>0 && a.length()>0){

                        double mwidth=Double.parseDouble(x);
                        double mheight=Double.parseDouble(a);

                        double calculate = (mheight * mwidth) / 100;
                         result = mwidth + calculate;

                        outputwidth.setText(String.valueOf(String.format("%.2f",result)));
                        wtitle.setText("(CM / INCH) WIDTH");
                    }else if(x.length()<=0 || a.length()<=0)
                            {
                                Toast.makeText(MainActivity.this, "Please, Enter Valid Number.", Toast.LENGTH_LONG).show();

                            }
                    //====== second part start========================//
                    if(y.length()>0 && b.length()>0){
                        double width=Double.parseDouble(y);
                        double height=Double.parseDouble(b);
                        double calculate2 = (width * height) / 100;
                         result2 = width + calculate2;
                        outputheight.setText(String.valueOf(String.format("%.2f",result2)));
                        htitle.setText("(CM / INCH) HEIGHT");
                    }else if(y.length()<=0 || b.length()<=0)
                    {
                        Toast.makeText(MainActivity.this, "Please, Enter Valid Number.", Toast.LENGTH_LONG).show();

                    }
                }



            }

        });


      //======  END OF RESLT BUTTON WORKING============================//
        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputheight.setText("");
                outputwidth.setText("");
                result=0;
                result2=0;
                mmwidth.setText("");
                mmheight.setText("");
                synwidth.setText("");
                synheight.setText("");
                htitle.setText("");
                wtitle.setText("");
            }
        });


        menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showmenu(v);
            }
        });







    }

    //=========== END OF CONCREATE METHOD==========================================//
public void showmenu(View v){
    PopupMenu popupMenu=new PopupMenu(MainActivity.this,v);
    popupMenu.getMenuInflater().inflate(R.menu.menuitems,popupMenu.getMenu());
    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if(item.getItemId()==R.id.homeid){
                Intent intent=new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);

            }



            if(item.getItemId()==R.id.exitid){
                AlertDialog.Builder alrt=new AlertDialog.Builder(MainActivity.this);
                alrt.setTitle("Warning");
                alrt.setMessage("Do you want to exit this Apps.");
                alrt.setIcon(R.drawable.error);
                alrt.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.exit(0);
                    }
                });

                alrt.show();
            }

            return true;
        }
    });
    popupMenu.show();
}

}
// END OF MAIN METHOD/CLASS========================//