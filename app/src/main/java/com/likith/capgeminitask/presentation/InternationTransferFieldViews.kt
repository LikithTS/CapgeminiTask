package com.likith.capgeminitask.presentation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.likith.capgeminitask.R
import com.likith.capgeminitask.presentation.util.toValidSwiftCode

@Composable
fun InternationTransferFieldViews(
    ibanNumber: String,
    onIbanNumberChanged: (String) -> Unit,
    swiftCode: String,
    onSwiftCodeChanged: (String) -> Unit,
) {

    var swiftCodeTextField by rememberSaveable(stateSaver = TextFieldValue.Saver) {
        mutableStateOf(TextFieldValue(swiftCode))
    }

    LaunchedEffect(swiftCode) {
        if (swiftCodeTextField.text != swiftCode) {
            swiftCodeTextField = TextFieldValue(
                text = swiftCode,
                selection = TextRange(swiftCode.length)
            )
        }
    }


    OutlinedTextField(
        value = ibanNumber,
        onValueChange = { value ->
            val newValue = value
                .filter { it.isLetterOrDigit() }
                .take(34)//Max length is 34 char limit
            onIbanNumberChanged(newValue)
        },
        label = {
            Text(text = stringResource(R.string.iban_number))
        },
        singleLine = true,
    )

    Spacer(Modifier.height(12.dp))


    OutlinedTextField(
        value = swiftCodeTextField,
        onValueChange = { value ->
            val swiftCode = value.text
                .filter { it.isDigit() }
                .take(10)

            val updateSwiftCode = swiftCode.toValidSwiftCode()
            swiftCodeTextField = TextFieldValue(
                text = updateSwiftCode,
                selection = TextRange(updateSwiftCode.length)
            )

            onSwiftCodeChanged(updateSwiftCode)
        },
        label = {
            Text(text = stringResource(R.string.swift_code))
        },
        singleLine = true,
    )
}