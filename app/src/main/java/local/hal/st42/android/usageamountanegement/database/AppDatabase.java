package local.hal.st42.android.usageamountanegement.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Card.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase _instance;

    public static AppDatabase getDatabase(Context context) {
        if (_instance == null) {
            _instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "todo_db").build();
        }
        return _instance;
    }

    public abstract CardDao createCardDAO();
}
