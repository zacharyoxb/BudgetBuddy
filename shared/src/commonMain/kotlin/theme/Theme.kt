package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    background = GreenBackgroundLight,
    onBackground = GreenOnBackgroundLight,
    primary = GreenPrimaryLight,
    onPrimary = GreenOnPrimaryLight,
    primaryContainer = GreenPrimaryContainerLight,
    onPrimaryContainer = GreenOnPrimaryContainerLight,
    secondaryContainer = GreenSecondaryContainerLight,
    onSecondaryContainer = GreenOnSecondaryContainerLight,
    tertiaryContainer = GreenTertiaryContainerLight,
    onTertiaryContainer = GreenOnTertiaryContainerLight,
    outline = GreenOutlineLight,
    outlineVariant = GreenOutlineVariantLight,
)

private val DarkColorScheme = darkColorScheme(
    background = GreenBackgroundDark,
    onBackground = GreenOnBackgroundDark,
    primary = GreenPrimaryDark,
    onPrimary = GreenOnPrimaryDark,
    primaryContainer = GreenPrimaryContainerDark,
    onPrimaryContainer = GreenOnPrimaryContainerDark,
    secondaryContainer = GreenSecondaryContainerDark,
    onSecondaryContainer = GreenOnSecondaryContainerDark,
    tertiaryContainer = GreenTertiaryContainerDark,
    onTertiaryContainer = GreenOnTertiaryContainerDark,
    outline = GreenOutlineDark,
    outlineVariant = GreenOutlineVariantDark,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}