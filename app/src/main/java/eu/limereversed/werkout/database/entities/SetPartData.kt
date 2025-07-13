package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="set_part_table")
data class SetPartData(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name="name")
    var name : String = "",

    @ColumnInfo(name="value")
    var value : String = "",

    @ColumnInfo(name="goal")
    var goal : String = "",

    @ColumnInfo(name="type")
    var type : String = "",

    @ColumnInfo(name="rest")
    var rest : Int = -1,

    @ColumnInfo(name="one_rm")
    var oneRM : Float = -1f,

    @ColumnInfo(name="%_of_one_rm")
    var procentOfOneRM : Int = -1,
)