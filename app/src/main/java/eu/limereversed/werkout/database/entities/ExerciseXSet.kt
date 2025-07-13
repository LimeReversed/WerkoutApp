package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "exercise_x_set_table", primaryKeys = ["exercise_id", "set_id"])
data class ExerciseXSet(
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    @ColumnInfo(name = "set_id")
    val setId: Long
)