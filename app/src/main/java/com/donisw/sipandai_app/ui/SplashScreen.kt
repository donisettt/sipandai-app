package com.donisw.sipandai_app.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.*
import com.donisw.sipandai_app.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    // State animasi
    val offsetX = remember { Animatable(-300f) }  // Mulai dari kiri luar layar
    val alpha = remember { Animatable(0f) }       // Transisi fade in

    // Side effect buat animasi + delay ke WelcomeScreen
    LaunchedEffect(true) {
        offsetX.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 500)
        )
        delay(2000) // Total tampil 2 detik
        navController.navigate("welcome") {
            popUpTo("splash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF03A9F4)), // Biru khas
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.logo_pangandaran), // ganti sesuai nama file logo
                contentDescription = "Logo Pangandaran",
                modifier = Modifier.size(180.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Pangandaran Hebat !",
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier
                    .offset { IntOffset(offsetX.value.toInt(), 0) }
                    .alpha(alpha.value)
            )
        }
    }
}
