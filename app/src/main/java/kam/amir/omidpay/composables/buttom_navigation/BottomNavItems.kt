package kam.amir.todo.composables.bottomNavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItems(var title:String, var icon:ImageVector, var route:String) {

    data object Products : BottomNavItems("Products", Icons.Default.Menu,"products")
    data object Bookmarks : BottomNavItems("Bookmarks", Icons.Default.Star,"bookmarks")

}