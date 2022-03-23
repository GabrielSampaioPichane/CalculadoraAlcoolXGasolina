package estudo.produto.gasselector.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import estudo.produto.gasselector.databinding.FragmentPricesBinding


class pricesFragment : Fragment() {
   private lateinit var binding : FragmentPricesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentPricesBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return binding.root
    }


}