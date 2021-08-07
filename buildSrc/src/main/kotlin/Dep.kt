import org.gradle.api.artifacts.dsl.DependencyHandler

object Dep {
	val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
	val coroutine = listOf(
		"org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}",
		"org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}",
	)
	val androidx = listOf(
		"androidx.appcompat:appcompat:${Versions.androidx_appcompat}",
		"androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintlayout}",
	)
	val androidxKtx = listOf(
		"androidx.core:core-ktx:${Versions.androidx_ktx}",	// for kotlin 1.5.10
		"androidx.activity:activity-ktx:${Versions.androidx_activity_ktx}",
	)
	val androidxNav = listOf(
		"androidx.navigation:navigation-fragment-ktx:${Versions.androidxNav}",
		"androidx.navigation:navigation-ui-ktx:${Versions.androidxNav}",
	)
	val androidxLifecycle = listOf(
		"androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.androidx_lifecycle}",
		"androidx.lifecycle:lifecycle-runtime-ktx:${Versions.androidx_lifecycle}",
	)
	val dagger = "com.google.dagger:hilt-android:${Versions.dagger}"
	val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
	val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
	val hilt = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"

	val material = "com.google.android.material:material:${Versions.androidx_material}"

	val coil = "io.coil-kt:coil:${Versions.coil}"

	val junit = "junit:junit:${Versions.junit}"
	val androidxTest = listOf(
		"androidx.test.ext:junit:${Versions.androidxJunit}",
		"androidx.test.espresso:espresso-core:${Versions.espresso}"
	)
}

//util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(list: List<String>) {
	list.forEach { dependency ->
		add("kapt", dependency)
	}
}

fun DependencyHandler.implementation(list: List<String>) {
	list.forEach { dependency ->
		add("implementation", dependency)
	}
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
	list.forEach { dependency ->
		add("androidTestImplementation", dependency)
	}
}

fun DependencyHandler.testImplementation(list: List<String>) {
	list.forEach { dependency ->
		add("testImplementation", dependency)
	}
}