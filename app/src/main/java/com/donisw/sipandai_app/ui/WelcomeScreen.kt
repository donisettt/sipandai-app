package com.donisw.sipandai_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.donisw.sipandai_app.R

@Composable
fun WelcomeScreen(onStartClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        // Logo Pangandaran
        Image(
            painter = painterResource(id = R.drawable.logo_pangandaran),
            contentDescription = "Logo Kabupaten Pangandaran",
            modifier = Modifier
                .size(180.dp)
                .padding(top = 48.dp)
        )

        // Panel Biru
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp))
                .background(Color(0xFF0096FF))
                .padding(24.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Divider(
                    color = Color.White.copy(alpha = 0.6f),
                    thickness = 4.dp,
                    modifier = Modifier
                        .width(50.dp)
                        .padding(bottom = 16.dp)
                )

                Text(
                    text = "Satu Aplikasi\nSolusi Warga Pangandaran",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Langkah kecil menuju Pangandaran yang lebih cerdas. Layanan digital untuk warga aktif, transparansi, dan solusi cepat dalam satu aplikasi.",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(32.dp))

                Button(
                    onClick = onStartClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFFFDE7)),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text("MULAI", color = Color.Black, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
