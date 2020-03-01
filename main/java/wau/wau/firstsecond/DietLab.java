package wau.wau.firstsecond;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import wau.wau.firstsecond.database.DietBaseHelper;
import wau.wau.firstsecond.database.DietDbGout;
import wau.wau.firstsecond.database.DietDbGout.DietTable;

public class DietLab {
    private static DietLab sDietLab;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    public static DietLab get(Context context) {
        if (sDietLab == null) {
            sDietLab = new DietLab(context);
        }
        return sDietLab;
    }

    private DietLab(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DietBaseHelper(mContext)
                .getWritableDatabase();

        for (int i = 0; i < 100; i++) {

            Diet diet = new Diet();

        }
    }

    public List<Diet> getDiets() {
        return new ArrayList<>();


    }
    public void updateDiet(Diet diet){
        String brearfastString= diet.getBreakfast();
        ContentValues values=getContentValues(diet);
        mDatabase.update(DietTable.NAME, values,
                DietTable.Cols.BREAKFAST +  " = ?",
                new String[]{brearfastString});
    }

    private static ContentValues getContentValues(Diet diet) {
        ContentValues values = new ContentValues();
        values.put(DietTable.Cols.BREAKFAST, diet.getBreakfast());
        values.put(DietTable.Cols.LUNCH, diet.getLunch());
        values.put(DietTable.Cols.SNACK, diet.getSnack());
        values.put(DietTable.Cols.DINNER, diet.getDinner());
        values.put(DietTable.Cols.STOPITING, diet.getStopiting());
        return values;
    }

    public void addDiet(Diet d) {
        ContentValues values = getContentValues(d);
        mDatabase.insert(DietTable.NAME, null, values);
    }
}
