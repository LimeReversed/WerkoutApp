package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

// For default goals
@Entity(tableName = "exercise_x_set_part_table", primaryKeys = ["exercise_id", "set_part_id"])
data class ExerciseXSetPart(
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    @ColumnInfo(name = "set_part_id")
    val setPartId: Long
)