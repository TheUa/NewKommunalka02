package com.example.admin.newkommunalka02;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Admin on 08.09.2016.
 */
public class FileJsonTaskDownload extends AsyncTask<Void, Void, Void> {

    private String porog_electro_1;
    private String porog_electro_2;
    private String electro_1;
    private String electro_2;
    private String electro_3;
    private String porog_electro_selo_1;
    private String porog_electro_selo_2;
    private String electro_selo_1;
    private String electro_selo_2;
    private String electro_selo_3;
    private String porog_electro_pgt_1;
    private String porog_electro_pgt_2;
    private String electro_pgt_1;
    private String electro_pgt_2;
    private String electro_pgt_3;
    private String porog_gas1;
    private String gas1;
    private String gas2;
    private int test;
    private ProgressDialog pDialog;

    private Activity activity;
    private Context mContext;


    FileJsonTaskDownload fileReadTaskDownload;

    private String TAG = "KEY_007";
    final String textSource = "https://drive.google.com/uc?export=download&confirm=no_antivirus&id=0B7zCew1T1qQKeFczWTRSNjc0dDQ";
    DatabaseHelperTarif databaseHelperTarif;

    String textResult;

//        ProgressDialog dialog = new ProgressDialog(getApplicationContext());

    public FileJsonTaskDownload(Context context){
        //constructor
        this.mContext = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pDialog = ProgressDialog.show(mContext, "Wait...", "sending data ...", true);
        pDialog.setCancelable(false);
//            dialog.setMessage("Doing something, please wait.");
//            dialog.show();

        new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                fileReadTaskDownload.cancel(true);
            }

        };
    }

    @Override
    protected Void doInBackground(Void... params) {

        URL textUrl;

        try {
            textUrl = new URL(textSource);

            BufferedReader bufferReader = new BufferedReader(
                    new InputStreamReader(textUrl.openStream()));
            String StringBuffer;
            String stringText = "";
            while ((StringBuffer = bufferReader.readLine()) != null) {
                stringText += StringBuffer;
            }
            bufferReader.close();

            textResult = stringText;
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            textResult = e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            textResult = e.toString();
        }
        isCancelled();
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {

            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }
//            jsone_object.setText(textResult);

        try {


            databaseHelperTarif = new DatabaseHelperTarif(mContext);
            databaseHelperTarif.onDelete();

            JSONObject jsonObject = new JSONObject(textResult);
            JSONArray gorod = jsonObject.getJSONArray("gorod");
            JSONArray selo = jsonObject.getJSONArray("selo");
            JSONArray pgt = jsonObject.getJSONArray("pgt");

            JSONArray crimea = jsonObject.getJSONArray("crimea");
            for (int i = 0; i < crimea.length(); i++) {
                JSONObject json_message = crimea.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemTarif(databaseHelperTarif.TABLE_CRIMEA, new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray volin = jsonObject.getJSONArray("volin");
            for (int i = 0; i < volin.length(); i++) {
                JSONObject json_message = volin.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemVolin(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray vinica = jsonObject.getJSONArray("vinica");
            for (int i = 0; i < vinica.length(); i++) {
                JSONObject json_message = vinica.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemVinica(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray donetsk = jsonObject.getJSONArray("donetsk");
            for (int i = 0; i < donetsk.length(); i++) {
                JSONObject json_message = donetsk.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemDoneck(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray dnepr = jsonObject.getJSONArray("dnepr");
            for (int i = 0; i < dnepr.length(); i++) {
                JSONObject json_message = dnepr.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemDnepr(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray jitomir = jsonObject.getJSONArray("jitomir");
            for (int i = 0; i < jitomir.length(); i++) {
                JSONObject json_message = jitomir.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemJitomir(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray zakarpatia = jsonObject.getJSONArray("zakarpatia");
            for (int i = 0; i < zakarpatia.length(); i++) {
                JSONObject json_message = zakarpatia.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemZakarpatia(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray zapor = jsonObject.getJSONArray("zapor");
            for (int i = 0; i < zapor.length(); i++) {
                JSONObject json_message = zapor.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemZapor(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray ivanofr = jsonObject.getJSONArray("ivanofr");
            for (int i = 0; i < ivanofr.length(); i++) {
                JSONObject json_message = ivanofr.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemIvanoFr(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray kievski = jsonObject.getJSONArray("kievski");
            for (int i = 0; i < kievski.length(); i++) {
                JSONObject json_message = kievski.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemKievski(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray kirovograd = jsonObject.getJSONArray("kirovograd");
            for (int i = 0; i < kirovograd.length(); i++) {
                JSONObject json_message = kirovograd.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemKirovograd(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray lugansk = jsonObject.getJSONArray("lugansk");
            for (int i = 0; i < lugansk.length(); i++) {
                JSONObject json_message = lugansk.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemLygansk(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray lvov = jsonObject.getJSONArray("lvov");
            for (int i = 0; i < lvov.length(); i++) {
                JSONObject json_message = lvov.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemLvov(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray nikolaev = jsonObject.getJSONArray("nikolaev");
            for (int i = 0; i < nikolaev.length(); i++) {
                JSONObject json_message = nikolaev.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemNikolaev(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray odessa = jsonObject.getJSONArray("odessa");
            for (int i = 0; i < odessa.length(); i++) {
                JSONObject json_message = odessa.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemOdessa(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray poltava = jsonObject.getJSONArray("poltava");
            for (int i = 0; i < poltava.length(); i++) {
                JSONObject json_message = poltava.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemPoltava(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray rovno = jsonObject.getJSONArray("rovno");
            for (int i = 0; i < rovno.length(); i++) {
                JSONObject json_message = rovno.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemRovno(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray sumi = jsonObject.getJSONArray("sumi");
            for (int i = 0; i < sumi.length(); i++) {
                JSONObject json_message = sumi.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemSymi(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray ternopol = jsonObject.getJSONArray("ternopol");
            for (int i = 0; i < ternopol.length(); i++) {
                JSONObject json_message = ternopol.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemTernopol(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray harkov = jsonObject.getJSONArray("harkov");
            for (int i = 0; i < harkov.length(); i++) {
                JSONObject json_message = harkov.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemHarkov(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray herson = jsonObject.getJSONArray("herson");
            for (int i = 0; i < herson.length(); i++) {
                JSONObject json_message = herson.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemHerson(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray hmelnitsk = jsonObject.getJSONArray("hmelnitsk");
            for (int i = 0; i < hmelnitsk.length(); i++) {
                JSONObject json_message = hmelnitsk.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemHmelnitsk(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray cherkasi = jsonObject.getJSONArray("cherkasi");
            for (int i = 0; i < cherkasi.length(); i++) {
                JSONObject json_message = cherkasi.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemCherkasi(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray chernovci = jsonObject.getJSONArray("chernovci");
            for (int i = 0; i < chernovci.length(); i++) {
                JSONObject json_message = chernovci.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemChernovci(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray chernigov = jsonObject.getJSONArray("chernigov");
            for (int i = 0; i < chernigov.length(); i++) {
                JSONObject json_message = chernigov.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemChernigov(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }
            JSONArray kiev = jsonObject.getJSONArray("kiev");
            for (int i = 0; i < kiev.length(); i++) {
                JSONObject json_message = kiev.getJSONObject(i);
                if (json_message != null) {
                    databaseHelperTarif.addArchiveItemKiev(new ArchiveItemTarif(json_message.getString("cwater_name"),
                            json_message.getString("cwater_in"),
                            json_message.getString("cwater_out")));
                }
            }

            JSONObject gorodItem = gorod.getJSONObject(0);
            JSONObject seloItem = selo.getJSONObject(0);
            JSONObject pgtItem = pgt.getJSONObject(0);
            porog_electro_1 = gorodItem.getString("porog_electro_1");
            porog_electro_2 = gorodItem.getString("porog_electro_2");
            electro_1 = gorodItem.getString("electro_1");
            electro_2 = gorodItem.getString("electro_2");
            electro_3 = gorodItem.getString("electro_3");
            porog_electro_selo_1 = seloItem.getString("porog_electro_1");
            porog_electro_selo_2 = seloItem.getString("porog_electro_2");
            electro_selo_1 = seloItem.getString("electro_1");
            electro_selo_2 = seloItem.getString("electro_2");
            electro_selo_3 = seloItem.getString("electro_3");
            porog_electro_pgt_1 = pgtItem.getString("porog_electro_1");
            porog_electro_pgt_2 = pgtItem.getString("porog_electro_2");
            electro_pgt_1 = pgtItem.getString("electro_1");
            electro_pgt_2 = pgtItem.getString("electro_2");
            electro_pgt_3 = pgtItem.getString("electro_3");
            porog_gas1 = jsonObject.getString("gas_porog1");
            gas1 = jsonObject.getString("gas_do_200");
            gas2 = jsonObject.getString("gas_vse");
            test = jsonObject.getInt("has_download");

                saveText();

            Log.e(TAG, "work!!!");

            Toast.makeText(mContext, "Download", Toast.LENGTH_LONG).show();

            super.onPostExecute(result);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(TAG, "error while parsing", e);
                Toast.makeText(mContext, e.toString(), Toast.LENGTH_LONG).show();
        }
    }

    private void saveText() {

            SharedPreferences mSettings = PreferenceManager.getDefaultSharedPreferences(mContext);
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString("test", "test");
            editor.putString("key_porog_electro_gorod1", porog_electro_1 + " " + mContext.getText(R.string.kwt));
//            editor.putString("key_porog_electro_gorod2", porog_electro_2 + " " + getText(R.string.kwt));
//            editor.putString("key_tarif_electro_gorod", electro_1 + " " + getText(R.string.valute));
//            editor.putString("key_tarif_electro_gorod1", electro_2 + " " + getText(R.string.valute));
//            editor.putString("key_tarif_electro_gorod2", electro_3 + " " + getText(R.string.valute));
//
//            editor.putString("key_porog_electro_selo1", porog_electro_selo_1 + " " + getText(R.string.kwt));
//            editor.putString("key_porog_electro_selo2", porog_electro_selo_2 + " " + getText(R.string.kwt));
//            editor.putString("key_tarif_electro_selo", electro_selo_1 + " " + getText(R.string.valute));
//            editor.putString("key_tarif_electro_selo1", electro_selo_2 + " " + getText(R.string.valute));
//            editor.putString("key_tarif_electro_selo2", electro_selo_3 + " " + getText(R.string.valute));
//
//            editor.putString("key_porog_electro_pgt1", porog_electro_pgt_1 + " " + getText(R.string.kwt));
//            editor.putString("key_porog_electro_pgt2", porog_electro_pgt_2 + " " + getText(R.string.kwt));
//            editor.putString("key_tarif_electro_pgt", electro_pgt_1 + " " + getText(R.string.valute));
//            editor.putString("key_tarif_electro_pgt1", electro_pgt_2 + " " + getText(R.string.valute));
//            editor.putString("key_tarif_electro_pgt2", electro_pgt_3 + " " + getText(R.string.valute));
//
//            editor.putString("key_gas1", gas1 + " " + getText(R.string.valute));
//            editor.putString("key_gas_porog", porog_gas1 + " " + getText(R.string.m3));
//            editor.putString("key_gas2", gas2 + " " + getText(R.string.valute));
            editor.putInt("test_download", 1);
            editor.apply();

    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}



