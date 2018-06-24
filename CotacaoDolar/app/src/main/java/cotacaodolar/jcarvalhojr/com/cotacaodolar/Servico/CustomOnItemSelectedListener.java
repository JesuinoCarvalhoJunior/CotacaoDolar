package cotacaodolar.jcarvalhojr.com.cotacaodolar.Servico;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public int idQdadeRegistro;


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Log.v("GBP-BRL", parent.getItemAtPosition(position).toString());
        idQdadeRegistro = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
//
    }
}
