package wau.wau.firstsecond;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    public int numLeft;//переменная для левой картинки
    public int numRight;//переменная для Right картинки
    Array array = new Array();
    Random random = new Random();//генератор  случайных чисел
    public int count = 0;// счетчик правильных ответов


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //создаем переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.Level1);//установили текст


        final ImageView img_left = (ImageView) findViewById(R.id.img_left);
        //код который скругляет углы
        img_left.setClipToOutline(true);
        final ImageView img_right = (ImageView) findViewById(R.id.img_right);
        img_right.setClipToOutline(true);
        //путь к левой TextView
        final TextView text_left = findViewById(R.id.text_left);
        //Путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);
        //развернуть игру на весь экран
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //развернуть игру на весь экран конец
        //вызов диалогового окна в начале игры
        dialog = new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.previewdialog);// путь к макету окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалоговонго окна
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад
        //устанавливаем картинку в диалоговое он=кно начало
        ImageView previewimg=(ImageView)dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewimgtwo);
        //устанавливаем картинку в диалоговое он=кно конец
        //устанавливаем фон диалогово окна начало
        LinearLayout dialogfon = (LinearLayout) dialog.findViewById(R.id.dialodfon);
        dialogfon.setBackgroundResource(R.drawable.previewbackdroundone);
        //устанавливаем фон диалогово окна конец
        //Устанавливаем описание задания начала
        TextView textdescription=(TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.levelthree);
        //Устанавливаем описание задания конец
        //кнопка которая закрывает диалоговое окно- начало
        TextView btnclose = (TextView) dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обрабатываем кнопки начало
                try {
                    //вернуться к началу выбора начало
                    Intent intent = new Intent(Level3.this, GameLevels.class);//создали намерение для перехода
                    startActivity(intent);//start
                    finish();//clous this class
                    //вернуться к началу выбора конец


                } catch (Exception e) {
                    //здесь кода не будет

                }
                dialog.dismiss();//закрываем диалоговое окно
                //обрабатываемм нажатие кнопки конец
            }
        });


        //кнопка которая закрывает диалоговое окно- конец
        //кнопка продолжить начало
        Button btncontinue = dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        //кнопка продолжить конец


        dialog.show();//показать диалоговое окно

        //_______________________________________________
        //вызов диалогового окна в конце игры
        dialogEnd = new Dialog(this);//создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend);// путь к макету окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалоговонго окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);//окно нельзя закрыть кнопкой назад
        //интересный факт начало
        TextView textdescriptionEnd=(TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.levеltwoEnd);

        //интересный факт конец
        //кнопка которая закрывает диалоговое окно- начало
        TextView btnclose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обрабатываем кнопки начало
                try {
                    //вернуться к началу выбора начало
                    Intent intent = new Intent(Level3.this, GameLevels.class);//создали намерение для перехода
                    startActivity(intent);//start
                    finish();//clous this class
                    //вернуться к началу выбора конец


                } catch (Exception e) {
                    //здесь кода не будет

                }
                dialogEnd.dismiss();//закрываем диалоговое окно
                //обрабатываемм нажатие кнопки конец
            }
        });


        //кнопка которая закрывает диалоговое окно- конец
        //кнопка продолжить начало
        Button btncontinue2 = dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent=new Intent(Level3.this, Level3.class);
                    startActivity(intent);
                    finish();

                }catch (Exception  e){
                    //здесь кода не будет

                }

                dialog.dismiss();

            }
        });
        //кнопка продолжить конец



        //_________________________________________________

        //кнопка назад начал
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обрабатываем нажатие кнопки "Назад"
                try {

                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        //кнопка назад конец
        //масииив для прогрксса  игры начало
        final int[] progress = {R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5, R.id.point6,
                R.id.point7, R.id.point8, R.id.point9, R.id.point10, R.id.point11, R.id.point12, R.id.point13,
                R.id.point14, R.id.point15, R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,

        };
        //масииив для прогрксса  игры конец
        //подключаем анимацию начало
        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);


        //подключаем анимацию конец
        numLeft = random.nextInt(10);//генерируем  случайное  число
        img_left.setImageResource(array.images2[numLeft]);//достаем из масива картинку
        text_left.setText(array.texts2[numLeft]);//достаем из массива текст

        numRight = random.nextInt(10);//генерируем случайное число
        //цикл с предусловием, проверяющий равенство чисел начало
        while (numLeft == numRight) {
            numRight = random.nextInt(10);
        }
        //цикл с предусловием, проверяющий равенство чисел конец
        img_right.setImageResource(array.images2[numRight]);
        text_right.setText(array.texts2[numRight]);//достаем из масива текс
        //обрабатываем нажатие начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условия касания картинки начало

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки начало
                    img_right.setEnabled(false);
                    if (numLeft > numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //если отпустил палец- начало
                    if (numLeft > numRight) {
                        //если левая картинка больше
                        if (count < 20) {
                            count = count + 1;
                        }
                        //закрашиваем серым цветом начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем серым цветом-конец
                        //определяемправильные ответы и закрашиваем зеленым -начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяемправильные ответы и закрашиваем зеленым -конец


                    } else {
                        //если левая картинка меньше
                        if (count>0){
                            if(count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем серым цветом-конец
                        //определяемправильные ответы и закрашиваем зеленым -начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }


                    }
                    //если отпустил палец конец
                    if (count==20){
                        //ВЫХОД из УРОВНЯ
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(10);//генерируем  случайное  число
                        img_left.setImageResource(array.images2[numLeft]);//достаем из масива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]);//достаем из массива текст

                        numRight = random.nextInt(10);//генерируем случайное число
                        //цикл с предусловием, проверяющий равенство чисел начало
                        while (numLeft == numRight) {
                            numRight = random.nextInt(10);
                        }
                        //цикл с предусловием, проверяющий равенство чисел конец
                        img_right.setImageResource(array.images2[numRight]);//достаем из массива картику
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]);//достаем из масива текс
                        img_right.setEnabled(true);//включаем картинку

                    }

                }
                //условия касания картинки конец

                return true;
            }
        });


        //обрабатываем нажатие конец

        //обрабатываем нажатие на правую картинкуначало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условия касания картинки начало

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //если коснулся картинки начало
                    img_left.setEnabled(false);//блокируем левую картинку
                    if (numLeft < numRight) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }

                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //если отпустил палец- начало
                    if (numLeft < numRight) {
                        //если правая картинка больше
                        if (count < 20) {
                            count = count + 1;
                        }
                        //закрашиваем серым цветом начало
                        for (int i = 0; i < 20; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем серым цветом-конец
                        //определяемправильные ответы и закрашиваем зеленым -начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяемправильные ответы и закрашиваем зеленым -конец


                    } else {
                        //если левая картинка меньше
                        if (count>0){
                            if(count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        for (int i = 0; i < 19; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем серым цветом-конец
                        //определяемправильные ответы и закрашиваем зеленым -начало
                        for (int i = 0; i < count; i++) {
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }


                    }
                    //если отпустил палец конец
                    if (count==20){
                        //ВЫХОД из УРОВНЯ
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(10);//генерируем  случайное  число
                        img_left.setImageResource(array.images2[numLeft]);//достаем из масива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts2[numLeft]);//достаем из массива текст

                        numRight = random.nextInt(10);//генерируем случайное число
                        //цикл с предусловием, проверяющий равенство чисел начало
                        while (numLeft == numRight) {
                            numRight = random.nextInt(10);
                        }
                        //цикл с предусловием, проверяющий равенство чисел конец
                        img_right.setImageResource(array.images2[numRight]);//достаем из массива картику
                        img_right.startAnimation(a);
                        text_right.setText(array.texts2[numRight]);//достаем из масива текс
                        img_left.setEnabled(true);//включаем картинку левую

                    }

                }
                //условия касания картинки на правую картинку конец

                return true;
            }
        });


        //обрабатываем нажатие конец


    }

    //системная кнопка назад начало
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }

    }
    //системная кнопка назад конец
}
