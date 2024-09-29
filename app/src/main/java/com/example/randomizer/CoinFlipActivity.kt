package com.example.randomizer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.randomizer.databinding.ActivityCoinFlipBinding
import com.google.android.material.snackbar.Snackbar

class CoinFlipActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_coin_flip)

        val binding = DataBindingUtil.setContentView<ActivityCoinFlipBinding>(this, R.layout.activity_coin_flip)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.coinToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Flip Coin"

        binding.coinFaceImage.setImageResource(R.drawable.face)

        binding.flipACoinButton.setOnClickListener {
            binding.coinFaceImage.setImageResource(listOf(R.drawable.face, R.drawable.cross).random())
            Snackbar.make(binding.coinFaceImage, "Coin Flipped!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}