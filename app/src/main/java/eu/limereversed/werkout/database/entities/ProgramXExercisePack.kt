package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "program_x_exercise_pack_table", primaryKeys = ["program_id", "exercise_pack_id"])
data class ProgramXExercisePack(
    @ColumnInfo(name = "program_id")
    val programId: Long,
    @ColumnInfo(name = "exercise_pack_id")
    val exercisePackId: Long
)