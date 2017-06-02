package com.example.y_ogawara.realmtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    TextView text ;
    Realm realm;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        //realmの初期化
        realm.init(this);
        realm = Realm.getDefaultInstance();



    }
    public void add (View v){
        //トランザクション開始
        realm.beginTransaction();
        //dbの準備
        TestDB model;
        model = realm.createObject(TestDB.class);

        //書き込みたいデータを作成
        model.setId(1);
        model.setName(editText.getText().toString());

        //トランザクション終了
        realm.commitTransaction();

/***
        // データを挿入する
        realm.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                TestDB u = realm.createObject(TestDB.class);
                u.setName("サンプル太郎");
                u.setId(25);
            }
        });
 ***/


    }
    public void viewUpdate(View v){
        //検索用のクエリ作成
        RealmQuery<TestDB> query = realm.where(TestDB.class);

//        query.equalTo("name", "test");
//        query.or().equalTo("id", 2);
//        query.or().equalTo("id", 3);
        //インスタンス生成し、その中にすべてのデータを入れる 配列で
        RealmResults<TestDB> results = query.findAll();

        //0番目を出力
        text.setText(results.get(0).getName());

        //すべての値をログに出力
        for (TestDB test:results){
            System.out.println(test.getName());
        }
    }

}
