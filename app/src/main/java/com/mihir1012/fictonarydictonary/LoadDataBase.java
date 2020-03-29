package com.mihir1012.fictonarydictonary;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;

import java.io.IOException;

public class LoadDataBase extends AsyncTask<Void,Void,Boolean> {
    private Context context;
    private AlertDialog alertDialog;
    private  DataBaseHelper mdatabasehelper;

    public LoadDataBase(Context context){
        this.context = context;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        AlertDialog.Builder d = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogueview = inflater.inflate(R.layout.alert_progress_dialogue,null);
        d.setTitle("Loading Database...");
        d.setView(dialogueview);
        alertDialog = d.create();
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        mdatabasehelper = new DataBaseHelper(context);
        try{
            mdatabasehelper.createDatabase();
        } catch (IOException e) {

            throw new Error("Database not found");
        }
        mdatabasehelper.close();
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        alertDialog.dismiss();
        MainActivity.openDatabase();
    }


}
