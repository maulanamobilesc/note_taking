package com.maulana.notetaking.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maulana.notetaking.NoteDetailRoute
import com.maulana.notetaking.R
import com.maulana.notetaking.datasource.local.realm.model.NoteRealm
import com.maulana.notetaking.domain.HomeIntent
import com.maulana.notetaking.ui.component.PrimaryButton
import com.maulana.notetaking.ui.theme.GlobalDimension
import com.maulana.notetaking.ui.theme.Lotion
import com.maulana.notetaking.ui.theme.NoteTakingTheme
import com.maulana.warehouse.core.component.Spacer

@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {

    val notes by viewModel.notes.collectAsState()

    LaunchedEffect(true) {
        viewModel.processIntent(HomeIntent.GetAllNotes)
    }

    if (notes.isNotEmpty()) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(GlobalDimension.secondaryPadding),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(items = notes, key = { it.id }) {
                NoteItem(it, {navController.navigate(NoteDetailRoute(it.id))})
            }
        }
    } else {
        EmptyStateContent(navController)
    }
}

@Composable
fun NoteItem(note: NoteRealm, onClick: () -> Unit ) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = Lotion)
            .padding(GlobalDimension.sectionPadding).clickable { onClick() }
    ) {
        Text(fontWeight = FontWeight(800),text = note.title, fontSize = GlobalDimension.defaultFontSize)
        Text(text = note.content, fontSize = GlobalDimension.smallFontSize)
    }
}

@Composable
fun EmptyStateContent(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(GlobalDimension.mainPadding),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.weight(0.5f, fill = false)) {}
        Column(
            Modifier
                .fillMaxWidth()
                .weight(1f, fill = false),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.ic_note_empty_3x),
                contentDescription = "note empty state"
            )
            Spacer(40.dp)
            Text("Create Your First Note")
            Spacer(12.dp)
            Text(
                "Add a note about anything (your thoughts on climate change, or your history essay) and share it with the world.",
                textAlign = TextAlign.Center
            )
        }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            PrimaryButton(
                onClick = { navController.navigate(NoteDetailRoute("")) },
                text = "Create A Note"
            )
            Spacer(20.dp)
            Text("Import Notes")
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun HomeScreenPreview() {
    NoteTakingTheme(dynamicColor = false) {
        HomeScreen(rememberNavController())
    }
}