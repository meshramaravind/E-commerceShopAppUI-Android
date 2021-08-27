package com.arvind.nikeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arvind.nikeshop.navigation.Navigation
import com.arvind.nikeshop.ui.theme.NikeShopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetNikeShopUIMain()
        }
    }

    @Composable
    fun JetNikeShopUIMain() {
        NikeShopTheme {
            Surface(color = MaterialTheme.colors.background) {
                Navigation()
            }
        }
    }
}

