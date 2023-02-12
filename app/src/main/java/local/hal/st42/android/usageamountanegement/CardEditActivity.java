package local.hal.st42.android.usageamountanegement;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import local.hal.st42.android.usageamountanegement.viewmodel.EditViewModel;

public class CardEditActivity  extends AppCompatActivity {

    private long inputDone = 0;

    private EditViewModel _EditViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Insert);

        ViewModelProvider provider = new ViewModelProvider(CardEditActivity.this);
        _EditViewModel = provider.get(EditViewModel.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean Button(MenuItem menuitem){




    }


}
