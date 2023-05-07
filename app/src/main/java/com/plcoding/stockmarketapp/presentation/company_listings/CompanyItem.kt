package com.plcoding.stockmarketapp.presentation.company_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.BottomStart
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.stockmarketapp.domain.model.egForex.Row

@Composable
fun CompanyItem(
    company: Row,
    modifier: Modifier = Modifier
) {
    var backColors: Color
    if (company.changePercentage == null || company.changePercentage.toString() == 0f.toString()) {

        backColors = Color(0xFFA3A3A3)

    } else {
        backColors = if (company.changePercentage!! > 0.toDouble()) Color(0xFF5CE08D) else Color(
            0xFFD1606A
        )
    }



    Row(
        modifier = modifier


            .background(
                backColors,
                RoundedCornerShape(10)
            )
            .clip(RoundedCornerShape(10)), horizontalArrangement = Arrangement.Start,

        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(horizontalAlignment = Alignment.Start , verticalArrangement = Arrangement.Bottom) {


        Box(
            modifier = Modifier
                .padding(10.dp)
                .align(Start)

                .background(
                    Color(0xFFFFFFFF),
                    RoundedCornerShape(20)
                )
                .clip(RoundedCornerShape(20)),

        ) {
            androidx.compose.foundation.layout.Row() {


                Text(
                    text = company.price.toString()!!,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier=Modifier.padding(10.dp)

                )

            }
        }
        }
        Column(
            horizontalAlignment = Alignment.End
        ) {

            Row(

                modifier = Modifier.align(End), horizontalArrangement = Arrangement.End
            ) {


                Text(
                    text = "(${company.symbol})",
                    fontStyle = FontStyle.Italic,
                    color = Color.Black

                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = company.name!!,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 16.sp,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,

                    modifier = Modifier,
                )

            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .align(End)
                    .background(
                        Color(0xFFFFFFFF),
                        RoundedCornerShape(20)
                    )
                    .clip(RoundedCornerShape(20))
            ) {
                androidx.compose.foundation.layout.Row() {


                    Text(
                        text = company.changePercentage.toString()!!,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,

                        )
                    if (company.changePercentage == null) {
                    } else if (company.changePercentage!! > 0.toDouble()) {
                        Image(
                            painter = painterResource(com.plcoding.stockmarketapp.R.drawable.ic_baseline_arrow_upward_24),
                            contentDescription = "up"
                        )
                    } else {
                        Image(
                            painter = painterResource(com.plcoding.stockmarketapp.R.drawable.ic_baseline_arrow_downward_24),
                            contentDescription = "down"
                        )
                    }
                }
            }
        }
    }
}





