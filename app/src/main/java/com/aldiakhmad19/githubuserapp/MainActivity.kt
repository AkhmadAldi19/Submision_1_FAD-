package com.aldiakhmad19.githubuserapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUser:RecyclerView
    private val list = ArrayList<User>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Github User App"

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<User>
    get() {
        val dataAvatar = resources.obtainTypedArray(R.array.avatar)
        val dataName = resources.getStringArray(R.array.name)
        val dataUsername = resources.getStringArray(R.array.username)
        val dataRepo = resources.getStringArray(R.array.repository)
        val dataFollower = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)
        val dataBio = resources.getStringArray(R.array.bio)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataCompany = resources.getStringArray(R.array.company)

        val listUser = ArrayList<User>()
        for(i in dataName.indices){
            val user = User( dataAvatar.getResourceId(i, -1),dataName[i],dataUsername[i],dataRepo[i],dataFollower[i], dataFollowing[i],dataBio[i] , dataCompany[i],dataLocation[i])
            listUser.add(user)
        }
        return listUser
    }

    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter

        listUserAdapter.setOnItemClickback (object : ListUserAdapter.OnItemClickCallback{

            override fun onItemClicked(data: User) {
                val(avatar,name,username, repository, follower, following,bio,company,location )=data
                val detailData = User(avatar, name, username, repository, follower, following,bio, company,location)

                val intentToDetailUser = Intent(this@MainActivity,Profile_User::class.java)
                intentToDetailUser.putExtra(Profile_User.PROFILE_USER, detailData)
                startActivity(intentToDetailUser)
            }
        }
        )
    }

}


