package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.annotation.SuppressLint
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment
import java.util.logging.Handler

class HomePresenter(private  val view: HomeFragment) {

    // VIEWS <- PRESENTER
    // PRESENTER <- VIEW
    fun findAllCategories() {
        view.showProgress()
        fakeRequest()
    }

    fun onSuccess(response: List<String>) {
        val categories = response.map {Category(it, 0XFFFF0000)}

        view.showCategories(categories)
    }

    fun onError(message: String) {
        view.showFailure(message)
    }
    fun onComplete() {
        view.hideProgress()
    }

    // SIMULAR UMA REQUISIÇÃO HTTP

    private fun fakeRequest() {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Category 1",
                "Category 2",
                "Category 3",
                "Category 4"
            )

            // Aqui a lista já está pronta (response)

            // DEVOLVER SUCESSO OU FALHA


            onSuccess(response)

            //onError("FALHA NA CONEXÂO, TENTE NOVAMENTE MAIS TARDE!")

            onComplete()
        }, 2000)
    }

}