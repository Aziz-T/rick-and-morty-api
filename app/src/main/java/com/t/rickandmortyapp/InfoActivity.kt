package com.t.rickandmortyapp

import android.os.Bundle
import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class InfoActivity : AppCompatActivity() {

    val episodes : MutableList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val character : CharacterModel = intent.getSerializableExtra("character") as CharacterModel



        loadDatas(character)
        expandLayout()





    }



    private fun loadDatas(character: CharacterModel) {
        val nameTxt : TextView = findViewById(R.id.nameTxt)
        val status : TextView = findViewById(R.id.statusTxt)
        val gender : TextView = findViewById(R.id.genderTxt)
        val imageView: CircleImageView = findViewById(R.id.profile_image)
        val listView : ListView = findViewById(R.id.listView)

        nameTxt.text = character.name
        status.text = character.status +","+ character.species
        gender.text = character.gender
        Glide.with(this).load(character.image).into(imageView)




        for(i in 0..character.episode.size){
            episodes.add("Episode " + (i+1))
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, episodes)
        listView.adapter = adapter

    }

    private fun expandLayout() {
        val arrow : ImageView = findViewById(R.id.arrow);
        val expandableLinear : LinearLayout = findViewById(R.id.expandLinear)
        val hiddenView: LinearLayout = findViewById(R.id.hiddenView)

        hiddenView.visibility = View.GONE
        expandableLinear.setOnClickListener(){
            if(hiddenView.visibility == View.VISIBLE){
                TransitionManager.beginDelayedTransition(
                        expandableLinear,
                        AutoTransition()
                )
                hiddenView.visibility = View.GONE
                arrow.setImageResource(R.drawable.ic_baseline_expand_more_24)
            }else {
                TransitionManager.beginDelayedTransition(
                        expandableLinear,
                        AutoTransition()
                )
                hiddenView.visibility = View.VISIBLE
                arrow.setImageResource(R.drawable.ic_baseline_expand_less_24)
            }
        }
    }
}