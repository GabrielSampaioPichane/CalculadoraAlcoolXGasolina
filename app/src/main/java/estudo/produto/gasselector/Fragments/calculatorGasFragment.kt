package estudo.produto.gasselector.Fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import estudo.produto.gasselector.R
import estudo.produto.gasselector.ViewModel.MainViewModel
import estudo.produto.gasselector.databinding.FragmentCalculatorGasBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class calculatorGasFragment : Fragment() {
    private val viewModel : MainViewModel by viewModel()
   private  lateinit var binding : FragmentCalculatorGasBinding
   private lateinit var calcular : Button
    private lateinit var gasPrice: EditText
    private lateinit var alcoolPrice : EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        binding =FragmentCalculatorGasBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
         gasPrice = binding.gasprice
        alcoolPrice = binding.etnaolprice

        calcular = binding.btCalcular

        calcular.setOnClickListener{

            enviarDadosGasolina()

        }
    }


    private fun enviarDadosGasolina(){

      val valorDaGasolina =   gasPrice.text.toString()
      val valorDoAlcool =  alcoolPrice.text.toString()



        if(valorDaGasolina.isNotEmpty() && valorDoAlcool.isNotEmpty()){

       viewModel.precoAlcool = valorDoAlcool
       viewModel.precoGasolina = valorDaGasolina

            parentFragmentManager.beginTransaction()
                .replace(R.id.container_fragment, resultFragment()).addToBackStack(null).commit()

        }else{

            val snackbar = Snackbar.make(binding.gasPriceFragment,"Favor informar dados solicitados!",
                Snackbar.LENGTH_LONG)
            snackbar.setBackgroundTint(Color.BLACK)
            snackbar.setTextColor(Color.WHITE)
            snackbar.show()

        }


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return binding.root
    }


}