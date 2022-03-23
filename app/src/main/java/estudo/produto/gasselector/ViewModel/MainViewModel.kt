package estudo.produto.gasselector.ViewModel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel () {



     var consumoDeAlcool = ""
     var consumoDeGasolina = ""
     var tipoDoMotor = ""
     var precoGasolina = ""
     var precoAlcool = ""
     var resultado = ""


      fun calculoCombustivel() {

         if (consumoDeAlcool.isNotEmpty()  && consumoDeGasolina.isNotEmpty()
             && precoAlcool.isNotEmpty()  && precoGasolina.isNotEmpty() && tipoDoMotor.isNotEmpty()
         ) {
             melhorCombustivel()
         }

     }

    private fun melhorCombustivel() {
        val mediaConsumo = consumoDeAlcool.toDouble() / consumoDeGasolina.toDouble()


      val mediaPreco = precoAlcool.toDouble() / precoGasolina.toDouble()

        if(tipoDoMotor <= (1.4).toString() && mediaPreco > mediaConsumo){

            //abastece gasolina
            resultado = "Melhor abastecer com Gasolina"

        }else{

            //abastece Alcool
            resultado = "Melhor abastecer com Alcool"

        }
    }


    }

