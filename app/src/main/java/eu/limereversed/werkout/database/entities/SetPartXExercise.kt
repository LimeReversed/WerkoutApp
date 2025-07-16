package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

// For default goals
@Entity(tableName = "set_part_x_exercise_table", primaryKeys = ["set_part_id", "exercise_id"])
data class SetPartXExercise(
    @ColumnInfo(name = "set_part_id")
    val setPartId: Long,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long
)