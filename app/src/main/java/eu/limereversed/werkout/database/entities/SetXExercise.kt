package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "set_x_exercise_table", primaryKeys = ["set_id", "exercise_id"])
data class SetXExercise(
    @ColumnInfo(name = "set_id")
    val setId: Long,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long
)