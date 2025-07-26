package eu.limereversed.werkout.classes

import eu.limereversed.werkout.database.entities.SetPartData

open class SetPartGoal(
    val id: Long,
    val name: String,
    val type: String,
    var goal: String,
)

class SetPart(
    id: Long,
    name: String,
    type: String,
    goal: String,
    var value: String,
    var rest: Int
) : SetPartGoal(id, name, type, goal) {
    // Do I abandon Generic types here? Have it as a string, but the convert it with the right get?
    // Or do I have inheritence SetPartInt that takes care of that?
    constructor(setPartData: SetPartData): this(setPartData.id, setPartData.name, setPartData.type,
        setPartData.goal, setPartData.value, setPartData.rest)

    fun asData(): SetPartData { return SetPartData(
        id = id,
        name = this.name,
        value = this.value,
        goal = this.goal,
        type = this.type,
        rest = this.rest)}
}

//class SetPartKgs(value: Float?, goal: Float?):SetPart<Float>("Kg", "Float",value, goal)
//
//// Have get and set methods so I can control what else gets updated on value change?
//class SetPart1RM(value: Float?, goal: Float?, val oneRM: Float?, val percentOfOneRM: Int):SetPart<Float>("Kg", "Float", value, goal)
//class SetPartReps(value: Int?, goal: Int?):SetPart<Int>("Reps", "Float", value, goal)