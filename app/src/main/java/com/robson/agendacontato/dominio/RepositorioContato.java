package com.robson.agendacontato.dominio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import com.robson.agendacontato.dominio.entidades.Contato;

/**
 * Created by CIDAO on 05/09/2016.
 */
public class RepositorioContato {

    //Conexão do banco de dados
    SQLiteDatabase conn;

    public RepositorioContato(SQLiteDatabase conn) {
        this.conn = conn;
    }

    public void inserir(Contato contato){
        //Criação dos parâmetros da tela de cadastro de contato
        ContentValues values = new ContentValues();
       // values.put("Nome", contato.getNome());
        values.put("TELEFONE", contato.getTipoTelefone() );
        values.put("TIPOTELEFONE", contato.getTipoTelefone());
        values.put("EMAIL", contato.getEmail());
        values.put("TIPOEMAIL", contato.getTipoEmail());
        values.put("ENDERECO", contato.getEndereco());
        values.put("TIPOENDERECO", contato.getTipoEndereco());
        values.put("DATAESPECIAIS", contato.getDataEspeciais().getTime());
        values.put("TIPODATAESPECIAS", contato.getTipoDataEspeciais());
        values.put("GRUPOS", contato.getGrupos());

        //salvar os dados
        conn.insertOrThrow("CONTATO", null, values );

    }
    /*
    public void testeInserirContato() {
        for (int i = 0; i < 10; i++) {
            ContentValues values = new ContentValues();
            values.put( "TELEFONE", "3261-1908" );
            conn.insertOrThrow( "CONTATO", null, values );
        }
    }*/

    public ArrayAdapter<String> buscaContatos(Context context) {

        ArrayAdapter<String> adpContatos = new ArrayAdapter<String>( context, android.R.layout.simple_list_item_1 );

        Cursor cursor = conn.query( "CONTATO", null, null, null, null, null, null );

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                String telefone = cursor.getString( 1 );
                adpContatos.add( telefone );
            } while (cursor.moveToNext());
        }
        return adpContatos;
    }


}
