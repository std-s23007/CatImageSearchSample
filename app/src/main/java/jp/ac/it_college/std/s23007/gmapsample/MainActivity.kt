package jp.ac.it_college.std.s23007.gmapsample

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.catImageView)

        fetchRandomCatImage()
    }

    private fun fetchRandomCatImage() {
        RetrofitClient.catApiService.getRandomCatImage().enqueue(object : Callback<List<CatImage>> {
            override fun onResponse(call: Call<List<CatImage>>, response: Response<List<CatImage>>) {
                if (response.isSuccessful && response.body() != null) {
                    val catImageUrl = response.body()!![0].url
                    Glide.with(this@MainActivity)
                        .load(catImageUrl)
                        .into(imageView)
                }
            }

            override fun onFailure(call: Call<List<CatImage>>, t: Throwable) {
                // エラーハンドリング
            }
        })
    }
}
