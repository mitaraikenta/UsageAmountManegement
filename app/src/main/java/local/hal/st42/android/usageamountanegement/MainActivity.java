package local.hal.st42.android.usageamountanegement;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import local.hal.st42.android.usageamountanegement.database.Card;
import local.hal.st42.android.usageamountanegement.databinding.ActivityMainBinding;
import local.hal.st42.android.usageamountanegement.viewmodel.MainViewModel;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel _mainviewmodel;

    private LiveData<List<Card>> _cardlist;

    private RecyclerView _list;

    private int _menuCategory;

    private  CardListObserver _cardlistobserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //リストの接続
        _list =findViewById(R.id.cardlist);
        LinearLayoutManager layout =new LinearLayoutManager(MainActivity.this);
        _list.setLayoutManager(layout);
        //横線
        DividerItemDecoration decoration = new DividerItemDecoration(MainActivity.this, layout.getOrientation());
        _list.addItemDecoration(decoration);

        ViewModelProvider provider = new ViewModelProvider(MainActivity.this);
        _mainviewmodel = provider.get(MainViewModel.class);
        _cardlist = new MutableLiveData<>();
        createRecyclerView();

    }

    /**
     * リストビューを表示させるメソッド。
     */
    private void createRecyclerView() {
        _cardlist.removeObserver(_cardlistobserver);
        _cardlist = _mainviewmodel.getCardList(_menuCategory);
        _cardlist.observe(MainActivity.this, _cardlistobserver);
    }

    private class CardListObserver implements Observer<List<Card>> {
        @Override
        public void onChanged(List<Card> cardList) {
            CardListAdapter _adapter = (CardListAdapter) _list.getAdapter();
        }
    }

    private class CardViewHolder extends RecyclerView.ViewHolder {

        public TextView _tvTaskNameRow;
        public TextView _tvTaskDeadlineRow;
        public CheckBox _cbTaskCheckRow;

        public CardViewHolder(View itemView) {
            super(itemView);
            _tvTaskNameRow = itemView.findViewById(R.id.deckname);
        }
    }



    private class CardListAdapter extends RecyclerView.Adapter<CardViewHolder>{
        private List<Card> _listdata;

        public CardListAdapter(List<Card> listData) {
            _listdata = listData;
        }

        @Override
        public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            View row = inflater.inflate(R.layout.row, parent, false);

            CardViewHolder holder = new CardViewHolder(row);
            return holder;
        }

        //データベース内のテキスト達を保存している場所
        @Override
        public void onBindViewHolder(CardViewHolder holder, int position) {
            Card card = _listdata.get(position);
            holder._tvTaskNameRow.setText(card.DeckName);
        }

        @Override
        public int getItemCount() {
            return _listdata.size();
        }
    }
}