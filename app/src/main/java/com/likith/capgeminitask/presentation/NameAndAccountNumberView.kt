package com.likith.capgeminitask.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.likith.capgeminitask.R

@Composable
fun NameAndAccountNumberView(
    recipientName: String,
    onRecipientNameChange: (String) -> Unit,
    accountNumber: String,
    onAccountNumberChange: (String) -> Unit,
) {

    OutlinedTextField(
        value = recipientName,
        onValueChange = { value ->
            val newValue = value
                .filter { it.isLetter() }
                .take(50)//Max length is 50 char limit
            onRecipientNameChange(newValue)
        },
        label = {
            Text(text = stringResource(R.string.recipient_name))
        },
        singleLine = true,

        )

    Spacer(Modifier.height(12.dp))


    OutlinedTextField(
        value = accountNumber,
        onValueChange = { accNum ->
            val newAccountNumber = accNum
                .filter { it.isDigit() }
                .take(16) //As per my knowledge max 16 digit can be account number. We can increase this if required later.
            onAccountNumberChange(newAccountNumber)
        },
        label = {
            Text(text = stringResource(R.string.account_number))
        },
        singleLine = true,
    )
}