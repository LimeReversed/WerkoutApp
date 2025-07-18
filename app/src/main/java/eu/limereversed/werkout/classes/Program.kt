package eu.limereversed.werkout.classes

import java.util.Date

class Program(
    val id: Long = -1L,
    var name : String = "",
    var lastDone : Date? = null,
    val exercisesPack: List<ExercisePack> = emptyList<ExercisePack>(),
    var currentExercisePack: Int = -1,
)