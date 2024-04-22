package com.example.bsuirjournal

import android.os.Bundle//
import androidx.activity.ComponentActivity//
import androidx.activity.compose.setContent//
import androidx.compose.material3.ExperimentalMaterial3Api//
import com.example.bsuirjournal.ui.screens.BSUIRJournalApp
import com.example.bsuirjournal.ui.theme.BSUIRJournalTheme

//import androidx.constraintlayout.core.motion.utils.Utils


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BSUIRJournalTheme {
                BSUIRJournalApp()
            }
        }
    }
}