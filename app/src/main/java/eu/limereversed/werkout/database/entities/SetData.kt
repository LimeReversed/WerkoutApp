package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="set_table")
data class SetData(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name="tempo")
    var tempo : String = "",

    @ColumnInfo(name="rest")
    var rest : Int = -1,

    @ColumnInfo(name="equipment")
    var equipment : String = "",
)