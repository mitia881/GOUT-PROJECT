package wau.wau.firstsecond;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class QuestionActivity extends AppCompatActivity {
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mButton_back;
    private ImageButton mNextButton;
    private Button mCheatButton;
    private ImageButton mPrevButton;
    private TextView mQuestionTextView;

    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_australia, true),
            new Question(R.string.question_oceans, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
    };
    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_question);
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);


//        mTrueButton = (Button) findViewById(R.id.true_button);//Кнопка правда начало
//        mTrueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkAnswer(true);
//
//            }
//        });//кнопка правда конец
//        mFalseButton = (Button) findViewById(R.id.false_button);//кнопка лож начало
//        mFalseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                checkAnswer(false);
//
//
//            }
//        });//кнопка ложь конец
        mNextButton = (ImageButton) findViewById(R.id.next_button);//кнопка вперед начало
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });//кнопка вперед конец
//        mCheatButton = (Button) findViewById(R.id.cheat_button);//кнопка что бы подсмотреть ответ начало
//        mCheatButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //start CheatActivity
//                boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnsverTrue();
//                Intent intent = CheatActivity.newInent(QuestionActivity.this, answerIsTrue);
//                startActivity(intent);
//
//
//            }
//        });//кнопка что бы подсмотреть ответ конец
        mPrevButton = (ImageButton) findViewById(R.id.prev_button);//кнопка назад начало
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex - 1) % mQuestionBank.length;
                updateQuestion();
            }
        });//кнопка назад конец
        mButton_back = (Button) findViewById(R.id.button4);
        mButton_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обрабатываем нажатие кнопки "Назад"
                try {

                    Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {

                }
            }
        });
        updateQuestion();

    }


    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        Log.i(TAG, "saveInstanceState");
        saveInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }//сохраняем данные при повороте( когда перейдем на поворот)

    //обновляем вопрос
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }
   //проверяем ответ
    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnsverTrue();
        int messageResId = 0;
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }
    //системная кнопка назад начало
    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {

        }

    }
    //системная кнопка назад конец
}
