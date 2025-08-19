package com.likith.capgeminitask.presentation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.likith.capgeminitask.R

/**
 * We can have lambda function in parameter to handle any navigation icon.
 * Since we're not going with any back button for now let's remove this from the scope
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonHeaderView(headerName: String) {

    CenterAlignedTopAppBar(
        modifier = Modifier.height(45.dp),
        windowInsets = WindowInsets(0, 20, 0, 10),
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = colorResource(id = R.color.primary),
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        title = {
            Text(
                headerName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 18.sp,
                fontWeight = FontWeight.W500
            )
        }
    )
}