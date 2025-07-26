package eu.limereversed.easy_storage_example

import androidx.room.Database
import androidx.room.RoomDatabase
import eu.limereversed.werkout.database.daos.DescriptionDao
import eu.limereversed.werkout.database.daos.DescriptionXExerciseDao
import eu.limereversed.werkout.database.daos.ExerciseDao
import eu.limereversed.werkout.database.daos.ExercisePackDao
import eu.limereversed.werkout.database.daos.ExercisePackXProgramDao
import eu.limereversed.werkout.database.daos.ExerciseXExercisePackDao
import eu.limereversed.werkout.database.daos.ProgramDao
import eu.limereversed.werkout.database.daos.SetDao
import eu.limereversed.werkout.database.daos.SetPartDao
import eu.limereversed.werkout.database.daos.SetPartXExerciseDao
import eu.limereversed.werkout.database.daos.SetPartXSetDao
import eu.limereversed.werkout.database.daos.SetXExerciseDao
import eu.limereversed.werkout.database.entities.DescriptionData
import eu.limereversed.werkout.database.entities.DescriptionXExercise
import eu.limereversed.werkout.database.entities.ExerciseData
import eu.limereversed.werkout.database.entities.ExercisePackData
import eu.limereversed.werkout.database.entities.ExercisePackXProgram
import eu.limereversed.werkout.database.entities.ExerciseXExercisePack
import eu.limereversed.werkout.database.entities.ProgramData
import eu.limereversed.werkout.database.entities.SetData
import eu.limereversed.werkout.database.entities.SetPartData
import eu.limereversed.werkout.database.entities.SetPartXExercise
import eu.limereversed.werkout.database.entities.SetPartXSet
import eu.limereversed.werkout.database.entities.SetXExercise

// Tells the database what tables and entities to use. In this case "Product"
@Database(
    entities = [DescriptionData::class, DescriptionXExercise::class, ExerciseData::class,
        ExercisePackXProgram::class, ExercisePackData::class, ExerciseXExercisePack::class, ProgramData::class,
        SetData::class, SetPartData::class, SetPartXExercise::class, SetPartXSet::class,
        SetXExercise::class],
    version = 1,
    exportSchema = false,
)

// Tells the database what DAOs to use
abstract class AppDatabase : RoomDatabase() {
    abstract fun descriptionDao(): DescriptionDao
    abstract fun descriptionXExerciseDao(): DescriptionXExerciseDao
    abstract fun exerciseDao(): ExerciseDao
    abstract fun exercisePackXProgramDao(): ExercisePackXProgramDao
    abstract fun exercisePackDao(): ExercisePackDao
    abstract fun exerciseXExercisePackDao(): ExerciseXExercisePackDao
    abstract fun programDao(): ProgramDao
    abstract fun setDao(): SetDao
    abstract fun setPartDao(): SetPartDao
    abstract fun setPartXExerciseDao(): SetPartXExerciseDao
    abstract fun setPartXSetDao(): SetPartXSetDao
    abstract fun setXExerciseDao(): SetXExerciseDao
}