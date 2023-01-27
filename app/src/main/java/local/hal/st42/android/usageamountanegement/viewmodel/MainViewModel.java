package local.hal.st42.android.usageamountanegement.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import local.hal.st42.android.usageamountanegement.database.AppDatabase;
import local.hal.st42.android.usageamountanegement.database.Card;
import local.hal.st42.android.usageamountanegement.database.CardDao;

public class MainViewModel extends AndroidViewModel {

    private AppDatabase _db;

    public MainViewModel(Application application) {
        super(application);
        _db = AppDatabase.getDatabase(application);
    }

    public LiveData<List<Card>> getCardList(int _menu){
        CardDao carddao = _db.createCardDAO();

        LiveData<List<Card>> cardlist;

        cardlist = carddao.findAll();

        return cardlist;
    }
}
