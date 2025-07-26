package eu.limereversed.werkout.classes

import eu.limereversed.werkout.database.entities.ExerciseData

class Exercise(
    val id: Long = -1L,
    val exerciseId: Long = -1L,
    var name: String = "",
    var imagePath: String = "",
    var sets: List<Set> = emptyList<Set>(),
    var currentSet: Int = 0,
    var superSetWithNext: Boolean = false,
    var defaultSettings: SetSettings? = null,
    var defaultGoal: SetPart? = null,
    var showGoalsIndividually: Boolean = false,
    var description: List<Description> = emptyList<Description>()

    // FIX Do I want defaults for these?
) {
    constructor(exerciseData: ExerciseData): this(id = exerciseData.id, exerciseId = exerciseData.exerciseId, name = exerciseData.name,
        imagePath = exerciseData.imagePath, superSetWithNext = exerciseData.superSetWithNext)

    fun asData(): ExerciseData {

        if (defaultSettings == null) {
            return ExerciseData(
                this.id, this.exerciseId, this.name, this.imagePath, this.superSetWithNext,
                this.showGoalsIndividually, "", -1, ""
            )
        }

        return ExerciseData(
            this.id, this.exerciseId, this.name, this.imagePath, this.superSetWithNext,
            this.showGoalsIndividually, this.defaultSettings!!.tempo, this.defaultSettings!!.rest,
            this.defaultSettings!!.equipment
        )
    }
}