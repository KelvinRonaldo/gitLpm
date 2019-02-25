package br.senai.sp.agendacontatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.senai.sp.dao.ContatoDAO;
import br.senai.sp.modelo.Contato;

public class CadastroContatos extends AppCompatActivity {
    private CadastroContatoHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_contatos);
        helper = new CadastroContatoHelper(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_cadastro_contatos, menu);;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_pronto:
                Contato contato = helper.getContato();
                ContatoDAO dao = new ContatoDAO(this);
                dao.salvar(contato);
                dao.close();

                Toast.makeText(this, contato.getNome() + " gravado coom sucesso!", Toast.LENGTH_SHORT).show();

                break;
            case R.id.item_excluir:
                Toast.makeText(CadastroContatos.this, "Excluir", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
