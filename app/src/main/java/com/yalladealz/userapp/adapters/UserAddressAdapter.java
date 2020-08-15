package com.yalladealz.userapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yalladealz.userapp.R;
import com.yalladealz.userapp.model.responses.Address;

import java.util.List;

public class UserAddressAdapter extends RecyclerView.Adapter<UserAddressAdapter.AddressHolder> {

    private List<Address> addressList ;
    private ClickA listner;

    public UserAddressAdapter() {}

    public interface ClickA{
        void onDelete(int position);
        void onEdit(int position);
    }

    public void setListner(ClickA listner) {
        this.listner = listner;
    }

    class AddressHolder extends RecyclerView.ViewHolder {

        TextView addressTitle, city, subCity, uAddress, building, apartment;
        ImageView imgDelete, imgEdit;


        AddressHolder(@NonNull View itemView, ClickA listner) {
            super(itemView);

            addressTitle = itemView.findViewById(R.id.addressTitle);
            city = itemView.findViewById(R.id.city);
            subCity = itemView.findViewById(R.id.subCity);
            uAddress = itemView.findViewById(R.id.uAddress);
            building = itemView.findViewById(R.id.building);
            apartment = itemView.findViewById(R.id.apartment);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            imgEdit = itemView.findViewById(R.id.imgEdit);

            imgDelete.setOnClickListener(view -> {
                if (listner != null) {
                    int p = getAdapterPosition();
                    if (p != RecyclerView.NO_POSITION) {
                        listner.onDelete(p);
                    }
                }
            });

            imgEdit.setOnClickListener(view -> {
                if (listner != null) {
                    int p = getAdapterPosition();
                    if (p != RecyclerView.NO_POSITION) {
                        listner.onEdit(p);
                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public AddressHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_addresses_adapter,parent, false);
        return new AddressHolder(view, listner);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressHolder holder, int position) {

        Address address = addressList.get(position);

        holder.city.setText(address.getState());
        holder.subCity.setText(address.getCity());
        holder.uAddress.setText(address.getAddress());
        holder.building.setText(address.getBuilding());
        holder.apartment.setText(address.getApartment());

    }

    @Override
    public int getItemCount() {
        return addressList != null ? addressList.size() : 0;
    }

    public void updateAddress(List<Address> addresses){
        addressList = addresses;
        notifyDataSetChanged();
    }
}
