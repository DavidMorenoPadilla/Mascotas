package hfad.com.mascotas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas, MainActivity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaAdapter.MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);

        mascotaViewHolder.fotoVH.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreVH.setText(mascota.getNombre());


        mascotaViewHolder.tvLikesVH.setText(""+mascota.getLikes());

        mascotaViewHolder.fotoHuesoLikeVH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setLikes(mascota.getLikes()+1);
                mascotaViewHolder.tvLikesVH.setText(""+mascota.getLikes());
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoVH;
        private TextView tvNombreVH;
        private TextView tvLikesVH;
        private ImageView fotoHuesoLikeVH;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoVH = (ImageView)itemView.findViewById(R.id.fotoCV);
            tvNombreVH = (TextView)itemView.findViewById(R.id.nombreCV);
            tvLikesVH = (TextView)itemView.findViewById(R.id.likesCV);
            fotoHuesoLikeVH = (ImageView)itemView.findViewById(R.id.imgHuesoCV);
        }
    }
}
