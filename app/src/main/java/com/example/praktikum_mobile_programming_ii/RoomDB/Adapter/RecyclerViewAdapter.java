package com.example.praktikum_mobile_programming_ii.RoomDB.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.praktikum_mobile_programming_ii.R;
import com.example.praktikum_mobile_programming_ii.RoomDB.model.Mahasiswa;

import java.util.List;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Mahasiswa> albumList;
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView nama,nim,kejuruan,alamat;
        public MyViewHolder(View v) {
            super(v);

            nama = v.findViewById(R.id.tvNama);
            nim = v.findViewById(R.id.tvNim);
            kejuruan = v.findViewById(R.id.tvKejuruan);
            alamat = v.findViewById(R.id.tvAlamat);
        }
    }
    public RecyclerViewAdapter (Context mContext,List<Mahasiswa>albumList){
        this.mContext = mContext;
        this.albumList = albumList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mahasiswa, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Mahasiswa album = albumList.get(position);
        holder.nama.setText(album.getNama());
        holder.nim.setText(album.getNim());
        holder.kejuruan.setText(album.getKejuruan());
        holder.alamat.setText(album.getAlamat());
    }


    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
