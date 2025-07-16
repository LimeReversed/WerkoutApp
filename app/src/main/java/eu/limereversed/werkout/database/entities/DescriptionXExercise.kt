package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "description_x_exercise_table", primaryKeys = ["description_id", "exercise_id"])
data class DescriptionXExercise(
    @ColumnInfo(name = "description_id")
    val descriptionId: Long,
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long
)