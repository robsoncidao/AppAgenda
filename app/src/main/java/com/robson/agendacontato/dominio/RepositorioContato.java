package com.robson.agendacontato.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

/**
 * Created by CIDAO on 05/09/2016.
 */
public class RepositorioContato {

    //Conexão com o banco
    SQLiteDatabase comn;

    public RepositorioContato(SQLiteDatabase comn){
        this.comn = comn;
    }

    public  void testeInserirContato() {
        for (int i = 0; i < 5; i++) {
            ContentValues values = new ContentValues();
            values.put( "TELEFONE", "32611780" );
            comn.insert( "CONTATO", null, values );
        }

    }

    //ArrayAdapter para pencher o listView (lstContatos)
    public ArrayAdapter<String> buscaContatos(Context context){
        ArrayAdapter<String> adpContatos = new ArrayAdapter<String>( context, android.R.layout.simple_list_item_1 );

        //Método responsavel pela consulta e responsável por armazenar todos registros buscados
        Cursor cursor = comn.query( "CONTATO", null, null, null, null, null, null );
        //verificando se retornou alguma dado na busca na tabela
        if (cursor.getCount() > 0);{
            cursor.moveToFirst();
            do{
                String telefone = cursor.getString( 1 );
                adpContatos.add( telefone );
            }while (cursor.moveToNext());


        }
        return adpContatos;
    }



}
