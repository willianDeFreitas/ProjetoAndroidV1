package com.example.agenda.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agenda.R;
import com.example.agenda.dao.AlunoDAO;
import com.example.agenda.model.Aluno;

import java.io.Serializable;

public class FormularioAlunoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Novo aluno";
    private EditText txtNome;
    private EditText txtTelefone;
    private EditText txtEmail;
    private final AlunoDAO dao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicializacaoDosCampos();
        configuraBotaoSalvar();

        Intent dados = getIntent();
        Aluno aluno = (Aluno) dados.getSerializableExtra("aluno");
        txtNome.setText(aluno.getNome());
        txtTelefone.setText(aluno.getTelefone());
        txtEmail.setText(aluno.getEmail());

    }

    private void configuraBotaoSalvar() {
        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Aluno alunoCriado = criaAluno();
                salva(alunoCriado);

            }
        });
    }

    private void inicializacaoDosCampos() {
        txtNome = findViewById(R.id.activity_formulario_aluno_nome);
        txtTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        txtEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salva(Aluno aluno) {
        dao.salva(aluno);
        //finish usado para deixar de empilhar as activity
        finish();
    }

    private Aluno criaAluno() {
        String nome = txtNome.getText().toString();
        String telefone = txtTelefone.getText().toString();
        String email = txtEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }
}
