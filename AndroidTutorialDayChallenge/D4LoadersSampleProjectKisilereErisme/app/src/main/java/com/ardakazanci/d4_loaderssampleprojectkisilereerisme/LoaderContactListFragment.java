package com.ardakazanci.d4_loaderssampleprojectkisilereerisme;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/* Fragment Sınıfımız - ListFragment Yapısını kullanacağız */

/**
 * ListFragment
 * ----------------------
 * -> Bir adaptör tarafından yönetilen öğelerin bir listesini görüntüler.
 * -> Bu sınıfı listelenen verileri yönetmek için bazı metotlar sağlar. (Over..)
 * -> Listedeki herhangi bir öğeye tıklandığı zaman onListItemClick() metodu çağırılır.
 */

/**
 * Burada Sınıfımızı ListFragment ' tan kalıtım sağlayarak SearchView sınıfı içinden OnqueryTextListener ve LoaderManager ile birlikte
 * Arkaplan işlemlerini sağlıklı yapmak adına gerekli sınıfları implementasyon sağladık.
 * Asıl amaç burada Arkaplanda gerekli kişi verilerinin çağırılması ve listFragment ile birlikte listelenmesi
 * MainActivity'e bağlanması
 */

public class LoaderContactListFragment extends ListFragment implements SearchView.OnQueryTextListener, LoaderManager.LoaderCallbacks<Cursor> {

    // Kişileri listelemek için kullanılacaktır.
    SimpleCursorAdapter adapter;

    // Kişi bilgilerinin nasıl alınacağını gösteren filtreleme burada yapılacaktır.
    String filterForData;


    // 1. ADIM : MainActivity oluşturulduğu zaman çağırılır. Fragment'ın eklendiği activity oluşturulduğu zaman bu metot çağırılır

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.i("onActivityCreated", "Başlıyor");


        // Fragment ilk oluşturulduğu zaman eğer herhangi bir kullanıcı bilgisi yoksa gösterilecek mesajı burada belirtiyorum.
        setEmptyText("Telefon Numarası Yok");

        //AppBar - ActionBar da arama işlemini yapacak bir menü seçeneği ekleyeceğimizi bildiriyoruz. Bu metot fragment için kullanılacaktır.
        setHasOptionsMenu(true);


        adapter = new SimpleCursorAdapter(

                getActivity(), // Context - Bağlam Ana Activity nin Andrıid sistemine olan bağlamı
                android.R.layout.simple_list_item_2, // int tipinde bir gösterim şekli
                null,// Cursor : Null vermemiz yeterli. Çünkü sıralama rehber ile eş olacak
                new String[]{ContactsContract.Contacts.DISPLAY_NAME}, // Rehber içindeki verilerin - İsimleri
                new int[]{android.R.id.text1}, // Textview ' e yazılacak
                0// Flag bilgisi 0 ' dan başlasın.

        );

        //Adapter Bağlantısını sağlıyoruz.
        setListAdapter(adapter);
        // Loader hazırlanır. Ya mevcut bir Loader ile bağlanılır veya yeni bir Loader oluşturulur.
        getLoaderManager().initLoader(0, null, this);


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);


        // Arama isimli bir menü ekleyeceğiz.
        MenuItem menuItem = menu.add("Arama");
        // Menü için icon ekliyorum.
        menuItem.setIcon(android.R.drawable.ic_menu_search);
        // Menunun gösterim şeklini ayarlıyorum.
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        // Activity içerisinde arama işlemini yapmak için bir SearchView tanımlamamız gerekli

        SearchView searchView = new SearchView(getContext());

        // SearchView için bir olay dinleyicisi eklemek gerekli.
        // SearchView içine bir değer yazıldığında onQueryTextChange metodu tetiklenecektir.

        searchView.setOnQueryTextListener(this);

        // Bu dinleyici Searchview menü seçeneğine bağlanmalıdır.

        menuItem.setActionView(searchView);


    }



    /* OnQueryTextListener Metotları */

    @Override
    public boolean onQueryTextChange(String inputText) {

        // SearchView içine bir değer yazıldığında bu metot çağırılır.

        // Arama filtresi güncellenir.

        filterForData = !TextUtils.isEmpty(inputText) ? inputText : null;

        // Loader ' ı tekrar başlatmamız gerekli

        getLoaderManager().restartLoader(0, null, this);
        return true;


    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        // Kullanıcı sorgu gönderdiği zaman çağırılır. Bu uygulama için önemli değildir.
        return true;

    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        // ListFragment ile listelenen verilerden birine tıklandığı zaman Toast mesajı olarak gösteeceğiz.
        // Örneğin bir telefon bilgisine tıklandığında Toast mesajı gösterilecek

        Toast.makeText(getContext(), id + " . Kişiye Tıklandı ", Toast.LENGTH_LONG).show();
    }


    static final String[] CONTACTS_SUMMARY_PROJECTION = new String[]{


            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.PHOTO_ID,
            ContactsContract.Contacts.LOOKUP_KEY,


    };



    /* Artık sıra LoaderManager.LoaderCallBacks metotlarını oluşturmada */

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {

        Log.i("onCreateLoader", "başlıyor");
        // Bu metot yeni bir loader oluşturulacağı zaman çağırılır bu uygulama da tek bir loader vardır ve bundan dolayı
        // LoaderID bilgisi hiç önemli değildir. Öncelikle uri ile filtre bağlantısı sağlanır.

        Uri uri;

        if (filterForData != null) {

            // Eğer filtre null değilse,tanımlanan filtre uygulanır.

            uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(filterForData));


        } else {

            // Eğer filtre null ise herhangi bir filtre uygulanmaz varsayılan uyglanır.

            uri = ContactsContract.Contacts.CONTENT_URI;

        }

        // Görüntülenecek veriler için select deyimi oluşturuluyor
        String select = "((" + ContactsContract.Contacts.DISPLAY_NAME + "NOTNULL) AND (" + ContactsContract.Contacts.HAS_PHONE_NUMBER +

                "=1) AND (" + ContactsContract.Contacts.DISPLAY_NAME + " '' ))";

        //

        CursorLoader cursorLoader = new CursorLoader(getActivity(), uri, CONTACTS_SUMMARY_PROJECTION, select, null, ContactsContract.Contacts.DISPLAY_NAME + "COLLATE LOCALIZED ASC");
        return cursorLoader;


    }


    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        Log.i("onLoadFinished", "Başlıyor");
        // Yukarıda oluşturduğumuz Loader'a veriler yüklendikten sonra bu metin çağılır.
        // Son yayınlanan verilerin öncesinde bu metot mutlaka çağılır.

        adapter.swapCursor(data);
    }


    // Yukarıda oluşturulan loader sıfırlandığı zaman bu metot çağırılır
    // Bu metotla beraber veriler kullanılamaz hale gelir.
    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        Log.i("onLoadReset", "başlıyor");
        adapter.swapCursor(null);

    }
}
