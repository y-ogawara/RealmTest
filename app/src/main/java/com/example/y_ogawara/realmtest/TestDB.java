package com.example.y_ogawara.realmtest;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * Created by y-ogawara on 17/06/02.
 */

public class TestDB extends RealmObject {
    private String          name;
    private int             id;

    @Ignore
    private int             sessionId;

    // Standard getters & setters generated by your IDE…
    public String getName() { return name; }
    public void   setName(String name) { this.name = name; }
    public int    getId() { return id; }
    public void   setId(int id) { this.id = id; }
    public int    getSessionId() { return sessionId; }
    public void   setSessionId(int sessionId) { this.sessionId = sessionId; }
}