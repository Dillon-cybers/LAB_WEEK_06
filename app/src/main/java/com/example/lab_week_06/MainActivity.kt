package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male, CatBreed.BalineseJavanese, "Fred", "Silent and deadly", "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair, "William", "Cuddly assassin", "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Corigor Gorga", "Award winning investigator", "https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male, CatBreed.AmericanCurl, "Tommy", "Always hungry", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna maya", "Loves to sleep", "https://cdn2.thecatapi.com/images/9lo.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Oscar cicak", "Playful jumper", "https://cdn2.thecatapi.com/images/1me.jpg"),
                CatModel(Gender.Unknown, CatBreed.AmericanCurl, "Shadow", "Hides everywhere", "https://cdn2.thecatapi.com/images/2si.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Misty", "Gentle and calm", "https://cdn2.thecatapi.com/images/8u2.jpg"),
                CatModel(Gender.Male, CatBreed.ExoticShorthair, "Leo vince", "Fast runner", "https://cdn2.thecatapi.com/images/5rk.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl, "Anabel", "Loves cuddles", "https://cdn2.thecatapi.com/images/a3t.jpg")
            )
        )

    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK", null)
            .show()
    }
}
