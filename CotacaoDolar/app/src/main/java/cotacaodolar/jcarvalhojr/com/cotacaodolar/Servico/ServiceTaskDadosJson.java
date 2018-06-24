package cotacaodolar.jcarvalhojr.com.cotacaodolar.Servico;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cotacaodolar.jcarvalhojr.com.cotacaodolar.Dominio.Dados;
import cotacaodolar.jcarvalhojr.com.cotacaodolar.MainActivity;


public class ServiceTaskDadosJson extends ListActivity {

    private String moeda;
    private String QdadeRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        moeda = (String) getIntent().getSerializableExtra("moeda");
        QdadeRegistro = (String) getIntent().getSerializableExtra("QdadeRegistro");


        if(moeda == ""){
            moeda = "USD-BRL";
        }
        if(QdadeRegistro == ""){
            QdadeRegistro = "1";
        }


        new DownloadJsonAsyncTask().execute("https://economia.awesomeapi.com.br/"+moeda+"/"+QdadeRegistro+"");
        // new DownloadJsonAsyncTask().execute("https://economia.awesomeapi.com.br/all");


    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Dados dados = (Dados) l.getAdapter().getItem(position);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("dados", dados);
        startActivity(intent);
    }




    class DownloadJsonAsyncTask extends AsyncTask<String, Void, List<Dados>> {

        ProgressDialog dialog;

        //Exibe pop-up indicando que est� sendo feito o download do JSON
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = ProgressDialog.show(ServiceTaskDadosJson.this, "Aguarde...",
                    "Fazendo download do JSON");
        }

        //Acessa o servico do JSON e retorna a lista de dados
        @Override
        protected List<Dados> doInBackground(String... params) {

            String urlString = params[0];
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpget = new HttpGet(urlString);

            try {
                HttpResponse response = httpclient.execute(httpget);
                HttpEntity entity = response.getEntity();

                if (entity != null) {
                    InputStream instream = entity.getContent();
                    String json = getStringFromInputStream(instream);
                    instream.close();
                    List<Dados> dados = getDados(json);
                    return dados;
                }
            } catch (Exception e) {
                Log.e("Erro", "Falha ao acessar Web service!", e);
            }
            return null;
        }


        //Depois de executada a chamada do servico
        @Override
        protected void onPostExecute(List<Dados> result) {
            super.onPostExecute(result);
            dialog.dismiss();

            if (result.size() > 0) {

                ArrayAdapter<Dados> adapter = new ArrayAdapter<Dados>(
                        ServiceTaskDadosJson.this,
                        android.R.layout.simple_list_item_1, result);
                setListAdapter(adapter);



            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(ServiceTaskDadosJson.this)
                        .setTitle("Erro")
                        .setMessage("Não foi possível acessar as informações!")
                        .setPositiveButton("OK", null);
                builder.create().show();
            }
        }

        //Retorna uma lista de DADOS com as informacoes  retornadas do JSON
        private List<Dados> getDados(String jsonString) {

            List<Dados> dados = new ArrayList<Dados>();

            try {

                JSONArray dadosJson = new JSONArray(jsonString);
                // JSONObject objObtido;
                JSONObject objObtido = new JSONObject();

                for (int i = 0; i < dadosJson.length(); i++) {

                    //JSONObject objObtido = new JSONObject(dado.getString(i));

                    objObtido = new JSONObject(dadosJson.getString(i));

                    Log.i("COTACAO: ", "name= " + objObtido.getString("name"));

                    Dados objetoDados = new Dados();


                    //  objetoDados.setIdReg(objObtido.getString("idReg"));
                    objetoDados.setCode(objObtido.getString("code"));
                    objetoDados.setCodeIn(objObtido.getString("codein"));
                    objetoDados.setName(objObtido.getString("name"));
                    objetoDados.setHigh(objObtido.getString("high"));
                    objetoDados.setLow(objObtido.getString("low"));
                    objetoDados.setPctChange(objObtido.getString("pctChange"));
                    objetoDados.setOpen(objObtido.getString("open"));
                    objetoDados.setBid(objObtido.getString("bid"));
                    objetoDados.setAsk(objObtido.getString("ask"));
                    objetoDados.setVarBid(objObtido.getString("varBid"));
                    objetoDados.setTimeStamp(objObtido.getString("timestamp"));
                    objetoDados.setCreate_Date(objObtido.getString("create_date"));

                    dados.add(objetoDados);


                    /*

                    objetoDados.setIdReg(dado.getString("idReg"));
                    objetoDados.setCode(dado.getString("code"));
                    objetoDados.setCodeIn(dado.getString("CodeIn"));
                    objetoDados.setName(dado.getString("name"));
                    objetoDados.setHigh(dado.getString("high"));
                    objetoDados.setLow(dado.getString("low"));
                    objetoDados.setPctChange(dado.getString("pctChange"));
                    objetoDados.setOpen(dado.getString("open"));
                    objetoDados.setBid(dado.getString("bid"));
                    objetoDados.setAsk(dado.getString("ask"));
                    objetoDados.setVarBid(dado.getString("varBid"));
                    objetoDados.setTimeStamp(dado.getString("timeStamp"));
                    objetoDados.setCreate_Date(dado.getString("create_Date"));
*/
                }

            } catch (JSONException e) {
                Log.e("Erro", "Erro no parsing do JSON", e);
            }
            return dados;
        }


        //Converte objeto InputStream para String
        private String getStringFromInputStream(InputStream is) {

            BufferedReader br = null;
            StringBuilder sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(is));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            return sb.toString();

        }

    }
}
