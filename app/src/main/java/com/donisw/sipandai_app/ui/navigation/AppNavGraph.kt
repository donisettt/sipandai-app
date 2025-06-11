package com.donisw.sipandai_app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.donisw.sipandai_app.ui.OnboardingScreen
import com.donisw.sipandai_app.ui.WelcomeScreen
import com.donisw.sipandai_app.ui.auth.LoginScreen
import com.donisw.sipandai_app.ui.auth.RegisterScreen
import com.donisw.sipandai_app.ui.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("welcome") {
            WelcomeScreen(onStartClick = {
                navController.navigate("onboarding")
            })
        }
        composable("onboarding") {
            OnboardingScreen(
                navController = navController,
                onRegisterClick = {},
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("login") {
            LoginScreen(
                onBackClick = { navController.popBackStack() },
                onLoginClick = { username, password ->

                }
            )
        }

        composable("register") {
            RegisterScreen(onBackClick = { navController.popBackStack() })
        }

    }
}
