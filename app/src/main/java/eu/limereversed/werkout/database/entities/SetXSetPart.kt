package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "set_x_set_part_table", primaryKeys = ["set_id", "set_part_id"])
data class SetXSetPart(
    @ColumnInfo(name = "set_id")
    val setId: Long,
    @ColumnInfo(name = "set_part_id")
    val setPartId: Long
)