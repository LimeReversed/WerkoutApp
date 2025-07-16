package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "exercise_pack_x_program_table", primaryKeys = ["exercise_pack_id", "program_id"])
data class ExercisePackXProgram(
    @ColumnInfo(name = "exercise_pack_id")
    val exercisePackId: Long,
    @ColumnInfo(name = "program_id")
    val programId: Long,
)