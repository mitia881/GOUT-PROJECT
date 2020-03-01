package wau.wau.firstsecond;

public class Question {
    private int mTextResId;
    private boolean mAnsverTrue;

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnsverTrue() {
        return mAnsverTrue;
    }

    public void setAnsverTrue(boolean ansverTrue) {
        mAnsverTrue = ansverTrue;
    }

    public Question(int textResId, boolean ansverTrue) {
        mTextResId = textResId;


    }
}
