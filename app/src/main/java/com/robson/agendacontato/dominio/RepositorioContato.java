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

    public void inserirContato(Contato contato){
        //Dados preenchidos pelo usuários
        ContentValues values = new ContentValues();
        values.put( "NOME", contato.getNome());
        values.put( "TELEFONE", contato.getTelefone());
        values.put( "TIPOTELEFONE", contato.getTipoTelefone());
        values.put( "EMAIL", contato.getEmail());
        values.put( "TIPOEMAIL", contato.getTipoEmail());
        values.put( "ENDERECO", contato.getEndereco());
        values.put( "TIPOENDERECO", contato.getTipoEndereco());
        //getTime() converte a data em um inteiro para salvar no banco
        values.put( "DATASESPECIAIS", contato.getDataEspeciais().getTime());
        values.put( "TIPODATASESPECIAIS", contato.getTipoDataEspeciais());
        values.put( "GRUPOS",contato.getGrupos());

        //inserindo os dados na tabela contato
        conn.insertOrThrow( "CONTATO", null, values );
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
