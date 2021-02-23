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

public class MascotaFavoritaAdapter extends RecyclerView.Adapter<MascotaFavoritaAdapter.MascotaFavoritaViewHolder> {

    ArrayList<Mascota> mascotasFavoritas;
    Activity activity;

    public MascotaFavoritaAdapter(ArrayList<Mascota> mascotasFavoritas, Activity activity) {
        this.mascotasFavoritas = mascotasFavoritas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaFavoritaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_favorita,parent,false);
        return new MascotaFavoritaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaFavoritaViewHolder mascotaFavoritaViewHolder, int position) {
        Mascota mascotaFavorita = mascotasFavoritas.get(position);

        mascotaFavoritaViewHolder.fotoVH.setImageResource(mascotaFavorita.getFoto());
        mascotaFavoritaViewHolder.tvNombreVH.setText(mascotaFavorita.getNombre());
        mascotaFavoritaViewHolder.tvLikesVH.setText(""+mascotaFavorita.getLikes());
    }

    @Override
    public int getItemCount() {
        return mascotasFavoritas.size();
    }


    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder{
        private ImageView fotoVH;
        private TextView tvNombreVH;
        private TextView tvLikesVH;
        private ImageView fotoHuesoLikeVH;

        public MascotaFavoritaViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoVH = (ImageView)itemView.findViewById(R.id.fotoCV);
            tvNombreVH = (TextView)itemView.findViewById(R.id.nombreCV);
            tvLikesVH = (TextView)itemView.findViewById(R.id.likesCV);
            fotoHuesoLikeVH = (ImageView)itemView.findViewById(R.id.imgHuesoCV);
        }
    }


}
