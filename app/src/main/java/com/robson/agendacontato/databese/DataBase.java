package com.robson.agendacontato.databese;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by CIDAO on 02/09/2016.
 */


public class DataBase extends SQLiteOpenHelper{


    public DataBase (Context context){
        //o número 1 indica a versão do banco.
        super(context, "Agenda", null, 1);
    }

    @Override
    //Criação da tabela
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( ScriptSQL.getCreateTableContato() );

    }
    //Alteração de tabela
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
