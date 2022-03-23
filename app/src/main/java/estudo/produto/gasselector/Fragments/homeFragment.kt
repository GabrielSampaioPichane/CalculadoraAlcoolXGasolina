package estudo.produto.gasselector.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import estudo.produto.gasselector.R
import estudo.produto.gasselector.ViewModel.MainViewModel
import estudo.produto.gasselector.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class homeFragment : Fragment() {
    private val viewModel : MainViewModel by viewModel()
    private lateinit var binding : FragmentHomeBinding
    private lateinit var calculator : Button
    private lateinit var calculatorFragment : calculatorGasFragment
    private lateinit var pricesFragment : pricesFragment
    private lateinit var pricesButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        calculatorFragment = calculatorGasFragment()
        pricesFragment = pricesFragment()
        pricesButton =binding.btPrices

        calculator = binding.btGasCalculator



        pricesButton.setOnClickListener{

            parentFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, pricesFragment).addToBackStack(null).commit()

        }

        calculator.setOnClickListener{

            parentFragmentManager.beginTransaction()
           .replace(R.id.container_fragment, carInformation()).addToBackStack(null).commit()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return binding.root
    }


}