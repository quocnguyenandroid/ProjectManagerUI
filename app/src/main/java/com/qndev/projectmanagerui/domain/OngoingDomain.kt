package com.qndev.projectmanagerui.domain

data class OngoingDomain(
    val title: String,
    val date: String,
    val progressPercent: Int,
    val picPath: String,
)