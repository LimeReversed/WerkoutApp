package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="program_table")
data class ProgramData(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name="name")
    var name : String = "",

    @ColumnInfo(name="last_done")
    var lastDone : String = "",
)