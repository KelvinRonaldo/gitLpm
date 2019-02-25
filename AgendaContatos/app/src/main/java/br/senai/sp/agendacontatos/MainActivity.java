package br.senai.sp.agendacontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.senai.sp.dao.ContatoDAO;
import br.senai.sp.modelo.Contato;

public class MainActivity extends AppCompatActivity {

    private ListView listaContatos;
    private ImageButton botaoAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaContatos = findViewById(R.id.lista_contatos);
        botaoAdd = findViewById(R.id.botao_adicionar);

//        String[] contatos = {"Kelvin", "Sabrina", "Lohany", "Felipe", "Fernando",
//                "Amanda", "Ananda","Kelvin", "Sabrina", "Lohany", "Felipe", "Fernando",
//                "Amanda", "Ananda","Kelvin", "Sabrina", "Lohany", "Felipe", "Fernando",
//                "Amanda", "Ananda","Kelvin", "Sabrina", "Lohany", "Felipe", "Fernando",
//                "Amanda", "Ananda","Kelvin", "Sabrina", "Lohany", "Felipe", "Fernando",
//                "Amanda", "Ananda","Kelvin", "Sabrina", "Lohany", "Felipe", "Fernando",
//                "Amanda", "Ananda"};

        botaoAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CadastroContatos.class);
                startActivity(intent);
            }
        });

//        ArrayAdapter<String> listaContatosAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contatos);
//
//        listaContatos.setAdapter(listaContatosAdapter);


    }

    @Override
    protected void onResume() {
        carregarLista();
        super.onResume();
    }

    private void carregarLista(){
        ContatoDAO dao = new ContatoDAO(this);
        List<Contato> contatos = dao.getContatos();

        ArrayAdapter<Contato> listaContatosAdapter = new ArrayAdapter<Contato>(this, android.R.layout.simple_list_item_1, contatos);

        listaContatos.setAdapter(listaContatosAdapter);
    }
}
