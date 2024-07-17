package hanaoka.hikikomori.uz.refrigerator

import android.content.Context
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener

class CameraPervissionListener(val context: Context) : PermissionListener {
    override fun onPermissionGranted() {
        Toast.makeText(context, "사용이 가능합니다.", Toast.LENGTH_SHORT).show()

    }

    override fun onPermissionDenied(p0: MutableList<String>?) {
        Toast.makeText(context, "사용이 불가능 합니다.", Toast.LENGTH_SHORT).show()
    }
}