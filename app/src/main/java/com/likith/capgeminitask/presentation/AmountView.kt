package com.likith.capgeminitask.presentation

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.likith.capgeminitask.R

@Composable
fun AmountView(
    amount: String,
    onAmountChanged: (String) -> Unit,
) {

    OutlinedTextField(
        value = amount,
        onValueChange = { amt ->
            val newAmount = amt
                .filter { it.isDigit() }
                .take(16) //We can extent this later
            onAmountChanged(newAmount)
        },
        label = {
            Text(text = stringResource(R.string.amount))
        },
        singleLine = true,
    )
}