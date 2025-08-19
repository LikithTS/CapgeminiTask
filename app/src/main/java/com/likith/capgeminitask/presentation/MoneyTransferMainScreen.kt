package com.likith.capgeminitask.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.likith.capgeminitask.R
import com.likith.capgeminitask.domain.util.TransferType

@Composable
fun MoneyTransferMainScreen(modifier: Modifier) {

    var transferType by remember { mutableStateOf(TransferType.DOMESTIC) }
    var recipientName by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    var ibanNumber by remember { mutableStateOf("") }
    var swiftCode by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }

    Box(modifier = modifier.fillMaxSize()) {

        Column(
            modifier = modifier.padding(bottom = 80.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            CommonHeaderView(headerName = stringResource(R.string.money_transfer))

            Spacer(Modifier.height(20.dp))

            CustomRadioButtonView(
                selected = transferType,
                onSelected = { transferType = it }
            )

            Spacer(Modifier.height(30.dp))

            NameAndAccountNumberView(
                recipientName, onRecipientNameChange = {
                    recipientName = it
                }, accountNumber, onAccountNumberChange = {
                    accountNumber = it
                }
            )

            if (transferType == TransferType.INTERNATIONAL) {
                Spacer(Modifier.height(12.dp))
                InternationTransferFieldViews(
                    ibanNumber, onIbanNumberChanged = {
                        ibanNumber = it
                    }, swiftCode, onSwiftCodeChanged = {
                        swiftCode = it
                    }
                )
            }

            Spacer(Modifier.height(12.dp))
            AmountView(
                amount,
                onAmountChanged = {
                    amount = it
                }
            )

            Spacer(Modifier.height(12.dp))

        }

        Button(
            onClick = {
//                Calling API with below detail to send money
//                transferType
//                recipientName
//                accountNumber
//                ibanNumber
//                swiftCode
//                amount
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.primary), // custom bg color
                contentColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .align(Alignment.BottomCenter)
        ) {
            Text(text = stringResource(R.string.send_money))
        }

    }
}