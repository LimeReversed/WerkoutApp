package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "set_part_x_set_table", primaryKeys = ["set_part_id", "set_id"])
data class SetPartXSet(
    @ColumnInfo(name = "set_part_id")
    val setPartId: Long,
    @ColumnInfo(name = "set_id")
    val setId: Long,
)