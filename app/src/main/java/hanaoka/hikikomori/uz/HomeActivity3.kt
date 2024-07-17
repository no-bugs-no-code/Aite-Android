package hanaoka.hikikomori.uz

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import hanaoka.hikikomori.uz.databinding.ActivityHome3Binding

class HomeActivity3 : AppCompatActivity(), BottomControllable {

private lateinit var binding: ActivityHome3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityHome3Binding.inflate(layoutInflater)
     setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_home3)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
    }
    override fun setBottomNavVisibility(visibility: Boolean) {
        binding.navView.visibility = if (visibility) View.VISIBLE else View.GONE
    }
}