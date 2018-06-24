package cotacaodolar.jcarvalhojr.com.cotacaodolar;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import cotacaodolar.jcarvalhojr.com.cotacaodolar.Dominio.Dados;

public class MainActivity extends Activity {

    private TextView txtCode;
    private TextView txtCodeIn;
    private TextView txtName;
    private TextView txtHigh;
    private TextView txtLow;
    private TextView txtPctChange;
    private TextView txtOpen;
    private TextView txtBid;
    private TextView txtAsk;
    private TextView txtVarBid;
    private TextView txtTimeStamp;
    private TextView txtCreate_Date;

    private TextView txtDadoCode;
    private TextView txtDadoCodeIn;
    private TextView txtDadoNome;
    private TextView txtDadoAlta;
    private TextView txtDadoBaixa;
    private TextView txtDadoPercVar;
    private TextView txtDadoAbriu;
    private TextView txtDadoCompra;
    private TextView txtDadoVenda;
    private TextView txtDadoVariacao;
    private TextView txtDadoTimeStamp;
    private TextView txtDadoData;

    private Dados dados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Inicializar();
        getDados();

    }


    private void getDados() {
        txtDadoCode.setText(dados.getCode());
        txtDadoCodeIn.setText(dados.getCodeIn());
        txtDadoNome.setText(dados.getName());
        txtDadoAlta.setText(dados.getHigh());
        txtDadoBaixa.setText(dados.getLow());
        txtDadoPercVar.setText(dados.getPctChange()+" %");
        txtDadoAbriu.setText(dados.getOpen());
        txtDadoCompra.setText(dados.getBid());
        txtDadoVenda.setText(dados.getAsk());
        if(dados.getVarBid().contains("-")){
            txtDadoVariacao.setTextColor(Color.rgb(255,0,4));
            txtDadoVariacao.setText(dados.getVarBid());
        }
        txtDadoVariacao.setTextColor(Color.rgb(52,205,18));
        txtDadoVariacao.setText(dados.getVarBid());
        txtDadoTimeStamp.setText(dados.getTimeStamp());
        txtDadoData.setText(dados.getCreate_Date());

    }

    private void Inicializar() {
        dados = (Dados) getIntent().getSerializableExtra("dados");

        txtCode = (TextView) findViewById(R.id.txtCode);
        txtCodeIn = (TextView) findViewById(R.id.txtCodeIn);
        txtName = (TextView) findViewById(R.id.txtName);
        txtHigh = (TextView) findViewById(R.id.txtHigh);
        txtLow = (TextView) findViewById(R.id.txtLow);
        txtPctChange = (TextView) findViewById(R.id.txtPctChange);
        txtOpen = (TextView) findViewById(R.id.txtOpen);
        txtBid = (TextView) findViewById(R.id.txtBid);
        txtAsk = (TextView) findViewById(R.id.txtAsk);
        txtVarBid = (TextView) findViewById(R.id.txtVarBid);
        txtTimeStamp = (TextView) findViewById(R.id.txtTimeStamp);
        txtCreate_Date = (TextView) findViewById(R.id.txtCreate_Date);


        txtDadoCode = (TextView) findViewById(R.id.txtDadoCode);
        txtDadoCodeIn = (TextView) findViewById(R.id.txtDadoCodeIn);
        txtDadoNome = (TextView) findViewById(R.id.txtDadoNome);
        txtDadoAlta = (TextView) findViewById(R.id.txtDadoAlta);
        txtDadoBaixa = (TextView) findViewById(R.id.txtDadoBaixa);
        txtDadoPercVar = (TextView) findViewById(R.id.txtDadoPercVar);
        txtDadoAbriu = (TextView) findViewById(R.id.txtDadoAbriu);
        txtDadoCompra = (TextView) findViewById(R.id.txtDadoCompra);
        txtDadoVenda = (TextView) findViewById(R.id.txtDadoVenda);
        txtDadoVariacao = (TextView) findViewById(R.id.txtDadoVariacao);
        txtDadoTimeStamp = (TextView) findViewById(R.id.txtDadoTimeStamp);
        txtDadoData = (TextView) findViewById(R.id.txtDadoData);


    }


}
