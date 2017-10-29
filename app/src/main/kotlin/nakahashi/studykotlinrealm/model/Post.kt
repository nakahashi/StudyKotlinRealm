package nakahashi.studykotlinrealm.model

import io.realm.Realm
import io.realm.RealmObject

import nakahashi.studykotlinrealm.getAutoIncrementKey

open class Post (open var id: Long = 0,
                 open var title: String = "タイトル！",
                 open var content: String = "内容！"
) : RealmObject() {
//    init {
//        id = getAutoIncrementKey<Post>(realm)
//    }
}

//open class Post constructor(realm: Realm?,
//                _title: String = "タイトル！"
//               ) : RealmObject() {
//    val id: Long = getAutoIncrementKey<Post>(realm)
//    var title: String = _title
//
//    public constructor() : this(null) {}
//}
//open class Post (realm: Realm,
//                 open var title: String = "タイトル！",
//                 open var content: String = "内容！"
//) : RealmObject() {
//    public val id: Long = getAutoIncrementKey<Post>(realm)
//
//    constructor(realm) { super() }
//}
