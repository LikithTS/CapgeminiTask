package com.likith.capgeminitask.presentation

import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.likith.capgeminitask.domain.util.TransferType
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@Composable
fun CustomRadioButtonView(
    selected: TransferType,
    onSelected: (TransferType) -> Unit,
    modifier: Modifier = Modifier
) {

    val entries = TransferType.entries.toList()

    SingleChoiceSegmentedButtonRow(modifier) {
        entries.forEachIndexed { index, type ->
            SegmentedButton(
                selected = selected == type,
                onClick = { onSelected(type) },
                shape = SegmentedButtonDefaults.itemShape(index = index, count = entries.size),
                label = {
                    Text(
                        stringResource(id = type.labelId)
                    )
                }
            )
        }
    }
}