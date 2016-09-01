package com.robson.agendacontato;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class actCadContatos extends AppCompatActivity {

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
    ArrayAdapter<String> adpTipEmail;
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
        adpTipEmail           = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipEmail.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoTelefone       = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoTelefone.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adpTipoEndereco       = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoEndereco.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item;

        adpTipoDatasEspeciais = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adpTipoDatasEspeciais.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Associando as opções de cada ArrayAdapter para cada spinner
        spnTipoEmail.setAdapter(adpTipEmail);
        spnTipoEndereco.setAdapter(adpTipoEndereco);
        spnTipoEndereco.setAdapter(adpTipoEndereco);
        spnTipoDataEspeciais.setAdapter(adpTipoDatasEspeciais);
    }
}
