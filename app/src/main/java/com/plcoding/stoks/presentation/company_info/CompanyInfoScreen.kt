package com.plcoding.stoks.presentation.company_info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
 import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.glide.GlideImage

@Composable
@Destination
fun CompanyInfoScreen(
    symbol: String,
    viewModel: CompanyInfoViewModel = hiltViewModel()
) {
    val state = viewModel.state
    if (state.error == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(com.plcoding.stoks.R.color.primaryDark))
                .padding(16.dp)
        ) {
            state.company?.let { company ->

                Row() {
                    Box(
                        modifier = Modifier
                            .background(
                                Color(0xFFFFFFFF),
                                RoundedCornerShape(20)
                            )
                            .clip(RoundedCornerShape(20))
                            .width(60.dp)
                            .height(40.dp)
                    ) {
                        GlideImage(
                            imageModel = company.image.toString(),
                            contentScale = ContentScale.Crop,
                            circularReveal = CircularReveal(duration = 100),
                            alignment = Alignment.Center,

                            shimmerParams = ShimmerParams(
                                baseColor = MaterialTheme.colors.background,
                                highlightColor = Color.Gray,
                                durationMillis = 500,
                                dropOff = 0.55f,
                                tilt = 20f

                            ), modifier = Modifier
                                .width(40.dp)
                                .height(30.dp)
                                .align(Center)
                        )
                    }
                    Column() {
                        Text(
                            text = company.name!!,
                            color=colorResource(com.plcoding.stoks.R.color.white),
                             fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,


                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .wrapContentSize()
                                .align(End)

                                .align(CenterHorizontally)
                                .padding(start = 30.dp, top = 10.dp)
                        )
                    }


                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .align(End)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = company.companyTab?.priceBar?.updatedAt.toString(),
                        fontStyle = FontStyle.Italic,
                        fontSize = 14.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Start)
                ) {
                    Text(
                        text = "Price: ${company.companyTab?.priceBar?.value} LE",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color=colorResource(com.plcoding.stoks.R.color.mainTextColor),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Change : ${company.companyTab?.priceBar?.change} LE",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.mainTextColor),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Start)
                ) {
                    Text(
                        text = "Status: ${company.companyTab?.priceBar?.status?.toUpperCase()}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),


                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Percentage : ${company.companyTab?.priceBar?.changePercentage}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Start)
                ) {
                    Text(
                        text = "Open: ${company.companyTab?.priceBar?.open}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "Close : ${company.companyTab?.priceBar?.close}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))


                Spacer(modifier = Modifier.height(8.dp))
                Divider(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Start)
                ) {
                    Text(
                        text = "History High: ${company.companyTab?.priceBar?.historicalHigh}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "History Low : ${company.companyTab?.priceBar?.historicalLow}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Start)
                ) {
                    Text(
                        text = "volume: ${company.companyTab?.priceBar?.volume}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )

                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Start)
                ) {
                    Text(
                        text = "turnover: ${company.companyTab?.priceBar?.turnover}",
                        fontSize = 18.sp,
                        color=colorResource(com.plcoding.stoks.R.color.white),

                        modifier = Modifier
                            .wrapContentWidth()
                            .weight(1f),
                        overflow = TextOverflow.Ellipsis
                    )

                }
             }
        }
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Center
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else if (state.error != null) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error
            )
        }
    }
}