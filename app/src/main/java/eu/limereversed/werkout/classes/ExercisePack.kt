package eu.limereversed.werkout.classes

class ExercisePack(
    val id: Long = -1L,
    val exercises: List<Exercise> = emptyList<Exercise>(),
    var currentExercise: Int = -1,
)