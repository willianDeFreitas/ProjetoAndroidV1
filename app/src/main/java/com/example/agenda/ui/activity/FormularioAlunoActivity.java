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

import static com.example.agenda.ui.activity.ConstantesActivities.CHAVE_ALUNO;

public class FormularioAlunoActivity extends AppCompatActivity {

    private static final String TITULO_APPBAR_NOVO_ALUNO = "Novo aluno";
    private static final String TITULO_APPBAR_EDITA_ALUNO = "Edita aluno";
    private EditText txtNome;
    private EditText txtTelefone;
    private EditText txtEmail;
    private final AlunoDAO dao = new AlunoDAO();
    private Aluno aluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        inicializacaoDosCampos();
        configuraBotaoSalvar();
        carregaAluno();
    }

    private void carregaAluno() {
        Intent dados = getIntent();
        if (dados.hasExtra(CHAVE_ALUNO)){
            setTitle(TITULO_APPBAR_EDITA_ALUNO);
            aluno = (Aluno) dados.getSerializableExtra(CHAVE_ALUNO);
            preencheCampos();
        } else {
            setTitle(TITULO_APPBAR_NOVO_ALUNO);
            aluno = new Aluno();
        }
    }

    private void preencheCampos() {
        txtNome.setText(aluno.getNome());
        txtTelefone.setText(aluno.getTelefone());
        txtEmail.setText(aluno.getEmail());
    }

    private void configuraBotaoSalvar() {
        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finalizaFormulario();
            }
        });
    }

    private void finalizaFormulario() {
        preencheAluno();

        if(aluno.temIdValido()){
            dao.edita(aluno);
        } else {
            dao.salva(aluno);
        }

        finish();
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

    private void preencheAluno() {
        String nome = txtNome.getText().toString();
        String telefone = txtTelefone.getText().toString();
        String email = txtEmail.getText().toString();

        aluno.setNome(nome);
        aluno.setTelefone(telefone);
        aluno.setEmail(email);
    }
}
