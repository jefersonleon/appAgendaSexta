package br.ulbra.appagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.ulbra.appagenda.dao.PessoaDAO;

public class MainActivity extends AppCompatActivity {
   private EditText edNome;
   private EditText edEmail;
   private EditText edTelefone;
   private Button btSalvar;
   private Button btVoltar;
   private PessoaDAO dao;
   private Pessoa pessoa = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarComponentes();

    }

    private void inicializarComponentes() {
        edNome = findViewById(R.id.edNome);
        edEmail = findViewById(R.id.edEmail);
        edTelefone = findViewById(R.id.edTelefone);
    }
    public void salvar(View view){
        if(pessoa == null){
            pessoa = new Pessoa();
            pessoa.setNome(edNome.getText().toString());
            pessoa.setEmail(edEmail.getText().toString());
            pessoa.setTelefone(edTelefone.getText().toString());
            Long id = dao.inserir(pessoa);
            Toast.makeText(this, "Pessoa inserida no ID de nº: "+id, Toast.LENGTH_LONG).show();
        }else{
            pessoa.setNome(edNome.getText().toString());
            pessoa.setEmail(edEmail.getText().toString());
            pessoa.setTelefone(edTelefone.getText().toString());
            dao.atualizar(pessoa);
            Toast.makeText(this, "Atualizado com Sucesso!!", Toast.LENGTH_LONG).show();
        }
    }
    public void voltar(View view){
        Intent i = new Intent(MainActivity.this, Listar_pesssoas_activity.class);
        startActivity(i);
    }

}