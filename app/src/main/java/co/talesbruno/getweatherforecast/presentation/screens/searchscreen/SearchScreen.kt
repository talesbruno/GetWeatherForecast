package co.talesbruno.getweatherforecast.presentation.screens.searchscreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onNavigateToMainScreen: (String) -> Unit,
    popBackStack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    SearchBar(onNavigateToMainScreen = onNavigateToMainScreen)
                },
                navigationIcon = {
                    IconButton(
                        onClick = { popBackStack() },
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) {

    }
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "Digite um nome de cidade",
    onNavigateToMainScreen: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = searchText,
        onValueChange = { searchText = it },
        placeholder = { Text(text = hint, color = Color.Gray) },
        trailingIcon = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (searchText.isNotEmpty()) {
                    IconButton(
                        onClick = { searchText = "" },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear",
                            tint = Color.Gray
                        )
                    }
                }
                Spacer(modifier = Modifier.size(4.dp))
                IconButton(
                    onClick = { onNavigateToMainScreen(searchText) },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color.Gray
                    )
                }
            }
        },
        colors = TextFieldDefaults.colors(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                onNavigateToMainScreen(searchText)
                keyboardController?.hide()
            }
        )
    )
}

@Preview
@Composable
fun PreviewSearchBar() {
    SearchScreen(onNavigateToMainScreen = {}, popBackStack = {})
}