package eu.limereversed.werkout.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="exercise_table")
data class ExerciseData(

    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,

    @ColumnInfo(name="exercise_id")
    // FIX If -1 it's a new one?
    // How to autogenerate
    var exerciseId : Long = -1L,

    @ColumnInfo(name="name")
    var name : String = "",

    @ColumnInfo(name="image_path")
    var imagePath : String = "",

    @ColumnInfo(name="super_set_with_next")
    var superSetWithNext : Boolean = false,

    @ColumnInfo(name="show_goals_individually")
    var showGoalsIndividually : Boolean = false,

    @ColumnInfo(name="tempo")
    var tempo : String = "",

    @ColumnInfo(name="rest")
    var rest : Int = -1,

    @ColumnInfo(name="equipment")
    var equipment : String = "",
)