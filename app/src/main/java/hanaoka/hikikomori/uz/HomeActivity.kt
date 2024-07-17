package hanaoka.hikikomori.uz

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity(), BottomControllable {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    override fun setBottomNavVisibility(visibility: Boolean) {
        findViewById<BottomNavigationView>(R.id.nav_view).visibility = if (visibility) View.VISIBLE else View.GONE
    }
}