package com.plcoding.stoks.presentation.company_listings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.plcoding.stoks.R
import com.plcoding.stoks.presentation.destinations.CompanyInfoScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination(start = true)
fun CompanyListingsScreen(
    navigator: DestinationsNavigator,
    viewModel: CompanyListingsViewModel = hiltViewModel()
) {
    val swipeRefreshState = rememberSwipeRefreshState(
        isRefreshing = viewModel.state.isRefreshing
    )
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(
                    CompanyListingsEvent.OnSearchQueryChange(it)
                )
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                ,
            placeholder = {
                Text(text = "Search...",)
                    colorResource(id = R.color.white)
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(

                focusedLabelColor = colorResource(id = R.color.white),
                cursorColor = colorResource(id = R.color.teal_700)
            ),
            maxLines = 1,
            singleLine = true
        )
        SwipeRefresh(
            state = swipeRefreshState,
            onRefresh = {
                viewModel.onEvent(CompanyListingsEvent.Refresh)
            }
        ) {
            Column() {


                Row(modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .align(CenterHorizontally),    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(


                        modifier = Modifier
                            .padding(5.dp)
                            .background(
                                Color(0xFF282b2f),
                                RoundedCornerShape(20)
                            )
                            .clip(RoundedCornerShape(20))


                        ) {
                        Row(modifier = Modifier.padding(10.dp)) {

                            Column(modifier = Modifier, horizontalAlignment = Alignment.Start) {
                                Text(
                                    text = "سعر الدولار",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,

                                    )
                                Text(
                                    text = "${state.usdRate} LE",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,

                                    )
                            }



                            Image(
                                painter = painterResource(R.drawable.usdicon)
                                    , modifier = Modifier
                                    .width(50.dp)
                                    .height(50.dp)
                                    .padding(5.dp),
                                contentDescription = "down"
                            )

                        }
                    }
                    Box(
                        modifier = Modifier

                            .padding(5.dp)

                            .background(
                                Color(0xFF282b2f),
                                RoundedCornerShape(20)
                            )
                            .clip(RoundedCornerShape(20))


                    ) {
                        Row(modifier = Modifier.padding(10.dp)) {

                            Column( horizontalAlignment = Alignment.Start) {
                                Text(
                                    text = "سعر الذهب",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,

                                    )
                                Text(
                                    text = "${state.goldRate} LE",
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp,
                                    color = Color.White,
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 1,

                                    )
                            }



                            Image(
                                painter = painterResource(R.drawable.gold),
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                                    .padding(5.dp),
                                contentDescription = "down"
                            )

                        }
                    }
                }
                 Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(state.companies!!.size) { i ->
                        val company = state.companies[i]
                        CompanyItem(
                            company = company!!,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    if (company != null) {
                                        navigator.navigate(
                                            CompanyInfoScreenDestination(company.symbol!!)
                                        )
                                    }
                                }
                                .padding(16.dp),

viewModel
                        )
                        if (i < state.companies.size) {
                            Divider(
                                modifier = Modifier.padding(
                                    horizontal = 16.dp
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}