package hanaoka.hikikomori.uz.refrigerator

import android.graphics.Bitmap
import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RefrigeratorViewModel : ViewModel() {
    var imageBitmap = MutableLiveData<Bitmap?>().apply { value = null }
    var itemData : MutableLiveData<List<String>> = MutableLiveData<List<String>>().apply { value = listOf() }

}