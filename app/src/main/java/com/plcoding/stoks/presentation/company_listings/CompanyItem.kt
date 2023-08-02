package com.plcoding.stoks.presentation.company_listings

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.plcoding.stoks.domain.model.egForex.Row

@Composable
fun CompanyItem(

    company: Row,
    modifier: Modifier = Modifier,
    viewModel: CompanyListingsViewModel
) {
    val context = LocalContext.current

    var backColors: Color
    if (company.changePercentage == null || company.changePercentage.toString() == 0f.toString()) {

        backColors = Color(0xFFA3A3A3)

    } else {
        backColors = if (company.changePercentage!! > 0.toDouble()) Color(0xFF5CE08D) else Color(
            0xFFD1606A
        )
    }


//Main background Row
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                backColors,
                RoundedCornerShape(10)
            )
            .clip(RoundedCornerShape(10)), horizontalArrangement = Arrangement.Start,

        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(4.dp))
        val image: Painter = painterResource(id = com.plcoding.stoks.R.drawable.heart_svgrepo_com)

        Image(painter = image,contentDescription = "",  colorFilter = ColorFilter.tint(color = Color.White), modifier = Modifier
            .size(40.dp)
            .padding(3.dp)
            .clickable(enabled = true, onClick = {
                viewModel.setFavorite(company.symbol!!)
                Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show()})
          )

        Column(horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Bottom) {


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
                        text = "${company.price.toString()!!} LE",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                        modifier = Modifier.padding(10.dp)

                    )

                }

            }
        }

        Column(
            modifier=Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {

            Row(

                modifier = Modifier.align(End), horizontalArrangement = Arrangement.End
            ) {


                Text(
                    text = "(${company.symbol})",
                    fontStyle = FontStyle.Italic,
                    color = Color.Black,


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
                        text ="${ company.changePercentage.toString()!!} %",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp,
                        color = Color.Black,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,

                        )
                    if (company.changePercentage == null) {
                    } else if (company.changePercentage!! > 0.toDouble()) {
                        Image(
                            painter = painterResource(com.plcoding.stoks.R.drawable.ic_baseline_arrow_upward_24),
                            contentDescription = "up"
                        )
                    } else {
                        Image(
                            painter = painterResource(com.plcoding.stoks.R.drawable.ic_baseline_arrow_downward_24),
                            contentDescription = "down"
                        )
                    }
                }
            }

        }

    }

}






