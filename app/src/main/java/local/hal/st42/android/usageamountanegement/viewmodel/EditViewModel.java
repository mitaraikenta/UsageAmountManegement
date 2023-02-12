package local.hal.st42.android.usageamountanegement.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.google.common.util.concurrent.ListenableFuture;

import local.hal.st42.android.usageamountanegement.CardEditActivity;
import local.hal.st42.android.usageamountanegement.database.AppDatabase;
import local.hal.st42.android.usageamountanegement.database.Card;
import local.hal.st42.android.usageamountanegement.database.CardDao;

public class EditViewModel extends AndroidViewModel {

    private AppDatabase _db;

    public EditViewModel(@NonNull Application application) {
        super(application);
        _db = AppDatabase.getDatabase(application);
    }

    public long insert(Card card){
        CardDao carddao = _db.createCardDAO();
        ListenableFuture<Long> future = carddao.insert(card);
    }


}
