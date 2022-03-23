package estudo.produto.gasselector.MainActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import estudo.produto.gasselector.Fragments.homeFragment
import estudo.produto.gasselector.R
import estudo.produto.gasselector.ViewModel.MainViewModel
import estudo.produto.gasselector.databinding.MainactivityBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity () {
    private val viewModel : MainViewModel by viewModel()
    private  lateinit var binding : MainactivityBinding
    private lateinit var fragmentHome : homeFragment


    override fun onCreate(savedInstanceState: Bundle?) {
         binding = MainactivityBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
         setContentView(binding.root)

        fragmentHome = homeFragment()

          viewModel.calculoCombustivel()

        setFragment(fragmentHome)

    }



    private fun setFragment(fragment: Fragment) {

        val fragChange = supportFragmentManager.beginTransaction()
        fragChange.replace(R.id.container_fragment, fragment)
        fragChange.commit()


    }

}