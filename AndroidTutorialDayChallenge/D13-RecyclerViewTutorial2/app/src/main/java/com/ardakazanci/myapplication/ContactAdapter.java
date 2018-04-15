package com.ardakazanci.myapplication;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Burada verileri RecyclerView ' e yerleştirilecek metotlar oluşturulur.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {


    private List<Contact> mContacts; // Yapıcı metot'a gelen veriler burada depolanacak

    public ContactAdapter(List<Contact> contacts) {

        mContacts = contacts;

    }

    // ViewHolder'ın görünümünün oluşturulması ve şişirme işlemleri.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        // Özel düzen şişirme işlemi.
        View view = layoutInflater.inflate(R.layout.activity_sil, parent, false);
        ViewHolder viewHolder = new ViewHolder(view); // ViewHolder türünden nesne oluşturuluyorç

        return viewHolder; // Şişirilen ViewHolder döndürülüyor.


    }

    // Şişirilen görünüme ilgili verinin aktarılması işlemi.
    // İlgili veriler üzerinde burada işlem yapılabilir.
    // Online veya Offline gibi. Bu örnekte
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Veri modelini konuma göre aldık. Örneğin 1. veri Arda Kazancı gibi.
        Contact contact = mContacts.get(position);

        TextView textView = holder.mTextView; // Holder içindeki textview i çağırdık. Çünkü iligili görünüm değişkenleri orada
        textView.setText(contact.getmName());
        Button button = holder.messageButton;
        button.setText(contact.isOnline() ? "Message" : "Offline");
        button.setEnabled(contact.isOnline());

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


    // Görünümlerin oluşturulmasında gereken elemanlar.
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Özel tasarımda yer alan view elemanları
        public TextView mTextView;
        public Button messageButton;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextView = itemView.findViewById(R.id.contact_name);
            messageButton = itemView.findViewById(R.id.message_button);


        }
    }
}
