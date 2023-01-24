package local.hal.st42.android.usageamountanegement.database;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Card{

    @PrimaryKey
    public long _id;

    //デッキ名
    @NonNull
    public String DeckName;
    //感想
    @NonNull
    public String thought;
    //勝敗
    @NonNull
    @ColumnInfo(defaultValue = "0")
    public long _win;

}
