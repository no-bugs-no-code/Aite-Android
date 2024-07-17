package hanaoka.hikikomori.uz.refrigerator

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RefrigeratorViewModel : ViewModel() {
    var imageUri = MutableLiveData<Uri?>().apply { value = null }

}