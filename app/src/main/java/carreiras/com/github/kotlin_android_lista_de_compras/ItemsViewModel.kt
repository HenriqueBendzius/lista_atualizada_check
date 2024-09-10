package carreiras.com.github.kotlin_android_lista_de_compras


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ItemsViewModel é uma classe que estende ViewModel.
 * Esta classe gerencia uma lista de ItemModel. Ela contém métodos para adicionar e remover itens da lista.
 * A lista de itens é exposta através de um LiveData.
 *
 * @property items Uma lista mutável de ItemModel. Esta lista é privada e só pode ser modificada através dos métodos addItem e removeItem.
 * @property itemsLiveData Um MutableLiveData que contém a lista de itens. Este LiveData é público e pode ser observado para receber atualizações quando a lista de itens é modificada.
 *
 * @author Ewerton Carreira
 * @version 1.0
 * @since 05/08/2021
 */


    /**
     * Uma lista mutável de ItemModel. Esta lista é privada e só pode ser modificada através dos métodos addItem e removeItem.
     */
    class ItemsViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * Um MutableLiveData que contém a lista de itens. Este LiveData é público e pode ser observado para receber atualizações quando a lista de itens é modificada.
     */
    private val itemDao: ItemDao
        val itemsLiveData: LiveData<List<ItemModel>>

    /**
     * Este método é responsável por adicionar um novo item à lista.
     * Ele cria um novo ItemModel e o adiciona à lista de itens.
     *
     * @param name O nome do item a ser adicionado.
     */
    init {
        val database = Room.databaseBuilder(
            getApplication(),
            ItemDatabase::class.java,
            "items_database"
        ).build()
        /**
         * Este bloco de código é responsável por adicionar um novo item à lista.
         * Ele cria um novo ItemModel e o adiciona à lista de itens.
         */

        itemDao = database.itemDao()
        itemsLiveData = itemDao.getAll()
    }
        /**
         * Observa as alterações na lista de itens na ViewModel.
         * Quando a lista de itens é alterada, atualiza o ItemsAdapter com a nova lista.
         */


        }


    /**
     * Este método é responsável por remover um item da lista.
     * Ele remove o item da lista de itens.
     *
     * @param item O item a ser removido.
     */
    fun removeItem(item: ItemModel) {
        viewModelScope.launch(Dispatchers.IO) {
            itemDao.delete(item)
        }

    }
