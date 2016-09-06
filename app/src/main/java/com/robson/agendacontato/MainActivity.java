package com.robson.agendacontato;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.robson.agendacontato.databese.DataBase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnAdd;
    EditText edtPesquisa;
    ListView lstContatos;

   // ArrayAdapter<String>adpContatos;

    //criando o objeto dataBase
    DataBase dataBase;
    //criando conexão com o banco
    SQLiteDatabase conn;

    //referência para a pasta dominio arquivo RespositórioContato
   // RepositorioContato repositorioContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (ImageButton)findViewById(R.id.btnAdd);
        edtPesquisa = (EditText)findViewById(R.id.edtPesquisa);
        lstContatos = (ListView)findViewById(R.id.lstContatos);
        //ação do botão adicionar(botão mais)
        btnAdd.setOnClickListener(this);

        //sempre que estiver usando banco de dados colocar dentro de um try cach
        try {
            //criando a conexão com a base de dados
            dataBase = new DataBase(this);
            //permite a criação, escrita e alteração do banco de dados
            conn = dataBase.getReadableDatabase();
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage( "Conexão criada com sucesso" );
            dlg.setNeutralButton( "OK", null );
            dlg.show();
        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage( "Erro ao criar o banco: " + ex.getMessage() );
            dlg.setNeutralButton( "OK", null );
            dlg.show();

        }

    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, actCadContatos.class);
        startActivity(it);
    }
}
