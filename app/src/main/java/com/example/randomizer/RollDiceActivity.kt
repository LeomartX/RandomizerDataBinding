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
import com.example.randomizer.databinding.ActivityRollDiceBinding
import com.google.android.material.snackbar.Snackbar

val diceFaces = listOf(
    R.drawable.area_1,
    R.drawable.area_2,
    R.drawable.area_3,
    R.drawable.area_4,
    R.drawable.area_5,
    R.drawable.area_6
)

class RollDiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_roll_dice)

        val binding = DataBindingUtil.setContentView<ActivityRollDiceBinding>(this, R.layout.activity_roll_dice)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Usando data binding para Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Roll Dice"

        // Usando data binding para la imagen del dado
        binding.diceFaceImage.setImageResource(diceFaces[1])

        binding.rollADiceButton.setOnClickListener {
            binding.diceFaceImage.setImageResource(diceFaces.random())
            Snackbar.make(binding.diceFaceImage, "Dice rolled!", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}