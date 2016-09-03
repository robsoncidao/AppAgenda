package com.robson.agendacontato;

/**
 * Created by CIDAO on 02/09/2016.
 */
public class ScriptSQL {

    public  static String getCreateTableContato(){

        //builder é utilizado para juntar uma string grande
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append( "CREATE TABLE IF NOT EXISTS CONTATO( ");
        sqlBuilder.append( "_ID INTEGER NOT NULL " );
        sqlBuilder.append( "PRIMARY KEY AUTOINCREMENT," );
        sqlBuilder.append( "TELEFONE       VARCHAR(14), ");
        sqlBuilder.append( "TIPOTELEFONE   VARCHAR(1), ");
        sqlBuilder.append( "EMAIL          VARCHAR(255), ");
        sqlBuilder.append( "TIPOEMAIL      VARCHAR(1), ");
        sqlBuilder.append( "ENDERECO       VARCHAR(255), ");
        sqlBuilder.append( "TIPOENDERECO   VARCHAR(1), ");
        sqlBuilder.append( "DATASESPECIAIS VARCHAR(1), ");
        sqlBuilder.append( "TIPOESPECIAIS  VARCHAR(1), " );
        sqlBuilder.append( "GRUPOS         VARCHAR(255) ");

    return sqlBuilder.toString();

    }
}
