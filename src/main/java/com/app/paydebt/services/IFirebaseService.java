package com.app.paydebt.services;

import com.google.firebase.auth.FirebaseAuthException;

public interface IFirebaseService {
    public String isToken(String idToken) throws FirebaseAuthException;
}
