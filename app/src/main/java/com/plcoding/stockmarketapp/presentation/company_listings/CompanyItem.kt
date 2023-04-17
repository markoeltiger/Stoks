package com.plcoding.stockmarketapp.presentation.company_listings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
      if (company.changePercentage == null||company.changePercentage.toString()==0f.toString()) {

            backColors =  Color(0xFFA3A3A3)

      }else{
            backColors = if (company.changePercentage!! >0.toDouble()) Color(0xFF5CE08D) else Color(
              0xFFD1606A
          )
      }



         Row(
             modifier = modifier
                 .background(
                     backColors,
                     RoundedCornerShape(20)
                 )
                 .clip(RoundedCornerShape(20))
                 ,

             verticalAlignment = Alignment.CenterVertically
         ) {
             Column(
                 modifier = Modifier.weight(1f)
             ) {
                 Row(

                     modifier = Modifier
                         .fillMaxWidth()
                         .align(Alignment.Start)
                 ) {
                     Text(
                         text = company.sector!!,
                         fontWeight = FontWeight.Light,
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

                         modifier = Modifier.weight(1f))

                 }
                 Spacer(modifier = Modifier.height(8.dp))
                 Text(
                     text = "(${company.symbol})",
                     fontStyle = FontStyle.Italic,
                     color = Color.Black
                 )
             }
         }

     }

@Preview
@Composable
fun WelcomeScreenPreview() {
   CompanyItem(company = Row(changePercentage =4.5, currency = "LE", name = "البنك التجاري الدولي", lastUpdate = "11 أبريل 2023", marketUrl = "", url = "", market = "", sector = "بنوك", symbol = "GDIC", price =45.0, profileUrl = ""))
}
     



