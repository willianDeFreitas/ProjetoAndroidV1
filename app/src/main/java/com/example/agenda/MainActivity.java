package com.example.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mensagem apresentada na tela
        //Toast.makeText(this, "Willian", Toast.LENGTH_LONG).show();

        //mansagem apresentada na view por text view
        //TextView aluno = new TextView(this);
        //aluno.setText("Willian Oliveira");
        //setContentView(aluno);

        //chamando a activity_main que apresenta o layout da tela
        setContentView(R.layout.activity_main);

        //criando array para adicionar lista de alunos
        List<String> alunos = new ArrayList<>(Arrays.asList("Willian","Amanda","Julia"));
        TextView primeiroAluno = findViewById(R.id.alunoUm);
        TextView segundoAluno = findViewById(R.id.alunoDois);
        TextView terceiroAluno = findViewById(R.id.alunoTres);
        primeiroAluno.setText(alunos.get(0));
        segundoAluno.setText(alunos.get(1));
        terceiroAluno.setText(alunos.get(2));

    }
}
