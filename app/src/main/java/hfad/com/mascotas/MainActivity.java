package hfad.com.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initListaMascotas();

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(linearLayoutManager);
        MascotaAdapter adapter = new MascotaAdapter(mascotas,this);
        listaMascotas.setAdapter(adapter);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mascotas, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch ((item.getItemId())){
            case R.id.mascotas_favoritas:
                Intent intent = new Intent(this,MascotasFavoritas.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void initListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Pancho",R.drawable.pancho,0));
        mascotas.add(new Mascota("Coco",R.drawable.coco,0));
        mascotas.add(new Mascota("Manolo",R.drawable.manolo,0));
        mascotas.add(new Mascota("Mico",R.drawable.mico,0));
        mascotas.add(new Mascota("Pelusa",R.drawable.pelusa,0));
        mascotas.add(new Mascota("Risto",R.drawable.risto,0));
        mascotas.add(new Mascota("Roko",R.drawable.roko,0));
        mascotas.add(new Mascota("Shakira",R.drawable.shakira,0));
        mascotas.add(new Mascota("Simon",R.drawable.simon,0));
        mascotas.add(new Mascota("Yako",R.drawable.yako,0));

    }

}