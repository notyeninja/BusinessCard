package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = Color(0xFF90a349))
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row(modifier = Modifier.weight(2f)) {
            JobInfoCard()
        }
        Row {
            ContactInfoCard()
        }
    }
}

@Composable
fun JobInfoCard(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.chibi_beard),
            contentDescription = null
        )
        Text(
            text = stringResource(id = R.string.title),
            modifier = Modifier.padding(top = 4.dp, bottom = 8.dp),
            fontSize = 32.sp
        )
        Text(text = stringResource(id = R.string.job_description))
    }
}

@Composable
fun ContactInfoCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier,
        ) {
            Icon(Icons.Outlined.Call, contentDescription = "Telephone number")
            Text(text = stringResource(id = R.string.phone_number), modifier = Modifier.offset(8.dp))
        }
        Row(
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        ) {
            Icon(Icons.Outlined.Share, contentDescription = "Twitter handle")
            Text(text = stringResource(id = R.string.social_handle), modifier = Modifier.offset(8.dp))
        }
        Row {
            Icon(Icons.Outlined.Email, contentDescription = "Email address")
            Text(text = stringResource(id = R.string.email_id), modifier = Modifier.offset(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}