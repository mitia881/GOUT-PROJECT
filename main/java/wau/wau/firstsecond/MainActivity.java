package wau.wau.firstsecond;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonStart= (Button)findViewById(R.id.buttonStartGame);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent= new Intent(MainActivity.this,Level1.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });
        Button buttonStartDiet= (Button)findViewById(R.id.buttonStartDiet);
        buttonStartDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent= new Intent(MainActivity.this,QuestionActivity.class);
                    startActivity(intent);finish();
                }catch (Exception e){}
            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    //системная кнопка начало

    @Override
    public void onBackPressed() {

        if(backPressedTime+2000>System.currentTimeMillis()){
              backToast.cancel();
            super.onBackPressed();
            return;
        }else{
           backToast =  Toast.makeText(getBaseContext(),"Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT) ;
           backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    //системная кнопка конец
}
