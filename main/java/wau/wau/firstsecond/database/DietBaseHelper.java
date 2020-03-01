package wau.wau.firstsecond.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import wau.wau.firstsecond.database.DietDbGout.DietTable;

public class DietBaseHelper extends SQLiteOpenHelper {
    private static final int VERSION=1;
    private static final String DATABASE_NAME= "dietBase.db";
    public DietBaseHelper(Context context){
        super(context,DATABASE_NAME,null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + DietTable.NAME + " ( " +
                        " _id integer primary key autoincrement, " +
                DietTable.Cols.BREAKFAST + ", " +
                DietTable.Cols.LUNCH + ", " +
                DietTable.Cols.SNACK + ", " +
                DietTable.Cols.DINNER + ", " +
                DietTable.Cols.STOPITING +
                ")"
                );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
