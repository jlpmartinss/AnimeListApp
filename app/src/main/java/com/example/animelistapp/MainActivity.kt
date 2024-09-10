package com.example.animelistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.animelistapp.ui.screen.anime.AnimeScreen
import com.example.animelistapp.ui.screen.trending_anime.TrendingAnimeListScreen
import com.example.animelistapp.ui.theme.AnimeListAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.serialization.Serializable


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalSharedTransitionApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(
                android.graphics.Color.TRANSPARENT
            )
        )

        setContent {
            AnimeListAppTheme {
                val navController = rememberNavController()

                SharedTransitionLayout {
                    NavHost(navController = navController, startDestination = TrendingAnimeRoute) {
                        composable<TrendingAnimeRoute> {
                            TrendingAnimeListScreen(
                                onAnimeClick = { cover, id ->
                                    navController.navigate(
                                        AnimeRoute(
                                            id = id.toString(),
                                            coverImage = cover.toString()
                                        )
                                    )
                                },
                                animatedVisibilityScope = this
                            )
                        }
                        composable<AnimeRoute> {
                            val args = it.toRoute<AnimeRoute>()

                            AnimeScreen(
                                id = args.id,
                                coverImage = args.coverImage,
                                animatedVisibilityScope = this
                            )
                        }
                    }
                }
            }
        }
    }
}

@Serializable
data object TrendingAnimeRoute


@Serializable
data class AnimeRoute(val id: String, val coverImage: String)