package nakahashi.studykotlinrealm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmQuery
import io.realm.RealmResults
import nakahashi.studykotlinrealm.model.Post
import nakahashi.studykotlinrealm.R
import nakahashi.studykotlinrealm.bindView

class MainActivity : AppCompatActivity() {
    lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Realm.init(this);

//        val config = RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded().build();
//        Realm.setDefaultConfiguration(config);
//
//        val realmConfig = RealmConfiguration.Builder(baseContext).deleteRealmIfMigrationNeeded().build()
//        val realmConfig = RealmConfiguration.Builder(baseContext).build()
//        realm = Realm.getInstance(realmConfig)
        realm = Realm.getDefaultInstance();

        var query: RealmQuery<Post> = realm.where(Post::class.java)
        query.findAll().deleteAllFromRealm()

        val listAdapter = PostListAdapter(applicationContext, realm)
        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = listAdapter
        listView.setOnItemClickListener { adapterView, view, position, id ->
            var query: RealmQuery<Post> = realm.where(Post::class.java)
            realm.executeTransaction {
                query.equalTo("id", id).findAll().deleteAllFromRealm()
            }
            listAdapter.notifyDataSetChanged()
//            return query.findAll()[position]

//            val article = listAdapter.getItem(position)
//            article.clear()
//            ArticleActivity.intent(this, article).let { startActivity(it) }
        }

        val addEditText = findViewById<TextView>(R.id.add_edit_text)
        val addButton = findViewById<Button>(R.id.add_button)

        addButton.setOnClickListener {
            realm.executeTransaction {
                val post = Post(title = addEditText.text.toString())
                realm.copyToRealm(post)
            }
            listAdapter.notifyDataSetChanged()
        }
    }
}
