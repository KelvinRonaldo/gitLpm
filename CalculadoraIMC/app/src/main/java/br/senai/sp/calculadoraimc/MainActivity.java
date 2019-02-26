package br.senai.sp.calculadoraimc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

//    primeiro declarar as variáveis que receberam as views

    private EditText txtPeso;
    private EditText txtAltura;

    private TextView txtImc;
    private TextView txtResultado;
    private TextView txtResumo;

    private Button btnCalcular;
    private Button btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        instanciar as views nas variáveis
        txtPeso = findViewById(R.id.txt_peso);
        txtAltura = findViewById(R.id.txt_altura);

        txtImc = findViewById(R.id.view_imc);
        txtResultado = findViewById(R.id.view_imc_resultado);
        txtResumo = findViewById(R.id.view_resumo);

        btnCalcular = findViewById(R.id.btn_calcular);
        btnLimpar = findViewById(R.id.btn_limpar);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] resultados = calcularImc();
                txtImc.setText(String.valueOf(resultados[0]).toString());
                txtResultado.setText(resultados[1]);
                txtResumo.setText(resultados[2]);
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtAltura.setText("");
                txtPeso.setText("");
                txtImc.setText("");
                txtResultado.setText("");
                txtResumo.setText("");
            }
        });


    }

    private String[] calcularImc() {

        DecimalFormat df = new DecimalFormat(".#");

        double imc = 0;
        double peso = Double.parseDouble(txtPeso.getText().toString());
        double altura = Double.parseDouble(txtAltura.getText().toString());

//        Math.pow(método para fazer potenciação)

        imc = (peso / (Math.pow(altura, 2)));
//        txtImc.setText(String.valueOf(df.format(imc)));

        String situacao = "";
        String descricao = "";


        if(imc <= 15){
            situacao = getResources().getText(R.string.abaixo_do_peso_1).toString();
            descricao = getResources().getText(R.string.desc_abaixo_do_peso_1).toString();
        }
        if(imc > 15 && imc <= 18.5){
            situacao = getResources().getText(R.string.abaixo_do_peso).toString();
            descricao = getResources().getText(R.string.desc_abaixo_do_peso).toString();
        }
        if(imc > 18.5 && imc <= 24.9){
            situacao = getResources().getText(R.string.peso_normal).toString();
            descricao = getResources().getText(R.string.desc_peso_normal).toString();
        }
        if(imc > 24.9 && imc <= 29.9){
            situacao = getResources().getText(R.string.acima_do_peso).toString();
            descricao = getResources().getText(R.string.desc_acima_do_peso).toString();
        }
        if(imc > 29.9 && imc <= 39.9){
            situacao = getResources().getText(R.string.obesidade_1).toString();
            descricao = getResources().getText(R.string.desc_obesidade_1).toString();
        }
        if(imc > 39.9){
            situacao = getResources().getText(R.string.obesidade_2).toString();
            descricao = getResources().getText(R.string.desc_obesidade_2).toString();
        }

        String[] resultado = {df.format(imc), situacao, descricao};

        return resultado;

    }
}
