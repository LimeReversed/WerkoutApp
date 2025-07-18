package eu.limereversed.werkout.classes

abstract class SetPartAbstract (
    val name: String?,
){}

open class SetPartGoal<T>(
    name: String?,
    val goal: T?,
) : SetPartAbstract(name){}

open class SetPart<T>(
    name: String?,
    val value: T?,
    val goal: T?,
) : SetPartAbstract(name){}

class SetPartKgs(value: Int?, goal: Int?):SetPart<Int>("Kg", value, goal){}
class SetPartReps(value: Int?, goal: Int?):SetPart<Int>("Reps", value, goal){}