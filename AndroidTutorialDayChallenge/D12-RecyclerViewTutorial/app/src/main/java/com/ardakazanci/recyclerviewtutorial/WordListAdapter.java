package com.ardakazanci.recyclerviewtutorial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    // mWordList : Kelime bilgilerini tutacak
    // mInflater : Görünüm işleyecek,şişirecek.
    private final LinkedList<String> mWordList; // MainActivity'den gelecek kelime listesi
    private LayoutInflater mInflater; // Düzen Yöneticisini şişirme işlemi .

    // Adapter ' e gelecek verilerin listesi
    public WordListAdapter(Context context, LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context); // Inflater ' a context
        this.mWordList = wordList; //  kelimeler ise değişkene atandı.
    }


    // RecyclerView - Görünüm ortaya çıkarma metodu.
    // XML ' in View ' e dönüştürüldüğü yer.

    /**
     * @param parent   : Bir ViewGroup
     * @param viewType :
     * @return : Holder döner.
     */
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false); // Yer tutucu şişirme işlemi .
        return new WordViewHolder(mItemView, this); // İlgili değere ait görünüm döndürüyor.

    }

    /**
     * @param holder   : ilgili pozisyona ait görünüm
     * @param position : İlgili pozisyon
     */
    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);  // Verilerin görüntüye aktarıldığı yer. İlgili pozisyonda ki ilgili değere ilgili data yazıır.
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Verinin görünümünü oluşturuyor.
        public final TextView wordItemView;
        final WordListAdapter mAdapter;

        /**
         * @param itemView : İlgili VieW Elemanı ve Adapter
         * @param adapter
         */
        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Tıklanan öğenin konumu
            int mPosition = getLayoutPosition();
            // Etkilenen öğeye erişmek için. içeriği yani.
            String element = mWordList.get(mPosition);
            // içeriğini değiştir.
            mWordList.set(mPosition, "Clicked! " + element);
            // Adapter ' e bilgi verilir ve değişim sağlanır.
            mAdapter.notifyDataSetChanged();
        }
    }


}


