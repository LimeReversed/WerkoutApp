package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "exercise_x_description_table", primaryKeys = ["exercise_id", "description_id"])
data class ExerciseXDescription(
    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long,
    @ColumnInfo(name = "description_id")
    val descriptionId: Long
)