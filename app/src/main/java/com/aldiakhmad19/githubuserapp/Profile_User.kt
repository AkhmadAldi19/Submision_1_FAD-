package com.aldiakhmad19.githubuserapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class Profile_User : AppCompatActivity() {

    companion object{
        const val PROFILE_USER = "Profile_User"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_user)

        supportActionBar?.title="User Profile"

        val dataAvatar: ImageView = findViewById(R.id.img_avatar)
        val dataName: TextView = findViewById(R.id.name)
        val dataUsername: TextView = findViewById(R.id.username)
        val dataRepository: TextView = findViewById(R.id.repository)
        val dataFollowers: TextView = findViewById(R.id.followers)
        val dataFollowing: TextView = findViewById(R.id.following)
        val dataBio: TextView = findViewById(R.id.bio)
        val dataCompany: TextView = findViewById(R.id.company)
        val dataLocation: TextView = findViewById(R.id.location)

        val dataUser = intent.getParcelableExtra<User>(PROFILE_USER) as User
        Log.d("Profile_user", dataUser?.name.toString())

        dataAvatar.setImageResource(dataUser.avatar)
        dataName.text = dataUser.name
        dataUsername.text = dataUser.username
        dataRepository.text = dataUser.repository
        dataFollowers.text = dataUser.followers
        dataFollowing.text = dataUser.following
        dataBio.text = dataUser.bio
        dataCompany.text = dataUser.company
        dataLocation.text = dataUser.location
    }
}