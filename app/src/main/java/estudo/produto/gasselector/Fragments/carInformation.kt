package estudo.produto.gasselector.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import estudo.produto.gasselector.R
import estudo.produto.gasselector.ViewModel.MainViewModel
import estudo.produto.gasselector.databinding.FragmentCarInformationBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class carInformation : Fragment() {

      private val viewModel : MainViewModel by viewModel()
       private lateinit var binding : FragmentCarInformationBinding
       private lateinit var motorCarro : EditText
       private lateinit var consumoGasolina : EditText
       private lateinit var consumoAlcool : EditText
       private lateinit var proxima : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        binding =FragmentCarInformationBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        motorCarro = binding.carMotor
        consumoGasolina = binding.carConsumGas
        consumoAlcool = binding.carConsumAlcool
        proxima = binding.btProxima


       proxima.setOnClickListener{

           enviarCarInformationData()

       }

    }

       private fun enviarCarInformationData(){

           if(consumoAlcool.text.isNotEmpty() &&
               consumoGasolina.text.isNotEmpty() && motorCarro.text.isNotEmpty()){



            viewModel.consumoDeAlcool = consumoAlcool.text.toString()
            viewModel.consumoDeGasolina = consumoGasolina.text.toString()
            viewModel.tipoDoMotor = motorCarro.text.toString()

               parentFragmentManager.beginTransaction()
                   .replace(R.id.container_fragment, calculatorGasFragment()).addToBackStack(null).commit()
           }else{

               val snackbar = Snackbar.make(binding.carInformationFragment,"Favor informar dados solicitados!",
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
