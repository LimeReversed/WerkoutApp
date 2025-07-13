package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "exercise_pack_x_exercise_table", primaryKeys = ["exercise_pack_id", "exercise_id"])
data class ExercisePackXExercise(
    @ColumnInfo(name = "exercise_pack_id")
    val exercisePackId: Long,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long
)