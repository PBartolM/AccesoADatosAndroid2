import androidx.room.*
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Empleat (
    @PrimaryKey val num: Int?,
    val nom: String?,
    @ColumnInfo(name = "depart") val departament: Int?,
    val edat: Int?,
    val sou: Float?
)


@Dao
interface EmpleatsDAO {
    @Insert
    fun insert(e: Empleat)

    @Delete
    fun delete(e: Empleat)

    @Update
    fun update(e: Empleat)

    @Query("SELECT * FROM EMPLEAT")
    fun getEmpleats() : List<Empleat>
}

@Database(entities = arrayOf(Empleat::class), version = 1)
abstract class EmpleatsDatabase:RoomDatabase() {
    abstract fun empleatsDao(): EmpleatsDAO
}