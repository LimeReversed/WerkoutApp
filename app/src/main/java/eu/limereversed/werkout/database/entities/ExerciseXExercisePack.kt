package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "exercise_x_exercise_pack_table", primaryKeys = ["exercise_id", "exercise_pack_id"])
data class ExerciseXExercisePack(
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    @ColumnInfo(name = "exercise_pack_id")
    val exercisePackId: Long

)