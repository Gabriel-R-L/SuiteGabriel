package com.suitegabriel.suitesensores.utils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.suitegabriel.suitesensores.R;

public class Creditos extends Fragment {
    ImageView titulo;
    ImageView github;
    ImageView linkedin;
    public Creditos() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_creditos, container, false);

        github = view.findViewById(R.id.github);
        linkedin = view.findViewById(R.id.linkedin);

        github.setOnClickListener(v -> {
                //* Mostrar el Toast
                Toast.makeText(getActivity(), "Viajando a mi GitHub", Toast.LENGTH_SHORT).show();
//*             Crear un Intent con la acción de ver
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://github.com/Gabriel-R-L"));
                //* Iniciar la actividad
                startActivity(intent);
        });

        linkedin.setOnClickListener(v -> {
            //* Mostrar el Toast
            Toast.makeText(getActivity(), "Viajando a mi LinkedIn", Toast.LENGTH_SHORT).show();
            //* Crear un Intent con la acción de ver
            //* Verificar si hay una aplicación que puede manejar el Intent
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.linkedin.com/in/gabriel-ramos-lopez/"));
            //* Iniciar la actividad
            startActivity(intent);
        });

        return view;
    }
}