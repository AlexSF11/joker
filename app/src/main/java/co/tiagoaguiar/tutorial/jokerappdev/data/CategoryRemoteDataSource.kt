package co.tiagoaguiar.tutorial.jokerappdev.data

import android.os.Looper

class CategoryRemoteDataSource {

    fun findAllCategories(callback: ListCategoryCallback) {
        android.os.Handler(Looper.getMainLooper()).postDelayed({
            val response = arrayListOf(
                "Category 1",
                "Category 2",
                "Category 3",
                "Category 4"
            )

            // Aqui a lista já está pronta (response)

            // DEVOLVER SUCESSO OU FALHA


            callback.onSuccess(response)

            //onError("FALHA NA CONEXÂO, TENTE NOVAMENTE MAIS TARDE!")

            callback.onComplete()
        }, 4000)
    }
}