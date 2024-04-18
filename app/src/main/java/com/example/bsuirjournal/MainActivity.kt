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
            var searchText = remember { mutableStateOf("") }
            var isActive by rememberSaveable { mutableStateOf(false) }
            val groupList = remember {
                mutableStateOf(Utils.originList)
            }
            val painter = painterResource(id = R.drawable.ic_list)
            val description = "Info"
            val openGroupDialog = remember { mutableStateOf(false) }
            BSUIRJournalTheme {
                SearchBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(horizontal = 4.dp)
                        .background(color = Color.White),
                    query = searchText.value,
                    onQueryChange = { text ->
                        searchText.value = text
                        groupList.value = Utils.search(text)
                    },
                    onSearch = {text ->
                        isActive = false
                        groupList.value = Utils.search(text)
                    },
                    active = isActive,
                    onActiveChange = {
                        isActive = it
                    },
                    placeholder = {
                        Text(text = "Номер группы...", color = Color.Black)
                    },
                ) {
                    GroupList(grouplist = groupList, painter = painter, description = description, openGroupDialog = openGroupDialog)
                }
                if (openGroupDialog.value == true) {
                    OpenGroupDialog(openGroupDialog = openGroupDialog)
                }
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                }
            }
        }
    }
}

@Composable
fun OpenGroupDialog(
    openGroupDialog: MutableState<Boolean>
) {
    Dialog(
        onDismissRequest = {
            openGroupDialog.value = false
        },
    ) {
        Card{
            Text(
                text = "Group",
                modifier = Modifier
                    .wrapContentSize(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
fun GroupCard(
    group: String,
    painter: Painter,
    contentDescription: String,
    modifier: Modifier,
    openGroupDialog: MutableState<Boolean>,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(75.dp)
            .padding(vertical = 5.dp, horizontal = 5.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(),
    ) {
        Row(modifier = Modifier.height(75.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier
                    .size(width = 75.dp, height = 75.dp)
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .clickable { openGroupDialog.value = true }
            )
            Text(
                style = TextStyle(color = Color.Black, fontSize = 18.sp),
                text = "$group",
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 22.dp)
            )
        }
    }
}

@Composable
fun GroupList(
    grouplist: MutableState<List<String>>,
    painter: Painter,
    description: String,
    openGroupDialog: MutableState<Boolean>,
) {
    LazyColumn {
        items(grouplist.value) {item ->
            GroupCard(
                group = item,
                painter = painter,
                contentDescription = description,
                modifier = Modifier,
                openGroupDialog = openGroupDialog
            )
        }
    }
}

object Utils {
    val originList = listOf (
        "353501",
        "353502",
        "353503",
        "353504",
        "353505",
    )

    fun search(text: String): List<String> {
        return originList.filter {
            it.startsWith(text)
        }
    }
}
