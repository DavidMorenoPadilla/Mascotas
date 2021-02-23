package hfad.com.mascotas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initListaMascotasFavoritas();

        listaMascotasFavoritas = (RecyclerView)findViewById(R.id.rvMascotasFavoritas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(linearLayoutManager);
        MascotaFavoritaAdapter adapter = new MascotaFavoritaAdapter(mascotasFavoritas,this);
        listaMascotasFavoritas.setAdapter(adapter);


    }

   private void initListaMascotasFavoritas() {
        mascotasFavoritas = new ArrayList<Mascota>();

        mascotasFavoritas.add(new Mascota("Shakira",R.drawable.shakira,0));
        mascotasFavoritas.add(new Mascota("Simon",R.drawable.simon,0));
        mascotasFavoritas.add(new Mascota("Mico",R.drawable.mico,0));
        mascotasFavoritas.add(new Mascota("Pelusa",R.drawable.pelusa,0));
        mascotasFavoritas.add(new Mascota("Risto",R.drawable.risto,0));
    }
}