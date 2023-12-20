package com.example.basictodoapp.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped //Activity çalıştığı süre boyunca repository'nin tutulmasını sağlıyor.
class Repository @Inject constructor(val localDataSource: LocalDataSource) {

}