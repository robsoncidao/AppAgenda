package com.robson.agendacontato;

import android.app.Activity;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.robson.agendacontato.databese.DataBase;
import com.robson.agendacontato.dominio.RepositorioContato;
import com.robson.agendacontato.dominio.entidades.Contato;

import java.util.Date;

public class actCadContatos extends AppCompatActivity {

    //Criando os campos da agenda
    EditText edtNome;
    EditText edtTelefone;
    EditText edtEmail;
    EditText edtEndereco;
    EditText edtDataEspeciais;
    EditText edtGrupos;
    //Criando os Spinner
    Spinner spnTipoTelefone;
    Spinner spnTipoEmail;
    Spinner spnTipoEndereco;
    Spinner spnTipoDataEspeciais;

    // Armazenar os dados digitados no ArrayAdapter
    ArrayAdapter<String> adpTipoEmail;
    ArrayAdapter<String> adpTipoTelefone;
    ArrayAdapter<String> adpTipoEndereco;
    ArrayAdapter<String> adpTipoDatasEspeciais;

    //criando o objeto dataBase
    DataBase dataBase;
    //criando conexão com o banco
    SQLiteDatabase conn;
    //referência para a pasta dominio arquivo RespositórioContato
    RepositorioContato repositorioContato;

    //Adicionando a classe Contato
    Contato contato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_contatos);
       // Toolbar toolbar = ( Toolbar ) findViewById( R.id.toolbar );
        //setSupportActionBar(toolbar);
        //Iniciando os campos da agenda
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtDataEspeciais = (EditText) findViewById(R.id.edtDatasEspeciais);
        edtGrupos = (EditText) findViewById(R.id.edtGrupos);

        //Iniciando as opções de cada campo da agenda
        spnTipoTelefone = (Spinner) findViewById(R.id.spnTipoTelefone);
        spnTipoEmail = (Spinner) findViewById(R.id.spntTipEmail);
        spnTipoEndereco = (Spinner) findViewById(R.id.spnTipoEndereco);
        spnTipoDataEspeciais = (Spinner) findViewById(R.id.spnTipoDatasEspeciais);

        //Iniciando os ArrayAdapter<>
        adpTipoEmail = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoTelefone = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoEndereco = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoDatasEspeciais = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoDatasEspeciais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Associando o Spnnier ao ArrayAdapter
        spnTipoEmail.setAdapter(adpTipoEmail);
        spnTipoTelefone.setAdapter(adpTipoTelefone);
        spnTipoEndereco.setAdapter(adpTipoEndereco);
        spnTipoDataEspeciais.setAdapter(adpTipoDatasEspeciais);

        //Adicionando os itens da cada Spnnier
        adpTipoEmail.add("Pessoal");
        adpTipoEmail.add("Trabalho");
        adpTipoEmail.add("Outros");

        adpTipoTelefone.add("Celular");
        adpTipoTelefone.add("Trabalho");
        adpTipoTelefone.add("Casa");
        adpTipoTelefone.add("Principal");

        adpTipoEndereco.add("Casa");
        adpTipoEndereco.add("Trabalho");
        adpTipoEndereco.add("Outros");

        adpTipoDatasEspeciais.add("Aniversário");
        adpTipoDatasEspeciais.add("Data comemorativa");
        adpTipoDatasEspeciais.add("Outros");


        //sempre que estiver usando banco de dados colocar dentro de um try cach
        try {
            //criando a conexão com a base de dados
            dataBase = new DataBase(this);
            //permite a criação, escrita e alteração do banco de dados
            conn = dataBase.getWritableDatabase();

            //repositorio contato é o arquivo que contem o CRUD
            repositorioContato = new RepositorioContato( conn );


        }catch (SQLException ex){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage( "Erro ao criar o banco: " + ex.getMessage() );
            dlg.setNeutralButton( "OK", null );
            dlg.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_act_cad_contatos, menu);
        return true;
    }
// Criação das ações de menu da tela de cadastro de contato
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //Opções de ação do menu na tela de cadastro de contato
        switch (item.getItemId()) {
            case R.id.mni_acao1:
                if (contato == null){
                    inserir();
                }
                /** teste do botão salvar
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(this);
                dlg1.setMessage( "Você escolheu Salvar " );
                dlg1.setNeutralButton( "OK", null );
                dlg1.show();
                */
               // finish();
                break;
            case R.id.mni_acao2:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inserir() {
        try {
            //Método responsável por receber os dados digitados pelo usuário
            contato = new Contato();

            contato.setNome( edtNome.getText().toString() );
            contato.setTelefone( edtTelefone.getText().toString() );
            contato.setEmail( edtEmail.getText().toString() );
            contato.setEndereco( edtEndereco.getText().toString() );

            Date date = new Date();
            contato.setDataEspeciais( date );

            contato.setGrupos( edtGrupos.getText().toString() );


            contato.setTipoTelefone( "" );
            contato.setTipoEmail( "" );
            contato.setTipoEndereco( "" );
            contato.setTipoDataEspeciais( "" );


            repositorioContato.inserir( contato );
        } catch (Exception ex) {
            AlertDialog.Builder dlg = new AlertDialog.Builder( this );
            dlg.setMessage( "Erro ao inserir os dados: " + ex.getMessage() );
            dlg.setNeutralButton( "OK", null );
            dlg.show();
        }
    }

}

