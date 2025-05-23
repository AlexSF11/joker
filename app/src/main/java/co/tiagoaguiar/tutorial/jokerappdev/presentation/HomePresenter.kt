package co.tiagoaguiar.tutorial.jokerappdev.presentation

import android.annotation.SuppressLint
import android.os.Looper
import co.tiagoaguiar.tutorial.jokerappdev.data.CategoryRemoteDataSource
import co.tiagoaguiar.tutorial.jokerappdev.data.ListCategoryCallback
import co.tiagoaguiar.tutorial.jokerappdev.model.Category
import co.tiagoaguiar.tutorial.jokerappdev.view.CategoryItem
import co.tiagoaguiar.tutorial.jokerappdev.view.HomeFragment
import java.util.logging.Handler

class HomePresenter(
    private  val view: HomeFragment,
    private val dataSource: CategoryRemoteDataSource = CategoryRemoteDataSource()
) : ListCategoryCallback {

    // VIEWS <- PRESENTER
    // PRESENTER <- VIEW
    fun findAllCategories() {
        view.showProgress()
        dataSource.findAllCategories(this)
    }

    override fun onSuccess(response: List<String>) {
        val categories = response.map {Category(it, 0XFFFF0000)}

        view.showCategories(categories)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }
    override fun onComplete() {
        view.hideProgress()
    }

}