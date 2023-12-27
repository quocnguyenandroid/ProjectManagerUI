package com.qndev.projectmanagerui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.qndev.projectmanagerui.adapter.ArchiveAdapter
import com.qndev.projectmanagerui.adapter.MyTeamAdapter
import com.qndev.projectmanagerui.databinding.ActivityProfileBinding
import com.qndev.projectmanagerui.domain.TeamDomain

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerViewArchive()
        initRecyclerViewMyTeam()
    }

    private fun initRecyclerViewMyTeam() {
        val items = mutableListOf<TeamDomain>()
        items.add(TeamDomain("Food App Application", "Project in progress"))
        items.add(TeamDomain("AI Python", "Completed"))
        items.add(TeamDomain("Weather App Backend", "Project in progress"))
        items.add(TeamDomain("Kotlin Developers", "Completed"))
        binding.myTeamView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.myTeamView.adapter = MyTeamAdapter(items)
    }

    private fun initRecyclerViewArchive() {
        val items = mutableListOf<String>()
        items.add("UI/UX Screenshot")
        items.add("Kotlin Source Code")
        items.add("Source Codes")
        binding.archivesView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.archivesView.adapter = ArchiveAdapter(items)
    }
}