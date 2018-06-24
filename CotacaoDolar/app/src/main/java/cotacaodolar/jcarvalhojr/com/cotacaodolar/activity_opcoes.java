package cotacaodolar.jcarvalhojr.com.cotacaodolar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import cotacaodolar.jcarvalhojr.com.cotacaodolar.Servico.CustomOnItemSelectedListener;
import cotacaodolar.jcarvalhojr.com.cotacaodolar.Servico.ServiceTaskDadosJson;
import cotacaodolar.jcarvalhojr.com.cotacaodolar.fragments.AboutDialog;

public class activity_opcoes extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton USD_BRL;
    private RadioButton USD_BRLT;
    private RadioButton CAD_BRL;
    private RadioButton EUR_BRL;
    private RadioButton GBP_BRL;
    private RadioButton ARS_BRL;
    private RadioButton BTC_BRL;
    private Button btnOk;

    private TextView txtTitulo;
    private TextView textView4;


    private String idQdadeRegistro;
    private String moeda = "";

    private Spinner spinnerResultados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opcoes);

        Inicializar();

        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*USD-BRL (Dólar Comercial)
                USD-BRLT (Dólar Turismo)
                CAD-BRL (Dólar Canadense)
                EUR-BRL (Euro)
                GBP-BRL (Libra Esterlina)
                ARS-BRL (Peso Argentino)
                BTC-BRL (Bitcoin)*/

                if (checkedId == R.id.rDolarComercial) {

                    moeda = "USD-BRL";
                    Log.v("USD-BRL", "Dolar Comercial");

                } else if (checkedId == R.id.rDolarTurismo) {
                    moeda = "USD-BRLT";
                    Log.v("USD-BRLT", "Dolar Turismo");

                } else if (checkedId == R.id.rDolarCanadense) {
                    moeda = "CAD-BRL";
                    Log.v("CAD-BRL", "Dolar Canadense");
                } else if (checkedId == R.id.rEuro) {
                    moeda = "EUR-BRL";
                    Log.v("EUR-BRL", "Euro");
                } else if (checkedId == R.id.rLibraEsterlina) {
                    moeda = "GBP-BRL";
                    Log.v("GBP-BRL", "Libra Esterlina");
                } else if (checkedId == R.id.rPesoArgentino) {
                    moeda = "ARS-BRL";
                    Log.v("ARS-BRL", "Peso Argentino");
                } else if (checkedId == R.id.rBitcoin) {
                    moeda = "BTC-BRL";
                    Log.v("BTC-BRL", "Bitcoin");
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            AboutDialog.showAbout(getSupportFragmentManager());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                idQdadeRegistro = String.valueOf(spinnerResultados.getSelectedItem());
                Log.v("GBP-BRL", idQdadeRegistro);

                Intent intent = new Intent(activity_opcoes.this, ServiceTaskDadosJson.class);
                intent.putExtra("moeda", moeda);
                intent.putExtra("QdadeRegistro", idQdadeRegistro);
                startActivity(intent);
            }
        });
    }


    public void addListenerOnSpinnerItemSelection() {
        spinnerResultados = (Spinner) findViewById(R.id.spinnerResultados);
        spinnerResultados.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }


    public void Inicializar() {
        moeda = "";
        radioGroup = (RadioGroup) findViewById(R.id.radioGrupo);

        txtTitulo = (TextView) findViewById(R.id.txtTitulo);


        USD_BRL = (RadioButton) findViewById(R.id.rDolarComercial);
        USD_BRLT = (RadioButton) findViewById(R.id.rDolarTurismo);
        CAD_BRL = (RadioButton) findViewById(R.id.rDolarCanadense);
        EUR_BRL = (RadioButton) findViewById(R.id.rEuro);
        GBP_BRL = (RadioButton) findViewById(R.id.rLibraEsterlina);
        ARS_BRL = (RadioButton) findViewById(R.id.rPesoArgentino);
        BTC_BRL = (RadioButton) findViewById(R.id.rBitcoin);

        spinnerResultados = (Spinner) findViewById(R.id.spinnerResultados);
        btnOk = (Button) findViewById(R.id.btnOk);
    }
}
