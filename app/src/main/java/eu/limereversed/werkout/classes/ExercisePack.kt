package eu.limereversed.werkout.classes

import eu.limereversed.werkout.database.entities.ExercisePackData

class ExercisePack(
    val id: Long = -1L,
    var exercises: List<Exercise> = emptyList<Exercise>(),
    var currentExercise: Int = 0,
){
    constructor(exercisePackData: ExercisePackData): this(id = exercisePackData.id)

    fun asData(): ExercisePackData {
        return ExercisePackData(this.id)
    }
}