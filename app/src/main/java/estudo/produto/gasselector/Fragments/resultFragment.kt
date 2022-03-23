package estudo.produto.gasselector.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import estudo.produto.gasselector.ViewModel.MainViewModel
import estudo.produto.gasselector.databinding.FragmentResultBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class resultFragment : Fragment() {
    private val viewModel : MainViewModel by viewModel()

    private lateinit var binding : FragmentResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentResultBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)



    }

    override fun onStart() {
        super.onStart()
        binding.resultCalculum.text  = viewModel.resultado
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
               return binding.root
    }


}