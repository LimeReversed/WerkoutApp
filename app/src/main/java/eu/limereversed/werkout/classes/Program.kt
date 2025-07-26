package eu.limereversed.werkout.classes

import eu.limereversed.werkout.database.entities.ProgramData
import java.util.Date

class Program(
    val id: Long = -1L,
    var name : String = "",
    var lastDone : Date? = null,
    var exercisePacks: List<ExercisePack> = emptyList<ExercisePack>(),
    var currentExercisePack: Int = 0,
) {
    constructor(programData: ProgramData): this(id = programData.id, name = programData.name)

    fun asData(): ProgramData {
        return ProgramData(this.id, this.name, this.lastDone.toString())
    }
}