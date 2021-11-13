package com.example.composedesign.navigation

import com.example.composedesign.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home: NavigationItem("home", R.drawable.ic_explore_active,"Explore")
    object WhistList: NavigationItem("wishlist", R.drawable.ic_heart,"WhisList")
    object Chat: NavigationItem("chat", R.drawable.ic_chat,"Chat")
}
