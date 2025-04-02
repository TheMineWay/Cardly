import app.cash.sqldelight.db.SqlDriver
import org.themineway.Database
import app.cash.sqldelight.driver.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(Database.Schema, "main.db")
    }
}