package com.example.bsuirjournal

import android.os.Bundle//
import androidx.activity.ComponentActivity//
import androidx.activity.compose.setContent//
import androidx.compose.foundation.Image//
import androidx.compose.foundation.background//
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row//
import androidx.compose.foundation.layout.fillMaxSize//
import androidx.compose.foundation.layout.fillMaxWidth//
import androidx.compose.foundation.layout.height//
import androidx.compose.foundation.layout.padding//
import androidx.compose.foundation.layout.size//
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn//
import androidx.compose.foundation.lazy.items//
import androidx.compose.foundation.shape.RoundedCornerShape//
import androidx.compose.material3.Card//
import androidx.compose.material3.CardDefaults//
import androidx.compose.material3.ExperimentalMaterial3Api//
import androidx.compose.material3.MaterialTheme//
import androidx.compose.material3.SearchBar//
import androidx.compose.material3.Surface//
import androidx.compose.material3.Text//
import androidx.compose.runtime.Composable//
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue//
import androidx.compose.runtime.mutableStateOf//
import androidx.compose.runtime.remember//
import androidx.compose.runtime.saveable.rememberSaveable//
import androidx.compose.runtime.setValue//
import androidx.compose.ui.Modifier//
import androidx.compose.ui.graphics.Color//
import androidx.compose.ui.graphics.painter.Painter//
import androidx.compose.ui.res.painterResource//
import androidx.compose.ui.text.TextStyle//
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp//
import androidx.compose.ui.unit.sp//
import androidx.compose.ui.window.Dialog
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