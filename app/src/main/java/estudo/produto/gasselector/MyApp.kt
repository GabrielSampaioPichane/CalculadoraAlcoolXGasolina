package estudo.produto.gasselector

import android.app.Application
import estudo.produto.gasselector.App.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)

            modules(mainModule)
        }

    }

}