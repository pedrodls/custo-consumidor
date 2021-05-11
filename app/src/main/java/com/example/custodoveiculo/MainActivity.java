package com.example.custodoveiculo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcularValores(View view) {

        EditText edtxtTotal = (EditText) findViewById(R.id.edtxt1);
        EditText edtxtLucro = (EditText) findViewById(R.id.edtxt2);
        EditText edtxtImposto = (EditText) findViewById(R.id.edtxt3);

        Float valorLucro;
        Float valorImposto;
        Float valorFabrica;
        Float totalVeiculo;

        String resultado;

        try {
                valorFabrica = Float.parseFloat(edtxtTotal.getText()+"");
                valorLucro   = (valorFabrica*Float.parseFloat(edtxtLucro.getText()+""))/100;
                valorImposto = (valorFabrica*Float.parseFloat(edtxtImposto.getText()+""))/100;

                totalVeiculo = valorFabrica + valorLucro + valorImposto;

                resultado = "Valor de fabrico: "+valorFabrica+
                            "\nLucro do distribuidor: "+valorLucro+
                            "\nImposto: "+valorImposto+
                            "\nTotal do veículo: "+totalVeiculo;

                mensagem("Valores calculados", resultado);
        }
        catch (Exception ex){
           mensagem("Erro", "Preencha os campos");
        }
    }

    public void mensagem(String titulo, String corpo){

        AlertDialog.Builder a = new AlertDialog.Builder(this);

        a.setTitle(titulo);
        a.setMessage(corpo);
        a.create().show();

    }
}