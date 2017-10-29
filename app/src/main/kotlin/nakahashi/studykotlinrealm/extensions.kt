package nakahashi.studykotlinrealm

import android.support.annotation.IdRes
import android.view.View
import io.realm.Realm
import io.realm.RealmObject

fun <T : View> View.bindView(@IdRes id: Int): Lazy<T> = lazy {
    findViewById<T>(id) as T
}

inline fun <reified T : RealmObject> getAutoIncrementKey(realm: Realm): Long {
    if (realm.where(T::class.java).count() == 0L) return 1
    else return realm.where(T::class.java).max("id").toLong() + 1
}
