package local.hal.st42.android.usageamountanegement.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@Dao
public interface CardDao {

    @Query("SELECT * FROM Card")
    LiveData<List<Card>> findAll();

    @Query("UPDATE card SET _win = :win WHERE _id = :id")
    ListenableFuture<Integer> updatewin(long id, long win);

    @Insert
    ListenableFuture<Long> insert(Card card);

    @Update
    ListenableFuture<Integer> update(Card card);

    @Delete
    ListenableFuture<Integer> delete(Card card);
}
