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

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);

        final AlunoDAO dao = new AlunoDAO();

        final EditText txtNome = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText txtTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText txtEmail = findViewById(R.id.activity_formulario_aluno_email);

        Button btnSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = txtNome.getText().toString();
                String telefone = txtTelefone.getText().toString();
                String email = txtEmail.getText().toString();

                Aluno alunoCriado = new Aluno(nome, telefone, email);
                dao.salva(alunoCriado);

                //finish usado para deixar de empilhar as activity
                finish();

            }
        });
    }
}
