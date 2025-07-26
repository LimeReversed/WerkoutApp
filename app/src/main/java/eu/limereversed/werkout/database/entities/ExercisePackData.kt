package eu.limereversed.werkout.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="exercise_pack_table")
data class ExercisePackData(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
)
