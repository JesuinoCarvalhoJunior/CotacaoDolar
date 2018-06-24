package cotacaodolar.jcarvalhojr.com.cotacaodolar.Servico;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public int idQdadeRegistro;


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(position).toString(),
                Toast.LENGTH_SHORT).show();

        idQdadeRegistro = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
//
    }
}
