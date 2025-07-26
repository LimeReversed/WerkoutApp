package eu.limereversed.werkout

import android.content.Context
import androidx.room.Room
import eu.limereversed.werkout.AppDatabase
import eu.limereversed.werkout.repositories.DescriptionRepository
import eu.limereversed.werkout.repositories.ExercisePackRepository
import eu.limereversed.werkout.repositories.ExerciseRepository
import eu.limereversed.werkout.repositories.ProgramRepository
import eu.limereversed.werkout.repositories.SetPartRepository
import eu.limereversed.werkout.repositories.SetRepository

// Defines the database builder
object Graph {
    lateinit var database: AppDatabase

    val programRepository by lazy {
        ProgramRepository(programDao = database.programDao())
    }

    val descriptionRepository by lazy {
        DescriptionRepository(
            descriptionDao = database.descriptionDao(),
            descriptionXExerciseDao = database.descriptionXExerciseDao()
        )
    }

    val exerciseRepository by lazy {
        ExerciseRepository(
            exerciseDao = database.exerciseDao(),
            exerciseXExercisePackDao = database.exerciseXExercisePackDao()
        )
    }

    val exercisePackRepository by lazy {
        ExercisePackRepository(
            exercisePackDao = database.exercisePackDao(),
            exercisePackXProgramDao = database.exercisePackXProgramDao()
        )
    }

    val setRepository by lazy {
        SetRepository(setDao = database.setDao(), setXExerciseDao = database.setXExerciseDao())
    }

    val setPartRepository by lazy {
        SetPartRepository(
            setPartDao = database.setPartDao(),
            setPartXSetDao = database.setPartXSetDao(),
            setPartXExerciseDao = database.setPartXExerciseDao()
        )
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, AppDatabase::class.java, "appDatabase.db").build()
    }
}