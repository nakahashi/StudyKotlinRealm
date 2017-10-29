package nakahashi.studykotlinrealm

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults
import java.text.FieldPosition

import nakahashi.studykotlinrealm.model.Post
import nakahashi.studykotlinrealm.view.PostView

class PostListAdapter(private val context: Context, val realm: Realm) : BaseAdapter() {

    private var query: RealmQuery<Post>

    init {
        query = realm.where(Post::class.java)
    }

    override fun getCount(): Int = query.findAll().count()
    override fun getItem(position: Int): Any? = find(position)
    override fun getItemId(position: Int): Long = find(position).id

    override fun getView(position: Int,
                         convertView: View?,
                         parent: ViewGroup?): View =
            ((convertView as? PostView) ?: PostView(context)).apply {
                setPost(find(position))
            }

    private fun find(position: Int): Post = query.findAll()[position]
}
