package com.robson.agendacontato;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class actCadContatos extends Activity {

    //Criando os campos da agenda
    EditText edtNome;
    EditText edtTelefone;
    EditText edtEmail;
    EditText edtEndereco;
    EditText edtDataEspeciais;
    EditText edtGrupos;
    //Criando as opções de cada campo
    Spinner spnTipoTelefone;
    Spinner spnTipoEmail;
    Spinner spnTipoEndereco;
    Spinner spnTipoDataEspeciais;

    //Armazenar os dados digitados no ArrayAdapter
    ArrayAdapter<String> adpTipoEmail;
    ArrayAdapter<String> adpTipoTelefone;
    ArrayAdapter<String>adpTipoEndereco;
    ArrayAdapter<String>adpTipoDatasEspeciais;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_contatos);
        //Iniciando os campos da agenda
        edtNome          = (EditText)findViewById(R.id.edtNome);
        edtTelefone      = (EditText)findViewById(R.id.edtEndereco);
        edtEmail         = (EditText)findViewById(R.id.edtEmail);
        edtEndereco      = (EditText)findViewById(R.id.edtEndereco);
        edtDataEspeciais = (EditText)findViewById(R.id.edtDatasEspeciais);
        edtGrupos        = (EditText)findViewById(R.id.edtGrupos);

        //Iniciando as opções de cada campo da agenda
        spnTipoTelefone  = (Spinner)findViewById(R.id.spnTipoTelefone);
        spnTipoEmail     = (Spinner)findViewById(R.id.spntTipEmail);
        spnTipoEndereco  = (Spinner)findViewById(R.id.spnTipoEndereco);
        spnTipoDataEspeciais = (Spinner)findViewById(R.id.spnTipoDatasEspeciais);

        //Iniciando os ArrayAdapter<>
        adpTipoEmail           = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoTelefone       = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoEndereco       = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoDatasEspeciais = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoDatasEspeciais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Associando o Spnnier ao ArrayAdapter
        spnTipoEmail.setAdapter(adpTipoEmail);
        spnTipoTelefone.setAdapter(adpTipoTelefone);
        spnTipoEndereco.setAdapter(adpTipoEndereco);
        spnTipoDataEspeciais.setAdapter(adpTipoDatasEspeciais);

        //Adicionando os itens da cada Spnnier
        adpTipoEmail.add("Casa");
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //criando a ação para que o menu apareça
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_contatos, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //responsável pela seleção do item selecionado no menu (gerencia qual item do menu foi selecionado)
        switch (item.getItemId())
        {
            case R.id.mni_acao1:

                break;
            case R.id.mni_acao2:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
